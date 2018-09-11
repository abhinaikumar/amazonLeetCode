import java.util.Stack;

public class MinStack {
    /*
    155. Min Stack
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
    Example:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.


    main idea is how to track the min value when new min is push to the stack,
    the solution is push the older min on stack first and push the new min, when
    pop the stack, if the pop value is min, then pop again and refresh the min value to older min

    */

    int min=Integer.MAX_VALUE;
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        if(x<=min){
            stack.push(min);
            min=x;

        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min)
            min=stack.pop();
    }

    public int top() {
        int top = stack.peek();
        return top;
    }

    public int getMin() {
        return min;
    }

}
