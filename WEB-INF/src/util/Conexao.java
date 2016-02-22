package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	
private Connection con;	
	
	public Statement conecta() throws Exception
	{
		con = null;
		String url = "jdbc:mysql:///pesp";
		String login = "root";
		String senha = "";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url, login, senha);			        
		Statement stm = con.createStatement();		
		return stm;		
	}
	
	public void desconecta() throws Exception
	{
		if (con != null)
		{
			con.close();
		}
	}
	
	public ResultSet teste() throws Exception{
		ResultSet res = null;
		String q = "select * from estabelecimento";
        res = this.conecta().executeQuery(q);		
		return res;		
	}
}	
