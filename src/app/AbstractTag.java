package app;

import app.opc.OpcAnalogItem;
import app.opc.OpcDiscreteItem;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

@XmlSeeAlso({OpcAnalogItem.class, OpcDiscreteItem.class})
@XmlType
public abstract class AbstractTag {

    protected static final String PREFIX = "ns*7;s*0:";

    @XmlAttribute(name="BaseType")
    public String baseType;

    @XmlAttribute(name="DataClass")
    public String dataClass;

    @XmlAttribute(name="FriendlyName")
    public String friendlyName;

    @XmlAttribute(name="InstanceID")
    public String instanceID;

    @XmlAttribute(name="IsEnabled")
    public String isEnabled;

    @XmlAttribute(name="Link")
    public String link;

    @XmlAttribute(name="Name")
    public String name;

    @XmlAttribute(name="OpcTag")
    public String opcTag;

    @XmlAttribute(name="VariableType")
    public String variableType;

    private String convertTag() {
        String prefix = PREFIX.replace("*","=");
        return prefix + this.name;
    }

    private int iecIoa;


    public AbstractTag() {
        this.instanceID = UUID.randomUUID().toString();
        this.link = "0000000000000000";
        this.isEnabled = "true";
        this.eventTriggerOptions = "ValueChange QualityChange TimestampChange";
    }

    public AbstractTag(int ioa) {
        this.iecIoa = ioa;
        this.instanceID = UUID.randomUUID().toString();
        this.link = "0000000000000000";
        this.isEnabled = "true";
        this.eventTriggerOptions = "ValueChange QualityChange TimestampChange";
    }

    public String toJsonString() {

        StringBuilder result = new StringBuilder();
        result.append("{\n\t");
        if(this.baseType=="DiscreteVariableBase") {
            result.append("\"Type\" : \"D\",\n\t");
        } else if(this.baseType=="AnalogVariableBase") {
            result.append("\"Type\" : \"A\",\n\t");
        }
        result.append("\"OPC_tag\" : \"" + this.convertTag()+"\",\n\t");
        result.append("\"IOA\" : " + this.iecIoa);
        result.append("\n}");

        return result.toString();
    }

}
