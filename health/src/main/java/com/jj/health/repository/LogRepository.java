package com.jj.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.health.model.LogTable;

public interface LogRepository extends JpaRepository<LogTable,Integer>{
	

}
