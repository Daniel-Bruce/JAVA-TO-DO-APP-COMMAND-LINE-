public class Task {
    private int id;                // Unique identifier for the task
    private String description;    // Description of the task
    private String status;         // Status of the task (e.g., pending, completed)

    // Constructor to initialize a Task object
    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }


    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Converts the Task object to a string suitable for saving in a file
    @Override
    public String toString() {
        return id + "," + description + "," + status;
    }

    // Optional: method to display a task in a user-friendly format
    public String display() {
        return "Task ID: " + id + " | Description: " + description + " | Status: " + status;
    }
    
}

