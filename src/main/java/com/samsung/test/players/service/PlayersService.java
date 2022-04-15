package com.samsung.test.players.service;

import com.samsung.test.players.model.Player;
import com.samsung.test.players.request.PlayerRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayersService {
    Page<Player> players(Pageable pageable);

    Player find(Long id);

    List<Player> searchByName(String name);

    Player create(Player player);

    Player update(PlayerRequest playerRequest, Long playerId);
}
