package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.School;

public interface StudentRepository extends JpaRepository<School, Long> {

}
