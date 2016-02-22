package dao;
import java.sql.ResultSet;

import util.Conexao;

/**
 *<b>Autor: </b> Rafael Kloss<br>
 *<b>Data: </b> 28/08/2006<br>
 *<b>:Modificado: </b><br> 
 *<b>Descri��o: </b>Esta classe � a classe pai de todas as classes DAO, <br>
 *<b>todos os m�todos gen�ricos e comuns a DAO est�o aqui, inclusive conex�o<br>	 	
*/
abstract class SuperDao {
	
	/**
	 *<b>Autor: </b> Rafael Kloss<br>
	 *<b>Data: </b> 28/08/2006<br>
	 *<b>Par�metros: </b> String query<br>
	 *<b>Tipo do retorno: </b> ResultSet<br>
	 *<b>Retorno: </b> resultado da consulta solicitada pela query<br>
	 *<b>Descri��o: </b>Este m�todo tem a fun��o de realizar um<br>
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
	 *<b>Par�metros: </b> String query<br>
	 *<b>Tipo do retorno: </b> int<br>
	 *<b>Retorno: </b> n�mero de linhas afetadas<br>
	 *<b>Descri��o: </b>Este m�todo tem a fun��o de executar um insert,<br>
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
	 *<b>Par�metros: </b> n�o tem<br>
	 *<b>Tipo do retorno: </b> void<br>
	 *<b>Retorno: </b> n�o tem<br>
	 *<b>Descri��o: </b>Este m�todo tem a fun��o de encerrar a sess�o com o banco de dados<br>	 	
	*/
	protected void desconecta() throws Exception{
		Conexao con = new Conexao();
		con.desconecta();
	}	
	
}