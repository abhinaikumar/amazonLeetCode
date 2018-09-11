import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest215 {
    /*
    215. Kth Largest Element in an Array
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Example 1:

    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    Example 2:

    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
     */

    /*
    simple solution: sort then count
     */

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            count++;
            if (count == k)
                return nums[i];
        }
        return -1;
    }

    /*
    priority queue
     */
    public int findKthLargestII(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            queue.add(nums[i]);
        }
        int target = nums.length - k;
        int res = 0;
        while (target >= 0) {
            res = queue.poll();
            target--;
        }
        return res;
    }

    /*
    O(n) quick select: PDT partner Online Assignment Problem


     */

    public int findKthLargestIII(int[] nums, int k) {

        int left=0;
        int right=nums.length-1;
        while(true){
            int pos=partation(nums, left, right);
            if(pos+1==k)
                return nums[pos];
            if(pos+1<k){
                left=pos+1;
            }
            if(pos+1>k){
                right=pos-1;
            }
        }

    }

    private int partation(int[] nums,int left,int right){

        int pivot=nums[left];
        int l=left+1;
        int r=right;

        while(l<=r){
            if(nums[l]<=pivot && nums[r]>=pivot){
                swap(nums, nums[l], nums[r]);
                l++;
                r--;
            }
            if(nums[l]>=pivot)
                l++;
            if(nums[r]<=pivot)
                r--;
        }
        swap(nums, left, r);    //last step swap pivot to correct position
        return r;
    }

    private void swap(int[] nums, int l, int r){
        int tmp=nums[l];
        nums[l]=nums[r];
        nums[r]=tmp;
    }

}

/*
 核心思想：quickselect

    nums中取一个数，然后做partition，比他小的在他右边，比他大的在他左边！这里不要搞反了，因为我们要找第k个大的数，所以要降序排列

    partition方法：去第一个值是pivot，然后排序他后面的所有nums，用two pointers指首尾然后swap来做，如果num[left]比pivot小，而且
    num[right]比pivot那么swap，并且++--，如果nums[left]pivotsh说明这个数字不要挪动，那么left++，如果nums[right]比pivot小，那么也
    不需要挪到，right--，这个思路跟排序从小到大是相反的，因为我们要的是从大到小，求的是第k个大的数字！！！


    public int findKthLargest(int[] nums, int k) {

        if(nums==null || nums.length==0)
            return 0;

        int left=0;
        int right=nums.length-1;
        while(true){
            int pos=partition(nums,left,right);

            if(pos+1==k){
                return nums[pos];
            }
            else if(pos+1>k){
                right=pos-1;
            }
            else{
                left=pos+1;
            }
        }

    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l=left+1;
        int r=right;
        while(l<=r){
            if(nums[l]<pivot && nums[r]>pivot){
                swap(nums,l++,r--);
            }
            if(nums[l]>=pivot) l++;
            if(nums[r]<=pivot) r--;
        }
        swap(nums,left,r);
        return r;
    }


    public void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

 */
