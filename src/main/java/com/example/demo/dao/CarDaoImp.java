package com.example.demo.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;


@Repository
public class CarDaoImp implements CarDao {
	
	// création éléments en dur
	public static List<Car>carlist=new ArrayList<>();
	static {
		carlist.add(new Car(1, "Honda Accord", "blanche"));
		carlist.add(new Car(2, "Peugeot 106", "grise")); 
		carlist.add(new Car(3, "Renault Scenic", "bleu"));
	}
	
	@Override
	public List<Car>findAll() {
		return carlist;
	}


	@Override
	public Car findById(int id) {
		for (Car car : carlist) {  
            if(car.getId() == id){
                return car;
            }
        }
        return null;
	}

	@Override
	public Car save(Car car) {
		carlist.add(car);
        return car;
	}
	
	@Override
	public Car update(Car car) {
		Car updated_car = carlist.set((car.getId() - 1), car); // !! index utilisateur en base 1 !!
		return updated_car;
	}
	
	@Override
	public Car delete(int id) {
		Car deleted_car = carlist.remove(id - 1);
		return deleted_car;
	}

}

