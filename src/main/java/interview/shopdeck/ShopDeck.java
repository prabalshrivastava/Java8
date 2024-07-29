package interview.shopdeck;

class ShopDeck {
    //You are given a 0-indexed integer array nums. In one step, remove all elements nums[i] where nums[i - 1] > nums[i] for all 0 < i < nums.length.
    //
    //Return the number of steps performed until nums becomes a non-decreasing array.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [5,3,4,4,7,3,6,11,8,5,11]
    //Output: 3
    //Explanation: The following are the steps performed:
    //- Step 1: [5,3,4,4,7,3,6,11,8,5,11] becomes [5,4,4,7,6,11,11]
    //- Step 2: [5,4,4,7,6,11,11] becomes [5,4,7,11,11]
    //- Step 3: [5,4,7,11,11] becomes [5,7,11,11]
    //[5,7,11,11] is a non-decreasing array. Therefore, we return 3.
    //Example 2:
    //
    //Input: nums = [4,5,7,7,13]
    //Output: 0
    //Explanation: nums is already a non-decreasing array. Therefore, we return 0.
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 105
    //1 <= nums[i] <= 109
    //123456789101112131415161718192021222324252627282930313233
    //class ShopDeck {
    //    public int totalSteps(int[] nums) {
    //        int i = 1;
    //        int removeCount = 0;
    //        int currentNum = nums[0];
    //        while(i < nums.length){
    //            while(nums[i] < currentNum){
    //                removeCount++;
    //                i++;
    //            }
    //…
    //
    ////5,3,4,4,7,3,6,11,8,5,11
    //
    //
    //Testcase
    //Result
    //java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 15
    //  at line 7, ShopDeck.totalSteps
    //  at line 56, __DriverSolution__.__helper__
    //  at line 86, __Driver__.main
    //Console
    //Participants2
    //
    //Chat
    //Press 'Return' key to send
    public int totalSteps(int[] nums) {
        int i = 1;
        int removeCount = 0;
        int currentNum = nums[0];
        while(i < nums.length){
            while(nums[i] < currentNum){
                removeCount++;
                i++;
            }
            if(i >= nums.length){
                break;
            }
            currentNum = nums[i];
            i++;
        }
        return removeCount/2;
    }
}


//1,34,4,1,4,5,7,8,9,0,1,3,45,1,3
//1,34,4,5,7,8,9,1,3,45,3
//1,34,5,7,8,9,3,45
//1,34,7,8,9,45
//1,34,8,9,45
//1,34,9,45
//1,34,45

//steps = 6


//5,3,4,4,7,3,6,11,8,5,11
