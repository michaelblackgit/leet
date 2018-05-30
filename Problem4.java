// Median of two sorted arrays

import java.lang.Math;

public class Problem4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int min = 0;
    int max = nums1.length;
    int i, j;
    int[] A = nums1;
    int[] B = nums2;

    if(A.length > B.length) {
      A = nums2;
      B = nums1;
    }

    int m = A.length;
    int n = B.length;

    if(m == 0) {
      return n % 2 == 0 ? (B[n/2 - 1] + B[n/2]) / 2.0 : B[n/2];
    }

    if(n == 0) {
      return m % 2 == 0 ? (A[m/2 - 1] + A[m/2]) / 2.0 : A[m/2];
    }

    while(min <= max) {
      i = (min + max) / 2;
      j = ((m + n + 1) / 2) - i;

      if(i > m) max = i - 1;

      // System.out.println("i: " + i);
      // System.out.println("j: " + j);
      // System.out.println("m: " + m);
      // System.out.println("n: " + n);
      // System.out.println("min: " + min);
      // System.out.println("max: " + max);

      else if(i < max && i < m && j > 0 && B[j - 1] > A[i]) {
        min = i + 1;
      }

      else if(i > min && j < n && i > 0 && A[i - 1] > B[j]) {
        max = i - 1;
      }

      else if((j == 0 || i == m || B[j - 1] <= A[i]) && (i == 0 || j == n || A[i - 1] <= B[j])) {
        return getMedian(A, B, i, j);
      }
    }

    return 0;
  }

  private double getMedian(int[] A, int[] B, int i, int j) {
    int left, right;

    if(i == 0) left = B[j - 1];
    else if(j == 0) left = A[i - 1];
    else left = Math.max(A[i - 1], B[j - 1]);

    if((A.length + B.length) % 2 != 0) return left;

    if(i == A.length) right = B[j];
    else if(j == B.length) right = A[i];
    else right = Math.min(A[i], B[j]);

    return (left + right) / 2.0;
  }

  public static void main(String[] args) {
    Problem4 p4 = new Problem4();

    int[] nums1 = new int[] {1,3};
    int[] nums2 = new int[] {2};
    System.out.println(p4.findMedianSortedArrays(nums1, nums2));

    int[] nums3 = new int[] {1,2};
    int[] nums4 = new int[] {3,4};
    System.out.println(p4.findMedianSortedArrays(nums3, nums4));

    int[] nums5 = new int[] {3,4};
    int[] nums6 = new int[] {};
    System.out.println(p4.findMedianSortedArrays(nums5, nums6));

    int[] nums7 = new int[] {};
    int[] nums8 = new int[] {1};
    System.out.println(p4.findMedianSortedArrays(nums7, nums8));

    int[] nums9 = new int[] {1,2};
    int[] nums10 = new int[] {3};
    System.out.println(p4.findMedianSortedArrays(nums9, nums10));

    int[] nums11 = new int[] {2,3,4,5};
    int[] nums12 = new int[] {1};
    System.out.println(p4.findMedianSortedArrays(nums11, nums12));
  }
}
