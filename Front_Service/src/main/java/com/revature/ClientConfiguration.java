package com.revature;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.revature.soap.service.DiceService;

@Configuration
public class ClientConfiguration {

	@Bean
	public JaxWsPortProxyFactoryBean serviceProxy() {
		JaxWsPortProxyFactoryBean proxyFactory = new JaxWsPortProxyFactoryBean();
		
		try {
			proxyFactory.setWsdlDocumentUrl(new URL("http://localhost:8080/dnd-service/dice-service?wsdl"));
			proxyFactory.setServiceInterface(DiceService.class);
			
			proxyFactory.setServiceName("DiceServiceImplService");
			proxyFactory.setPortName("dicePort");
			proxyFactory.setNamespaceUri("http://service.revature.com/");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		return proxyFactory;
	}

}
