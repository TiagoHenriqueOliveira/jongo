package br.edu.unoesc.jongoTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Comentario {
	
	public static final String NOME_COLLECTION = Comentario.class.getSimpleName().toLowerCase();
	
	private Date dataComentario;
	private String autor;
	private String comentario;
	
	public void setDataComentario(LocalDate dataComentario) {
		Instant instant = dataComentario.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		this.dataComentario = date;
	}
}