package com.revature.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.revature.DiceRepository.DiceRepository;
import com.revature.models.Dice;

@WebService(endpointInterface = "com.revature.service.DiceService", name = "dice")
public class DiceServiceImpl implements DiceService{

	@Autowired
	private RestTemplate restTemplate;
	
	private DiceRepository diceRepository;
	
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
	public void contactDndService(String message) {
		final String URI = "/dnd-service?wsdl";
		final String SOAP_MESSAGE = "";//copy message from SOAP UI here
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<>(SOAP_MESSAGE, header);
		this.restTemplate.postForLocation(URI, request);
	

		
	}

}
