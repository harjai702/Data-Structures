//  Kosaraju’s algorithm strongest connected components
package com.company;
import java.util.*;
public class graph1 {
    int V;
    LinkedList<Integer> adj[];
    graph1(int v){
        V=v;
        adj=new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    public void addEdge(int s,int e){
        adj[s].add(e);
    }
    graph1 getTranspose()
    {
        graph1 g = new graph1(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }
    void DFSUtil(int src,int vis[]){
        vis[src]=1;
        System.out.print(src+" ");
        Iterator<Integer> itr=adj[src].listIterator();
        while(itr.hasNext()){
            int n=itr.next();
            if(vis[n]==0){
                DFSUtil(n,vis);
            }
        }
    }
    void dfs(int src,int vis[],Stack<Integer> stk){
        vis[src]=1;
        //System.out.println(src);
        Iterator<Integer> itr=adj[src].listIterator();
        while(itr.hasNext()){
            int n=itr.next();
            if(vis[n]==0){
                dfs(n,vis,stk);
            }
        }
        stk.push(src);
    }
    public void second(int vis[],Stack<Integer> stk,int v){
        graph1 gr = getTranspose();
        for (int i = 0; i < v; i++)
            vis[i] = 0;
        while (stk.empty() == false)
        {
            int q =stk.pop();
            if (vis[q] == 0)
            {
                gr.DFSUtil(q, vis);
                System.out.println();
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
        graph1 g=new graph1(v);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.dfs(0,vis,stk);
        g.second(vis,stk,v);
    }
}