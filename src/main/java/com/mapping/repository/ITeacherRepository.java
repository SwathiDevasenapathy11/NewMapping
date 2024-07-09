package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long>{

}
