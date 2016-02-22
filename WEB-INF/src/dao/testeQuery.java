package dao;
import java.sql.ResultSet;

import util.Conexao;

public class testeQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Conexao c = new Conexao();
		ResultSet res = c.teste();
		while(res.next()){
			System.out.println(res.getString("dsEstabelecimento"));
		}
		

	}

}
