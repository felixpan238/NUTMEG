package org.nutmegsoccer.nutmeg.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlayerDAO extends JpaRepository<Player, Integer>, QueryDslPredicateExecutor{

    Optional<Player> findById(final int id);


}