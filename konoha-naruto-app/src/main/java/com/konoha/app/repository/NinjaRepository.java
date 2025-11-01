package com.konoha.app.repository;
import com.konoha.app.domain.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NinjaRepository extends JpaRepository<Ninja, Long> {}
