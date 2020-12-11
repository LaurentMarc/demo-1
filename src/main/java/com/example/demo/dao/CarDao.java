package com.example.demo.dao;
import java.util.List;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

 

public interface CarDao extends JpaRepository<Car, Integer> {
	
	Car findById(int id);
	
	/*
	* public List<Car>findAll();
    * public Car findById(int id);
    * public Car save(Car car);
	* public Car update(int id, Car car);
	* public Car delete(int id);
	*/
}
