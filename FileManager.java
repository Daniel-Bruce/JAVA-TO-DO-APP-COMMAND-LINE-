import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "tasks.txt"; // Path to the file where tasks are stored

    // Method to add a task to the file
    public static void addTask(Task task) {
        List<Task> tasks = loadTasks(); // Load existing tasks to ensure data consistency
        tasks.add(task); // Add the new task to the list
        saveTasks(tasks); // Save the updated task list back to the file
        System.out.println("Task added successfully!");
    }

    // Method to delete a task from the file based on its ID
    public void deleteTask(int taskId) {
        List<Task> tasks = loadTasks(); // Load existing tasks
        boolean isRemoved = tasks.removeIf(task -> task.getId() == taskId); // Remove task by ID

        if (isRemoved) {
            saveTasks(tasks); // Save updated list after deletion
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    // Method to load tasks from the file
    // Also acts as a save method when called with an updated list of tasks
    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split line into components
                int id = Integer.parseInt(parts[0]); // Parse task ID
                String description = parts[1]; // Get task description
                String status = parts[2]; // Get task status
                tasks.add(new Task(id, description, status)); // Add task to list
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. A new file will be created when you add tasks.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing task ID. Ensure the file format is correct.");
        }
        return tasks;
    }

    // Private method to save tasks to the file
    static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : tasks) {
                writer.write(task.toString()); // Write each task as a line
                writer.newLine(); // Add a newline after each task
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving tasks: " + e.getMessage());
        }
    }
}



