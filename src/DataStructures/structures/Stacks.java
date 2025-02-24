package DataStructures.structures;

import java.util.Stack;

/**
 * Stacks
 * Linear is a Linear Data Structure that stores values in a "Vertical Tower"
 * The structure follows a LIFO order (First in Last Out).
 *
 * Main operations used on a stack are Push and Pop
 *
 * ->  push() : is used to add values to the top of a stack.
 * ->  pop()  : removes the top element from the stack
 * ->  peek() : is used to return the value from the stack without removing it.
 */

public class Stacks {
    Stack<String> stack;

    public Stacks() {
        stack = new Stack<>();
    }

    public Stack<String> getStack() {
        return stack;
    }
}
