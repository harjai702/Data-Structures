// breadth first traversal
package com.company;
import java.util.*;
public class graph4 {
    static int V=4;
    public static void bfs(int graph[][],int src){
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            vis[i]=0;
        }
        Queue<Integer> qw=new LinkedList<Integer>();
        System.out.println(src);
        vis[src]=1;
        for(int i=0;i<V-1;i++){
            for(int v=0;v<V;v++){
                if(graph[src][v]!=0&&vis[v]==0){
                    qw.add(v);
                    vis[v]=1;
                }
            }
            int temp=qw.remove();
            System.out.println(temp);
            src=temp;
        }
    }
    public static void main(String args[]) {
        int graph[][]=new int[][]{{0,1,1,0},{1,0,1,0},{1,1,0,1},{0,0,1,1}};
        bfs(graph,2);
    }
}