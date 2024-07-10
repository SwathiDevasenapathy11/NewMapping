package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {

}
