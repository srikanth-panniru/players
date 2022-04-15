package com.samsung.test.players.controller;

import com.samsung.test.players.model.Player;
import com.samsung.test.players.request.PlayerRequest;
import com.samsung.test.players.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("players")
public class PlayersController {

    private final PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("")
    public Page<Player> index(Pageable pageable) {
        return playersService.players(pageable);
    }

    @PostMapping("")
    public Player create(@RequestBody @Valid PlayerRequest playerRequest) {
        Player player = playersService.create(playerRequest.toPlayer());
        return player;
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable long id) {
        return playersService.find(id);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable long id, @RequestBody @Valid PlayerRequest playerRequest) {
        Player player = playersService.update(playerRequest, id);
        return player;

    }

    @GetMapping("/searchByName")
    public List<Player> searchByName(
            @RequestParam(name = "name", required = true) String name) {
        return playersService.searchByName(name);
    }

}
