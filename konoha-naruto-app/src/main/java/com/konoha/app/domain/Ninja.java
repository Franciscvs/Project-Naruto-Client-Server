package com.konoha.app.domain;

import com.konoha.app.domain.enums.NinjaRank;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private NinjaRank rank;

    @Min(0) @Max(999)
    private int attack;

    @Min(0) @Max(999)
    private int defense;

    @Min(0) @Max(999)
    private int chakra;

    @ManyToOne(optional = false)
    private Village village;

    // For simplicity, store jutsus as comma-separated values
    private String jutsus;

    public Ninja() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public NinjaRank getRank() { return rank; }
    public void setRank(NinjaRank rank) { this.rank = rank; }
    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }
    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }
    public int getChakra() { return chakra; }
    public void setChakra(int chakra) { this.chakra = chakra; }
    public Village getVillage() { return village; }
    public void setVillage(Village village) { this.village = village; }
    public String getJutsus() { return jutsus; }
    public void setJutsus(String jutsus) { this.jutsus = jutsus; }
}
