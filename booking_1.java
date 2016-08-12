/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabservice;

/**
 *
 * @author JMS
 */
public class booking {
   
    String toLocation;
    String fromlocation;
    String duration;
    String booking_id;
    
    
    booking(String toL,String fromL,String dur,String id){
    
    this.booking_id=id;
    this.duration=dur;
    this.fromlocation=fromL;
    this.toLocation=toL;
    
    
    }
    
    
    
    
    
}
