package com.nortal.course.dojo;

import java.util.Arrays;

/**
 * Created by ev on 28.01.15.
 */
public class Kata1 {
    public static int find(int find, Integer[] integers) {
        return findBinary(find, integers, 0);
    }

    public static int findBinary(int searchable, Integer[] integers, int shiftFromOriginal) {
        if(integers.length == 0) {
            return -1;
        }

        int middleIndex = integers.length / 2;
        int middle = integers[middleIndex];
        if(middle == searchable) {
            return middleIndex + shiftFromOriginal;
        }
        if(searchable < middle) {
            return findBinary(searchable, getLowerHalf(integers, middleIndex), shiftFromOriginal);
        }
        return findBinary(searchable, getUpperHalf(integers, middleIndex), shiftFromOriginal + middleIndex + 1);
    }

    public static Integer[] getUpperHalf(Integer[] integers, int middleIndex) {
        return Arrays.copyOfRange(integers,
            middleIndex + 1 ,
            integers.length);
    }

    public static Integer[] getLowerHalf(Integer[] integers, int middleIndex) {
        return Arrays.copyOfRange(integers, 0, middleIndex);
    }

}
