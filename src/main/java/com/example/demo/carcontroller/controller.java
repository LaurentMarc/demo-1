package com.example.demo.carcontroller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.CarDao;
import com.example.demo.model.Car;


@RestController
public class controller {

	@Autowired
	private CarDao cardao;

	@RequestMapping(value="/vehicules", method=RequestMethod.GET)
	public List<Car>listeElements() {
		return cardao.findAll();
	}
	
	@GetMapping(value = "/vehicule/{id}") //autre écriture de RequestMapping
	public Car afficherUnElement(@PathVariable int id) {
        return cardao.findById(id);
	}
	
	@PostMapping(value = "/vehicules")
	public void creerUnElement(@RequestBody Car car) {
		cardao.save(car);		
	}

	@PutMapping(value = "/vehicule/{id}")
	public Car modifierUnElement(@RequestBody Car car, @PathVariable int id) {
		return cardao.save(car);
	}

	@DeleteMapping(value = "/vehicule/{id}")
	public void supprimerUnElement(@PathVariable int id) {
		cardao.deleteById(id);
	}
	
}


