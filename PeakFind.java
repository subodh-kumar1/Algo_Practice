/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstapplication;

/**
 *
 * @author User
 */
public class PeakFind {
    // A binary search based function that returns index of a peak element
    static int findPeakUtil(int arr[], int low, int high, int n){
        
        // Find index of middle element
        int mid = low + (high - low)/2;  /* (low + high)/2 */
        
        // Compare middle element with its neighbours (if neighbours exist)
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
             arr[mid+1] <= arr[mid]))
            return mid;
        // If middle element is not peak and its left neighbor is 
        //greater than it,then left half must have a peak element
        else if (mid > 0 && arr[mid-1] > arr[mid])
            return findPeakUtil(arr, low, (mid -1), n);
 
        // If middle element is not peak and its right neighbor
        // is greater than it, then right half must have a peak
        // element
        else return findPeakUtil(arr, (mid + 1), high, n);
    }
    
    static int findPeak(int arr[], int n)
    {
        return findPeakUtil(arr, 0, n-1, n);
    }
    
    public static void main(String[] args){
        int arr[] = {1,2,3,7,4,5};
        int n = arr.length;
        int index = findPeak(arr, n);
        System.out.println("Index of Peak Element = " + index + " Value is = " + arr[index]);
    }
}
