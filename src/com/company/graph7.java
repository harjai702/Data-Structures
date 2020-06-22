// check cyclic undirected graph or not
package com.company;
import java.util.*;
public class graph7 {
    int V;
    LinkedList<Integer> adj[];
    graph7(int v){
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
        int count=0;
        vis[src]=1;
        Iterator<Integer> itr=adj[src].listIterator();
        while(itr.hasNext()){
            int n=itr.next();
            if(vis[n]==0){
                count=0;
                dfs(n,vis);
            }
            else{
                count++;
            }
            if(count>1){
                System.out.print("YEs");
            }
        }
    }
    public static void main(String args[]) {
        int v=4;
        int vis[]=new int[v];
        for(int i=0;i<v;i++){
            vis[i]=0;
        }
        graph7 graph=new graph7(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.dfs(0,vis);
    }
}