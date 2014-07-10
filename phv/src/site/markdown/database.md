# Eudravigilance 7 Database

The data from the XML messages is stored inside the schema ICHICSR.  
The tables used to store the data from the ICSR message are:

    I_ACTIVESUBSTANCE
    I_ACTIVESUBSTANCEINTERPRETED
    I_ALERTS
    I_CLUSTER
    I_CLUSTERDUPLICATE
    I_CLUSTERLOG
    I_DRUG
    I_DRUGINT_BAK
    I_DRUGINTERPRETED
    I_DRUGREACTIONRELATED
    I_DRUGRECURRENCE
    I_FLAGSTATUS
    I_ICHICSRMESSAGE
    I_LINKEDREPORT
    I_MESSAGEACK
    I_NARRATIVE_TRANSLATION
    I_PARENT
    I_PARENTMEDICALHISTORY
    I_PARENTPASTDRUGTHERAPY
    I_PATIENT
    I_PATIENTAUTOPSY
    I_PATIENTDEATH
    I_PATIENTDEATHCAUSE
    I_PATIENTMEDICALHISTORY
    I_PATIENTPASTDRUGTHERAPY
    I_PRIMARYSOURCE
    I_R_LOCKING
    I_R_LOG
    I_REACTION
    I_RECEIVER
    I_REPORTACK
    I_REPORTCOMMENT
    I_REPORTDUPLICATE
    I_SAFETYREPORT
    I_SAFETYREPORTACKS
    I_SAFETYREPORTS
    I_SENDER
    I_SUMMARY
    I_TEST

**I_ALERT** can be considered deprecated because not data there is inside.

**I_CLUSTER**, **I_CLUSTERDUPLICATE**, **I_CLUSTERLOG** are tables related to the duplicate detection algorithm and not to the XML message

The main table is **I_ICHMESSAGE** that contains all the message headers and the link to I_SAFETYREPORTS.

**I_SAFETYREPORTS** is a table used to link the I_ICHMESSAGE to I_SAFETYREPORT.

**I_SAFETYREPORT** contains the information from the report.

## Naming convention for the fields

**PK_** indicates a primary key

**FK_** indicates a foreign key from another table. Usually the field name is the same as the origin table without the PK_

**MREC** suffix indicates a field that is changed by the manual recoding via EVWEB

**RECODED** suffix indicates a field that is changed by the automatic recoding process.

**IS<something>CHANGED** indicates that the recoding process has changed the value for the field <SOMETHING>. 
The new value can be find inside <SOMETHING>RECODED. The value of **1** means **TRUE**

**IS<something>RECODED** indicates that the recoding process has recoded the field <SOMETHING>. 
The new value can be find inside <SOMETHING>RECODED. The value of **1** means **TRUE**


## Database and JPA notes

###Boolean values

There is no consistency between boolean field in the database. The value that indicates **TRUE** is **always 1**, 
however **FALSE** can be associate to the **value of 0 or 2** depends on the fields. 
The database comments don't cover all the fields, then the only way is looking on the PL/SQL code.

###Database constraints

Not always the table constraints are enabled. For some reason many table have the constraints defined but disable.  
This cause an issue with JPA because the system cannot handle automatically the dependencies between the objects.  
The solution is to change the entity definition as follow.
The table I_PATIENT has a relationship one to many with I_DRUG. The relationship is using the `SAFETYREPORT` key.   
Define on `Drug` class the foreign key as attribute (getter and setters omitted)

    @Column(name = "FK_SAFETYREPORT", nullable = false, precision = 10)
    @XmlTransient
    private long fkSafetyreport;

Define on `Drug` the `Patient` attribute in order to have access to the `Patient` object with an inverse reference.

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SAFETYREPORT", referencedColumnName = "PK_SAFETYREPORT", insertable = false,
            updatable = false)
    @XmlInverseReference(mappedBy = "IDrugs")
    private Patient IPatient;
    
The `@JoinColumn` specify the read-only nature of this field. The foreign key can be write only through the `fkSafetyreport` attribute.  
On the `Patient` class it is necessary to specify when copy the `SAFETYREPORT` field from `I_PATIENT` to `I_DRUG`.  
This is done with the `@PrePersist` annotation. The method will be called just before persisting the `Drug` object.
 
    @PrePersist
    public void initializeForeigners() {
        if (IDrugs != null) {
            for (Drug drug : this.IDrugs) {
                drug.setFkSafetyreport(pkSafetyreport);
            }
        }    
    }
    
`pkSafetreport` is the `SAFETYREPORT` field from `I_PATIENT`.  
In order to have the reference from `Patient` to the set of `Drug` define the follow.

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IPatient")
    @JoinColumn(name = "FK_SAFETYREPORT", referencedColumnName = "PK_SAFETYREPORT", insertable = false,
            updatable = false)
    @XmlElement(required = true, name = "drug")
    private List<Drug> IDrugs;
    
The `@JoinColumn` specify the read-only nature of this field. The foreign key can be write only through the `fkSafetyreport` attribute.


## Database sequence

The database is without the trigger for generating automatically the primary keys during an insert statement.  
Then on the JPA side it is necessary to define which sequence is used for every entity.

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SafetyReport")
    @SequenceGenerator(name="SafetyReport",sequenceName="SEQ_SAFETYREPORT", allocationSize=1)
    @Column(name = "PK_SAFETYREPORT", unique = true, nullable = false, precision = 10)
    @XmlTransient
    private long pkSafetyreport;

Where:  
`@Id` specifies that the attribute is a primary key.  
`@GeneratedValue` defines that the attribute is using a sequence.  
`@SequenceGenerator` defines the sequence name. The allocation size for the database is always 1. Different values can cause oracle errors.

## Database references

The references between different tables have to defined always with the CASCADE. E.G.
The follow line doesn't work. It was proposed by the code generator

     @OneToMany(mappedBy = "IPatientdeath")
     
Correct version

     @OneToMany(mappedBy = "IPatientdeath", cascade = CascadeType.ALL)

