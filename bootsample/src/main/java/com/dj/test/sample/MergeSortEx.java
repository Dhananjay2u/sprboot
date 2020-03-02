package com.dj.test.sample;

import java.util.Arrays;

public class MergeSortEx {
    
    public void sort(int [] arr,int i, int l) {
        if(i<l) {
            int m=(i+l)/2;
            sort(arr,i,m);
            sort(arr,m+1,l);
            merge(arr,i,m,l);
        }
    }
    
    public void merge(int [] arr,int i, int m, int l) {
        
        int s_arr1=m-i+1;
        int s_arr2=l-m;
        int arr1[]=new int[s_arr1];
        int arr2[]=new int[s_arr2];
        for(int p=0;p<s_arr1;p++) {
            arr1[p]=arr[i+p];
        }
        for(int p=0;p<s_arr2;p++) {
            arr2[p]=arr[m+1+p];
        }
        
        int p=0,q=0;
        int r=i;
        while(p <s_arr1 && q<s_arr2) {
            if(arr1[p]<=arr2[q]) {
                arr[r]=arr1[p];
                p++;
            }
            else {
                arr[r]=arr2[q];
                q++;
            }
            r++;
        }
        while(p<s_arr1) {
            arr[r]=arr1[p];
            p++;
            r++;
        }
        while(q<s_arr2) {
            arr[r]=arr2[q];
            q++;r++;
        }
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MergeSortEx ex=new MergeSortEx();
        int arr[] = {2,8,4,10,9};
        ex.sort(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }

}
