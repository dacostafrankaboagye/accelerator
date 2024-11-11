public class MyStack{
    private int size;
    private static final int INTIAL_CAPACITY = 10;
    private Object[] stackArray;

    public MyStack(int capacity){
        stackArray = new Object[capacity];
        size = 0;
    }

    public MyStack(){
        this(INTIAL_CAPACITY);
    }

    public int getSize(){
        return size;
    }

    public void resize(int newCapacity){
        Object[] newStackArray = new Object[newCapacity];
        System.arraycopy(stackArray, 0, newStackArray, 0, size);
        stackArray = newStackArray;
    }

    public void push(Object o){
        if(size == stackArray.length){
            resize(stackArray.length * 2);
        }
        stackArray[size++] = o;
    }

    public Object pop(){
        if(size == 0){
            throw new IllegalStateException("Stack is empty");
        }
        Object o = stackArray[--size];
        stackArray[size] = null;
        runResizeLogic();
        return o;
    }

    public Object peek(){
        if(size == 0){
            System.out.println("Stack is empty");
        }
        return stackArray[size-1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void runResizeLogic(){
        if (size > 0 && size == stackArray.length / 4) {
            resize(stackArray.length / 2);
        }
    }




}
