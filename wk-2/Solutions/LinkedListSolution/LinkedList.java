public class LinkedList {
    private Node head;

    public LinkedList(){
        this.head = null;
    }

    public boolean addToBeginning(int data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        return true;
    }

    public boolean addToEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        Node temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        return true;

    }

    public boolean addToSpecificPosition(int data, int position){
        if(position < 0){
            System.out.println("Position is negative");
            return false;
        }
        if(position == 0){
            return addToBeginning(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        for(int i = 0; i < position - 1 && temp.getNext() != null; i++){
            temp = temp.getNext();
        }
        if(temp == null){
            System.out.println("Out of range");
            return false;
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        return true;
    }

    public void printLinkedList(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.getData() + " --> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addToBeginning(10);
        list.addToEnd(20);
        list.addToSpecificPosition(15, 1);

        list.printLinkedList();

    }


}