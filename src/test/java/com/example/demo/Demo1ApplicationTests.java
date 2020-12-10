package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.Car;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TestRestTemplate testRestTemplate;    

	@Test
	public void getAllCars() {
		String result = this.testRestTemplate.getForObject("/vehicules", String.class);
		assertEquals("[{\"id\":1,\"nom\":\"Honda Accord\",\"couleur\":\"blanche\"},"
				+ "{\"id\":2,\"nom\":\"Peugeot 106\",\"couleur\":\"rouille\"},"
				+ "{\"id\":3,\"nom\":\"Renault Scenic\",\"couleur\":\"bleu\"}]", result);
	}

	@Test
	public void getCarById() {
		String result = this.testRestTemplate.getForObject("/vehicule/2", String.class);
		assertEquals("{\"id\":2,\"nom\":\"Peugeot 106\",\"couleur\":\"rouille\"}", result);
	}

	@Test
	public void addCar() {
		Car car = new Car(4, "Peugeot 306", "verte");
		this.testRestTemplate.postForObject("/vehicules", car, String.class);
		String result = this.testRestTemplate.getForObject("/vehicules", String.class);
		assertEquals("[{\"id\":1,\"nom\":\"Honda Accord\",\"couleur\":\"blanche\"},"
				+ "{\"id\":2,\"nom\":\"Peugeot 106\",\"couleur\":\"rouille\"},"
				+ "{\"id\":3,\"nom\":\"Renault Scenic\",\"couleur\":\"bleu\"},"
				+ "{\"id\":4,\"nom\":\"Peugeot 306\",\"couleur\":\"verte\"}]", result);
		testRestTemplate.delete("/vehicule/{1}", 4);
	}

	@Test
	public void updateCar() {
		Car car = new Car(2, "Peugeot 106", "rouille");
		this.testRestTemplate.put("/vehicule/2", car, String.class);
		String result = this.testRestTemplate.getForObject("/vehicule/2", String.class);
		assertEquals("{\"id\":2,\"nom\":\"Peugeot 106\",\"couleur\":\"rouille\"}", result);
	}

	@Test
	public void deleteCarById() {
		testRestTemplate.delete("/vehicule/{1}", 1);
		String result = this.testRestTemplate.getForObject("/vehicules", String.class);
		assertEquals("[{\"id\":2,\"nom\":\"Peugeot 106\",\"couleur\":\"rouille\"},"
				+ "{\"id\":3,\"nom\":\"Renault Scenic\",\"couleur\":\"bleu\"}]", result);
	}

}
