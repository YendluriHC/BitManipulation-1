//TC: O(log N)
//SC: O(1)
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Return the maximum 32-bit signed integer
        }
        
        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Convert both numbers to their absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        int result = 0;
        
        // Shift the divisor left until it's greater than or equal to the dividend
        while (absDividend >= absDivisor) {
            long temp = absDivisor, multiple = 1;
            
            // Shift left until temp * 2 would exceed dividend
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the largest shifted divisor from the dividend
            absDividend -= temp;
            result += multiple;
        }
        
        // Apply the sign to the result
        return negative ? -result : result;
    }
}
