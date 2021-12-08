package com.rwea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenNestedList {

    public static void main(String[] args) {
        List<Object> input = new ArrayList(Arrays.asList(3,Arrays.asList(4,5)));
        System.out.println(new FlattenNestedList().flattenList(input));
    }
    //Return flattened list. In cases where input is not integers or list of integers
    public List<Integer> flattenList(List<Object> input) throws IllegalArgumentException {
        List<Integer> output = new ArrayList<Integer>();
        if(input != null) {
            for (Object ob : input) {
                if (ob instanceof Integer) {
                    output.add((Integer) ob);
                } else if (ob instanceof List) {
                    List<Integer> innerList = (List<Integer>) ob;
                    for (Integer i : innerList) {
                        output.add(i);
                    }
                } else {
                    System.err.println("Element in the input list is not an integer or list of integers");
                    throw new IllegalArgumentException("Not an integer or list");
                }
            }
        }
        return output;

    }
}
