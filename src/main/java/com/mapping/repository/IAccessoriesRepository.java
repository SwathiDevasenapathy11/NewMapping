package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.Accessories;

@Repository
public interface IAccessoriesRepository extends JpaRepository<Accessories, Long> {

}
