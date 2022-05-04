package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.models.Dice;

@WebService
public interface DiceService {

	public List<Dice> findAll();
	public void save(Dice dice);
	public void contactDndService(String message);
}
