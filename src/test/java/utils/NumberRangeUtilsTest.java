package utils;

import org.example.utils.NumberRangeUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberRangeUtilsTest {

    @Test
    public void testSortWhenAlreadySorted() {
        int[] expectedArray = {1,2,3,4};
        int[] sourceArray = {1,2,3,4};
        NumberRangeUtils.sort(sourceArray);

        assertArrayEquals(expectedArray, sourceArray);
    }

    @Test
    public void testSortWhenNotSorted() {
        int[] expectedArray = {1,5,6,9,13};
        int[] sourceArray = {13,5,9,1,6};
        NumberRangeUtils.sort(sourceArray);

        assertArrayEquals(expectedArray, sourceArray);
    }

    @Test
    public void testFormatRangeWithNoRange() {
        ArrayList<Integer> sourceArray = new ArrayList<>();
        sourceArray.add(1);
        sourceArray.add(3);
        sourceArray.add(5);
        sourceArray.add(7);

        String expectedResult = "1, 3, 5, 7";
        String result = NumberRangeUtils.formatRange(sourceArray);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testFormatRangeWithRange() {
        ArrayList<Integer> sourceArray = new ArrayList<>();
        sourceArray.add(1);
        sourceArray.add(3);
        sourceArray.add(5);
        sourceArray.add(6);
        sourceArray.add(7);
        sourceArray.add(9);

        String expectedResult = "1, 3, 5-7, 9";
        String result = NumberRangeUtils.formatRange(sourceArray);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testFormatRangeWithDuplicates() {
        ArrayList<Integer> sourceArray = new ArrayList<>();
        sourceArray.add(1);
        sourceArray.add(3);
        sourceArray.add(3);
        sourceArray.add(3);
        sourceArray.add(5);
        sourceArray.add(6);
        sourceArray.add(7);
        sourceArray.add(9);

        String expectedResult = "1, 3, 5-7, 9";
        String result = NumberRangeUtils.formatRange(sourceArray);

        assertEquals(expectedResult, result);
    }

}
