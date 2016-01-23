/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        ret.add(new ArrayList<Integer>());

        Arrays.sort(nums);

        for (int n = 1; n <= nums.length; n++) {
            ret.addAll(pickN(nums, 0, n));
        }

        return ret;
    }
    public List<List<Integer>> pickN(int[] nums, int start, int N) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = start; i <= nums.length - N; i++) {
            if (N == 1) {
                List<Integer> c = new ArrayList<Integer>();
                c.add(nums[i]);
                ret.add(c);
            } else {
                for (List<Integer> sub : pickN(nums, i + 1, N - 1)) {
                    List<Integer> copy = new ArrayList<Integer>(sub);
                    copy.add(0, nums[i]);

                    ret.add(copy);
                }
            }
        }

        return ret;
    }
}


public class Subsets {
    public static void main(String[] args) {
        int[] nums = {4, 1, 0};

        Solution s = new Solution();

        for (List<Integer> l : s.subsets(nums)) {
            System.out.print("[");
            for (int n : l) {
                System.out.format("%d ", n);
            }
            System.out.print("]\n");
        }
    }
}

