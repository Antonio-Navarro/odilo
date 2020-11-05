package com.antoniojnavarro.odilo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.antoniojnavarro.odilo.controllers.ToDoRestController;

@SpringBootTest
class OdiloApplicationTests {

	@Autowired
	 private ToDoRestController controller;
	
	@Test
	void contextLoads() {
		  assertThat(controller).isNotNull();

	}

}
