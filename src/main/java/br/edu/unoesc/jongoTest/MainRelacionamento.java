package br.edu.unoesc.jongoTest;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class MainRelacionamento {
	
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("test");
		
		Jongo jongo = new Jongo(db);

		MongoCollection collectionTipoProduto = jongo.getCollection("tipoProduto");
		
		TipoProduto tipoProduto = new TipoProduto(null, "Tipo 1");
		
		WriteResult insert = collectionTipoProduto.insert(tipoProduto);
		
		Produto produtoNovo = new Produto();
		produtoNovo.setNome("Produto 1");
		produtoNovo.setIdTipoProduto(tipoProduto.get_id());
		produtoNovo.setValor(100.0);
		
		MongoCollection collectionProduto = jongo.getCollection("produto");
		collectionProduto.insert(produtoNovo);
		
	}
}