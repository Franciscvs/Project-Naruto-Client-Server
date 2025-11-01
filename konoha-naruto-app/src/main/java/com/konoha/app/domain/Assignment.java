package com.konoha.app.domain;

import com.konoha.app.domain.enums.AssignmentStatus;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Ninja ninja;

    @ManyToOne(optional = false)
    private Mission mission;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status = AssignmentStatus.ASSIGNED;

    private Instant assignedAt = Instant.now();
    private Instant completedAt;

    public Assignment() {}

    public Assignment(Ninja ninja, Mission mission) {
        this.ninja = ninja;
        this.mission = mission;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Ninja getNinja() { return ninja; }
    public void setNinja(Ninja ninja) { this.ninja = ninja; }
    public Mission getMission() { return mission; }
    public void setMission(Mission mission) { this.mission = mission; }
    public AssignmentStatus getStatus() { return status; }
    public void setStatus(AssignmentStatus status) { this.status = status; }
    public Instant getAssignedAt() { return assignedAt; }
    public void setAssignedAt(Instant assignedAt) { this.assignedAt = assignedAt; }
    public Instant getCompletedAt() { return completedAt; }
    public void setCompletedAt(Instant completedAt) { this.completedAt = completedAt; }
}
