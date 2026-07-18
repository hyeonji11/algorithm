package HashMapAndSet;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheDifferenceofTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        for(int val : set1) {
            if(!set2.contains(val)) {
                list1.add(val);
            }
        }

        for(int val : set2) {
            if(!set1.contains(val)) {
                list2.add(val);
            }
        }

        return List.of(list1, list2);

    }
}
