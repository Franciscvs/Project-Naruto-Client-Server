package com.konoha.app.service;

import com.konoha.app.domain.Ninja;
import com.konoha.app.repository.NinjaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NinjaService {
    private final NinjaRepository repo;
    public NinjaService(NinjaRepository repo){ this.repo = repo; }
    public Ninja create(Ninja n){ return repo.save(n); }
    public List<Ninja> list(){ return repo.findAll(); }
    public Ninja get(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Ninja not found")); }
}
