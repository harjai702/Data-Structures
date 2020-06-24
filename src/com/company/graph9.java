//Hacker rank roads and libraries problem
package com.company;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class graph9 {
    int V;
    LinkedList<Integer> adj[];
    graph9(int v){
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
    public void fun1(int child[],int n){
        int count=0;
        for(int i=0;i<n;i++){
            Iterator<Integer> itr=adj[i].listIterator();
            while(itr.hasNext()){
                int l=itr.next();
                count++;
            }
            child[i]=count;
            count=0;
        }
    }
    public int bfsutil(int j,int child[],int vis[]){
        Iterator<Integer> itr=adj[j].listIterator();
        int count=0;
        while(itr.hasNext()){
            int w=itr.next();
            vis[w]=1;
            child[w]=-1;
            count++;
        }
        return count;
    }
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int q=scan.nextInt();
        for(int k=0;k<q;k++){
            int n=scan.nextInt();
            int m=scan.nextInt();
            int clib=scan.nextInt();
            int croad=scan.nextInt();
            int vis[]=new int[n];
            int child[]=new int[n];
            for(int i=0;i<n;i++){
                vis[i]=0;
            }
           graph9 g=new graph9(n);

            for(int i=0;i<m;i++){
                int a=scan.nextInt();
                int b=scan.nextInt();
                g.addEdge(a-1,b-1);
            }
            g.fun1(child,n);
            int libcount=0;
            int roadcount=0;
            for(int i=0;i<n;i++){
                int w=child[0];
                int indx=0;
                for(int j=0;j<n;j++){
                    if(child[j]>w){
                        w=child[j];
                        indx=j;
                    }
                }
                if(w!=-1){
                    libcount++;
                    child[indx]=-1;
                    vis[indx]=1;
                    roadcount=roadcount+g.bfsutil(indx,child,vis);
                }
                else{
                    break;
                }
            }
            if(croad>clib){
                System.out.println(clib*n);
            }
            else{
                System.out.println((libcount*clib)+(roadcount*croad));
            }
        }
    }
}
