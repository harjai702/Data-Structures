package com.company;

import java.util.*;
public class graph {
    int V;
    LinkedList<Integer> adj[];
    graph(int v){
        V=v;
        adj=new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    public void addEdge(int s,int e){
        adj[s].add(e);
        adj[e].add(s);
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
        int v=5;
        int vis[]=new int[v];
        for(int i=0;i<v;i++){
            vis[i]=0;
        }
        graph g1=new graph(v);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.dfs(0,vis);
    }
}