package app;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OpcClientAnalogItem")
public class OpcAnalogItem extends AbstractTag{

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

    public OpcAnalogItem() {

    }

    public OpcAnalogItem(String[] csvSrc) {

        super();

        this.baseType = "AnalogVariableBase";
        this.dataClass = "Data";
        this.devisor = "1";
        this.friendlyName = csvSrc[1];
        this.multiplier = "1";
        this.name = csvSrc[1];
        this.offsetAdder = "0";
        this.opcTag = csvSrc[1];
        this.ratio = "1";
        this.ratioType = "Primary";
        this.userMultiplier = "1";

        switch (csvSrc[2]) {
            case "DOUBLE" :
                this.variableType = "Double";
                break;
            case "FLOAT":
                this.variableType = "Float";
                break;
        }
    }
}
