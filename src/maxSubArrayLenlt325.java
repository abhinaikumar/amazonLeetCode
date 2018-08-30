import java.util.HashMap;
import java.util.Map;

public class maxSubArrayLenlt325 {
    /*
    325. Maximum Size Subarray Sum Equals k

    Input: nums = [1, -1, 5, -2, 3], k = 3
    Output: 4
    Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.

    Input: nums = [-2, -1, 2, 1], k = 1
    Output: 2
    Explanation: The subarray [-1, 2] sums to 1 and is the longest.

     */

    /*
    first approach: brute force time:O(n!)
     */

    public int maxSubArrayLen(int[] nums, int k) {
        int count=nums.length;
        int max=0;
        for(int i=0;i<nums.length; i++){
            int sum=0;
            int len=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                len++;
                if(sum==k){
                    if(len>max){
                       max=len;
                    }
                }
            }
        }
        return max;
    }

    /*
    second approach: hashtable O(n)
     */
    public static int maxSubArrayLen2(int[] nums, int k) {
        int sum=0; int max=0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(sum==k){
                max=i+1;
            }
            //check previousSum = current-k!
            //if currentSum=1,k=-1; if it has a previousSum=2 which means from privousSum index to current index = -1 which
            // is equal to k! so the length = i-previousIndex! the key idea!
            else if(hashMap.containsKey(sum-k)){
                max=Math.max(max, i-hashMap.get(sum-k));
            }
            if(!hashMap.containsKey(sum)){
                hashMap.put(sum,i);
            }
        }
        for(Map.Entry e:hashMap.entrySet()){
            System.out.println(e.getValue());
        }

        return max;
    }




    public static void main(String[] args) {
        int[] nums={1, -1, 2, 1};
        int k=-1;
        System.out.println(maxSubArrayLen2(nums,k));
    }


}
