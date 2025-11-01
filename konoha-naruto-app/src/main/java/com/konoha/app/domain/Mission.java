package com.konoha.app.domain;

import com.konoha.app.domain.enums.MissionRank;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private MissionRank rank;

    @Min(0)
    private int reward;

    @Enumerated(EnumType.STRING)
    @NotNull
    private MissionRank minRank;

    public Mission() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public MissionRank getRank() { return rank; }
    public void setRank(MissionRank rank) { this.rank = rank; }
    public int getReward() { return reward; }
    public void setReward(int reward) { this.reward = reward; }
    public MissionRank getMinRank() { return minRank; }
    public void setMinRank(MissionRank minRank) { this.minRank = minRank; }
}
