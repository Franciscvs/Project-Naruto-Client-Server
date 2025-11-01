package com.konoha.app.web;

import com.konoha.app.domain.Ninja;
import com.konoha.app.service.NinjaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ninjas")
public class NinjaController {
    private final NinjaService service;
    public NinjaController(NinjaService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Ninja> create(@Valid @RequestBody Ninja n){
        return ResponseEntity.ok(service.create(n));
    }

    @GetMapping
    public ResponseEntity<List<Ninja>> list(){
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ninja> get(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }
}
