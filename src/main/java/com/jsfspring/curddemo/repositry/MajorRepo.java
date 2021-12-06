package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.MajorDTO;

@Repository
public interface MajorRepo extends JpaRepository<MajorDTO, Long> {

	MajorDTO findTitleByMajorName(String majorName);
}