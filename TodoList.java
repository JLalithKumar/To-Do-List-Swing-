import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class TodoList extends JFrame {
    private JPanel taskPanel;
    private JTextField taskField;
    private JButton addButton, deleteButton;
    private final String FILE_NAME = "tasks.txt";
    private ArrayList<JCheckBox> tasks;

    public TodoList() {
        setTitle("📝 To-Do List ");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tasks = new ArrayList<>();

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskField = new JTextField();
        addButton = new JButton("➕ Add Task");
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.NORTH);

        // Task Panel inside Scroll
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Delete Button
        deleteButton = new JButton("🗑 Delete Selected Tasks");
        add(deleteButton, BorderLayout.SOUTH);

        // Load tasks from file
        loadTasks();

        // Actions
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTasks());

        setVisible(true);
    }

    private void addTask() {
        String taskText = taskField.getText().trim();
        if (!taskText.isEmpty()) {
            JCheckBox taskBox = new JCheckBox(taskText);
            tasks.add(taskBox);
            taskPanel.add(taskBox);
            taskPanel.revalidate();
            taskField.setText("");
            saveTasks();
        }
    }

    private void deleteTasks() {
        ArrayList<JCheckBox> toRemove = new ArrayList<>();
        for (JCheckBox cb : tasks) {
            if (cb.isSelected()) {
                taskPanel.remove(cb);
                toRemove.add(cb);
            }
        }
        tasks.removeAll(toRemove);
        taskPanel.revalidate();
        taskPanel.repaint();
        saveTasks();
    }

    private void loadTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                JCheckBox cb = new JCheckBox(line.replace("✔ ", ""));
                if (line.startsWith("✔ ")) cb.setSelected(true);
                tasks.add(cb);
                taskPanel.add(cb);
            }
        } catch (IOException e) {
            System.out.println("No saved tasks found!");
        }
    }

    private void saveTasks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (JCheckBox cb : tasks) {
                bw.write(cb.isSelected() ? "✔ " + cb.getText() : cb.getText());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoList::new);
    }
}

