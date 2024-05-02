package com.sparrow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparrow.entity.GradingSchemeEntity;

public interface GradingSchemeRepo extends JpaRepository<GradingSchemeEntity, Long> {

}
