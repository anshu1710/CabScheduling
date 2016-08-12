/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabservice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class dijkst {

    int V;
    static int parent[];

    dijkst(int number) {
        this.V = number;
    }
// this method take an array in which minimum distance of various node from
// source node is stored. and print the slution;
    void printSolution(int dist[], int n) {
        System.out.print("Vertex Distance from Source\n");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }
// main method which take adjancy matrix and source node as an input.
    void dijkstra(int graph[][], int src) {
        PriorityQueue<node> pq = new PriorityQueue<node>(2 * V,
                new Comparator<node>() { // min priority queue
                    @Override
                    public int compare(node n1, node n2) {
                        return n1.distace - n2.distace;
                    }
                });
        int[] dis = new int[V]; // dis store minimum distance of various node
// from source node
        for (int i = 0; i < V; i++) { // initialize dis[] with infinity distance
            dis[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        dis[src] = 0; // initialize src to src distance as zero
        parent[src] = src;
        
        pq.add(new node(src, 0));
        while (!pq.isEmpty()) { // looping untill priority queue become empty
            node x = pq.poll();
            int currv = x.vertexNumber, currdist = x.distace;
            if (currdist > dis[currv]) {
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
        printSolution(dis, V); // this is to print the solution
    }
}

//
