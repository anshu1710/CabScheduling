
package GUI;



import cabservice.Database;
import cabservice.Dijkstra;
import java.awt.Color;
import java.awt.Graphics;


public class cab1 {

    private static class Dijsktra {

        public Dijsktra() {
        }
    }
	
         int reg_no;
         String capacity;
         double x, y;
        String driver;
     //   private String status;
         String duration;
        String destination;
         String user;
 double cab_speed;
	 boolean busy = false;
	 double[] stops_x;
  double[] stops_y;
	 double[] distances;
        int num=0;
        int radius=5;
        String type;
        Graphics g;
        String from;
	// constructor
	public cab1(double x, double y) {
		this.x = x;
		this.y = y;
                this.busy = false;
	}
        
        public cab1(double x, double y,int num,String type,int cap) {
		this.x = x;
		this.y = y;
                //this.capacity=cap;
                this.num=num;
                this.type=type;
                this.busy = false;
                
	}
        
        public cab1(int reg , String driver , boolean busy ,String capacity ,double x ,double  y , String user ,String type ,String duration , String from, String destination, double speed){
               this.x = x;
	       this.y = y;
               this.capacity = capacity;
               this.type=type; 
               this.reg_no = reg;
               this.driver = driver;
               this.busy = busy;
               this.user = user;
               this.type = type;
               this.duration = duration;
               this.destination = destination;
               this.cab_speed = speed;
               this.from=from;
               Database_thread runn = new Database_thread();
        }

	// information of all mid stops between two places
	public void initiate_stops(Point[] stops) {
         int noOfStops = stops.length;
         stops_x = new double[noOfStops]; 
         stops_y = new double[noOfStops];
         for(int i=0; i<noOfStops; i++){
        	 stops_x[i] = stops[i].getX();
        	 stops_y[i] = stops[i].getY();
         }
	}
        
        
                 
                class Database_thread extends Thread{

        public Database_thread() {
            start();
        }
        
           int matchingLandmark(int x, int y,int landmarks[][],int len) {

            for (int i = 0; i <len; i++) {
                if (landmarks[i][0] == x && landmarks[i][1] == y) {
                    return i;
                }
            }
            return -1;
        }

        
        public void run(){
           while(true){
                 if(busy){ 
                     Database forAdjancy=new Database("C:\\Users\\jms\\Desktop\\array.txt"); 
                     int[][] adjancy=forAdjancy.adjancy();
                     Database forLandmark=new Database("C:\\Users\\jms\\Desktop\\landmark.txt"); 
                     int landmark[][]=forLandmark.landmarks();
                     
                     Dijkstra distance =new Dijkstra(adjancy.length);
                     int fromx=Integer.parseInt(from.split(" ")[0]);
                     int fromy=Integer.parseInt(from.split(" ")[1]);
                     int tox=Integer.parseInt(destination.split(" ")[0]);
                      int toy=Integer.parseInt(destination.split(" ")[1]);
                     
                     int [] point_index=distance.give_me_path_baby(adjancy,matchingLandmark(fromx,fromy,landmark,adjancy.length),matchingLandmark(tox,toy,landmark,adjancy.length));
                     Point[] points=new Point[point_index.length];
                     for(int i=0;i<points.length;i++){
                     points[i]=new Point(landmark[point_index[i]][0],landmark[point_index[i]][1]);
                     
                     }
                     initiate_stops(points);
                     start();}
           }
        }
    }

	// to clear old information
	public void clear_stops() {
		stops_x = null; 
        stops_y = null;
	}
        
