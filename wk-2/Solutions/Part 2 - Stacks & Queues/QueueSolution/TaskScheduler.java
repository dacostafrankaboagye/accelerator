import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class TaskScheduler {
    private Queue<String> taskQueue;

    public TaskScheduler() {
        taskQueue = new LinkedList<String>();
    }

    public void addTask(String task) {
        taskQueue.offer(task);
        System.out.println("Task added: " + task);
    }

    public void displayTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks in the queue.");
        } else {
            System.out.println("Current tasks in the queue:");
            for (String task : taskQueue) {
                System.out.println("- " + task);
            }
        }
    }

    public void completeTask() {
        if (!taskQueue.isEmpty()) {
            String completedTask = taskQueue.poll();
            System.out.println("Task completed: " + completedTask);
        } else {
            System.out.println("No tasks to complete.");
        }
    }

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    scheduler.addTask(task);
                    break;
                case 2:
                    scheduler.completeTask();
                    break;
                case 3:
                    scheduler.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting Task Scheduler.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }

}