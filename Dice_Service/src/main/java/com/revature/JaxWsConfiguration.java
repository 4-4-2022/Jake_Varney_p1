package com.revature;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.service.DiceServiceImpl;

@Configuration
public class JaxWsConfiguration {
	@Bean
	public ServletRegistrationBean<CXFServlet> cxfServlet(){

	return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/dnd-service/*");
	}

	@Bean (name = "cxf")
	public SpringBus springBus(){
	return new SpringBus();
	}

	@Bean
	public DiceServiceImpl serviceImpl(){
	return new DiceServiceImpl();
	}


	@Bean
	public Endpoint endpoint(){
		EndpointImpl endpoint = new EndpointImpl(springBus(), serviceImpl());
		
		endpoint.publish("/dice-service");
		return endpoint;
	}

}
