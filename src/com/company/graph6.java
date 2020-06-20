// program to find the mother vertex of a graph
package com.company;
import java.util.*;
public class graph6 {
    int V;
    LinkedList<Integer> adj[];
    graph6(int v){
        V=v;
        adj=new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    public void addEdge(int s,int e){
        adj[s].add(e);
    }
    void dfs(int src,int vis[],Stack<Integer> stk){
        vis[src]=1;
        stk.push(src);
        Iterator<Integer> itr=adj[src].listIterator();
        while(itr.hasNext()){
            int n=itr.next();
            if(vis[n]==0){
                dfs(n,vis,stk);
            }
        }
    }
    public static void main(String args[]) {
        int v=5;
        int vis[]=new int[v];
        for(int i=0;i<v;i++){
            vis[i]=0;
        }
        Stack<Integer> stk=new Stack<Integer>();
        graph6 g=new graph6(v);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        for(int i=0;i<v;i++){
            g.dfs(i,vis,stk);
            if(stk.size()==v){
                System.out.println(i);
            }
            stk.clear();
            for(int j=0;j<v;j++){
                vis[j]=0;
            }
        }
    }
}