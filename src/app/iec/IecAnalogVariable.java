package app.iec;

import app.AbstractTag;
import app.opc.OpcAnalogItem;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Iec104ClientAnalogVariable")
public class IecAnalogVariable extends AbstractTag {

    @XmlAttribute(name="Devisor")
    String devisor;

    @XmlAttribute(name="Multiplier")
    String multiplier;

    @XmlAttribute(name="OffsetAdder")
    String offsetAdder;

    @XmlAttribute(name="Ratio")
    String ratio;

    @XmlAttribute(name="RatioType")
    String ratioType;

    @XmlAttribute(name="UserMultiplier")
    String userMultiplier;

    @XmlAttribute(name="Type")
    String type;

    @XmlAttribute(name="MonitoringAddress")
    String monitoringAddress;

    @XmlAttribute(name="InfElementQualifier")
    String qualifier;

    @XmlAttribute(name="Read")
    Boolean read;

    @XmlAttribute(name="ReadPeriod")
    String readPeriod;

    public IecAnalogVariable() {

    }

    public IecAnalogVariable(OpcAnalogItem item) {

    }
}
