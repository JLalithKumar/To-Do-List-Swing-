# 📝 TodoList / Task Manager

A simple **Java Swing GUI** based system to manage daily tasks efficiently.  

---

## 🎯 Objective
To create a Java program that allows users to **add, delete, and mark tasks as completed** in a structured and user-friendly interface. Tasks are saved to a file for persistence between sessions.  

---

## 🛠 Tools & Technologies Used
- Java (JDK 8 or higher)
- Java Swing (GUI)
- AWT (Event Handling)
- Java I/O (File Handling)
- Collections Framework (ArrayList)
- SwingUtilities & Layout Managers (BoxLayout, JScrollPane)

---

## ✨ Features
- **➕ Add Task** – Input a task description to add a new task to the list.  
- **✔ Mark Completed** – Use checkboxes to mark tasks as completed.  
- **🗑 Delete Task** – Remove selected tasks from the list.  
- **💾 Persistent Storage** – Tasks are automatically saved to `tasks.txt` and loaded on startup.  
- **📜 Scrollable List** – Handles large task lists with a scrollable panel.  

---

## 🛠 Implementation Details
- **JFrame + JPanel + JScrollPane** – Provides the main GUI window and scrollable task panel.  
- **JCheckBox** – Each task is represented as a checkbox for easy marking of completion.  
- **JTextField + JButton** – Allows adding new tasks through text input and button clicks.  
- **ArrayList<JCheckBox>** – Dynamically stores all tasks in memory.  
- **File I/O** – Reads and writes tasks to `tasks.txt` to ensure persistence.  

---

## ✅ Conclusion
This project provides a practical example of **GUI programming and list management** in Java. It demonstrates how to design a structured application using Swing components, event handling, and file I/O to create a functional and interactive task manager.  
