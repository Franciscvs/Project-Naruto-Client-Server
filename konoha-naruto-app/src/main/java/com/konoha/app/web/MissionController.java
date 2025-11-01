package com.konoha.app.web;

import com.konoha.app.domain.Mission;
import com.konoha.app.service.MissionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/missions")
public class MissionController {
    private final MissionService service;
    public MissionController(MissionService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Mission> create(@Valid @RequestBody Mission m){
        return ResponseEntity.ok(service.create(m));
    }

    @GetMapping
    public ResponseEntity<List<Mission>> list(){
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> get(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }
}
