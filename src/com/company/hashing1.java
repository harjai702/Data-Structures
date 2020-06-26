//Maximum distance between two occurrences of same element in array
package com.company;
import java.util.*;
public class hashing1 {
    public static void main(String args[]) {
        int arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> minmap = new HashMap<Integer, Integer>();
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            if (!minmap.containsKey(arr[i])) {
                minmap.put(arr[i], i);
            } else {
                hmap.put(arr[i], i-minmap.get(arr[i]));
            }
        }
        int a=0;
        for (Map.Entry<Integer,Integer> entry : hmap.entrySet()){
            int p=entry.getValue();
            if(p>a){
                a=p;
            }
        }
        System.out.println(a);
    }
}