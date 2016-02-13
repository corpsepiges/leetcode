class MyQueue {
    Stack<Integer> left=new Stack<Integer>();
    Stack<Integer> right=new Stack<Integer>();
    public void push(int x) {
        if(right.empty()){
            left.push(x);
        }else{
            right.push(x);
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!empty()){
            if(right.empty()){
                while(!left.empty()){
                    right.push(left.pop());
                }
                right.pop();
            }else{
                while(!right.empty()){
                    left.push(right.pop());
                }
                left.pop();
            }
            f();
        }
    }

    // Get the front element.
    public int peek() {
        int val=0;
        if(right.empty()){
            while(!left.empty()){
                right.push(left.pop());
            }
            val=right.peek();
        }else{
            while(!right.empty()){
                left.push(right.pop());
            }
            val=left.peek();
        }
        f();
        return val;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return left.empty()&&right.empty();
    }
    
    public void f(){
        if(right.empty()){
            while(!left.empty()){
                right.push(left.pop());
            }
        }else{
            while(!right.empty()){
                left.push(right.pop());
            }
        }
    }
}