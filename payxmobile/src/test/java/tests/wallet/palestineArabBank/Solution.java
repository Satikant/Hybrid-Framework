package tests.wallet.palestineArabBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
      return  findSubset(nums ,  dp, 3 );

    }

    public static int getLSize(int[] nums , int[] dp){
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int lSize = 1;
        for(int i =1 ; i< nums.length ; i++){
            for(int j = 0; j<i ;j++){
                if(nums[i] % nums[j]==0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    lSize = Math.max(lSize,dp[i]);
                }
            }
        }
        return lSize;
    }

    public static List<Integer> findSubset(int[] nums , int[] dp , int lSize){
        List<Integer> list = new ArrayList<Integer>();
        int prev = -1;
        for(int i = dp.length-1 ; i>0; i-- ){
            if(dp[i] == lSize && prev== -1 || prev % nums[i] == 0){
                list.add(nums[i]);
                lSize--;
                prev = nums[i];
            }
        }
        return list;
    }


}
