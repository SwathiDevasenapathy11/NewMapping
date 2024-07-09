package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{

}