package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.AccessoriesUsers;

@Repository
public interface IAccessoryUserRepository extends JpaRepository<AccessoriesUsers, Long> {

}
