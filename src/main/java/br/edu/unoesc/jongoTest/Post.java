package br.edu.unoesc.jongoTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
	
	public static final String NOME_COLLECTION = Post.class.getSimpleName().toLowerCase();
	
	private LocalDate data;
	private String titulo;
	private  String texto;
	private Comentario comentario;
	private List<Comentario> comentarios;
	
	public void adicionarPost() {
		if(comentarios != null) {
			comentarios = new ArrayList<>();
		}
		comentarios.add(comentario);
	}
}