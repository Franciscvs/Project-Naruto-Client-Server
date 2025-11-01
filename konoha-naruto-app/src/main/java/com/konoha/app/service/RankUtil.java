package com.konoha.app.service;

import com.konoha.app.domain.enums.MissionRank;
import com.konoha.app.domain.enums.NinjaRank;

public class RankUtil {
    // Map NinjaRank to MissionRank hierarchy
    public static boolean hasRequiredRank(NinjaRank ninjaRank, MissionRank minRank) {
        int n = switch (ninjaRank) {
            case GENIN -> 1;
            case CHUNIN -> 2;
            case JONIN -> 3;
        };
        int m = switch (minRank) {
            case D -> 1;
            case C -> 1;
            case B -> 2;
            case A -> 3;
            case S -> 3;
        };
        return n >= m;
    }
}
