package eu.europa.ema.phv.common.util;

import java.util.regex.Pattern;

/**
 * A utility class to extract value from the string using regular expression
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 8 Jul 2014 $
 * @since 8 Jul 2014 (creation date)
 */
public class XMLRegEx {
    public static final int FRE_None = 0;

    public static final int FRE_NodeAny = 0x01;

    public static final int FRE_NodeAnyAttr = 0x02;

    public static final int FRE_NodeFull = 0x03;

    public static final int FRE_NodeFullAttr = 0x04;

    public static final int FRE_NodeEmpty = 0x05;

    public static final int FRE_NodeEmptyAttr = 0x06;

    public static final int FRE_NodeBegin = 0x07;

    public static final int FRE_NodeBeginAttr = 0x08;

    public static final int FRE_NodeEnd = 0x09;

    public static final int FRE_MaskNode = 0x0F;

    public static final int FRE_CaptureNone = 0x00;

    public static final int FRE_CaptureWhole = 0x10;

    public static final int FRE_CaptureContent = 0x20;

    public static final int FRE_CaptureAll = 0x30;

    public static final int FRE_MaskCapture = 0xF0;

    public static final int FRE_NodeOKBroken = 0x100;

    public static final int FRE_ContentStopAtNL = 0x200;

    public static final int FRE_ContentTrim = 0x400;

    public static final int FRE_NodeAnyNaming = 0x800;

    public static final String XMLNameRE = "[a-zA-Z][a-zA-Z0-9_:]*";

    public static final String XMLNameREC = "(" + XMLNameRE + ")";

    public static final String XMLNameRENC = "(?:" + XMLNameRE + ")";

    public static final String XMLNodeContentRE = "[^<>]*";

    public static final String XMLNodeContentRENL = "[^<>\\n\\r]*";

    public static final String XMLNodeContentRESkipNL = "(?:[\\n\\r][^<>]*)?";

    public static final String XMLNodeContentRETrim = "[^<>\\s][^<>]*[^<>\\s]";

    public static final String XMLNodeContentRENLTrim =
            "[^<>\\s][^<>\\n\\r]*[^<>\\s]";

    public static final String XMLNodeContentREC =
            "(" + XMLNodeContentRE + ")";

    public static final String XMLNodeContentRENC =
            "(?:" + XMLNodeContentRE + ")";

    public static final String XMLNodeContentRENLC =
            "(" + XMLNodeContentRENL + ")";

    public static final String XMLNodeContentRENLNC =
            "(?:" + XMLNodeContentRENL + ")";

    public static final String XMLNodeContentRECTrim =
            "\\s*(" + XMLNodeContentRETrim + ")\\s*+";

    public static final String XMLNodeContentRENLCTrim =
            "\\s*(" + XMLNodeContentRENLTrim + ")[ \\t\\x0B\\f]*+";

    public static final String XMLBWNodeContentRE = "[^<>]*";

    public static final String XMLAttrContentRE = "[^<>\"]*";

    public static final String XMLAttrRE =
            "(?:\\s+" + XMLNameRE + "\\s*=\\s*\"" + XMLAttrContentRE + "\")";

    public static final String XMLCommentRE =
            "<!--" + XMLNodeContentRE + "-->";

    public static final String XMLCommentREC =
            "(<!--" + XMLNodeContentRE + "-->)";

    public static final String XMLCommentRECC =
            "(?:<!--" + XMLNodeContentREC + "-->)";

    public static final String XMLCommentRENC =
            "(?:<!--" + XMLNodeContentRE + "-->)";

    public XMLRegEx() {
    }

    public static Pattern compile(String ppPattern, int ppFlags) {
        return Pattern.compile(ppPattern, ppFlags);
    }

    public static String XMLNodeRE(final String ppNodeName) {
        return XMLNodeRE(ppNodeName, FRE_None, "");
    }

    public static String XMLNodeRE(final String ppNodeName,
            final int ppFlags) {
        return XMLNodeRE(ppNodeName, ppFlags, "");
    }

    public static String XMLNodeRE(final String ppNodeName,
            final String ppGreed) {
        return XMLNodeRE(ppNodeName, FRE_None, ppGreed);
    }

