package br.edu.unoesc.jongoTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Blog {
	
	public static final String NOME_COLLECTION = Blog.class.getSimpleName().toLowerCase();
	
	private String Dominio;
	private LocalDate dataCriacao;
	private Post post;
	private List<Post> posts;
	
	public void adicionaPost() {
		if(posts == null) {
			posts = new ArrayList<>();
		}
		posts.add(post);
	}
}