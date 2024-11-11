
import java.util.LinkedList;
import java.util.Arrays;

public class LinkedListSolution {

    private LinkedList<Integer> linkedList;

    public LinkedListSolution(){
        linkedList = new LinkedList<>();
    }

    public boolean addToBeginning(int data){
        linkedList.addFirst(data);
        return true;
    }

    public boolean addToEnd(int data){
        linkedList.addLast(data);
        return true;
    }

    public boolean addToSpecificPosition(int data, int position){
        linkedList.add(position, data);
        return true;
    }

    public void printLinkedList(){
        System.out.println(Arrays.toString(linkedList.toArray()));
    }

    public static void main(String[] args) {

        LinkedListSolution example = new LinkedListSolution();

        example.addToBeginning(10);
        example.addToEnd(20);
        example.addToSpecificPosition(15, 1);

        example.printLinkedList();
    }

}