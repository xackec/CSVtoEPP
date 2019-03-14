package app;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

@XmlSeeAlso({OpcAnalogItem.class,OpcDiscreteItem.class})
@XmlType
public abstract class AbstractTag {

    @XmlAttribute(name="BaseType")
    String baseType;

    @XmlAttribute(name="DataClass")
    String dataClass;

    @XmlAttribute(name="EventTriggerOption")
    String eventTriggerOptions;

    @XmlAttribute(name="FriendlyName")
    String friendlyName;

    @XmlAttribute(name="InstanceID")
    String instanceID;

    @XmlAttribute(name="IsEnabled")
    String isEnabled;

    @XmlAttribute(name="Link")
    String link;

    @XmlAttribute(name="Name")
    String name;

    @XmlAttribute(name="OpcTag")
    String opcTag;

    @XmlAttribute(name="VariableType")
    String variableType;

    public AbstractTag() {
        this.instanceID = UUID.randomUUID().toString();
        this.link = "0000000000000000";
        this.isEnabled = "true";
        this.eventTriggerOptions = "ValueChange QualityChange TimestampChange";
    }

}
