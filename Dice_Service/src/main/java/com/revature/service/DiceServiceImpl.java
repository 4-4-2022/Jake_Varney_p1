package com.revature.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Dice;
import com.revature.repository.DiceRepository;

@WebService(endpointInterface = "com.revature.service.DiceService", name = "dice")
public class DiceServiceImpl implements DiceService{

	
	private DiceRepository diceRepository;
	
	
	public DiceServiceImpl() {}
	
	public DiceServiceImpl(DiceRepository diceRepository) {
		this.diceRepository = diceRepository;
	}
	
	@Autowired
	public void setDiceRepository(DiceRepository diceRepository) {
		this.diceRepository = diceRepository;
	}
	
	@Override
	@WebMethod
	public List<Dice> findAll() {
		// TODO Auto-generated method stub
		return this.diceRepository.findAll();
	}

	@Override
	@WebMethod
	public void save(Dice dice) {
		this.diceRepository.save(dice);	
	}

	@Override
	@WebMethod
	public void delete(Dice dice) {
		this.diceRepository.delete(dice);
		
	}

	@Override
	public Dice findById(int id) {
		// TODO Auto-generated method stub
		return this.diceRepository.findById(id);
	}

	


}
