package com.gopal.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.FailureRecord;

public interface FailureRecordRepository extends JpaRepository<FailureRecord, Long>{

}
