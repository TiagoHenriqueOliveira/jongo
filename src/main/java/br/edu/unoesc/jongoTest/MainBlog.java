package br.edu.unoesc.jongoTest;

import org.jongo.Jongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MainBlog {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("blog");
		
		Jongo jongo = new Jongo(db);
	}
}