package util;

/**
 * Insira a descrição do tipo aqui.
 * Data de criação: (26/08/02 10:40:46)
 * @autor: Administrator
 */
public class Values {
/**
 * Comentário do construtor Values.
 */
public Values() {
	super();
}
/**
 * Insira a descrição do método aqui.
 * Data de criação: (26/08/02 10:43:09)
 */
public int treatInt(int num, boolean canZero)
{
	String strRetorno = new Integer(num).toString();
	
	if(num==0)
	{
		if(!canZero)
		{
			return -1;
		}
	}
		
	return num;
}
/**
 * Insira a descrição do método aqui.
 * Data de criação: (26/08/02 10:43:09)
 */
public int treatInt(String num, boolean canZero)
{
	if(num.equalsIgnoreCase("null"))
	{	
		return -1;
	}
	
	if(Integer.parseInt(num)==0)
	{
		if(!canZero)
		{
			return -1;
		}
	}
		
	return Integer.parseInt(num);
}
/**
 * Insira a descrição do método aqui.
 * Data de criação: (26/08/02 10:41:29)
 */
public String treatNullString(String str, boolean isTable)
{	
	if(str == null)
	{
		if(isTable)
		{
			str = "&nbsp";
		}
		else
		{
			str = "";
		}
	}
	else
	{
		if(str.equalsIgnoreCase("null"))
		{
			if(isTable)
			{
				str = "&nbsp";
			}
			else
			{
				str = "";
			}
		}
		else
		{
			str = Util.replaces(str, "'", " ");
			str = str.trim().toUpperCase();
		}
	}
	return str;
	
}
/**
 * Insira a descrição do método aqui.
 * Data de criação: (26/08/02 10:41:29)
 */
public String treatNullString2(String str)
{	
	if(str == null)
	{
		str = "";
	}
	else
	{
		if(str.equalsIgnoreCase("null"))
		{
			str = "";
		}
		else
		{
			str = str.trim().toUpperCase();
		}
	}
	return str;
	
}
}
