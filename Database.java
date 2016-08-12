/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabservice;

/**
 *
 * @author JMS
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Database {

    public String filePath;

    public Database(String filePath) {
        this.filePath = filePath;
    }

    
     public boolean userExists(String email_id) {

        try {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (getTagValue("email_id", eElement).equals(email_id)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception ex) {
            System.out.println("Database exception : userExists()");
            return false;
        }
    }

    //  check login is correct or not
    public boolean checkLogin(String email_id, String password) {

        if (!userExists(email_id)) {
            return false;
        }

        try {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (getTagValue("email_id", eElement).equals(email_id) && getTagValue("password", eElement).equals(password)) {
                        return true;
                    }
                }
            }
            System.out.println("Hippie");
            return false;
        } catch (Exception ex) {
            System.out.println("Database exception : userExists()");
            return false;
        }
    }

    // add new user in users.xml file
    public void addUser(String username, String password, String email_id) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);

            Node data = doc.getFirstChild();

            Element newuser = doc.createElement("user");
            Element newusername = doc.createElement("username");
            newusername.setTextContent(username);
            Element newpassword = doc.createElement("password");
            newpassword.setTextContent(password);
            Element newemail_id = doc.createElement("email_id");
            newemail_id.setTextContent(email_id);

            newuser.appendChild(newusername);
            newuser.appendChild(newpassword);
            newuser.appendChild(newemail_id);
            data.appendChild(newuser);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception ex) {
            System.out.println("Exceptionmodify xml");
        }
    }

    
    void setBusy(String time) {
     
        try {
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
                    if ((getTagValue("time", eElement).equals(time)) && (getTagValue("status", eElement).equals("not done"))) {
                       
System.out.println("in databe set busy");
            // setTagValue("status", eElement, "done");
           //  NodeList list = eElement.getChildNodes();
            
             
              NodeList nlList = eElement.getElementsByTagName("status").item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        nValue.setTextContent("done");
          TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

             
                        break;
                    

                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Database exception : setBusy");

        }


    }

    public int[][] free_taxi() {
        int[][] array = new int[50][2]; // to get position of taxi
        int counter = 0; // to count taxi
        try {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();


            NodeList nList = doc.getElementsByTagName("taxi");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (getTagValue("status", eElement).equals("free")) {
                        String[] location = getTagValue("pos", eElement).split(" ");
                        array[counter][0] = Integer.parseInt(location[0]);
                        array[counter][1] = Integer.parseInt(location[1]);
                        counter++;
                    }
                }
            }
            return array;
        } catch (Exception ex) {
            System.out.println("Database exception : free_taxi");
            return array;
        }
    }

   ArrayList<booking> get_bookings(int time) {
        ArrayList<booking> booking=new ArrayList<booking>();
       
        int counter = 0;
        try {
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
                    if (getTagValue("time", eElement).split(" ")[0].equals(""+time)&&getTagValue("status", eElement).equals("not done")) {
                        String fromLocation = getTagValue("from", eElement);
                        String toLocation=getTagValue("to", eElement);
                         String duration=getTagValue("time", eElement);       /// add this field in xml
                        //  String id=getTagValue("id", eElement);                              /////// to be identify
                        
                       
                        booking temp1=new booking(toLocation,fromLocation,duration, "o");
                        booking.add(temp1);
                       

                    }
                }
            }

            return booking;

        } catch (Exception ex) {

            System.out.println("Database exception : get_booking" + ex.getMessage());
            return booking;
        }



    }
   
   void delete_entry(String booking){
       String s="";
        try{
			
			FileInputStream fstream = new FileInputStream(this.filePath);
			
			DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
		int i=0;
			while ((strLine = br.readLine()) != null) 
			{ 
				if(!strLine.equals(booking)){
                                    s=s+strLine+"\n";
                                }
				
			}
                        
			in.close();
                        
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: delete booking " + e.getMessage());
			}
   
       
    try{
  // Create file 
  FileWriter fstream = new FileWriter(filePath);
  BufferedWriter out = new BufferedWriter(fstream);
 
  
  out.write(s);
  
  //Close the output stream
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }

   }
   
   
   
    // to get adjancy matrix
   public int[][] adjancy(){
        int[][] adjancy_mat=new int[50][50];
    try{
			
			FileInputStream fstream = new FileInputStream(this.filePath);
			
			DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
		int i=0;
			while ((strLine = br.readLine()) != null) 
			{ int x=0,y=0;
				String[] arr=strLine.split(" ");
			
                                  for(int j=0;j<arr.length;j++){
                                  adjancy_mat[i][j]=(int)Float.parseFloat(arr[j]);
                       
                                  }
                                  
                                i++;
				
				
			}
                        
                        int[][] arr = new int[i][i];
                        
                        for(int j=0;j<i;j++){
                        
                            for(int k=0;k<i;k++){
                        arr[j][k]=adjancy_mat[j][k];
                        }
                            
                        }
			adjancy_mat=arr;
			in.close();
                        
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: databse adjacy " + e.getMessage());
			}
        return adjancy_mat;
    }
    
    
// to get coord of landmarks
  public  int[][] landmarks() {
        int landmarks[][] = new int[50][2];
        int counter = 0;
        try {

            FileInputStream fstream = new FileInputStream(this.filePath);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;


            while ((strLine = br.readLine()) != null) {
                String[] landmark_info = strLine.split(" ");
                landmarks[counter][0] = Integer.parseInt(landmark_info[0]);
                landmarks[counter][1] = Integer.parseInt(landmark_info[1]);
                counter++;

            }

            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("error at databe landmark funtion " + e.getMessage());
        }
        return landmarks;


    }

    public void addTaxi(String reg, String type, String driver, String capacity, String speed, String pos) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);

            Node data = doc.getFirstChild();

            Element newtaxi = doc.createElement("taxi");
            Element newreg = doc.createElement("reg");
            newreg.setTextContent(reg);
            Element newtype = doc.createElement("type");
            newtype.setTextContent(type);
            Element newdriver = doc.createElement("driver");
            newdriver.setTextContent(driver);
            Element newstatus = doc.createElement("status");
            newstatus.setTextContent("free");
            Element newcapacity = doc.createElement("capacity");
            newcapacity.setTextContent(capacity);
            Element newspeed = doc.createElement("speed");
            newspeed.setTextContent(speed);
            Element newpos = doc.createElement("pos");
            newpos.setTextContent(pos);
            Element newfrom = doc.createElement("from");
            newpos.setTextContent("");
            Element newto = doc.createElement("to");
            newpos.setTextContent("");
            Element newusername = doc.createElement("username");
            newpos.setTextContent("");


            newtaxi.appendChild(newreg);
            newtaxi.appendChild(newtype);
            newtaxi.appendChild(newdriver);
            newtaxi.appendChild(newstatus);
            newtaxi.appendChild(newcapacity);
            newtaxi.appendChild(newspeed);
            newtaxi.appendChild(newpos);
            newtaxi.appendChild(newfrom);
            newtaxi.appendChild(newto);
            newtaxi.appendChild(newusername);
            data.appendChild(newtaxi);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception ex) {
            System.out.println("Exceptionmodify xml");
        }
    }

    public static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }

    public static void setTagValue(String sTag, Element eElement, String value) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        nValue.setTextContent(value);
        

    }

    public static void main(String[] args) {
        Database a = new Database("C:\\Users\\jms\\Desktop\\database.xml");
        int[][] arr = a.free_taxi();
        int i = 0;
        while (arr[i][0] != 0) {
            System.out.println(arr[i][0]);
            i++;
        }
    }
}
