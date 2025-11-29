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

    // TC -> O(log(max requirement * N))
    // SC -> O(1)
    static int maxUnitsBS(int[] requirement, int[] stock, int[] cost, int budget, int ans){
        int low = 0, high = Integer.MAX_VALUE;
        while (low < high){
            int sum = 0;
            int mid = low + (high - low)/2;
            for(int j = 0; j < requirement.length; j++){
                int p = requirement[j] * mid;
                int need = p - stock[j];
                if(need < 0){
                    need = 0;
                }
                sum += need * cost[j];
            }
            if(sum > budget){
                high = mid - 1;
            }
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}
