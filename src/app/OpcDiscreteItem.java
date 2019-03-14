package app;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement(name = "OpcClientDiscreteItem")
public class OpcDiscreteItem extends AbstractTag {

    @XmlAttribute(name="EnumID")
    String enumID;

    @XmlAttribute(name="EventDelay")
    String eventDelay = "0";

    @XmlAttribute(name="Offset")
    String offset = "255";

    public OpcDiscreteItem() {

    }

    public OpcDiscreteItem(String[] csvSrc) {

        super();

        this.baseType = "DiscreteVariableBase";
        this.dataClass = "Event";
        this.enumID = UUID.randomUUID().toString();
        this.friendlyName = csvSrc[1];
        this.name = csvSrc[1];
        this.opcTag = csvSrc[1];
        switch (csvSrc[2]) {
            case "INTEGER":
                this.variableType = "Uint16";
                break;
        }
    }
}
