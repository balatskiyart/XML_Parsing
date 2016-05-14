package core;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public class DOM_W_XPATH {
    public static void main(String[] args) throws Throwable, Exception, ParserConfigurationException {

        String url = "http://learn2test.net/sdc.xml";
        String xpath_element_01 = "//server/orig-kw";
        String xpath_element_02 = "//server/engine";
        String xpath_element_03 = "//server/kadu-version";
        String xpath_element_04 = "//response-time";
        String xpath_attribute_01 = "//deals/@count";

        // Get the DOM Builder Factory
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

        // Get the DOM Builder
        DocumentBuilder b = f.newDocumentBuilder();

        // Load and Parse the XML document contains the complete XML as a Tree.
        Document doc = b.parse(url);

        // Optional
        doc.getDocumentElement().normalize();

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        String element_01 = xpath.compile(xpath_element_01).evaluate(doc);
        String element_02 = xpath.compile(xpath_element_02).evaluate(doc);
        String element_03 = xpath.compile(xpath_element_03).evaluate(doc);
        String element_04 = xpath.compile(xpath_element_04).evaluate(doc);
        String attribute_01 = xpath.compile(xpath_attribute_01).evaluate(doc);

        System.out.println("Key Word: " + element_01);
        System.out.println("Engine: " + element_02);
        System.out.println("Version: " + element_03);
        System.out.println("Response time: " + element_04);
        System.out.println("Number of deals: " + attribute_01);
    }
}