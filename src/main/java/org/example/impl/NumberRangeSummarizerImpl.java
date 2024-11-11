package org.example.impl;

import org.example.interfaces.NumberRangeSummarizer;
import org.example.utils.NumberRangeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    /**
     * Collect and sort the input given. Has to be an integer list seperated by comma values.
     *
     * @param input - The input to convert to an ordered array/list.
     * @return - The ordered array/list of integers.
     * @throws NumberFormatException - When the values in the input are not integers.
     */
    @Override
    public Collection<Integer> collect(String input) {
        String[] inputArray = input.replaceAll(" ", "").split(",");
        int[] values =  Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
        NumberRangeUtils.sort(values);
        return Arrays.stream(values).boxed().toList();
    }

    /**
     * Summarize the collection by returning a string formatted representation of it.
     *
     * @param input - The input to format.
     * @return The formatted string representation.
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        ArrayList<Integer> values = new ArrayList<>(input);
        return NumberRangeUtils.formatRange(values);
    }
}
