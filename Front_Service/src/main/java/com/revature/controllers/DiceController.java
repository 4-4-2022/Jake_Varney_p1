package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.DiceDTO;
import com.revature.soap.service.DiceService;

@RestController("diceController")
@RequestMapping("/dice")
public class DiceController {

	@Autowired
	private DiceService diceService;
	
	/**
	 * This method returns all the dice in the database for the user to view.
	 * @return
	 */
	@GetMapping("/dice-all")
	public Object getDiceMessage() {
		return this.diceService.findAll();
	}
	/**
	 * This method takes in a new Dice and creates saves it to the database. Dice property id is not necessary since it is auto-generated.
	 * This method communicates with a SOAP service so the data is converted to XML.
	 * @param dice
	 * @return
	 */
	@PostMapping(value = "/dice-new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public Object saveNewDice(@RequestBody DiceDTO dice) {
		return this.diceService.save(dice);
	}
	/**
	 * This method finds a specific dice by id.
	 * This method communicates with a SOAP service so it is converted to XML format.
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/dice-id/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public DiceDTO findById(@RequestBody int id) {
		return this.diceService.findById(id);
	}
	/**
	 * This method removes a Dice from the database.
	 * This method communicates with a SOAP service so it is converted to XML format.
	 * @param id
	 */
	@DeleteMapping(value = "/dice-delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public void deleteDice(@PathVariable int id) {
		DiceDTO dice = this.diceService.findById(id);
		this.diceService.delete(dice);
	}
}
