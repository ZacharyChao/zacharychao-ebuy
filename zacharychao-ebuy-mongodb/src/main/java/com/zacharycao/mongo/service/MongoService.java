package com.zacharycao.mongo.service;

import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.client.FindIterable;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoService {
	
	private static MongoClient client = null;
	private static MongoDatabase db = null;
	private static MongoCollection<Document> collection = null;
	private static FindIterable<Document> findIterable = null;
	public static void main(String[] args) {
		
	}
	@Before
	public void before() {
		client = new MongoClient("47.98.163.175",27017);
		db = client.getDatabase("k10");
		collection = db.getCollection("students");
	}
	@Test
	public void insertOne() {
		Document doc1 = new Document();
		doc1.append("stuname", "wang");
		doc1.append("age", 12);
		doc1.append("gender", "man");
		
		collection.insertOne(doc1);
	}
	@Test
	public void get() {
		findIterable = collection.find();
		findIterable.iterator().forEachRemaining(temp -> System.out.println(temp));
	} 
	
	@Test
	public void getByCond() {
		Document doc = new Document();
		doc.append("$gte", 23);
		Document doc1 = new Document("age",doc);
		FindIterable<Document> iter = collection.find(doc1);
		iter.iterator().forEachRemaining(temp -> System.out.println(temp));
	}
	
	@After
	public void close() {
		client.close();
	}
	
	@Test
	public void insertMany() {
		Document doc1 = new Document();
		doc1.append("stuname", "zhao");
		doc1.append("age", 23);
		doc1.append("gender", "female");
		Document doc2 = new Document();
		doc2.append("stuname", "chao");
		doc2.append("age", 43);
		doc2.append("gender", "man");
		
		collection.insertMany(Arrays.asList(doc1,doc2));
		
	}
	
	@Test
	public void findByCond(){
//		Document doc = Document.parse("{$and:[{\"age\":{$gt:13}},{\"age\":{$lte:43}}]}");
		
		Bson bson1 = Filters.gt("age", 18);
		
		Bson bson2 = Filters.lte("age", 43);
		
		Bson bson = Filters.and(bson1,bson2);
		
		FindIterable iter = collection.find(bson);
		
		iter.iterator().forEachRemaining(temp -> System.out.println(temp));
	}
	
	@Test
	public void deleteOne() {
		Bson gte = Filters.gte("age", 12);
		Bson eq = Filters.eq("stuname","chao");
		Bson bson = Filters.and(gte,eq);
		
		DeleteResult deleteOne = collection.deleteMany(bson);
		System.out.println(deleteOne);
		
		
	}
	
	@Test
	public void update() {
		Bson bson = Filters.eq("stuname","chao");
		
		Document doc = Document.parse("{$set:{\"age\":21223}}");
		
		UpdateResult updateOne = collection.updateOne(bson, doc);
		
		System.out.println(updateOne);
		
		
		
	}
}
