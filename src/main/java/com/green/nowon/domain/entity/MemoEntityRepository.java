package com.green.nowon.domain.entity;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoEntityRepository extends JpaRepository<MemoEntity, Long>{

	//jpa정의되어 있는것만으로는 부족하다.
	//사용자가 정의한 repository 메서드 
	List<MemoEntity> findAllByOrderByNoDesc();
	List<MemoEntity> findByOrderByNoDesc();

	

	

}
