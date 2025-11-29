// You are given the requirement array + current stock array + cost array
//-> Tell the maximum number of units you can create in given budget
public class MaxUnitsInBudget {
    public static void main(String[] args) {
        int[] requirement = {3,2,4};
        int[] stock = {2,4,5};
        int[] cost = {3,2,2};
        int budget = 90;
        int ans = 0;
        int result = maxUnitsBS(requirement, stock, cost, budget, ans);
        System.out.println(result);
    }

    // TC -> sum of all required values -> O(max requirement * N)
    // SC -> O(1)
    static int maxUnits(int[] requirement, int[] stock, int[] cost, int budget, int ans){
        int i = 1;
        boolean check = false;

        while(!check){
            int sum = 0;
            for(int j = 0; j < requirement.length; j++){
                int p = requirement[j] * i;
                int need = p - stock[j];
                if(need < 0){
                    need = 0;
                }
                sum += need * cost[j];
            }
            if(sum > budget){
                check = true;
            }
            else {
                ans = i;
                i++;
            }
        }
        return ans;
    }

    // TC -> O(log(max requirement) * N)
    // SC -> O(1)
    static int maxUnitsBS(int[] requirement, int[] stock, int[] cost, int budget, int ans){

        long low = 0;
        long high = 1;
        while (true) {
            long needed = moneyNeeded(requirement, stock, cost, high, budget);
            if (needed > budget) break;
            low = high;
            if (high >= Integer.MAX_VALUE) {
                high = Integer.MAX_VALUE;
                break;
            }
            high <<= 1;
        }

        int res = (int) low;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long needed = moneyNeeded(requirement, stock, cost, mid, budget);
            if (needed <= budget) {
                res = (int) Math.min(mid, Integer.MAX_VALUE);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    static long moneyNeeded(int[] requirement, int[] stock, int[] cost, long units, int budget) {
        long sum = 0L;
        for (int j = 0; j < requirement.length; j++) {
            long p = (long) requirement[j] * units; // safe multiplication
            long need = p - stock[j];
            if (need > 0) {
                sum += need * (long) cost[j];
                if (sum > budget) return sum; // early exit when already over budget
            }
        }
        return sum;
    }
}
