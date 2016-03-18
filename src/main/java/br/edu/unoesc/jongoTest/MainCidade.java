package br.edu.unoesc.jongoTest;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MainCidade {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("test");
		
		Jongo jongo = new Jongo(db);
		
		MongoCollection collectionCidades = jongo.getCollection(Cidade.NOME_COLLECTION);
		MongoCursor<Cidade> cursorCidade = collectionCidades.find().as(Cidade.class);
		
		cursorCidade.forEach(c->System.out.println(c.getNome() + " - " + c.getNomeUf()));
		
		Cidade cidade = new Cidade();
		cidade.setNome("Xaxim");
		UF uf = new UF();
		uf.setNome("Amazonas");
		uf.setSigla("AM");
		cidade.setUf(uf);
		collectionCidades.insert(cidade);
		
	}
}