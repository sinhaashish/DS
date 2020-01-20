/* Program to find the maximum Value in Contiguous subsequence
Given an array on n numbers , give an algorithm for finding the contiguous 
subsequence  A(i) ... A(j) , For which the sum of element is maximum.
Ex : { -2,11, -4, 13, -5, 2 } -> 20

*/



public class MaximumValueContigousSubsequence {
  public static void main(String args[]) {

    int arr[] =  { -2, 11, -4, 13, -5, 2 };
    System.out.println( " The maximum sum is " +MaxContigousSum(arr));

  }

  public static int MaxContigousSum( int arr[]){
    int maxSum = arr[0];
    int sum =0;

    for (int i =0; i < arr.length; i ++) {
      sum = Math.max( sum + arr[i], arr[i]);
      maxSum = Math.max( maxSum, sum);
    }
     return maxSum;
  }
}