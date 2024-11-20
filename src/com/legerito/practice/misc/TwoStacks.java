package com.legerito.practice.misc;

//Taken stack soln from GFG code
public class TwoStacks {
    static final int MAX = 100;
    int[] stack = new int[MAX];
    int stack1top;
    int stack2top;
    TwoStacks() {
        stack1top = -1;
        stack2top = 49;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        stack[++stack1top] = x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        stack[++stack2top] = x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(stack1top < 0) {
            return -1;
        } else {
            return stack[stack1top--];
        }
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(stack2top < 50) {
            return -1;
        } else {
            return stack[stack2top--];
        }
    }
}
