package br.edu.unoesc.jongoTest;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Comentario {
	
	public static final String NOME_COLLECTION = Comentario.class.getSimpleName().toLowerCase();
	
	private LocalDate data;
	private String autor;
	private String comentario;
}