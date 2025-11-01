package com.konoha.app.web;

import com.konoha.app.domain.Assignment;
import com.konoha.app.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assignments")
public class AssignmentController {
    private final AssignmentService service;
    public AssignmentController(AssignmentService service){ this.service = service; }

    @PostMapping("/assign")
    public ResponseEntity<Assignment> assign(@RequestParam Long ninjaId, @RequestParam Long missionId){
        return ResponseEntity.ok(service.assign(ninjaId, missionId));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<Assignment> complete(@PathVariable Long id){
        return ResponseEntity.ok(service.complete(id));
    }
}
