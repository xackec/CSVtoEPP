package app;

 import javafx.stage.Stage;
 import org.w3c.dom.Document;
 import org.w3c.dom.Element;
 import org.w3c.dom.Node;
 import org.w3c.dom.NodeList;
 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBException;
 import javax.xml.bind.Marshaller;
 import javax.xml.parsers.DocumentBuilder;
 import javax.xml.parsers.DocumentBuilderFactory;
 import javax.xml.stream.*;
 import javax.xml.transform.Transformer;
 import javax.xml.transform.TransformerFactory;
 import javax.xml.transform.dom.DOMSource;
 import javax.xml.transform.stream.StreamResult;
 import java.io.*;
 import java.util.List;

public class Application{

    private List<AbstractTag> fromCsv;

    public static void main(String[] args) throws Exception{
        Application a = new Application();
        a.fromCsv = CsvParser.parse("2000d.csv");
        a.toJson();
        a.parseXml("res.epp");
    }

    private void toJson() throws IOException {
        File file = new File("tags.json");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        writer.write("[\n");

        for(int i = 0; i<fromCsv.size()-1; i++) {
            writer.write(fromCsv.get(i).toJsonString());
            writer.write(",\n");
        }

        writer.write(fromCsv.get(fromCsv.size()-1).toJsonString());
        writer.write("\n]");
        writer.flush();
        writer.close();
    }

    private void parseXmlIec(String pa) throws JAXBException{
        JAXBContext jc = JAXBContext.newInstance(AbstractTag.class);
        Marshaller marshaller = jc.createMarshaller();

        File xmlFile = new File(pa);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try{
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            Element root = doc.getDocumentElement();
            NodeList s = root.getElementsByTagName("ExportedItem");

            for(int i = 0; i<s.getLength(); i++) {
                Node node = s.item(i);
                if (node.getNodeName().equals("ExportedItem")) {
                    NodeList u = node.getChildNodes();
                    for (int j = 0; i < u.getLength(); i++) {
                        Node nd = u.item(i);
                        if (nd.getNodeName().equals("Iec104ClientSession")) {

                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private void parseXmlOpc(String pa) throws FileNotFoundException, XMLStreamException, JAXBException {

        JAXBContext jc = JAXBContext.newInstance(AbstractTag.class);
        Marshaller marshaller = jc.createMarshaller();

        File xmlFile = new File(pa);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            Element root = doc.getDocumentElement();
            NodeList s = root.getElementsByTagName("ExportedItem");

            for(int i = 0; i<s.getLength(); i++) {
                Node node = s.item(i);
                if(node.getNodeName().equals("ExportedItem")) {
                    NodeList u = node.getChildNodes();
                    for(int j = 0; i<u.getLength(); i++) {
                        Node nd = u.item(i);
                        if(nd.getNodeName().equals("OpcClientServerItem")) {
                            NodeList v = nd.getChildNodes();
                            for(int o = 0; o<v.getLength(); o++) {
                                Node n = v.item(o);
                                if(n.getNodeName().equals("OpcClientGroupItem")) {
                                    for(AbstractTag tag:this.fromCsv) {
                                        marshaller.marshal(tag, n);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            DOMSource source = new DOMSource(doc);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("result.epp");
            transformer.transform(source, result);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
