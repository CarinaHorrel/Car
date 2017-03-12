package nl.programIT.Car.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarService {
	@Autowired
	private CarRepository carRepository;
	
	public Iterable<Car> findAll(){
		Iterable<Car> result=this.carRepository.findAll();
		return result;
	}
	public void save(Car car){
		this.carRepository.save(car);
	}
		
	public void deleteById(Long id){
		this.carRepository.delete(id);
	}

	public Car findById(Long id) {
		return this.carRepository.findOne(id);
	}
}



