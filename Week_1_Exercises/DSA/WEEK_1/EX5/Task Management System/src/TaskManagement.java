class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagement {
    private Node head;

    public TaskManagement() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            Task task = current.task;
            System.out.println("Task ID: " + task.getTaskId() + ", Name: " + task.getTaskName() +
                    ", Status: " + task.getStatus());
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagement tm = new TaskManagement();
        tm.addTask(new Task(1, "Task 1", "Pending"));
        tm.addTask(new Task(2, "Task 2", "In Progress"));
        tm.addTask(new Task(3, "Task 3", "Completed"));

        System.out.println("Tasks:");
        tm.traverseTasks();

        Task task = tm.searchTask(2);
        if (task != null) {
            System.out.println("Found Task: " + task.getTaskName());
        }

        tm.deleteTask(2);
        System.out.println("Tasks after deletion:");
        tm.traverseTasks();
    }
}
