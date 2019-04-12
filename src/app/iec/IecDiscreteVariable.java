package app.iec;

import app.AbstractTag;
import app.opc.OpcDiscreteItem;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Iec104ClientDiscreteVariable")
public class IecDiscreteVariable extends AbstractTag {

    @XmlAttribute(name="Devisor")
    String devisor;

    @XmlAttribute(name="Multiplier")
    String multiplier;

    @XmlAttribute(name="OffsetAdder")
    String offsetAdder;

    @XmlAttribute(name="Offset")
    String offset;

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

    public IecDiscreteVariable() {

    }

    public IecDiscreteVariable(OpcDiscreteItem item) {

    }
}
