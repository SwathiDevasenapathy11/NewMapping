package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.Owner;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

}
