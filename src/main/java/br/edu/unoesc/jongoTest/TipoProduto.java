package br.edu.unoesc.jongoTest;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class TipoProduto {

	private ObjectId _id;
	private String nome;
	
}