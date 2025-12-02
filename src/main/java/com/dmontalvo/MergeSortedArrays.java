package com.dmontalvo;
/**
 * Teniendo dos arrays de números enteros ordenados, mergearlos en uno, sin que se repitan y calcular la media.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortedArrays{

    public static int[] mergeArrays(int[] a,int[]b){
        int[] result=new int[a.length + b.length];
        int i=0,j=0,k=0;

        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                result[k]=a[i];
                i++;
                j++;
            }else if(a[i]<b[j]){
                result[k]=a[i];
                i++;
            }else{
                result[k]=b[j];
                j++;
            }
            k++;
        }

        while(i<a.length){
            result[k]=a[i];
            k++;
            i++;   
        }
        
        while(j<b.length){
            result[k]=b[j];
            k++;
            j++;   
        }
        
        return Arrays.copyOf(result, k);
    }   

    public double median(int[] array){
        if(array.length%2!=0){
            return (double)array[(array.length-1)/2];
        }else{
            int mid=array.length/2;
            return (double)(array[mid-1]+array[mid])/2;
        }
    }    
}