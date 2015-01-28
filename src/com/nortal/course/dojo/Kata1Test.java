package com.nortal.course.dojo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ev on 28.01.15.
 */
public class Kata1Test {


    @Test
    public void givenSmallArrayAndNumberFindsIndex() {
        check(2, new Integer[]{}, -1);
        check(2, new Integer[]{2}, 0);
        check(100, new Integer[]{2}, -1);
        check(2, new Integer[]{1, 2}, 1);
        check(100, new Integer[]{1, 2}, -1);

        check(2, new Integer[]{1, 2, 3, 4 }, 1);
    }

    @Test
    public void givenArrayAndNumberFindsIndex() {
        int index = Kata1.find(10, new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67});
        Assert.assertEquals(5, index);
    }

    @Test
    public void givenArrayAndNumberDoesntFindIndex() {
        int index = Kata1.find(7, new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67});
        Assert.assertEquals(-1, index);
    }

    @Test
    public void givenArrayFindAllElements() {
        Integer[] integers = new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67};
        for(int i = 0; i < integers.length; i++) {
            check(integers[i], integers, i);
        }
    }

    @Test
    public void givenArrayReturnsLowerHalf() {
        checkLowerHalf(new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67}, 0, new Integer[]{});
        checkLowerHalf(new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67}, 10,
                new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21});
        checkLowerHalf(new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67}, 5, new Integer[]{1, 2, 4, 6, 8});
    }

    private void checkLowerHalf(Integer[] array, int middle, Integer[] expected) {
        Assert.assertArrayEquals(expected, Kata1.getLowerHalf(array, middle));
    }

    @Test
    public void givenArrayReturnsUpperHalf() {
        Assert.assertArrayEquals(new Integer[]{},
                Kata1.getUpperHalf(new Integer[]{1, 2, 4}, 2));
        Assert.assertArrayEquals(new Integer[]{2, 4, 6, 8, 10, 15, 17, 19, 21, 67},
                Kata1.getUpperHalf(new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67}, 0));
        Assert.assertArrayEquals(new Integer[]{},
                Kata1.getUpperHalf(new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67}, 10));
        Assert.assertArrayEquals(new Integer[]{ 15, 17, 19, 21, 67},
                Kata1.getUpperHalf(new Integer[]{1, 2, 4, 6, 8, 10, 15, 17, 19, 21, 67}, 5));


    }

    private void check(int number, Integer[] array, int expected) {
        int index = Kata1.find(number, array);
        Assert.assertEquals(expected, index);
    }

}
