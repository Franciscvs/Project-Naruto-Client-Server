package com.konoha.app.service;

import com.konoha.app.domain.Assignment;
import com.konoha.app.domain.Mission;
import com.konoha.app.domain.Ninja;
import com.konoha.app.domain.enums.AssignmentStatus;
import com.konoha.app.repository.AssignmentRepository;
import com.konoha.app.repository.MissionRepository;
import com.konoha.app.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final NinjaRepository ninjaRepository;
    private final MissionRepository missionRepository;

    public AssignmentService(AssignmentRepository ar, NinjaRepository nr, MissionRepository mr){
        this.assignmentRepository = ar;
        this.ninjaRepository = nr;
        this.missionRepository = mr;
    }

    public Assignment assign(Long ninjaId, Long missionId){
        Ninja ninja = ninjaRepository.findById(ninjaId).orElseThrow(() -> new RuntimeException("Ninja not found"));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new RuntimeException("Mission not found"));
        if(!RankUtil.hasRequiredRank(ninja.getRank(), mission.getMinRank())){
            throw new RuntimeException("Ninja rank insufficient for mission");
        }
        Assignment a = new Assignment(ninja, mission);
        return assignmentRepository.save(a);
    }

    public Assignment complete(Long assignmentId){
        Assignment a = assignmentRepository.findById(assignmentId).orElseThrow(() -> new RuntimeException("Assignment not found"));
        a.setStatus(AssignmentStatus.COMPLETED);
        a.setCompletedAt(Instant.now());
        return assignmentRepository.save(a);
    }
}
