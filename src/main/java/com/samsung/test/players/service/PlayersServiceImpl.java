package com.samsung.test.players.service;

import com.samsung.test.players.model.Player;
import com.samsung.test.players.repository.PlayerRepository;
import com.samsung.test.players.request.PlayerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService {
    final static Logger logger = LoggerFactory.getLogger(PlayersServiceImpl.class);
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayersServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Page<Player> players(Pageable pageable) {
        return this.playerRepository.findAll(pageable);
    }

    @Override
    public Player find(Long id) {
        return this.playerRepository.findById(id).get();
    }

    @Override
    public List<Player> searchByName(String name) {
        return this.playerRepository.findByFirstNameOrLastName(name);
    }

    @Override
    public Player create(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    public Player update(PlayerRequest playerRequest, Long playerId) {
        Player player = find(playerId);
        if (player != null) {
            player.update(playerRequest);
            return playerRepository.save(player);
        }
        logger.warn("Update failed. Player not found!");
        return null;
    }
}
