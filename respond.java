/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import cabservice.*;
import GUI.Landmark;
import java.awt.Graphics2D;
import java.io.*;

/**
 *
 * @author JMS
 */
public class respond {
    
    // noOfCabs is total number of cabs
    boolean available(int Start_time , int end_time, int noOfCabs){
        int count=0;
        int array[][]=new int[count][2];
        // reading data from file 
         try{
			
			FileInputStream fstream = new FileInputStream("C:\\Users\\jms\\Desktop\\booking.txt");
			
			DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
		
			while ((strLine = br.readLine()) != null) 
			{ 
                           
                           count++;
			
			}
			
			in.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
    
         
         try{
			 int temp[][]=new int[count][2];
			FileInputStream fstream = new FileInputStream("C:\\Users\\jms\\Desktop\\booking.txt");
			
			DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
		
			while ((strLine = br.readLine()) != null) 
			{ 
                            String m[]=strLine.split(" ");
                            int start=Integer.parseInt(m[0]);
                            int end =Integer.parseInt(m[1]);
                           temp[i][0]=start;
                           temp[i][1]=end;
                           i++;
			
			}
			array=temp;
			in.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: in available " + e.getMessage());
			}
         
         taskScheduling ob=new taskScheduling(count);
         ob.tasks=array;
         ob.no=array.length;
         System.out.println(ob.no);
         int num=ob.scheduler();
         System.out.println("cabs " +num +"  no of cabs  "+noOfCabs);
         if(num>noOfCabs){
         return false;
         }
         else
             return true;
        
        
    
    }
    
    void book(int Start_time , int end_time, int noOfCabs){
    
    if(available(Start_time,end_time,noOfCabs)){
        
  try 
    	  { 
    	      String filename= "C:\\Users\\jms\\Desktop\\booking.txt"; 
    	      boolean append = true; 
    	      FileWriter fw = new FileWriter(filename,append); 
    	      fw.write("\r\n");
    	      fw.write(Start_time+" "+end_time);//appends the string to the file 
    	      fw.close(); 
    	  
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: in booking " + e.getMessage());}
 
    }
    
    }
    
    
    
    
}
