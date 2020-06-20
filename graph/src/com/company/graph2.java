// dijkstra_shortestpath_algorithm
package com.company;
import java.util.*;
public class graph2 {
    static int V=6;
    public static void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    public static int mindist(int dist[],Boolean spt[]){
        int min=Integer.MAX_VALUE,min_index=-1;
        for(int i=0;i<V;i++){
            if(spt[i]==false&&dist[i]<=min){
                min=dist[i];
                min_index=i;
            }
        }
        return min_index;
    }
    public static void dijkstra(int graph[][],int src){
        int dist[]=new int[V];
        Boolean spt[]=new Boolean[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            spt[i]=false;
        }
        dist[src]=0;
        for(int count=0;count<V-1;count++){
            int u=mindist(dist,spt);
            spt[u]=true;
            for(int v=0;v<V;v++){
                if(!spt[v]&&dist[u]!=Integer.MAX_VALUE&&graph[u][v]!=0&&dist[u] + graph[u][v] < dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }
        printSolution(dist);
    }
    public static void main(String args[]) {
        int graph[][]=new int[][]{{0,4,8,0,0,0},{4,0,11,8,0,0},{8,11,0,0,1,7},{0,8,0,0,0,2},{0,0,1,0,0,6},{0,0,7,2,6,0}};
        dijkstra(graph,3);
    }
}