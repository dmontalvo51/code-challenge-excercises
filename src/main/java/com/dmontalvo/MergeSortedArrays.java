package com.dmontalvo;
/**
 * Teniendo dos arrays de números enteros ordenados, mergearlos en uno, sin que se repitan y
 * calcular la media.
 */

public class MergeSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length + nums2.length];
    double median = 0.0;
    int i = 0, j = 0, k = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        result[k] = nums1[i];
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        result[k] = nums1[i];
        i++;
      } else {
        result[k] = nums2[j];
        j++;
      }
      median += result[k];
      k++;
    }

    while (i < nums1.length) {
      result[k] = nums1[i];
      median += result[k];
      k++;
      i++;
    }

    while (j < nums2.length) {
      result[k] = nums2[j];
      median += result[k];
      k++;
      j++;
    }

    return median / k;
  }

}