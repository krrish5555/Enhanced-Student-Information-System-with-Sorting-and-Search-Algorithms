# Enhanced-Student-Information-System-with-Sorting-and-Search-Algorithms
A Java application for managing student records and exam schedules using ArrayList and LinkedList. Implements bubble sort, insertion sort, and binary search for efficient data organization and retrieval.

This project focused on building a Java-based Student Information System (SIS) for managing student records, enrolled subjects, and exam data. I implemented classic sorting and searching algorithms to enable efficient retrieval and organization of information.

🛠️ Functional Highlights:
Class Design & Modularity:

Student class to manage student information including name and student number.

Subject class for academic subjects.

Exam class to manage exams and links between students and subjects.

Database class to simulate data storage and retrieval for students and subjects.

StudentInfoSystem class acts as a service to perform sorting and searching.

Main class to drive and test the application logic.


Bubble Sort for Subjects:

Implemented to sort subjects alphabetically in the StudentInfoSystem or Database class using Bubble Sort.


Insertion Sort for Students:

Applied Insertion Sort to arrange student records alphabetically by name for faster human lookup.


Binary Search for Student Lookup:

Implemented a binary search algorithm to quickly retrieve student information based on a unique student number (ID), assuming students are already sorted.


Test Outputs and Debugging:

Used System.out.println() and structured method calls in the Main class to test outputs of sorting and searching methods.


📦 Project Structure (from src folder):
Main.java – Entry point and test interface

Student.java, Subject.java, Exam.java – Entity classes

Database.java – In-memory store for data

StudentInfoSystem.java – Core logic for sorting and searching


✅ Technologies & Concepts:
Object-Oriented Programming (OOP)

Java Algorithms (Bubble Sort, Insertion Sort, Binary Search)

Static utility methods

Console-based application structure


