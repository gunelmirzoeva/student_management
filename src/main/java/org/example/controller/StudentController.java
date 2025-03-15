package org.example.controller;

import org.example.dto.StudentDto;
import org.example.service.StudentService;

import java.util.List;

public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void createStudent(String name, String email, int groupId) {
        studentService.createStudent(new StudentDto(name, email, groupId));
        System.out.println("Student created successfully");
    }

    public void listStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        if(students.isEmpty()) {
            System.out.println("No students found");
        } else {
            students.forEach(student ->
                    System.out.println("Name: " + student.getName() + ", Email: " + student.getEmail() + ", Group: " + student.getGroupId()));
        }
    }

    public void updateStudent(int id, String name, String email, int groupId) {
        studentService.updateStudent(id, new StudentDto(name, email, groupId));
        System.out.println("Student updated successfully");
    }
    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully");
    }
}
