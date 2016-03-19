package br.edu.unoesc.jongoTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
	
	public static final String NOME_COLLECTION = Post.class.getSimpleName().toLowerCase();
	
	private Date dataPost;
	private String titulo;
	private  String texto;
	private List<Comentario> comentarios;
	
	public void setDataPost(LocalDate dataPost) {
		Instant instant = dataPost.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		this.dataPost = date;
	}
	
	public LocalDate getData() {
		return LocalDate.from(dataPost.toInstant());
	}
	
	public void adicionarComentario(Comentario comentario) {
		if(comentarios == null) {
			comentarios = new ArrayList<>();
		}
		comentarios.add(comentario);
	}
}