package org.example.main;

import org.example.controller.GroupController;
import org.example.controller.StudentController;
import org.example.dao.GroupDao;
import org.example.dao.StudentDao;
import org.example.service.GroupService;
import org.example.service.StudentService;

import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GroupDao groupDao = new GroupDao();
        StudentDao studentDao = new StudentDao();

        GroupService groupService = new GroupService(groupDao);
        StudentService studentService = new StudentService(studentDao);

        GroupController groupController = new GroupController(groupService);
        StudentController studentController = new StudentController(studentService);

        System.out.println("\n--------WELCOME TO STUDENT MANAGEMENT SYSTEM--------\n");

        while(true) {
            System.out.println("""
                    1. Create group
                    2. Create student
                    3. List groups
                    4. List students
                    5. Update student
                    6. Update group
                    7. Delete student
                    8. Delete group
                    9. Exit
                    """);
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter group name: ");
                    String groupName = sc.nextLine();
                    System.out.print("Enter group description: ");
                    String groupDescription = sc.nextLine();
                    groupController.createGroup(groupName, groupDescription);
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Enter student email: ");
                    String studentEmail = sc.nextLine();
                    System.out.print("Enter group ID: ");
                    int groupId = sc.nextInt();
                    sc.nextLine();
                    studentController.createStudent(studentName, studentEmail, groupId);
                    break;

                case 3:
                    groupController.listGroups();
                    break;

                case 4:
                    studentController.listStudents();
                    break;


                case 5:
                    System.out.print("Enter student ID to update: ");
                    int studentUpdateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new student name: ");
                    String studentUpdateName = sc.nextLine();
                    System.out.print("Enter new student email: ");
                    String studentUpdateEmail = sc.nextLine();
                    System.out.print("Enter new group ID: ");
                    int studentUpdateGroupId = sc.nextInt();
                    sc.nextLine();
                    studentController.updateStudent(studentUpdateId, studentUpdateName, studentUpdateEmail, studentUpdateGroupId);
                    break;

                case 6:
                    System.out.print("Enter group ID to update: ");
                    int groupUpdateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new group name: ");
                    String groupUpdateName = sc.nextLine();
                    System.out.print("Enter new group description: ");
                    String groupUpdateDescription = sc.nextLine();
                    groupController.updateGroup(groupUpdateId, groupUpdateName, groupUpdateDescription);
                    break;

                case 7:
                    System.out.print("Enter student ID to delete: ");
                    int studentDeleteId = sc.nextInt();
                    sc.nextLine();
                    studentController.deleteStudent(studentDeleteId);
                    break;

                case 8:
                    System.out.print("Enter group ID to delete: ");
                    int groupDeleteId = sc.nextInt();
                    sc.nextLine();
                    groupController.deleteGroup(groupDeleteId);
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
