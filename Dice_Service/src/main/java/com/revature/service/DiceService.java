package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.models.Dice;

@WebService
public interface DiceService {

	List<Dice> findAll();
	void save(Dice dice);
	void contactDndService(String message);
}
