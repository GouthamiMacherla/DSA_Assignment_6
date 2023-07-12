/*
 * <aside>
💡 **Question 6**

An integer array original is transformed into a **doubled** array changed by appending **twice the value** of every element in original, and then randomly **shuffling** the resulting array.

Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not a **doubled** array, return an empty array. The elements in* original *may be returned in **any** order*.

**Example 1:**

**Input:** changed = [1,3,4,2,6,8]

**Output:** [1,3,4]

**Explanation:** One possible original array could be [1,3,4]:

- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.

Other original arrays could be [4,3,1] or [3,1,4].

</aside>
 * 
 */

package in.ineuron.gouthami;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubledArray {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : changed) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> originalList = new ArrayList<>();
        for (int num : changed) {
            if (frequencyMap.getOrDefault(num, 0) == 0) {
                continue;
            }

            if (frequencyMap.getOrDefault(2 * num, 0) == 0) {
                return new int[0];
            }

            originalList.add(num);
            frequencyMap.put(num, frequencyMap.get(num) - 1);
            frequencyMap.put(2 * num, frequencyMap.get(2 * num) - 1);
        }

        int[] original = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            original[i] = originalList.get(i);
        }

        return original;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);

        if (original.length == 0) {
            System.out.println("No original array exists.");
        } else {
            System.out.print("Original array: [");
            for (int i = 0; i < original.length - 1; i++) {
                System.out.print(original[i] + ", ");
            }
            System.out.println(original[original.length - 1] + "]");
        }
    }
}

