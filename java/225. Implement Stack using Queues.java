class MyStack {
    Stack<Integer> s=new Stack<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        s.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        s.pop();
    }

    // Get the top element.
    public int top() {
        return s.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return s.empty();
    }
}