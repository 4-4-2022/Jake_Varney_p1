package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Dice;
import com.revature.repository.DiceRepository;
import com.revature.service.DiceService;
import com.revature.service.DiceServiceImpl;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class DiceServiceApplicationTests {

	@InjectMocks
	private DiceServiceImpl diceServiceImpl;
	
	@Mock
	private DiceRepository diceRepository;
	
	private List<Dice> mockDice;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.mockDice = new ArrayList();
		this.mockDice.add(new Dice(5, "red", 5, "pretty", 25));
		this.mockDice.add(new Dice(6, "green", 5, "math", 25));
		this.mockDice.add(new Dice(7, "purple", 5, "rocks", 25));
		this.mockDice.add(new Dice(8, "yellow", 5, "rule", 25));
		this.mockDice.add(new Dice(9, "ouch", 5, "dnd", 25));
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testFindAll() {
		Mockito.when(this.diceRepository.findAll()).thenReturn(this.mockDice);
		List<Dice> dices = this.diceServiceImpl.findAll();
		Assertions.assertEquals(5, dices.size());
	}
	
	@Test
	void testFindById() {
		int id = 5;
		Mockito.when(this.diceRepository.findById(id)).thenReturn(this.mockDice.get(0));
		Dice dices = this.diceServiceImpl.findById(id);
		Assertions.assertEquals(5, dices.getId());
	}

	@Test
	void testNegDiceCost() {
		Dice dice = new Dice();
		dice.setCost(-1);
		Assertions.assertEquals(0, dice.getCost());
	}
	
	@Test
	void testDiceCost() {
		Dice dice = new Dice();
		dice.setCost(5);
		Assertions.assertEquals(5, dice.getCost());
	}
	
	@Test
	void testNegDiceQ() {
		Dice dice = new Dice();
		dice.setQuant(-1);
		Assertions.assertEquals(0, dice.getQuant());
	}
	
	@Test
	void testDiceQ() {
		Dice dice = new Dice();
		dice.setQuant(5);
		Assertions.assertEquals(5, dice.getQuant());
	}
}
