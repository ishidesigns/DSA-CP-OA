// Leetcode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// Time Complexity: O(logn)
// Space Complexity: O(1)

public class FirstLastPositionOfElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 3, 4};
        int target = 3;
        int[] result = firstLast(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] firstLast(int[] arr, int target){
        int fo = -1, lo = -1;
        int l = 0, r = arr.length - 1;
        fo = firstOccurance(arr, l, r, target);
        lo = lastOccurance(arr, l, r, target);
        return new int[] {fo, lo};
    }

    public static int firstOccurance(int[] arr, int l, int r, int target){
        int fo = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid] > target) r = mid - 1;
            if(arr[mid] < target) l = mid + 1;
            if(arr[mid] == target){
                fo = mid;
                r = mid - 1;
            }
        }
        return fo;
    }

    public static int lastOccurance(int[] arr, int l, int r, int target){
        int lo = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid] > target) r = mid - 1;
            if(arr[mid] < target) l = mid + 1;
            if(arr[mid] == target){
                lo = mid;
                l = mid + 1;
            }
        }
        return lo;
    }
}
