package nl.pepijn.Websockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeAutomationServerApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(HomeAutomationServerApplication.class, args);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
