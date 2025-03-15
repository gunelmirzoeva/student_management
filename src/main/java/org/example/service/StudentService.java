package org.example.service;

import org.example.dao.StudentDao;
import org.example.dto.StudentDto;
import org.example.entity.Student;
import org.example.exception.EntityNotFoundException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void createStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getName(), studentDto.getEmail(), studentDto.getGroupId());
        studentDao.save(student);
    }
    public List<StudentDto> getAllStudents() {
        return studentDao.getAll().stream()
                .map(student -> new StudentDto(student.getName(), student.getEmail(), student.getGroupId()))
                .collect(Collectors.toList());
    }

    public StudentDto getStudentById(int id) {
        Optional<Student> student = studentDao.get(id);
        if (student.isPresent()) {
            return new StudentDto(student.get().getName(), student.get().getEmail(), student.get().getGroupId());
        } else {
            throw new EntityNotFoundException("Student with ID " + id + " not found");
        }
    }

    public void updateStudent(int id, StudentDto studentDto) {
        Student student = new Student(id, studentDto.getName(), studentDto.getEmail(), studentDto.getGroupId());
        String[] params = {studentDto.getName(), studentDto.getEmail(), String.valueOf(studentDto.getGroupId())};
        studentDao.update(student, params);
    }
    public void deleteStudent(int id) {
        Optional<Student> student = studentDao.get(id);
        if (student.isPresent()) {
            studentDao.delete(student.get());
        } else {
            throw new EntityNotFoundException("Student with ID " + id + " not found");
        }
    }
}
