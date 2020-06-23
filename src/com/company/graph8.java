//Count the number of nodes at given level in a tree using BFS
package com.company;
import java.util.*;
public class graph8 {
    int V;
    int count=0;
    LinkedList<Integer> adj[];
    graph8(int v){
        V=v;
        adj=new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    void bfs(int src,int vis[],int ver,int levl){
        Queue<Integer> stk=new LinkedList<Integer>();
     vis[src]=1;
     int[] lev=new int[ver];
        for(int i=0;i<ver-1;i++) {
            lev[0]=0;
            Iterator<Integer> itr=adj[src].listIterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if(vis[v]==0){
                    vis[v]=0;
                    lev[v]=lev[i]+1;
                    stk.add(v);
                }
            }
            src=stk.remove();

        }
        for(int i=0;i<ver;i++){
            if(lev[i]==levl-1){
                count++;
            }
        }
        System.out.println(count);
    }
    public void addEdge(int s,int e){
        adj[s].add(e);
    }
    public static void main(String args[]) {
        int v=7;
        int vis[]=new int[v];
        for(int i=0;i<v;i++){
            vis[i]=0;
        }
        int levl=3;
        graph8 g=new graph8(v);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 6);
        g.bfs(0,vis,v,levl);
        }
    }