package com.example.demo.dao;
import java.util.List;

import com.example.demo.model.Car;

 

public interface CarDao {
	public List<Car>findAll();
    public Car findById(int id);
    public Car save(Car car);
	public Car update(Car car);
	public Car delete(int id);
}
