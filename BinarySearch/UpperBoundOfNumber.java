// Given a sorted array of size “N”; find the index of the number in the array
// which is just greater than x and as close as possible to x.

// Time Complexity: O(logn)
// Space Complexity: O(1)

import java.util.Scanner;

public class UpperBoundOfNumber {
    public static void main(String[] args) {
        int[] arr = {4,6,8,11,13,14};
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int result = upperbound(arr, target);
        if(arr[arr.length - 1] < target)
            System.out.println("Element not found");
        else
            System.out.println(arr[result]);
    }

    public static int upperbound(int[] arr, int target){
        int ans = -1;
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid] > target){
                ans = mid;
                r = mid - 1;
            }
            if(arr[mid] <= target) l = mid + 1;
        }
        return ans;
    }
}
