//TC: O(n)
//SC: O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers to get the XOR of the two unique numbers (x ^ y)
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        
        // Step 2: Find the rightmost set bit in xorResult (this will help in splitting numbers)
        int mask = xorResult & -xorResult; // Isolates the rightmost set bit
        
        // Step 3: Use the mask to divide numbers into two groups and XOR within each group
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                // Group 1: The bit at 'mask' position is 0
                num1 ^= num;
            } else {
                // Group 2: The bit at 'mask' position is 1
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2}; // Return the two unique numbers
    }
}
