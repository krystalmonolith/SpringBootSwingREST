package com.alphapulsar.sb01;

import com.alphapulsar.sb01.gui.GUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Sb01Application implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sb01Application.class);

	@Autowired
	private GUI gui;

	public static void main(String[] args) {
//		SpringApplication.run(Sb01Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Sb01Application.class);
		builder.headless(false);
		SpringApplication application  = builder.build();
		application.run(args);
	}

	@Override
	public void run(String... strings) throws Exception {
		LOGGER.info("RUN!");
		gui.createAndShowGUI();
	}
}
