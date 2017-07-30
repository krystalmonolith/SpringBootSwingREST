package com.alphapulsar.sb01;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb01ApplicationTests {

	@BeforeClass
	public static void before() {
		System.setProperty("java.awt.headless", "false");
	}

	@Test
	public void contextLoads() {
	}

}
