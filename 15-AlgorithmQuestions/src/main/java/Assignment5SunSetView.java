package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Assignment5SunSetView {
    public static void main(String[] args) {
        int[] buildings={3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println( "===================Stack Method EAST============");
        sunsetViews(buildings,"EAST").forEach(System.out::println);
        System.out.println( "===================Array Method EAST============");
        sunsetViews2(buildings,"EAST").forEach(System.out::println);

        System.out.println( "===================Stack Method WEST============");
        sunsetViews(buildings,"WEST").forEach(System.out::println);
        System.out.println( "===================Array Method WEST============");
        sunsetViews2(buildings,"WEST").forEach(System.out::println);

    }
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<Integer> candidateBuildings=new Stack<>(); // O(n) space complexity
        int startIdx=0;
        int step=1;

        if(direction.equals("WEST")){startIdx= buildings.length-1; step=-1;}
        int idx=startIdx;
        while (idx>=0 && idx< buildings.length){
            while(!candidateBuildings.isEmpty()&& buildings[candidateBuildings.peek()]<=buildings[idx]){
                candidateBuildings.pop();
            }
            candidateBuildings.push(idx);
            idx+=step;
        }
        //O(n)
        if (direction.equals("WEST")) Collections.reverse(candidateBuildings); //O(n)
        return new ArrayList<Integer>(candidateBuildings); // O(2n)= O(n) time complexity
    }

    public static ArrayList<Integer> sunsetViews2(int[] buildings, String direction) {

        ArrayList<Integer> result = new ArrayList<>();
        int currentTallest=-1;

        // Start from the last element,
        // if previous element>current element , add to the result

        if (direction.equals("EAST")) {
            currentTallest = buildings[buildings.length - 1];
            result.add(buildings.length - 1);  // add the last index
            for (int i = buildings.length - 2; i >= 0; i--) {
                if (buildings[i] > currentTallest) {
                    result.add(i);
                    currentTallest = buildings[i];
                }
            }
        }else {
            currentTallest = buildings[0];
            result.add(0);  // add the first index
            for (int i = 1; i <buildings.length; i++) {
                if (buildings[i] > currentTallest) {
                    result.add(i);
                    currentTallest = buildings[i];
                }
            }
        }
        return result;
    }

}
