package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergingIntervalsAlgoQ3 {
    public static void main(String[] args) {
        int[][] array={{4,7},{3,3},{1, 4},{6,8},{9,10}};
        System.out.println("mergeIntervals(array) = " + Arrays.deepToString(mergeIntervals(array)));

    }

    public static Object[] mergeIntervals(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> mergedIntervals=new ArrayList<>();

        for (int i = 0; i < intervals.length-1; i++) {
            // intervals overlapping
            if(intervals[i][1]>=intervals[i+1][0]){
                mergedIntervals.add(new int[]{Math.min(intervals[i][0],intervals[i+1][0]), Math.max(intervals[i + 1][1], intervals[i][1])});
            }
            // if intervals not overlapping, then add it to the new list
            else {
               mergedIntervals.add(intervals[i]);
            }

        }


        return mergedIntervals.toArray();
    }

}