           /** Draw itself using the given graphics context. */
   public void draw() {
	   
      g.setColor(Color.red);
      g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius),
            (int)(2 * radius));
       System.out.println("cab coordiante "+x +" "+y);
	   
   }
   public void draw(Graphics g) {
	   
      g.setColor(Color.red);
      g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius),
            (int)(2 * radius));
      
      System.out.println("cab coordiante "+x +" "+y);
	   
   }

	// to start another thread which shows cab on the map
	public void start(Graphics g) {
            this.g=g;
		Cab_runner runner = new Cab_runner();
		runner.start();
	}

	// getters and setters 
	// for x coordinate of the cab
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	// for y coordinate of the cab
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
 
	// for cab status
	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}
        
     
	
	// for cab speed
	public double getCab_speed() {
		return cab_speed;
	}

	public void setCab_speed(double cab_speed) {
		this.cab_speed = cab_speed;
	}

	// thread class
	class Cab_runner extends Thread{
		
		int currentMidStop = 0;
		
		double getNext_xCoordinate(double temp_x, double xfactor){
			return temp_x + cab_speed*xfactor; 
		}
		 
		double getNext_yCoordinate(double temp_y, double yfactor){
			return temp_y + cab_speed*yfactor; 
		}
		
		double getDistance(){
			double distance = 0.0;
			int length = stops_x.length;
			distances = new double[length-1]; 
			for(int i=0; i<length-1; i++){
				double dy = stops_y[i+1] - stops_y[i];
				double dx = stops_x[i+1] - stops_x[i];
				double extra = Math.sqrt(dy*dy+dx*dx);
				distance = distance + extra;
				distances[i] = distance;
			}
			return distance;
		}
		
		public void run(){
			
			 // xfactor and yfactor are cos theta and y theta and assigned initial values
			 double xfactor;                                  
			 if(stops_x[1] - stops_x[0] != 0){
				 xfactor  =  Math.abs(Math.cos(Math.atan((stops_y[1] - stops_y[0])/(stops_x[1] - stops_x[0])))); 
			 }
			 else{
				 xfactor = 0;
			 }
			 double yfactor = Math.sqrt(1 - xfactor*xfactor);  
			 if(stops_x[1] < stops_x[0]) xfactor*=(-1);
			 if(stops_y[1] < stops_y[0]) yfactor*=(-1);
			 
			 // initial cab coordinates or source coordinates
			 double temp_x = x;
			 double temp_y = y;
			 
			 // total distance between source and target
			 double distance = getDistance();
			
			 // t1 and t2 for sleeping thread
			 long t1 = 0,t2 = 0; 
			 
			 // while runs till cab runs
			 // Temporary variable for distance
			 double d=0; 	     
			 while(d < distance && currentMidStop<stops_x.length){ 
				// we wii show cab code for cab showing will be inserted here
				 draw();
				// finding next position of the cab after one second
			    x = temp_x = getNext_xCoordinate(temp_x, xfactor);  
				y = temp_y = getNext_yCoordinate(temp_y, yfactor); 	 
				
				// sleeping process
				try {
					sleep(1000 - t2 + t1);  
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				t1 = System.currentTimeMillis();
				
				// d increasing every one second
				d = d + cab_speed; 
				
				// if moing the cab linearly any mid stop comes there may be a turn so
				// that is handled here
				if(d > distances[currentMidStop]){
					
					// how much from stop is extra accounted that is diff
					 double diff = d - distances[currentMidStop] ; 
					 currentMidStop++;
					 
                                         
                                         // condition
                                         if(currentMidStop+1>=stops_x.length)
                                             break;
                                         
					// finding next cos theta and sin theta
                  
					 if(currentMidStop+1<stops_x.length &&(stops_x[currentMidStop+1] - stops_x[currentMidStop] != 0)){
						 xfactor  = Math.abs(Math.cos(Math.atan((stops_y[currentMidStop+1] - stops_y[currentMidStop])/(stops_x[currentMidStop+1] - stops_x[currentMidStop])))); 
					 }
					 else{
						 xfactor = 0;
					 }
					  yfactor = Math.sqrt(1 - xfactor*xfactor); 
					 if(stops_x[currentMidStop+1] < stops_x[currentMidStop]) xfactor*=(-1);
					 if(stops_y[currentMidStop+1] < stops_y[currentMidStop]) yfactor*=(-1);
					 
					 // finding correct next location of ccab
					 x = temp_x = stops_x[currentMidStop] + diff*xfactor;
					 y = temp_y = stops_y[currentMidStop] + diff*yfactor;
				}
				t2 = System.currentTimeMillis();
			}
		}// end of run
       
                
                
	}// end of thread class
        
        

}

