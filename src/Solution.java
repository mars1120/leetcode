import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    //Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        var profit = 0;
        var buy=Integer.MAX_VALUE;

        for (int x=0;x<prices.length;x++) {
            if(prices[x]<buy){
                buy=prices[x];
            }
            var cacheProfit=prices[x]-buy;
            if(cacheProfit>profit)
                profit=cacheProfit;
        }

        return profit;
    }

    //Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        HashMap hs = new HashMap<>();
        for (int i:nums) {
            if(hs.get(i)!=null)
                return true;
            hs.put(i,true);
        }
        return false;
    }

   // Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        //example: input 1,2,3,4,5
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 1;//most-left
        right[n - 1] = 1;//most-right

        //left will become 1,1,2,6,24
        for (int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        //right will becom 120(5*4*3*2),60(5*4*3),20(5*4),5(5*1),1
        for (int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        int ans[] = new int[n];
        for (int i=0;i<n;i++) {
            ans[i]= left[i]*right[i];
        }
        return ans;
    }
    
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int x=0;x<nums.length;x++){
            sum+= nums[x];
            max=Math.max(sum,max);
        if(sum<0)
            sum=0;
        }
        return max;

    }
}
