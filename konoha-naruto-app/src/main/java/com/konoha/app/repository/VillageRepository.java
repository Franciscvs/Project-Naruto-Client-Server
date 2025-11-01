package com.konoha.app.repository;
import com.konoha.app.domain.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface VillageRepository extends JpaRepository<Village, Long> {
    Optional<Village> findByNameIgnoreCase(String name);
}
