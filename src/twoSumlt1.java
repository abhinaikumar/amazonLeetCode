import java.util.HashMap;
import java.util.Map;

public class twoSumlt1 {

    /*
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
     */

    /*
    first Approach: HashMap
     */

    public int[] twoSum(int[] nums, int target){
        int[] res=new int[2];
        if(nums==null || nums.length==0){
            return res;
        }
        Map<Integer, Integer> hashMap=new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(target-nums[i])){
                res[0]=hashMap.get(target-nums[i]);
                res[1]=i;
                break;
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return res;
    }


}
