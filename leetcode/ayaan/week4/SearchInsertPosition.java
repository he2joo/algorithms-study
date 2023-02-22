package leetcode.ayaan.week4;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {3,6,7,8,10};
        int target = 5;

        int result = searchInsert(nums, target);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(num == target){
                result = i;
                break;
            } else if (num > target){
                if(i == 0){
                    if(target <= 0){
                        result = 0;
                    } else {
                        result = target-1;
                    }
                } else {
                    result = (i-1) + (target - nums[i-1]);
                }
                break;
            }

            if(i == nums.length-1){
                result = i + (target - nums[i]);
            }
        }
        return result;
    }
}
