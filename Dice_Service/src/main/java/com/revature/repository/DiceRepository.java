package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Dice;

@Repository("diceRepository")
public interface DiceRepository extends JpaRepository<Dice, String>{

	public List<Dice> findAll();
	public <S extends Dice> S save(Dice dice);

}
