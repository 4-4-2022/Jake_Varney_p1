package com.revature.DiceRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Dice;

public interface DiceRepository extends JpaRepository<Dice, Integer>{

	List<Dice> findAll();
	<S extends Dice> S save(S entity);

}
