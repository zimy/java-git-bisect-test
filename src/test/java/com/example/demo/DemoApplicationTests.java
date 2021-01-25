package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	FirstEntityRepository repository;
	@Test
	void contextLoads() {
	}

	@Test
	void testJPAAdditionAndFind(){
		FirstEntity entity = new FirstEntity("a", "b");
		repository.save(entity);
	}

}
