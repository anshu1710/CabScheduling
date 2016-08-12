/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabservice;

import GUI.MapAdmin;
import GUI.freeCab;
import java.util.ArrayList;

/**
 *
 * @author JMS
 */
public class controller {
final static long starting_time=System.currentTimeMillis();
    MapAdmin map;
    backEnd t;

    public controller(MapAdmin m) {
        t = new backEnd();
        map = m;
System.out.println("controller starts.............");

        t.start();

    }

    class backEnd extends Thread {

        int[][] freeCab;
        int[][] landmarks;
        int adjancy[][];
        Dijkstra distance;
        ArrayList<freeCab> freecabA;
        
       

        void init() {

             
            freecabA = map.findFreecabs();
            freeCab = new int[freecabA.size()][2];
            System.out.println(" size of free cab a " + freecabA.size());

            for (int i = 0; i < freecabA.size(); i++) {
                
                freeCab[i][0] = (int) freecabA.get(i).x;
                freeCab[i][1] = (int) freecabA.get(i).y;
               
            }


            Database forLandmark = new Database("C:\\Users\\jms\\Desktop\\landmark.txt");
            landmarks = forLandmark.landmarks();
            Database forAdjancy = new Database("C:\\Users\\jms\\Desktop\\array.txt");
            adjancy = forAdjancy.adjancy();

            distance = new Dijkstra(adjancy.length);





        }

        // find coordinae of matching cab
        int matchingLandmark(int x, int y) {
            System.out.println("matching lansg " + x + "  " + y);
            for (int i = 0; i < 50; i++) {
                if (landmarks[i][0] == x && landmarks[i][1] == y) {
                    return i;
                }
            }
            return -1;
        }

        // to find the index of free cab which is shortest to the request position
        int freecabInd(int dest) {
            int index = 0;
            int min = 0;
            int minIndex = 0;

            for(int i=0;i<freeCab.length;i++){

                int matLandmark = matchingLandmark(freeCab[index][0], freeCab[index][1]);

                int dis = distance.dijkstra(adjancy, matLandmark, dest);

                if (dis < min) {
                    min = dis;
                    minIndex = index;
                }
                index++;

            }

            return minIndex;

        }

        public void run() {
while(true){
            // init funtion to initialize matrix
            init();


            int current_time = (int)((System.currentTimeMillis()-starting_time)/(60000));             // instead of this we will use date object
            Database database = new Database("C:\\Users\\jms\\Desktop\\bookings.xml");
            
             System.out.println("current_time in  mm controller "+current_time);

            ArrayList<booking> bookingA = database.get_bookings(current_time);
            if (!bookingA.isEmpty()) {
                System.out.println("current_time in controller "+current_time);
                int[][] booking = new int[bookingA.size()][2];
                for (int i = 0; i < bookingA.size(); i++) {

                    booking[i][0] = Integer.parseInt(bookingA.get(i).fromlocation.split(" ")[0]);
                    booking[i][1] = Integer.parseInt(bookingA.get(i).fromlocation.split(" ")[1]);

                }

                // int[][] booking=database.get_bookings(current_time);

                int index = 0;
                
                System.out.println("booking length controoler "+booking.length);
               for(int i=0;i<booking.length;i++) {
   
                    int matchingInd = matchingLandmark(booking[index][0], booking[index][1]);
                    int cabInd = freecabInd(matchingInd);
 System.out.println("booking free cab size "+freeCab.length);
 
 System.out.println("booking object  "+bookingA.get(index).duration+" "+bookingA.get(index).fromlocation+" "+bookingA.get(index).toLocation+" ");
                    // set busy to this index cab ,, before this get the booking
                    map.set_busy(bookingA.get(index).duration, bookingA.get(index).fromlocation, bookingA.get(index).toLocation, freecabA.get(cabInd).reg);
                   Database delete=new Database("C:\\Users\\jms\\Desktop\\booking.txt");
                   delete.delete_entry(bookingA.get(index).duration);
                    Database deleteXml=new Database("C:\\Users\\jms\\Desktop\\bookings.xml");
                    deleteXml.setBusy(bookingA.get(index).duration);
                   
                    index++;
                }





            }
        }
        }
    }
}
