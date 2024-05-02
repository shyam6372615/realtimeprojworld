package com.sparrow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparrow.entity.RegionalSettingsEntity;

public interface RegionalSettingsRepo extends JpaRepository<RegionalSettingsEntity, Long> {

}
