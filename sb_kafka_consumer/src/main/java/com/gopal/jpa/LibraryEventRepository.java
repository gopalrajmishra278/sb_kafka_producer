package com.gopal.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.LibraryEvent;

public interface LibraryEventRepository extends JpaRepository<LibraryEvent, Long>{

}
