package org.SpringSOAPServiceConsume.configuration;

import org.SpringSOAPServiceConsume.client.GreetingClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class GreetingConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("greetings.wsdl");
		return marshaller;
	}

	@Bean
	public GreetingClient greetingClient(Jaxb2Marshaller marshaller) {
		GreetingClient greetingClient = new GreetingClient();
		greetingClient.setDefaultUri("http://localhost:8080/ws/");
		greetingClient.setMarshaller(marshaller);
		greetingClient.setUnmarshaller(marshaller);
		return greetingClient;
	}

}
