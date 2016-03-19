package br.edu.unoesc.jongoTest;

import java.time.LocalDate;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MainBlog {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("blog");

		Jongo jongo = new Jongo(db);

		MongoCollection collectionBlog = jongo.getCollection("Blog");

		Blog blog = new Blog();
		blog.setDominio("blog.bitzera.com");
		blog.setDataCriacao(LocalDate.now());

		Post post = new Post();
		post.setDataPost(LocalDate.now());
		post.setTexto("Primeiro Post");
		post.setTitulo("Vamo passa a lambida na nilbaiada");

		Comentario comentario = new Comentario();
		comentario.setAutor("Birita");
		comentario.setComentario("Passa nada seu nilba");
		comentario.setDataComentario(LocalDate.now());

		post.adicionarComentario(comentario);
		blog.adicionarPost(post);

		collectionBlog.insert(blog);

		MongoCursor<Blog> cursorBlog = collectionBlog.find().as(Blog.class);

		cursorBlog.forEach(c -> {
			System.out.println("BLOG:" + c.getDominio());

			c.getPosts().forEach(p -> {
				p.getTexto();
				p.getComentarios().forEach(co -> {
					System.out.println(co.getDataComentario());
					System.out.println(co.getComentario());
				});
			});
		});
	}
}