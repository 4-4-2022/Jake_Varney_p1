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
	/**
	 * This method returns all the Dice from the database and displays them for the user to view.
	 */
	@Override
	@WebMethod
	public List<Dice> findAll() {
		// TODO Auto-generated method stub
		return this.diceRepository.findAll();
	}

	/**
	 * This method saves a Dice to the database. Dice id is not needed since it is auto-generated.
	 */
	@Override
	@WebMethod
	public void save(Dice dice) {
		this.diceRepository.save(dice);	
	}

	/**
	 * This method deletes a dice from the database.
	 */
	@Override
	@WebMethod
	public void delete(Dice dice) {
		this.diceRepository.delete(dice);
		
	}

	/**
	 * This method finds a dice by its id number.
	 */
	@Override
	public Dice findById(int id) {
		// TODO Auto-generated method stub
		return this.diceRepository.findById(id);
	}

	


}
