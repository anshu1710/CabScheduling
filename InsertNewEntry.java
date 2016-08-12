package GUI;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.SAXException;

public class InsertNewEntry {

    public InsertNewEntry(String name, String phone_no, String type, String date, String time,String to, String from) throws ParserConfigurationException, SAXException, Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(new File("C:\\Users\\jms\\Desktop\\bookings.xml"));
        Insertingnewentry(doc, name, phone_no, type, date, time,to, from);
    }

    public void Insertingnewentry(Document doc, String name, String phone_no, String type, String date,String time, String to, String from) throws Exception {

        Element booking = doc.createElement("bookings");

        Element Name = doc.createElement("name");
        booking.appendChild(Name);
        Text idtextNode = doc.createTextNode(name);
        Name.appendChild(idtextNode);

        Element root = doc.getDocumentElement();


        Element Phone_no = doc.createElement("Phone_no");
        booking.appendChild(Phone_no);
        Text nametextNode = doc.createTextNode(phone_no);
        Phone_no.appendChild(nametextNode);
        
        
        Element Status = doc.createElement("status");
        booking.appendChild(Status);
        Text statustextNode = doc.createTextNode("not done");
        Status.appendChild(statustextNode);

        Element Type = doc.createElement("type");
        booking.appendChild(Type);
        Text passwordtextNode = doc.createTextNode(type);
        Type.appendChild(passwordtextNode);

        Element Date = doc.createElement("date");
        booking.appendChild(Date);
        Text emailtextNode = doc.createTextNode(date);
        Date.appendChild(emailtextNode);
        
        Element Time = doc.createElement("time");
        booking.appendChild(Time);
        Text timetextNode = doc.createTextNode(time);
        Time.appendChild(timetextNode);

        Element From = doc.createElement("from");
        booking.appendChild(From);
        Text fromtextNode = doc.createTextNode(from);
        From.appendChild(fromtextNode);

        Element To = doc.createElement("to");
        booking.appendChild(To);
        Text TotextNode = doc.createTextNode(to);
        To.appendChild(TotextNode);

        root.appendChild(booking);

        Node firstNode = root.getFirstChild();
        root.insertBefore(booking, firstNode);

        TransformerFactory factory =
                TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");


        StreamResult result = new StreamResult(new File("C:\\Users\\jms\\Desktop\\bookings.xml"));
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);

        System.out.println("file saved");


    }
}
