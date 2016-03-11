package org.SpringSOAPServiceConsume;

import greetings.wsdl.GetGreetingResponse;

import org.SpringSOAPServiceConsume.client.GreetingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
	private static String name = "Mafalda";
	
	@Autowired
	GreetingClient greetingClient;

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		GetGreetingResponse response = greetingClient.getGreeting(name);
		greetingClient.logResponse(response);
	}
}
