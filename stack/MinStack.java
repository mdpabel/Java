package stack;

class MinStack {
    private java.util.Stack<Integer> items;
    private java.util.Stack<Integer> minItems;

    public MinStack() {
        items = new java.util.Stack<>();
        minItems = new java.util.Stack<>();
    }
    
    public void push(int val) {
        if(minItems.isEmpty() || minItems.peek() >= val) {
            minItems.push(val);
        }
        items.push(val);
    }
    
    public void pop() {
        if(!minItems.isEmpty() && items.peek().equals(minItems.peek())) {
            minItems.pop();
        }
        items.pop();
    }
    
    public int top() {
        if(items.isEmpty()) {
            return -1;
        }
        return items.peek();
    }
    
    public int getMin() {
        if(minItems.isEmpty()) {
            return -1;
        }
        return minItems.peek();
    }
}