package com.revature.soap.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.revature.dtos.DiceDTO;

@WebService(serviceName = "dice-service", targetNamespace = "http://service.revature.com/")
@Component
public interface DiceService {

	@WebMethod
	public List<DiceDTO> findAll();
	@WebMethod
	public String save(DiceDTO dice);
	public void delete(DiceDTO dice);
	public DiceDTO findById(int id);
	
}
