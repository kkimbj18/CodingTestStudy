interface StackForm {
    boolean isEmpty();

    boolean isFull();

    void push(char item);

    char pop();
}

public class Stack implements StackForm {
    private int top;
    private int stackSize;
    private char stackArr[];

    public Stack(int stackSize) {
        top = -1;
        this.stackSize = stackSize;
        stackArr = new char[this.stackSize];
    }

    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }
    
    public boolean isFull() {
        return (top == stackSize - 1) ? true : false;
    }

    public void push(char item) {
        if (isFull()) {
            System.out.println("Stack is full!");
        } else {
            stackArr[++top] = item;
            System.out.println("Inserted Item : " + item);
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return 0;
        } else {
            return stackArr[top--];
        }
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int stackSize = 5;
        Stack arrStack = new Stack(stackSize);
        
        arrStack.push('A');
        arrStack.printStack();
        
        arrStack.push('B');
        arrStack.printStack();
        
        arrStack.push('C');
        arrStack.printStack();
        
        arrStack.pop();
        arrStack.printStack();
        
        arrStack.pop();
        arrStack.printStack();
    }
}
