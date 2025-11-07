// Leetcode Link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/



public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        int result = singleNonDuplicate(arr);
        System.out.println(result);
    }

    static int singleNonDuplicate(int[] arr) {

//      Time Complexity: O(logn)
//      Space Complexity: O(1)
//        int l = 0, r = arr.length - 1;
//        while(l < r){
//            int mid = l + (r - l) / 2;
//            // System.out.println(l + " " + mid + " " + r);
//            if(mid % 2 == 0) {
//                if(arr[mid] != arr[mid + 1]) r = mid;
//                else l = mid + 1;
//            }
//            else {
//                if(arr[mid] == arr[mid + 1]) r = mid - 1;
//                else l = mid + 1;
//            }
//        }
//        return arr[l];

//      Time Complexity: O(n)
//      Space Complexity: O(1)
        int result = 0;
        for(int a : arr){
            result ^= a;
        }
        return result;
    }
}
