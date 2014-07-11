package eu.europa.ema.phv.common.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.encoder.EncoderBase;
import net.logstash.logback.LogstashFormatter;
import net.logstash.logback.encoder.LogstashEncoder;

import java.io.IOException;

/**
 * Encoder for logastash. The class is a modification of {@link LogstashEncoder}
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 10 Jun 2014 $
 * @since 10 Jun 2014 (creation date)
 */
public class LogStashEncoder extends EncoderBase<ILoggingEvent> {

    private boolean immediateFlush = true;

    private String encoding = "UTF-8";

    private String newLine = System.getProperty("line.separator");

    private final LogstashFormatter formatter = new LogstashFormatter();

    @Override
    public void doEncode(ILoggingEvent event) throws IOException {

        String log = formatter.writeValueAsString(event, context);
        outputStream.write(log.getBytes(encoding));
        if (newLine != null) {
            outputStream.write(newLine.getBytes(encoding));
        }

        if (immediateFlush) {
            outputStream.flush();
        }

    }

    @Override
    public void close() throws IOException {
        if (newLine != null) {
            outputStream.write(newLine.getBytes(encoding));
        }
    }

    public boolean isImmediateFlush() {
        return immediateFlush;
    }

    public void setImmediateFlush(boolean immediateFlush) {
        this.immediateFlush = immediateFlush;
    }

    public boolean isIncludeCallerInfo() {
        return formatter.isIncludeCallerInfo();
    }

    public void setIncludeCallerInfo(boolean includeCallerInfo) {
        formatter.setIncludeCallerInfo(includeCallerInfo);
    }

    public void setCustomFields(String customFields) {
        formatter.setCustomFieldsFromString(customFields, this);
    }

    public String getCustomFields() {
        return formatter.getCustomFields().toString();
    }

    /**
     * Define the encoding used for sending the logs
     *
     * @param encoding the encoding to set
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Define the new line. <br/>
     * NULL no new line. <br/>
     * SYSTEM operating system new line. <br/>
     * UNIX is the \n combination (default). <br/>
     * WINDOWS is \n\r combination
     *
     * @param newLine the newLine to set
     */
    public void setNewLine(String newLine) {
        if (newLine == null || newLine.isEmpty()) {
            this.newLine = null;
        }
        else if (newLine.equalsIgnoreCase("SYSTEM")) {
            this.newLine = System.getProperty("line.separator");
        }
        else if (newLine.equalsIgnoreCase("UNIX")) {
            this.newLine = "\n";
        }
        else if (newLine.equalsIgnoreCase("UNIX")) {
            this.newLine = "\r\n";
        }
        else {
            this.newLine = newLine;
        }
    }

    /**
     * @return the newLine
     */
    public String getNewLine() {
        return newLine;
    }

}
