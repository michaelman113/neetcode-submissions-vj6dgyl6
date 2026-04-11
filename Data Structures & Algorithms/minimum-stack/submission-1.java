class MinStack {

private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return (stack.peek());
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int mini = stack.peek();

        //find min element by removing from stack
        while (!stack.isEmpty()) {
            mini = Math.min(mini, stack.peek());
            tmp.push(stack.pop());
        }
        //restore the stack
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        
        return mini;
    }
}
