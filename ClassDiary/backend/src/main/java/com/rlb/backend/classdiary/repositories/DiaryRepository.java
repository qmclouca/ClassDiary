package com.rlb.backend.classdiary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rlb.backend.classdiary.entities.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long>{

	
}