    public static String XMLNodeRE(final String ppNodeName, final int ppFlags,
            final String ppGreed) {
        String pContentRE;
        String pContentEmptyRE;
        String pContentRESkipNL = "";
        String pRE1;
        String pRE2;
        String pAttrsRE;

        switch (ppFlags & FRE_MaskNode) {
        case FRE_NodeBegin:
        case FRE_NodeBeginAttr:
        case FRE_NodeEnd:
            pContentRE = "";
            pContentEmptyRE = "";
            break;

        case FRE_None:
        case FRE_NodeAny:
        case FRE_NodeAnyAttr:
        case FRE_NodeFull:
        case FRE_NodeFullAttr:
        case FRE_NodeEmpty:
        case FRE_NodeEmptyAttr:
        default:
            switch (ppFlags & FRE_MaskCapture) {
            case FRE_CaptureWhole:
                if ((ppFlags & FRE_ContentStopAtNL) == FRE_ContentStopAtNL) {
                    pContentRE = XMLNodeContentRENL;
                    pContentRESkipNL = XMLNodeContentRESkipNL;
                }
                else {
                    pContentRE = XMLNodeContentRE;
                }
                pContentEmptyRE = "";
                break;

            case FRE_CaptureContent:
            case FRE_CaptureAll:
                if ((ppFlags & FRE_ContentStopAtNL) == FRE_ContentStopAtNL) {
                    pContentRE =
                            ((ppFlags & FRE_ContentTrim) == FRE_ContentTrim) ?
                                    XMLNodeContentRENLCTrim : XMLNodeContentRENLC;
                    pContentRESkipNL = XMLNodeContentRESkipNL;
                }
                else {
                    pContentRE =
                            ((ppFlags & FRE_ContentTrim) == FRE_ContentTrim) ?
                                    XMLNodeContentRECTrim : XMLNodeContentREC;
                }
                pContentEmptyRE = "()";
                break;

            case FRE_CaptureNone:
            default:
                if ((ppFlags & FRE_ContentStopAtNL) == FRE_ContentStopAtNL) {
                    pContentRE = XMLNodeContentRENL;
                    pContentRESkipNL = XMLNodeContentRESkipNL;
                }
                else {
                    pContentRE = XMLNodeContentRE;
                }
                pContentEmptyRE = "";
                break;
            }
            break;
        }

        switch (ppFlags & FRE_MaskNode) {
        case FRE_NodeBeginAttr:
        case FRE_NodeAnyAttr:
        case FRE_NodeFullAttr:
        case FRE_NodeEmptyAttr:
            pAttrsRE = XMLAttrRE + "*";
            break;
        default:
            pAttrsRE = "";
            break;
        }

        String pNodeName;
        if ((ppFlags & FRE_NodeAnyNaming) == FRE_NodeAnyNaming) {
            pNodeName = "(?:\\w+:)?" + ppNodeName;
        }
        else {
            pNodeName = ppNodeName;
        }

        String pNodeClosure;
        if ((ppFlags & FRE_NodeOKBroken) == FRE_NodeOKBroken) {
            pNodeClosure = "(?:</" + pNodeName + "\\s*>)?";
        }
        else {
            pNodeClosure = "</" + pNodeName + "\\s*>";
        }

        switch (ppFlags & FRE_MaskNode) {
        case FRE_NodeFull:
        case FRE_NodeFullAttr:
            pRE1 =
                    "<" + pNodeName + pAttrsRE + "\\s*>" + pContentRE + pContentRESkipNL +
                            pNodeClosure;
            pRE2 = "";
            break;

        case FRE_NodeEmpty:
        case FRE_NodeEmptyAttr:
            pRE1 =
                    "<" + pNodeName + pAttrsRE + "\\s*>" + pContentEmptyRE + pNodeClosure;
            pRE2 = "<" + pNodeName + pAttrsRE + "\\s*/>" + pContentEmptyRE;
            break;

        case FRE_NodeBegin:
        case FRE_NodeBeginAttr:
            pRE1 = "<" + pNodeName + pAttrsRE + "\\s*>";
            pRE2 = "";
            break;

        case FRE_NodeEnd:
            pRE1 = "</" + pNodeName + "\\s*>";
            pRE2 = "";
            break;

        case FRE_None:
        case FRE_NodeAny:
        case FRE_NodeAnyAttr:
        default:
            pRE1 =
                    "<" + pNodeName + pAttrsRE + "\\s*>" + pContentRE + pContentRESkipNL +
                            pNodeClosure;
            pRE2 = "<" + pNodeName + pAttrsRE + "\\s*/>" + pContentEmptyRE;
            break;
        }

        if (pRE2.length() == 0) {
            if ((ppFlags & FRE_CaptureWhole) == FRE_CaptureWhole) {
                return "(" + pRE1 + ")" + ppGreed;
            }
            else {
                return "(?:" + pRE1 + ")" + ppGreed;
            }
        }
        else {
            if ((ppFlags & FRE_CaptureWhole) == FRE_CaptureWhole) {
                return "((" + pRE1 + ")|(" + pRE2 + "))" + ppGreed;
            }
            else {
                return "(?:" + pRE1 + "|" + pRE2 + ")" + ppGreed;
            }
        }
    }
}
