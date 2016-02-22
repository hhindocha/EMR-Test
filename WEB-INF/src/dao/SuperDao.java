package dao;
import java.sql.ResultSet;

import util.Conexao;

/**
 *<b>Autor: </b> Rafael Kloss<br>
 *<b>Data: </b> 28/08/2006<br>
 *<b>:Modificado: </b><br> 
 *<b>Descrição: </b>Esta classe é a classe pai de todas as classes DAO, <br>
 *<b>todos os métodos genéricos e comuns a DAO estão aqui, inclusive conexão<br>	 	
*/
abstract class SuperDao {
	
	/**
	 *<b>Autor: </b> Rafael Kloss<br>
	 *<b>Data: </b> 28/08/2006<br>
	 *<b>Parâmetros: </b> String query<br>
	 *<b>Tipo do retorno: </b> ResultSet<br>
	 *<b>Retorno: </b> resultado da consulta solicitada pela query<br>
	 *<b>Descrição: </b>Este método tem a função de realizar um<br>
	 *<b>select no Banco de Dados<br>	 	
	*/
	protected ResultSet executeQuery(String query) throws Exception{
		Conexao con = new Conexao();
		ResultSet res;
	    res = con.conecta().executeQuery(query);		
		return res;
	}

	/**
	 *<b>Autor: </b> Rafael Kloss<br>
	 *<b>Data: </b> 28/08/2006<br>
	 *<b>Parâmetros: </b> String query<br>
	 *<b>Tipo do retorno: </b> int<br>
	 *<b>Retorno: </b> número de linhas afetadas<br>
	 *<b>Descrição: </b>Este método tem a função de executar um insert,<br>
	 *<b>update ou delete no Banco de Dados<br>	 	
	*/
	protected int executeUpdate(String query) throws Exception{
		Conexao con = new Conexao();
		int resultado;
		resultado = con.conecta().executeUpdate(query);
		con.desconecta();
		return resultado;
	}
	
	/**
	 *<b>Autor: </b> Rafael Kloss<br>
	 *<b>Data: </b> 28/08/2006<br>
	 *<b>Parâmetros: </b> não tem<br>
	 *<b>Tipo do retorno: </b> void<br>
	 *<b>Retorno: </b> não tem<br>
	 *<b>Descrição: </b>Este método tem a função de encerrar a sessão com o banco de dados<br>	 	
	*/
	protected void desconecta() throws Exception{
		Conexao con = new Conexao();
		con.desconecta();
	}	
	
}