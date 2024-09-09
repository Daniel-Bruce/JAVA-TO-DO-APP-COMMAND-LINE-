/**
 * Todolist
 */
import java.util.*;

public class Todolist {
     private static FileManager filemanager = new FileManager();
     private static Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                addTask();
                break;
                case 2:
                deleteTask();
                break;
                case 3:
                loadTasks();
                break;
                case 4:
                System.exit(0);
                break;
                default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }}
     }
       private static void displayMenu() {
        System.out.println("Todolist Menu:");
        System.out.println("1. Add task");
        System.out.println("2. Delete task");
        System.out.println("3. Load tasks");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        }
    

    private static void loadTasks() {
        List<Task> tasks = filemanager.loadTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Current Tasks:");
            for (Task task : tasks) {
                System.out.println(task.display());
            }
        }
    }



    private static void deleteTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of task to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        List<Task> tasks = filemanager.loadTasks();
        boolean isRemoved = tasks.removeIf(task -> task.getId() == id); // Remove task by ID
        filemanager.saveTasks(tasks); // save updated list back to file
        System.out.println("Task deleted successfully!");
    }

    private static void addTask() {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task task = new Task(generateTaskId(), description, "pending");
        FileManager.addTask(task);
        System.out.println("Task added successfully!");
    }

       private static int generateTaskId() {
        return new Random().nextInt(1000); // Random ID for simplicity
    }
}

  
