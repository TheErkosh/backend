package com.project.BitlabTask.service;


import com.project.BitlabTask.exception.UserNotFoundException;
import com.project.BitlabTask.model.Student;
import com.project.BitlabTask.repo.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //add method
    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString());
        student.setMark(calculateMark(student.getExam()));
        return studentRepository.save(student);
    }

    private String calculateMark(int exam) {
        if (exam >= 90) {
            return "A";
        } else if (exam >= 75) {
            return "B";
        } else if (exam >= 60) {
            return "C";
        } else if (exam >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public List<Student> finaAllStudents() {
        return studentRepository.findAll();
    }


    //update method
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student findStudentById(int id) {
        return studentRepository.findStudentById(id).orElseThrow(() -> new UserNotFoundException("user by id "+id+" was not found"));
    }



    //delete method
    public void deleteStudent(int id) {
        studentRepository.deleteStudentById(id);
    }

}
