package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ReverseFirstKElementsQueue {
    public static void main(String[] args) {
        Deque<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i <6 ; i++) {
            queue.add(i);
        }
        System.out.println("queue = " + queue);
        System.out.println("ReverseFirstK((ArrayDeque<Integer>) queue,3) = " + ReverseFirstK((ArrayDeque<Integer>) queue, 3));
    }
    public static Deque<Integer> ReverseFirstK(ArrayDeque<Integer> queue, int k){
        // 0,1,2,3,4, k=3; stack[0,1,2] ==> [2,1,0,3,4]
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <k ; i++) {
            int currentNum=queue.remove();
            System.out.println("currentNum = " + currentNum);
            stack.push(currentNum); //for i=0,  queue = [1, 2, 3, 4, 5], removed 0 from queue and added to the stack
            System.out.println("queue = " + queue);
            System.out.println("stack = " + stack);
        }
        while (!stack.isEmpty()){ queue.add(stack.pop());}

        for (int i = 0; i < queue.size()-k; i++) {
            queue.add(queue.remove());
        }
        return queue;
    }

}
