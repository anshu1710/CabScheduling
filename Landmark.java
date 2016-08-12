/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author JMS
 */
public class Landmark {
    
    float x,y;
    float radius;
    boolean hasCity;
    Color color;
    String name;
    
    
    Landmark(float xc, float yc , float rad,boolean city,String name){
    x=xc;
    y=yc;
    radius=rad;
    hasCity=city;
    this.name=name;
    if(hasCity){
    this.color=Color.BLUE;
            }
    else{
    this.color=Color.RED;}
    
    
    }
    
    
     /** Draw itself using the given graphics context. */
   public void draw(Graphics g) {
	   
      g.setColor(color);
      g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius),
            (int)(2 * radius));
	   
   }
   
   boolean IsIntersect(float xc, float yc){
       System.out.println(xc+" "+yc+" "+this.x+" "+this.y);
   if(distance(xc,yc,this.x,this.y)<=this.radius){
       System.out.println("intersect");
       return true;
       
   }
   else 
       return false;
   
   }
   
   float distance(float x1,float y1, float x2, float y2){
     return (float)(Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))));
   
   }
    
}
