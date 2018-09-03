public class productExceptSelflt238 {
    /*
    238. Product of Array Except Self

    Given an array nums of n integers where n > 1,
    return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    Example:
    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity?
    (The output array does not count as extra space for the purpose of space complexity analysis.)

     */

    /*
    first approach:
   [1,2,3,4] => [24, 12, 8, 6]
   1=2*3*4, 2=1*3*4, 3=1*2*4, 4=1*2*3
   left product: [1, 1, 2, 6]
   right product:[24,12,4,1]

   get the product except self => get the left part product of this number * the right part product of this number!!
     */

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums==null||nums.length==0)
            return res;
        //get left part of this product
        int left=1;
        for(int i=0; i<nums.length; i++){
            if(i==0){
               res[i]=left;
            }
            else{
                left*=nums[i-1];
                res[i]=left;
            }
        }
        int right=1;
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1){
                res[i]=res[i]*right;
            }
            else{
                right*=nums[i+1];
                res[i]=res[i]*right;
            }
        }
        return res;
    }

}
