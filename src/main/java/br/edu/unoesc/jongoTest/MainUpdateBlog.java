package br.edu.unoesc.jongoTest;

import java.time.LocalDate;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MainUpdateBlog {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("blog");

		Jongo jongo = new Jongo(db);

		MongoCollection collectionBlog = jongo.getCollection("Blog");
		
	//	MongoCursor<Blog> blogBitzera = collectionBlog.find("{dominio:blog.bitzera.com}").as(Blog.class);
		Blog blogBitzera = collectionBlog.findOne("{Dominio:'blog.bitzera.com'}").as(Blog.class);
		
		//blogBitzera.forEach(blog -> {
			Post post = new Post();
			post.setDataPost(LocalDate.now());
			post.setTitulo("Update do Post");
			post.setTexto("Tá tranquilo, tá favorável");
			blogBitzera.adicionarPost(post);
			//collectionBlog.save(blogBitzera);
	//	});
			collectionBlog.update("{Dominio:'blog.bitzera.com'}").with(blogBitzera);
	}
}