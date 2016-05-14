package core;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOM_NO_XPATH {
    public static void main(String[] args) throws Throwable, Exception, ParserConfigurationException {

        String url = "http://learn2test.net/sdc.xml";
        String node = "kadu-response";
        String element_1 = "orig-kw";
        String element_2 = "engine";
        String element_3 = "kadu-version";
        String element_4 = "response-time";
        String element_5 = "deals";
        String attribute = "count";

        // Get the DOM Builder Factory
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

        // Get the DOM Builder
        DocumentBuilder b = f.newDocumentBuilder();

        // Load and Parse the XML document contains the complete XML as a Tree.
        Document doc = b.parse(url);

        // Optional
        doc.getDocumentElement().normalize();

        // Parsing elements
        NodeList nList = doc.getElementsByTagName(node);

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Key Word: "
                        + eElement.getElementsByTagName(element_1).item(0).getChildNodes().item(0).getNodeValue());
                System.out.println("Engine: "
                        + eElement.getElementsByTagName(element_2).item(0).getChildNodes().item(0).getNodeValue());
                System.out.println("Version: " + eElement.getElementsByTagName(element_3).item(0).getChildNodes()
                        .item(0).getNodeValue().trim());
                System.out.println("Response time: " + eElement.getElementsByTagName(element_4).item(0).getChildNodes()
                        .item(0).getNodeValue().trim());
            }
        }

        // Parsing attribute
        NodeList nList2 = doc.getElementsByTagName(element_5);

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList2.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Number of deals: " + eElement.getAttribute(attribute).trim());

            }
        }
    }
}