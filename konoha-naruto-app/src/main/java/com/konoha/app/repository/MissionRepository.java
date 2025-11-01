package com.konoha.app.repository;
import com.konoha.app.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MissionRepository extends JpaRepository<Mission, Long> {}
