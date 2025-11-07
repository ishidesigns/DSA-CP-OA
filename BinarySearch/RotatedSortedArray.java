// Leetcode Link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// Time Complexity: O(logn)
// Space Complexity: O(1)

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {6,7,1,2,3,4,5};
        int target = 5;
        int result = search(arr, target);
        System.out.println(result);
    }

    static int search(int[] arr, int target){
        int s = 0, e = arr.length - 1;

        while(s <= e){
            int mid = s + (e - s)/2;
            if(arr[mid] == target) return mid;

//            if(arr[mid] < arr[s]){
//                if(target > arr[mid] && target <= arr[e]) s = mid + 1;
//                else e = mid - 1;
//            }
//            else{
//                if(target >= arr[s] && target < arr[mid]) e = mid - 1;
//                else s = mid + 1;
//            }

            if(arr[mid] >= arr[0]){
                if(target > arr[mid] || target < arr[0]) s = mid + 1;
                else e = mid - 1;
            } else{
                if(target < arr[mid] || target > arr[arr.length - 1]) e = mid - 1;
                else s = mid + 1;
            }
        }
        return -1;
    }
}
