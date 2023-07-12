/*
 * <aside>
💡 **Question 4**

Given a binary array nums, return *the maximum length of a contiguous subarray with an equal number of* 0 *and* 1.

**Example 1:**

**Input:** nums = [0,1]

**Output:** 2

**Explanation:**

[0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

</aside>
 * 
 */

package in.ineuron.gouthami;


import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarray {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int maxLength = findMaxLength(nums);
        System.out.println("Contiguous SubArray is ::" +maxLength);
    }
}

