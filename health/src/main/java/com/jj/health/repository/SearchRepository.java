package com.jj.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jj.health.model.Activity;


@Repository
public interface SearchRepository extends JpaRepository<Activity,Integer> {
	
	@Query(value="SELECT d FROM data d",nativeQuery=true)
	List<Activity> findAllRecord();
	
	
	@Query(value="SELECT d FROM data d where d.fid=:fid",nativeQuery=true)
	Activity findActivityRecord(@Param("fid") int fid);

}
