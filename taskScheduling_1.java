/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabservice;

/**
 *
 * @author JMS
 */
public class taskScheduling {
    
    int[][] tasks;
    int no;
    
    taskScheduling(int number){
        no=0;
        tasks=new int[number][2];
    }
    
    
  void sort () 
    {
    //Sort the given inputs in ascending order (start times)
 for(int i=0;i<no;i++)
  {
         for(int j=i+1;j<no;j++)
          {
                 if(tasks[i][0]>tasks[j][0])
                          {
                            int temp;
                            temp=tasks[i][0];
                            tasks[i][0]=tasks[j][0];
                            tasks[j][0]=temp;                  
                            
                            temp=tasks[i][1];
                            tasks[i][1]=tasks[j][1];
                            tasks[j][1]=temp;                
                          }
                if((tasks[i][0]==tasks[j][0])&&(tasks[i][1]>tasks[j][1]))
                          {
                            int temp;
                            temp=tasks[i][0];
                            tasks[i][0]=tasks[j][0];
                            tasks[j][0]=temp;                  
                            
                            temp=tasks[i][1];
                            tasks[i][1]=tasks[j][1];
                            tasks[j][1]=temp;                
                          }                                 
           }
      
    
    
    
  }
    }
  
  
  int scheduler(){
  sort();
   int mach=1;
   for(int i=0;i<no;i++)
    {
    
     if(i!=0)
      {
        if(tasks[i][0]<tasks[i-1][1])        
            {mach++;}   
      }
     
     
  
  }
   return mach;
   
    }
    
    

}