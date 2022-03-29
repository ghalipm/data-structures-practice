package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
    public static void mergeIntervals(Interval arr[]){
        if (arr.length <= 0)
            return;
        Stack<Interval> stack=new Stack<>();
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });
        stack.push(arr[0]); // (1,9) is pushed
        for (int i = 1 ; i < arr.length; i++)
        {
            // get interval from stack top
            Interval top = stack.peek();
            // for i=3 (6,8)
            // top = (1,7)
            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < arr[i].start) {
                stack.push(arr[i]);

            }
            // Otherwise update the ending time of top if ending of current
            // interval is more
            else if (top.end < arr[i].end)
            {
                top.end = arr[i].end; // top = (1,8) outside the stack, we never injected in the stack
                stack.pop(); // erase (1,7) nothing in the stack, empty
                stack.push(top);

            }
        }
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty())
        {
            Interval t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }
    }
    static class Interval
    {
        int start,end;
        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
    }

}
