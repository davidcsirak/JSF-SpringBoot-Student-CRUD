package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.StudentDTO;

@Repository
public interface StudentRepo extends JpaRepository<StudentDTO, Long> {
}