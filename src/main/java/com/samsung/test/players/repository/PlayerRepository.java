package com.samsung.test.players.repository;

import com.samsung.test.players.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {

    @Query(value = "SELECT p.* from players p WHERE (p.first_name ILIKE %:name% OR p.last_name ILIKE %:name%)", nativeQuery = true)
    List<Player> findByFirstNameOrLastName(@Param("name") String q);
}
