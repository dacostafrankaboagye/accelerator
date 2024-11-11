
import java.util.Arrays;

public class StudentManager{
    private int maxSize;
    private String students[]; // stores students names
    private int count;

    public StudentManager(int size){
        this.maxSize = size;
        this.students = new String[maxSize];
        this.count = 0;
    }

    public StudentManager(){
        this(5);
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean add(String name){
        // handling edge cases
        if(count >= maxSize){
            System.out.println("Array is full");
            return false;
        }
        students[count++] = name;
        System.out.println("Student added: " + name);
        return true;
    }

    public int search(String name){
        for(int i=0; i<count; i++){
            if(students[i].equals(name)){
                System.out.println("Student found: " + name + " at index " + i);
                return i;
            }
        }
        System.out.println("Student not found");
        return -1;
    }
    public boolean delete(String name){
        int index = search(name);
        if(index == -1){
            System.out.println("Student not found");
            return false;
        }
        for(int i=index; i<count-1; i++){
            students[i] = students[i+1];
        }
        students[--count] = null;
        System.out.println("Student deleted: " + name);

        return true;
    }

    public void display(){
        System.out.println(Arrays.toString(students));
    }


    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();
        studentManager.add("Eric");
        studentManager.add("John");
        studentManager.add("Jane");

        studentManager.display();
        studentManager.search("Jon");
        studentManager.delete("John");
        studentManager.display();

    }
}