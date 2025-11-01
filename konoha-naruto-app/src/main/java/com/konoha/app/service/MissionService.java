package com.konoha.app.service;

import com.konoha.app.domain.Mission;
import com.konoha.app.repository.MissionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MissionService {
    private final MissionRepository repo;
    public MissionService(MissionRepository repo){ this.repo = repo; }
    public Mission create(Mission m){ return repo.save(m); }
    public List<Mission> list(){ return repo.findAll(); }
    public Mission get(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Mission not found")); }
}
