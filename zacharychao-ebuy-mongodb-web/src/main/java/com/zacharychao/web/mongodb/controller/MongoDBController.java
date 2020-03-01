package com.zacharychao.web.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zacharychao.web.mongodb.entity.Students;
import com.zacharychao.web.mongodb.service.MongoDbService;

@RestController
public class MongoDBController {
	@Autowired
	private MongoDbService mongoDbService;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@PostMapping("/saveObj")
	public String saveObj() {
		Students stu = new Students();
		mongoDbService.saveObj(stu);
		return "SUCCESS";
	}
	
	@GetMapping("/findAll")
	@ResponseBody 
	public List<Students> findAll(){
		return mongoDbService.findAll();
		
	}
	
	@GetMapping("/findByName/{name}/{value}")
	@ResponseBody
	public Students findByName(@PathVariable(name="name") String name,@PathVariable("value") String value) {
		return mongoDbService.findByName(name,value);
	}
	
	@GetMapping("/findAllByName/{name}/{value}")
	@ResponseBody
	public List<Students> findAllByName(@PathVariable(name="name") String name,@PathVariable("value") String value) {
		return mongoDbService.findAllByCond(name,value);
	}
	
	@GetMapping("/findById/{id}")
	@ResponseBody
	public Students findById(@PathVariable(name="id") String id) {
		return mongoDbService.findById(id);
	}
	
	@GetMapping("/findAllByRegex/{name}/{value}")
	@ResponseBody
	public List<Students> findAllByRegex(@PathVariable("name") String name,@PathVariable("value") String value){
		return mongoDbService.findAllByRegex(name, value);
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public String update(@PathVariable("id") String id) {
		return mongoDbService.updateStudent(id);
	}
}
