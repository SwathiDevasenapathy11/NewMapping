package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.EmployeeDetails;

@Repository
public interface IEmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

}
