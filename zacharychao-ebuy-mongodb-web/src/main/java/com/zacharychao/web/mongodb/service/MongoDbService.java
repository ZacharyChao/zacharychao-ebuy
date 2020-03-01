package com.zacharychao.web.mongodb.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.zacharychao.web.mongodb.entity.Students;

@Service
public class MongoDbService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String saveObj(Students stu) {
		stu.setAddress("saveObj address");
		stu.setAge(12);
		stu.setName("saveObj name");
		mongoTemplate.save(stu);
		return "添加成功";
	}
	
	public List<Students> findAll(){
		return mongoTemplate.findAll(Students.class);
	}
	
	public Students findByName(String name,String value) {
		Query query = new Query(Criteria.where(name).is(value));
		return mongoTemplate.findOne(query, Students.class);
	}
	
	public List<Students> findAllByCond(String name,String value){
		Query query = new Query(Criteria.where(name).is(value));
		return mongoTemplate.find(query, Students.class);
	}

	public Students findById(String id) {
//		Query query = new Query(Criteria.where("_id").is(id));
//		return mongoTemplate.findOne(query, Students.class);
		return mongoTemplate.findById(id, Students.class);
	}
	
	public String updateStudent(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		Update update = new Update().set("name", "updateStudents_name").set("address", "updateStudents_address");
		mongoTemplate.updateFirst(query, update, Students.class);
		return "Success";
	}
	
	public List<Students> findAllByRegex(String name,String value){
		Query query = new Query();
		Criteria criteria = new Criteria();
		Pattern pattern = Pattern.compile("^.*" + value + ".*$",Pattern.CASE_INSENSITIVE);
		query.addCriteria(criteria.and(name).regex(pattern));
		return mongoTemplate.find(query, Students.class);
	}
}
