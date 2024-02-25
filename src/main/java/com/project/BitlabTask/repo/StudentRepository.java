package com.project.BitlabTask.repo;

import com.project.BitlabTask.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    void deleteStudentById(int id);
    Optional<Student> findStudentById(int id);
}
