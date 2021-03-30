package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DroppingShip {

    public static void main(String[] args) {
        int[] input = {1,2,6,4,2,3,1,8,9,2};

        boolean decreaseFlag = false; // false
        boolean increaseFlag = false;  //true

        List<List<Integer>> result = new ArrayList<>(); // [{1,2,6}, {6,4,2}, {2, 3}, {3, 1}, ]
        List<Integer> temp = newSet(); // {1, 8}
        for(int i = 0; i < input.length-1; i++) {
            if(input[i] < input[i+1]) {
                increaseFlag = true;
                if(decreaseFlag) {
                    temp.add(input[i]);
                    result.add(temp);
                    temp = newSet();
                    decreaseFlag = false;
                }

                temp.add(input[i]);
            } else if(input[i] > input[i + 1]) {
                decreaseFlag = true;
                if(increaseFlag) {
                    temp.add(input[i]);
                    result.add(temp);
                    temp = newSet();
                    increaseFlag = false;
                }
                temp.add(input[i]);
            }
        }

        temp.add(input[input.length -1]);
        result.add(temp);



        System.out.println(result.stream().map(e -> {
            Collections.sort(e);
            return e.size() * e.get(0);
        }).reduce((a, b) -> a+b).orElse(0));
    }

    private static List<Integer> newSet() {
            return new ArrayList<>();
    }
}
