package util;

import java.util.Properties;
import java.util.StringTokenizer;

public class Util
{
	//duplica apostrofos em String, para resolver problemas com as querys
	public static String duploApostrofo(String str)
	{
		String strAux = "", strRetorno = "";
		
		for (int i=0 ; i < str.length() ; i++)
		{
			strAux = str.substring(i, (i+1));
			strRetorno += strAux;
			
			if (strAux.equals("\'"))
			{
				strRetorno += "\'";
			}
		}
		
		return strRetorno;
	}
	//enche com espacos em branco uma string, para formacao de colunas das msgs
	public static String enche(String var, int tam) throws Exception
	{
		String auxStr = "";

		for (int i=var.length(); i <= tam; i++)
		{
			auxStr += " ";
		}

		return (auxStr + var);
	}
	//recebe data 30/01/2001 retorna 01/30/2001
	public static String mesDiaAno(String data) throws Exception
	{
		String ret = "";

		ret += data.substring(3, 6);
		ret += data.substring(0, 3);
		ret += data.substring(6, 10);

		return ret;
	}
	public static String replaces(String s, String oldString, String newString)
	{
		if (s == null || oldString == null)
            return " ";

        StringBuffer sb = new StringBuffer(s);

	    int pos = -1;
		int oldLength = oldString.length();
	    int newLength = newString.length();
		
		while((pos=sb.toString().indexOf(oldString, pos+1))>=0)
	    {
			sb = sb.replace(pos, pos+oldString.length(), newString);
		}
		return sb.toString();
	}
	public static String retiraApostrofo(String str)
	{						
		String strAux = "", strRetorno = "";
		
		for (int i=0 ; i < str.length() ; i++)
		{
			strAux = str.substring(i, (i+1));

			if (strAux.equals("'"))
			{
				strRetorno += "\\";
			}
			strRetorno += strAux;
			
			
		}
		
		return strRetorno;
	}
	
	public static String getPrimeiroNome(String nome){
		if(nome == null)
			return "";

		StringTokenizer st = new StringTokenizer(nome, " ");
		while(st.hasMoreElements()){
			return st.nextToken();
		}
		return "";
	}
	
	public static String getPropertyFromFile(String property, String filePath) throws Exception {
        Properties props = new Properties();
        props.load(Util.class.getResourceAsStream(filePath));
        return props.getProperty(property);
    }
}
