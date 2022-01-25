package com.bk.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bk.examportal.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
