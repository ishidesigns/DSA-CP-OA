// GFG Link: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
// Time Complexity: O(n*logm)
// Space Complexity: O(1)
public class NthRootOfM {
    public static void main(String[] args) {
        int n = 3;
        int m = 25;
        int result = findNthRoot(n, m);
        
        System.out.println(result);
    }

    static int findNthRoot(int n, int m) {
        if (m == 0) return 0;
        int l = 1, r = m;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cmp = comparePow(mid, n, m);
            if (cmp == 0) return mid;
            else if (cmp < 0) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    static int comparePow(int a, int n, int m) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= a;
            if (res > m) return 1;
        }
        if (res == m) return 0;
        return -1;
    }
}

