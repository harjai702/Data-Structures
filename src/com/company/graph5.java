// Deapth first search
package com.company;
import java.util.*;
public class graph5 {
    int V;
    LinkedList<Integer> adj[];
    graph5(int v){
        V=v;
        adj=new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    public void addEdge(int s,int e){
        adj[s].add(e);
    }
    void dfs(int src,int vis[]){
        vis[src]=1;
        System.out.println(src);
        Iterator<Integer> itr=adj[src].listIterator();
        while(itr.hasNext()){
            int n=itr.next();
            if(vis[n]==0){
                dfs(n,vis);
            }
        }
    }
    public static void main(String args[]) {
        int v=6;
        int vis[]=new int[v];
        for(int i=0;i<v;i++){
            vis[i]=0;
        }
        graph5 g=new graph5(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.dfs(2,vis);
    }
}