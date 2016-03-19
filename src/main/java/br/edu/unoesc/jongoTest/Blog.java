package br.edu.unoesc.jongoTest;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Blog {
	
	public static final String NOME_COLLECTION = Blog.class.getSimpleName().toLowerCase();
	
	private String Dominio;
	private Date dataCriacao;
	private List<Post> posts;
	
	public void setDataCriacao(LocalDate dataCriacao) {
		Instant instant = dataCriacao.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		this.dataCriacao = date;
	}
	
	public void adicionarPost(Post post) {
		if(posts == null) {
			posts = new ArrayList<>();
		}
		posts.add(post);
	}
}