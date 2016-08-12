/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author JMS
 */
public class details {
    
     public String filePath;
    
    public details(String filePath){
        this.filePath = filePath;
    }
     public void FillTable(showBooking frame){
      
        DefaultTableModel model = (DefaultTableModel) frame.jTable1.getModel();
    
        try{
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("bookings");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    model.addRow(new Object[]{getTagValue("name", eElement), getTagValue("phone_no", eElement), getTagValue("type", eElement), getTagValue("time", eElement),getTagValue("date", eElement), getTagValue("from", eElement), getTagValue("to", eElement)});
                }
            }
        }
        catch(Exception ex){
            System.out.println("Filling Exception");
        }
    }
    
    public static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
	return nValue.getNodeValue();
  }
    
}
