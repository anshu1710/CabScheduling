/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import GUI.Point;
import cabservice.Database;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author JMS
 */
public class MapAdmin extends javax.swing.JFrame {

    
   
 static   ArrayList<cab1> Cabs = new ArrayList<cab1>();
 static   ArrayList freeCabs = new ArrayList();
    
    Landmark[] landmarks;
    int count=0;
    int startroad=0;
    int toX=0,toY=0,fromX=0,fromY=0;
    int frmInd=0;
    int toInd=0;
    int[] xcor;
    int[] ycor;
   // cab1[] cabs;
    int numcab=0;
    Point[] points;
    
    float[][] adjancy_mat;
    
    
    
    /**
     * Creates new form MapAdmin
     */
    public MapAdmin() {
        initComponents();
        landmarks=new Landmark[50];
      //  cabs= new cab1[50];
        count=0;
        adjancy_mat=new float[50][50];
        load();
        System.out.println("num of cab "+this.numcab);
       
    }

    
    
    
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        backButton = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Add Landmark");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Add Road");
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("add cab");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("TYPE");

        jLabel2.setText("REG NO.");

        jLabel3.setText("Sitting Capacity");

        jLabel4.setText("drivername");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "NON AC" }));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(backButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        
        if(this.jRadioButton1.isSelected()){
             Graphics2D g=(Graphics2D) jPanel1.getGraphics();
             g.setColor(Color.red);
             
             
             boolean repeat =false;
             for(int i=0;i<count;i++){
             if(landmarks[i].name.equals(this.jTextField1.getText())){
             repeat=true;
             break;
             }
             }
             if(!repeat||count==0){
             landmarks[count]=new Landmark(evt.getX(),evt.getY(),10,true,this.jTextField1.getText());
              g.setColor(Color.red);
              landmarks[count].draw(g);
            // g.fillOval(evt.getX()-10, evt.getY()-10, 20, 20);
              g.setColor(Color.red);
              g.drawString(landmarks[count].name,landmarks[count].x-landmarks[count].radius-5 , landmarks[count].y-landmarks[count].radius-5);
             count++;
             System.out.println("here else");
             
             }
             else{
             // code for pop up window
                 System.out.println("here else");
             
             }
             
             
             
            
        }
        else if(this.jRadioButton2.isSelected()){
          int x=evt.getX(),y=evt.getY();

          boolean proceed=false;
          if(startroad>0){
          int index=0;
          for(int i=0;i<count;i++){
          if(landmarks[i].IsIntersect(x, y)){
          proceed =true;
          index=i;
          break;
          }
          
          }
          if(proceed){
          toX=x;toY=y;
           Graphics2D g=(Graphics2D) jPanel1.getGraphics();
           g.setColor(Color.BLACK);
           g.drawLine(fromX, fromY, toX, toY);
           fromX=x;fromY=y;
           startroad=0;
           adjancy_mat[frmInd][index]=distance(landmarks[frmInd].x,landmarks[frmInd].y,landmarks[index].x,landmarks[index].y);
             adjancy_mat[index][frmInd]=distance(landmarks[frmInd].x,landmarks[frmInd].y,landmarks[index].x,landmarks[index].y);
          }
          else{
          startroad=0;
          }
          
          }
          else{
          
           int index=0;
          for(int i=0;i<count;i++){
              System.out.println(" het  ");
          if(landmarks[i].IsIntersect(x, y)){
          proceed =true;
          index=i;
          break;
          }
          
          }
          if(proceed){
             fromX=x;fromY=y;
          startroad++;
          frmInd=index;
          }
          }
          
            
        }
        else if (this.jRadioButton3.isSelected()){
            
          int x=evt.getX(),y=evt.getY();
          Graphics2D g=(Graphics2D) jPanel1.getGraphics();
             g.setColor(Color.red);
             
              boolean proceed=false;
        
          int index=0;
          for(int i=0;i<count;i++){
          if(landmarks[i].IsIntersect(x, y)){
          proceed =true;
          index=i;
          break;
          }
          
          }
           
            if(proceed){
                // little manipulation
      //    cabs[numcab]=new cab1(x,y,Integer.parseInt(this.jTextField4.getText()),"AC",Integer.parseInt(this.jTextField5.getText()));
      //     Database data=new Database ("C:\\Users\\JMS\\Desktop\\database.xml");
           String reg=this.jTextField4.getText();
           int reg_no=Integer.parseInt(reg);
           String type=this.jComboBox1.getSelectedItem().toString();
           String capacity=this.jTextField5.getText();
           String driver=this.jTextField7.getText();
    //       String pos= x+" "+y;
           String speed="20";
             cab1 new_cab = new cab1(reg_no , driver , false , capacity , landmarks[index].x , landmarks[index].y , "" , type , "0 0", "0 0" ,  "0 0" , 20);
           Cabs.add(new_cab);
        //   data.addTaxi(reg, type, driver,capacity,speed,pos);
              
              g.setColor(Color.red);
            //  cabs[numcab].draw(g);
              Cabs.get(numcab).draw(g); 
            // g.fillOval(evt.getX()-10, evt.getY()-10, 20, 20);
              g.setColor(Color.red);
            //  g.drawString(landmarks[count].name,landmarks[count].x-landmarks[count].radius-5 , landmarks[count].y-landmarks[count].radius-5);
             numcab++;
             
             /*
             points=new Point[3];                                   // for testing
            
              points[0]=new Point(x,y);
             g.drawOval(x,y,10,10); 
             points[1]=new Point((int)landmarks[1].x,(int)landmarks[1].y);
             points[2]=new Point((int)landmarks[2].x,(int)landmarks[2].y);
              
             
             
             cabs[numcab-1].initiate_stops(points);
             cabs[numcab-1].setCab_speed(25);
             cabs[numcab-1].start(g);
             * 
             */
             
             System.out.println("here else");
            }
             
             
        
        }
        
    }//GEN-LAST:event_jPanel1MousePressed

    
     
    public  ArrayList<freeCab> findFreecabs(){
        ArrayList<freeCab> freeCabs=new ArrayList<freeCab>();
        int len = Cabs.size();
        for(int i=0; i<len; i++){
            int counter=0;
            if(!Cabs.get(i).busy){
                
                System.out.println("map admin 402 get x" +Cabs.get(i).getX() );
                freeCab freec = new freeCab(i , Cabs.get(i).getX() ,  Cabs.get(i).getY()  );
				freeCabs.add(freec);
                                
                                 System.out.println("map admin 412 freecab " +freeCabs.get(counter++).x );
                                
            }
        }
        return freeCabs;
    }
	
	public  void set_busy(String duration , String from , String desination , int index){
       cab1 new_cab = Cabs.get(index);
       new_cab.duration = duration;
       new_cab.from =from;
       new_cab.destination = desination;
       new_cab.busy = true;
    }
	
    
    
    
    float distance(float x1,float y1, float x2, float y2){
     return (float)(Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))));
   
   }
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
        // TODO add your handling code here:
        if(this.jRadioButton2.isSelected()){
        startroad=0;
        }
        
    }//GEN-LAST:event_jRadioButton2StateChanged

    void save(){
    
      try{
  // Create file 
  FileWriter fstream = new FileWriter("C:\\Users\\JMS\\Desktop\\array.txt");
  BufferedWriter out = new BufferedWriter(fstream);
 
  StringBuffer sb=new StringBuffer();
  
  String s="";
  
  for(int i=0;i<count;i++){
  for(int j=0;j<count;j++){
      if(j<count-1){
  sb.append(adjancy_mat[i][j]+" ");
  s=s+adjancy_mat[i][j]+" ";
  
      }
      else{
           sb.append(adjancy_mat[i][j]);
           s=s+adjancy_mat[i][j]+" ";
      }
      
  }
  
   s=s+"\n";
  }
  out.write(s);
  
  String cor="";
  for(int i=0;i<count;i++){
  if(i==0){
      cor=(int)landmarks[i].x +" "+(int)landmarks[i].y +"\n";
  }
  else if(i<count-1){
      cor=cor+(int)landmarks[i].x +" "+(int)landmarks[i].y +"\n";
  }
  else{
       cor=cor+(int)landmarks[i].x +" "+(int)landmarks[i].y ;
  }
  }
  
  
  //Close the output stream
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
          try{
  // Create file 
  FileWriter fstream = new FileWriter("C:\\Users\\JMS\\Desktop\\landmark.txt");
  BufferedWriter out = new BufferedWriter(fstream);
 
  
  
  String cor="";
  for(int i=0;i<count;i++){
  if(i==0){
      cor=(int)landmarks[i].x +" "+(int)landmarks[i].y +" "+landmarks[i].name+"\n";
  }
  else if(i<count-1){
      cor=cor+(int)landmarks[i].x +" "+(int)landmarks[i].y +" "+landmarks[i].name+"\n";
  }
  else{
       cor=cor+(int)landmarks[i].x +" "+(int)landmarks[i].y +" "+landmarks[i].name+"\n";
  }
  }
  out.write(cor);
  
  //Close the output stream
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
          
           try{
  // Create file 
  FileWriter fstream = new FileWriter("C:\\Users\\JMS\\Desktop\\cab.txt");
  BufferedWriter out = new BufferedWriter(fstream);
 
  
  
  String cor="";
  for(int i=0;i<numcab;i++){
   if(i==0){
     // cor=(int)cabs[i].getX() +" "+(int)cabs[i].getY() +" "+cabs[i].num+"\n";
      cor=(int)Cabs.get(i).getX() +" "+(int)Cabs.get(i).getY() +" "+Cabs.get(i).num+"\n";
  }
  else if(i<numcab-1){
      cor=cor+(int)Cabs.get(i).getX() +" "+(int)Cabs.get(i).getY() +" "+Cabs.get(i).num+"\n";  
  }
  else{
       cor=cor+(int)Cabs.get(i).getX() +" "+(int)Cabs.get(i).getY() +" "+Cabs.get(i).num+"\n";
  }
  }
 out.write(cor);
  
  //Close the output stream
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
           
           
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
      save();
      this.jButton1.disable();  
    }//GEN-LAST:event_formWindowClosing

    
    void load(){
    try{
			
			FileInputStream fstream = new FileInputStream("C:\\Users\\jms\\Desktop\\landmark.txt");
			
			DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
		
			while ((strLine = br.readLine()) != null) 
			{ int x=0,y=0;
				String[] arr=strLine.split(" ");
				//System.out.println(Integer.parseInt(arr[0])+" "+Integer.parseInt(arr[1]));
                                x=Integer.parseInt(arr[0]);
                                y=Integer.parseInt(arr[1]);
                                
                                landmarks[count]=new Landmark(x,y,10,true,arr[2]);
                                 Graphics2D g=(Graphics2D) jPanel1.getGraphics();
				landmarks[count].draw(g);
                                  g.drawString(landmarks[count].name,landmarks[count].x-landmarks[count].radius-5 , landmarks[count].y-landmarks[count].radius-5);
                               System.out.println(landmarks[count].x+" "+landmarks[count].y+" "+landmarks[count].name);
                                  count++;
                                
				
				
			}
			
			in.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
        
        
         try{
			
			FileInputStream fstream = new FileInputStream("C:\\Users\\jms\\Desktop\\cab.txt");
			
			DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
		
			while ((strLine = br.readLine()) != null) 
			{ int x=0,y=0;
				String[] arr=strLine.split(" ");
				//System.out.println(Integer.parseInt(arr[0])+" "+Integer.parseInt(arr[1]));
                                x=Integer.parseInt(arr[0]);
                                y=Integer.parseInt(arr[1]);
                                
                              //  cabs[this.numcab]=new cab1(x,y);
                                cab1 new_vab = new cab1(x,y);
                                Cabs.add(new_vab); 
                                 Graphics2D g=(Graphics2D) jPanel1.getGraphics();
				//cabs[numcab].draw(g);
                                 Cabs.get(numcab).draw(g); 
                                     numcab++;
                                
				
				
			}
			
			in.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
        
        
        
        
        
         try{
			
			FileInputStream fstream = new FileInputStream("C:\\Users\\jms\\Desktop\\array.txt");
			
			DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
		int i=0;
			while ((strLine = br.readLine()) != null) 
			{ int x=0,y=0;
				String[] arr=strLine.split(" ");
				
                                 Graphics2D g=(Graphics2D) jPanel1.getGraphics();
				
                                 
                                  for(int j=0;j<arr.length;j++){
                                  adjancy_mat[i][j]=Float.parseFloat(arr[j]);
                                  if(adjancy_mat[i][j]>0){
                                      g.setColor(Color.black);
                                  g.drawLine((int)landmarks[i].x,(int) landmarks[i].y,(int) landmarks[j].x, (int)landmarks[j].y);
                                  
                                  }
                                  
                                  }
                                  
                                i++;
				
				
			}
			
			in.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
        
    
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
load();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

     
        
    }//GEN-LAST:event_formWindowStateChanged

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    /*    
        if(this.jRadioButton3.isSelected()){
        this.jTextField5.enable();
        this.jTextField4.enable();
        this.jComboBox1.enable();
        }
        else{
        this.jTextField5.disable();
        this.jTextField4.disable();
        this.jComboBox1.disable();
        * 
       
        
        }
        * 
        */
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        
        adminPage obj=new adminPage();
        obj.show();
       
        save();
       this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MapAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MapAdmin().setVisible(true);
                System.out.println("hey");
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}