package impl;

import org.example.impl.NumberRangeSummarizerImpl;
import org.example.interfaces.NumberRangeSummarizer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class NumberRangeSummarizerImplTest {

    @Test
    public void testCollect() {
        String input = "15,24,7,23,31,1,22,13,8,6,14,12,21,3";
        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> actual = numberRangeSummarizer.collect(input);
        Collection<Integer> expectedArray = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);

        assertIterableEquals(expectedArray, actual);
    }

    @Test
    public void testCollectWithSpaces() {
        String input = "15, 24, 7, 23, 31, 1, 22, 13, 8, 6, 14, 12, 21, 3";
        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> actual = numberRangeSummarizer.collect(input);
        Collection<Integer> expectedArray = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);

        assertIterableEquals(expectedArray, actual);
    }

    @Test
    public void testCollectWithNegatives() {
        String input = "15, 24, 7, 23, 31, 1, 22, 13, 8, 6, 14, 12, -21, 3, -1";
        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> actual = numberRangeSummarizer.collect(input);
        Collection<Integer> expectedArray = Arrays.asList(-21,-1,1,3,6,7,8,12,13,14,15,22,23,24,31);

        assertIterableEquals(expectedArray, actual);
    }

    @Test
    public void testCollectWithLetters() {
        String input = "a, 24, 7, 23, 31, 1, 22, 13, 8, 6, 14, 12, -21, 3, -1";
        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        assertThrows(NumberFormatException.class, () -> numberRangeSummarizer.collect(input));
    }

    @Test
    public void testSummarize() {
        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> sourceArray = Arrays.asList(-21,-1,1,3,6,7,8,12,13,14,15,22,23,24,31);
        String actual = numberRangeSummarizer.summarizeCollection(sourceArray);
        String expected = "-21, -1, 1, 3, 6-8, 12-15, 22-24, 31";

        assertEquals(expected, actual);
    }
}
