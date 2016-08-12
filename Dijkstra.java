/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabservice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author JMS
 */
public class Dijkstra {

    int V;
    static int[] parent;
    
  public  Dijkstra(int number) {
        this.V = number;
    }
// this method take an array in which minimum distance of various node from
// source node is stored. and print the slution;\
    
    
  public  int[] give_me_path_baby(int graph[][], int src, int des){
    
     Dijkstra dijk = new Dijkstra(4);
         int[][] adj = {{0,0,113,211},{0,0,194,122},{133,194,0,0},{211,122,0,0}};
         dijk.dijkstra(adj, 0,1);
         
    
// main method which take adjancy matrix and source node as an input.
    
        PriorityQueue<node> pq = new PriorityQueue<node>(2 * V,
                new Comparator<node>() { // min priority queue
                    @Override
                    public int compare(node n1, node n2) {
                        return n1.distace - n2.distace;
                    }
                });
        int[] dis = new int[V]; // dis store minimum distance of various node
        parent = new int[V];
// from source node
        for (int i = 0; i < V; i++) { // initialize dis[] with infinity distance
            dis[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            
        }
        dis[src] = 0; // initialize src to src distance as zero
        parent[src] = src;
        pq.add(new node(src, 0));
         System.out.println("hello before while");
        while (!pq.isEmpty()) { // looping untill priority queue become empty
            node x = pq.poll();
             System.out.println("hello while");
            int currv = x.vertexNumber, currdist = x.distace;
            if (currdist > dis[currv]) {
                 System.out.print("hello continue");
                continue;
            }
// if(currv == V ) break;
            for (int i = 0; i < V; i++) {
                int temp = graph[currv][i];
                if ((graph[currv][i] != 0) && (dis[i] > temp + currdist)) {
                    dis[i] = temp + currdist;
                    parent[i] = currv;
                    pq.add(new node(i, dis[i]));
                }
            }
        } // at this this stage we dis[] in which minimum distace is stored
         System.out.print("hello function");
        
return printSolution(dis, V , src , des); // this is to print the solution
      
    }
    

    
    
    
    int[] printSolution(int dist[], int n , int src ,  int des) {
        System.out.print("Vertex Distance from Source\n");
        int t = des;
        int len_path=0;
        int temp[] =new int[50];
        while( t != src){
            System.out.print(t + "  ");
            temp[len_path++]=t;
            t = parent[t];
            
            
            
        }
        int path[] = new int[len_path+1];
        for(int i=0;i<len_path+1;i++){
        if(i==0)
            path[i]=src;
        else{
        path[i]=temp[len_path-i];
                }
        
        System.out.println(path[i]);
            
        }
return path;
        
    }
    
    public static void main(String args[]){
        // System.out.print("hello");
         Dijkstra dijk = new Dijkstra(4);
         int[][] adj = {{0,0,113,211},{0,0,194,122},{133,194,0,0},{211,122,0,0}};
         dijk.dijkstra(adj, 0,1);
         
    }
// main method which take adjancy matrix and source node as an input.
    int dijkstra(int graph[][], int src, int des) {
        PriorityQueue<node> pq = new PriorityQueue<node>(2 * V,
                new Comparator<node>() { // min priority queue
                    @Override
                    public int compare(node n1, node n2) {
                        return n1.distace - n2.distace;
                    }
                });
        int[] dis = new int[V]; // dis store minimum distance of various node
        parent = new int[V];
// from source node
        for (int i = 0; i < V; i++) { // initialize dis[] with infinity distance
            dis[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            
        }
        dis[src] = 0; // initialize src to src distance as zero
        parent[src] = src;
        pq.add(new node(src, 0));
         System.out.println("hello before while");
        while (!pq.isEmpty()) { // looping untill priority queue become empty
            node x = pq.poll();
             System.out.println("hello while");
            int currv = x.vertexNumber, currdist = x.distace;
            if (currdist > dis[currv]) {
                 System.out.print("hello continue");
                continue;
            }
// if(currv == V ) break;
            for (int i = 0; i < V; i++) {
                int temp = graph[currv][i];
                if ((graph[currv][i] != 0) && (dis[i] > temp + currdist)) {
                    dis[i] = temp + currdist;
                    parent[i] = currv;
                    pq.add(new node(i, dis[i]));
                }
            }
        } // at this this stage we dis[] in which minimum distace is stored
       //  System.out.print("hello function");
        
//printSolution(dis, V , src , des); // this is to print the solution
        return dis[des];
    }
}

class node { // node class
    int vertexNumber;
    int distace;

    node(int num, int dis) {
        this.distace = dis;
        this.vertexNumber = num;
    }
}