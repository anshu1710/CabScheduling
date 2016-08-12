
package cabservice;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.xml.sax.SAXException;

public class Readxml {
    
    
String filePath;
Readxml(String path){
    this.filePath=path;
}
    
        public void get_bookings(StringBuffer buffer) throws ParserConfigurationException, SAXException, IOException{
            
                File fXmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile); 
		doc.getDocumentElement().normalize();
                
                NodeList nList = doc.getElementsByTagName("bookings");
                System.out.println(nList.getLength());
		for (int temp = 0; temp < nList.getLength(); temp++) {
                   Node nNode = nList.item(temp);
                   Element eElement = (Element) nNode;
                   buffer.append("booking " + (temp + 1) +  "\n"); 
                   buffer.append("    name          -    " + getTagValue("name", eElement) + "\n");
                   buffer.append("    phone_no      -    " + getTagValue("phone_no", eElement) + "\n");
                   buffer.append("    from          -    " + getTagValue("from", eElement) + "\n");
                   buffer.append("    to            -    " + getTagValue("to", eElement) + "\n");
                   buffer.append("    date          -    " + getTagValue("date", eElement) + "\n");
                   buffer.append("    time          -    " + getTagValue("time", eElement) + "\n");
                   buffer.append("    type          -    " + getTagValue("type", eElement) + "\n\n");
                  
                }
        }

        
  private static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

        Node nValue = (Node) nlList.item(0);

	return nValue.getNodeValue();
  }

}
