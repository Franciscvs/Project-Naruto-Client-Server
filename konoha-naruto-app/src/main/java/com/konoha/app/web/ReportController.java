package com.konoha.app.web;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konoha.app.repository.MissionRepository;
import com.konoha.app.repository.NinjaRepository;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    private final NinjaRepository ninjaRepo;
    private final MissionRepository missionRepo;

    public ReportController(NinjaRepository nr, MissionRepository mr){
        this.ninjaRepo = nr;
        this.missionRepo = mr;
    }

    @GetMapping(value = "/ninjas.csv", produces = "text/csv")
    public ResponseEntity<byte[]> ninjasCsv() {
        String header = "id,name,rank,attack,defense,chakra,village,jutsus\n";

        String body = ninjaRepo.findAll().stream()
                .map(n -> String.join(",",
                        String.valueOf(n.getId()),
                        escape(n.getName()),
                        String.valueOf(n.getRank()),
                        String.valueOf(n.getAttack()),
                        String.valueOf(n.getDefense()),
                        String.valueOf(n.getChakra()),
                        escape(n.getVillage() != null ? n.getVillage().getName() : ""),
                        escape(n.getJutsus() == null ? "" : n.getJutsus())
                ))
                .collect(Collectors.joining("\n"));

        byte[] bytes = (header + body + "\n").getBytes(StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"ninjas.csv\"")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(bytes);
    }

    @GetMapping(value = "/missions.csv", produces = "text/csv")
    public ResponseEntity<byte[]> missionsCsv() {
        String header = "id,name,rank,reward,minRank\n";

        String body = missionRepo.findAll().stream()
                .map(m -> String.join(",",
                        String.valueOf(m.getId()),
                        escape(m.getName()),
                        String.valueOf(m.getRank()),
                        String.valueOf(m.getReward()),
                        String.valueOf(m.getMinRank())
                ))
                .collect(Collectors.joining("\n"));

        byte[] bytes = (header + body + "\n").getBytes(StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"missions.csv\"")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(bytes);
    }

    /**
     * Escapa valores para CSV en formato RFC 4180:
     * - Si contiene coma, comillas o saltos de línea, se rodea con comillas dobles.
     * - Las comillas internas se duplican.
     */
    private String escape(String s) {
        if (s == null) return "";
        boolean mustQuote = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");
        if (mustQuote) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
