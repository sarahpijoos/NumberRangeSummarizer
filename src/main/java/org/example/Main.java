package org.example;

import org.example.impl.NumberRangeSummarizerImpl;
import org.example.interfaces.NumberRangeSummarizer;
import org.example.utils.NumberRangeUtils;

import java.util.Collection;

public class Main {

    /**
     * Entry point for the application.
     */
    public static void main(String[] args) {
        try {
            NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
            Collection<Integer> result =  summarizer.collect("-21,-1,1,3,6,7,8,12,13,14,15,22,23,24,31");
            String rangeResult = summarizer.summarizeCollection(result);
            System.out.println(rangeResult);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Please only use numbers/integers.");
        }

    }
}