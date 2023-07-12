/*
 * <aside>
💡 **Question 1**

A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

- s[i] == 'I' if perm[i] < perm[i + 1], and
- s[i] == 'D' if perm[i] > perm[i + 1].

Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return **any of them**.

**Example 1:**

**Input:** s = "IDID"

**Output:**

[0,4,1,3,2]

</aside>
 * 
 */

package in.ineuron.gouthami;


import java.util.*;

public class ReconstructPermutation {
    public static int[] findPermutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];

        int small = 0;
        int large = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = small++;
            } else {
                perm[i] = large--;
            }
        }

        perm[n] = small; // Add the remaining number

        return perm;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] permutation = findPermutation(s);

        System.out.println("Permutations are ::"+Arrays.toString(permutation));
    }
}


