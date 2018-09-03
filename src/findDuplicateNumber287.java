import java.util.HashSet;
import java.util.Set;

public class findDuplicateNumber287 {

    /*
    287. Find the Duplicate Number

    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

    Example 1:

    Input: [1,3,4,2,2]
    Output: 2
    Example 2:

    Input: [3,1,3,4,2]
    Output: 3

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.
    */

    /*
    first approach: use O(n) space.

     */
    public int findDuplicate(int[] nums) {
        int res=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length;i++){
            if(set.contains(nums[i])){
                res=nums[i];
                break;
            }else{
                set.add(nums[i]);
            }
        }
        return res;
    }


    /*
    second approach: cyclic entry point detect!!!!!!!!!!!!!!!!
    nums = 1, 3, 4, 2, 2
    slow = 1, 3, 2, 4, 2, 4, 2
    fast = 3, 4, 4, 4,
    slow = 2, 4, 2
    p    = 1, 3, 2
     */

    public static int findDuplicateNumbers(int[] nums){

        int slow=nums[0];
        int fast=nums[nums[0]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int p=0;
        while(slow!=p){
            p=nums[p];
            slow=nums[slow];
        }
        return p;
    }


    public static void main(String[] args) {
        int[] n={1,3,4,2,2};
        System.out.println(findDuplicateNumbers(n));
    }



}
