package src.com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();


        for(int i: nums1) {
            if(map.containsKey(i)) {
                int v = map.get(i);
                map.put(i, ++v);
            } else {
                map.put(i, 1);
            }
        }

        System.out.println(map);

        for(int i: nums2) {
            if(map.containsKey(i)) {
                int v = map.get(i);
                v--;
                l.add(i);
                if(v == 0) {
                    map.remove(i);
                } else {
                    map.put(i, v);
                }
            }
        }

        return l.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
