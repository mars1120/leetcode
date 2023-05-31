import java.lang.reflect.Array;
import java.util.*;

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

    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i =1;i<nums.length;i++)
        {
            if(nums[i]<0){
                //swap
                int cache = max;
                max= min;
                min=cache;
            }
            max=Math.max(nums[i],max*nums[i]);
            min= Math.min(nums[i],min*nums[i]);
            result=Math.max(max,result);
        }
        return result;
    }

    public int findMin(int[] nums) {
        int l = nums[0], r = nums[nums.length - 1];
        int minResult = l < r ? l : r;
        for (int i = 0; i <= nums.length / 2; i++) {
            l = nums[i];
            r = nums[nums.length - 1 - i];
            var cache = l < r ? l : r;
            minResult = Math.min(cache, minResult);
        }
        return minResult;
    }

    public int search(int[] nums, int target) {
        int l = nums[0], r = nums[nums.length - 1];
        for (int i = 0; i <= nums.length / 2; i++) {
            l = nums[i];
           if(l==target)  return i;
            r = nums[nums.length - 1 - i];
            if(r==target)  return nums.length - 1 - i;
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i <= nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ArrayList<Integer> sp = new ArrayList<>();
                    sp.add(nums[i]);
                    sp.add(nums[l]);
                    sp.add(nums[r]);
                    ans.add(sp);

                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }

            }
        }
        return new ArrayList<>(ans);

    }

    public int maxArea(int[] height) {
        int currentMax = Integer.MIN_VALUE;
        int lIdx = 0;
        int rIdx = height.length - 1;
        while (lIdx < rIdx) {
            int spacing = Math.abs(lIdx - rIdx);
            int l = height[lIdx];
            int r = height[rIdx];
            int sum = 0;
            int minHeight = Math.min(l, r);
            sum = spacing * minHeight;
            if (sum > currentMax) currentMax = sum;
            if (l < r)
                lIdx++;
            else
                rIdx--;
        }

        return currentMax;
    }
}
