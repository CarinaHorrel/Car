package nl.programIT.Car.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.programIT.Car.domain.Car;
import nl.programIT.Car.domain.CarService;


@Path("car")
@Component
public class CarEndpoint {
	@Autowired
	private CarService carService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		Iterable <Car> result = this.carService.findAll();
		return Response.ok(result).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getPersonById(@PathParam("id") Long id){
		Car result = this.carService.findById(id);
		return Response.ok(result).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCar(Car car){
		System.out.println("POSTED: "+ car.getBrand() + " " + car.getBouwjaar());
		this.carService.save(car);
		return Response.accepted(car).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putCar(Car car) {
		System.out.println("PUT: " + car.getId());
		this.carService.save(car);
		return Response.accepted(car).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response deleteCarById(@PathParam("id") Long id){
		System.out.println("Deleted!");
		this.carService.deleteById(id);
		return Response.accepted().build();
	}
}
