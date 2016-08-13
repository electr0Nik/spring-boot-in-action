package com.github.electr0nik.repository;

import com.github.electr0nik.repository.jpa.entity.ProcessEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author nik
 * @since 1.0.0-SNAPSHOT
 */
public interface ProcessRepository extends JpaRepository<ProcessEntity, UUID> {
  List<ProcessEntity> findByUser(final String user);
}
