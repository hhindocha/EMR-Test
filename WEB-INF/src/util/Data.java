package util;

import util.Conexao;

import java.util.Date;
import java.util.*;
import java.sql.*;
import java.text.*;
 
public class Data
{
	public Data()
	{
	}
/**
 * Insira a descrição do método aqui.
 * Data de criação: (16/09/02 16:15:04)
 * @return int[]
 * @param date java.lang.String
 */
public static int[] brokenDate(String date)throws Exception
{
	int tokensOfDate[] = new int[3];
	
	tokensOfDate[0] = Integer.parseInt(date.substring(0,2));
	tokensOfDate[1] = Integer.parseInt(date.substring(3,5))-1;
	tokensOfDate[2] = Integer.parseInt(date.substring(6,10));

	
	return tokensOfDate;
}
	//retorna em dias a diferenca entre duas datas
	public static long days(String startDate, String endDate)
	{
		int startDia, startMes, startAno;
		int endDia, endMes, endAno;
		
		startDia = (int)Integer.parseInt(startDate.substring(0,2));
		startMes = (int)Integer.parseInt(startDate.substring(3,5));
		startAno = (int)Integer.parseInt(startDate.substring(6,10));

		endDia = (int)Integer.parseInt(endDate.substring(0,2));
		endMes = (int)Integer.parseInt(endDate.substring(3,5));
		endAno = (int)Integer.parseInt(endDate.substring(6,10));
		
		Date d1 = new Date(startAno, startMes - 1, startDia);
		Date d2 = new Date(endAno, endMes - 1, endDia);
		
		return(Math.abs(d2.getTime() - d1.getTime())/86400000);
	}
	
/**
*<b>Método :</b> validaDays<br>
*<b>Autor :</b> Fernando de Lima Canelas<br>
*<b>Data :</b> 17/12/2003<br>
*<b>Parâmetros :</b>startDate, endDate<br>
*<b>Tipo :</b> Data<br>
*<b>Retorna :</b> long<br>
*<b>Descrição :</b><br>
*Utilizo essa função para retorna a diferença entre duas datas
*Inclusive negativas
*/
	public static long validaDays(String startDate, String endDate)
	{
		int startDia, startMes, startAno;
		int endDia, endMes, endAno;
		
		startDia = (int)Integer.parseInt(startDate.substring(0,2));
		startMes = (int)Integer.parseInt(startDate.substring(3,5));
		startAno = (int)Integer.parseInt(startDate.substring(6,10));

		endDia = (int)Integer.parseInt(endDate.substring(0,2));
		endMes = (int)Integer.parseInt(endDate.substring(3,5));
		endAno = (int)Integer.parseInt(endDate.substring(6,10));
		
		Date d1 = new Date(startAno, startMes - 1, startDia);
		Date d2 = new Date(endAno, endMes - 1, endDia);
		
		return((d2.getTime() - d1.getTime())/86400000);
	}
	/**
	*<b>Método :</b> validaDays<br>
	*<b>Autor :</b> Fernando de Lima Canelas<br>
	*<b>Data :</b> 17/12/2003<br>
	*<b>Parâmetros :</b>startDate, endDate<br>
	*<b>Tipo :</b> Data<br>
	*<b>Retorna :</b> long<br>
	*<b>Descrição :</b><br>
	*Utilizo essa função para retorna a diferença entre duas datas
	*Inclusive negativas
	*/
	public static long validaMinutes(String startDate, String endDate) throws Exception
	{
		int startDia, startMes, startAno, startHour, startMinutes;
		int endDia, endMes, endAno, endHour, endMinutes;
		
		try{
			startDia = (int)Integer.parseInt(startDate.substring(0,2));
			startMes = (int)Integer.parseInt(startDate.substring(3,5));
			startAno = (int)Integer.parseInt(startDate.substring(6,10));
			startHour = (int)Integer.parseInt(startDate.substring(11,13));
			startMinutes = (int)Integer.parseInt(startDate.substring(14,16));		

			endDia = (int)Integer.parseInt(endDate.substring(0,2));
			endMes = (int)Integer.parseInt(endDate.substring(3,5));
			endAno = (int)Integer.parseInt(endDate.substring(6,10));
			endHour = (int)Integer.parseInt(endDate.substring(11,13));
			endMinutes = (int)Integer.parseInt(endDate.substring(14,16));
		} catch(IndexOutOfBoundsException e){
			throw new Exception("Formato de data inválido");
		} catch(NumberFormatException e){
			throw new Exception("Formato de data inválido");
		}
		
		Date d1 = new Date(startAno, startMes - 1, startDia, startHour, startMinutes);
		Date d2 = new Date(endAno, endMes - 1, endDia, endHour, endMinutes);
		
		return ((d2.getTime() - d1.getTime())/60000);
	}

	
	public static String deBD (String var) throws Exception 
	{
		//recebe  "2002-03-25 14:05:00.0"
		//retorna "25/03/2002 14:05"
		
		if (var == null) return ""; 
	
		if (var.length() < 19) return var;
		
		String ano = var.substring(0,4);
		String mes = var.substring(5,7);
		String dia = var.substring(8,10);
		String h   = var.substring(11,13);
		String m   = var.substring(14,16);
		String s   = var.substring(17,19);
		
		if (dia.equals("01") && mes.equals("01") && ano.equals("1900"))
			return "";
		
		return (dia + "/" + mes + "/" + ano + " " + h + ":" + m);
	}
	public String deBDData (String var) throws Exception 
	{
		//recebe  "2002-03-25 14:05:00.0"
		//retorna "25/03/2002"
		
		if (var == null) return ""; 
	
		if (var.length() < 19) return var;
		
		String ano = var.substring(0,4);
		String mes = var.substring(5,7);
		String dia = var.substring(8,10);
		
		if (dia.equals("01") && mes.equals("01") && ano.equals("1900"))
			return "";
		
		return (dia + "/" + mes + "/" + ano);
	}
	public static String deBDHora (String var) throws Exception 
	{
		//recebe  "2002-03-25 14:05:00.0"
		//retorna "14:05"
		
		if (var == null) return ""; 
	
		if (var.length() < 19) return var;
		
		String ano = var.substring(0,4);
		String mes = var.substring(5,7);
		String dia = var.substring(8,10);
		String h   = var.substring(11,13);
		String m   = var.substring(14,16);
		String s   = var.substring(17,19);
		
		if (dia.equals("01") && mes.equals("01") && ano.equals("1900"))
			return "";
		
		return (h + ":" + m);
	}
	
	public static String getAgora(boolean retornaDataHora) 
	{
		//
		//retorna :
		//			15/08/2001 10:28:18
		//			ou
		//			15/08/2001
		//

		String dt;
		
		Date agora = new Date();
		String formato = "";

		if (retornaDataHora) formato = "dd/MM/yyyy HH:mm";
		else formato = "dd/MM/yyyy";

		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		return formatter.format(agora);

	}
	public static String getAgoraExtenso() throws Exception 
	{
		String diaSem[] = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", 
				"Quinta-feira", "Sexta-feira", "Sábado"};

		String mes[] = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", 
			    "agosto", "setembro", "outubro", "novembro", "dezembro"};

		Date hoje = new Date();
		String dia;

		if (hoje.getDate() < 10)
			dia = "0" + hoje.getDate();
		else
			dia = "" + hoje.getDate();
		
		int ano = hoje.getYear() + 1900;
		
		String dataExtenso = diaSem[hoje.getDay()] + ", " + dia + " de " + mes[hoje.getMonth()] + " de " + ano;
		hoje = null;
		
		return dataExtenso;
	}
	public static String getDataHora() throws Exception 
	{
		//
		//retorna :
		//			15/08/2001 10:28
		
		String dt;
		
		Date agora = new Date();
		
		dt = agora.toLocaleString().substring(0,16); //retorna data e hoa
		agora = null;
		return dt;
	}
	public static String getHora() throws Exception 
	{
		//
		//retorna :
		//			10:28
		//
		
		String hora;
		
		Date agora = new Date();
		
		hora = agora.toGMTString().substring(12, 17); //retorna hora
		
		agora = null;
		
		return hora;
	}
	public static String getHoraLocal() throws Exception 
	{
		//
		//retorna :
		//			10:28
		//
		
		String hora;
		
		Date agora = new Date();
		
		DecimalFormat format=new DecimalFormat("00");
		hora = format.format(agora.getHours())+":"+format.format(agora.getMinutes()); //retorna hora
		
		agora = null;
		
		return hora;
	}
	public String getMesExtenso(String mes) throws Exception 
	{
		//
		//recebe 07
		//retorna Jul
		//

		int mesInt = (int)Integer.parseInt(mes);
		
		String mesMMM[] = new String [12];
		
	    mesMMM[0] = "Jan";
	    mesMMM[1] = "Feb";
	    mesMMM[2] = "Mar";
	    mesMMM[3] = "Apr";
	    mesMMM[4] = "May";
	    mesMMM[5] = "Jun";
	    mesMMM[6] = "Jul";
	    mesMMM[7] = "Aug";
	    mesMMM[8] = "Sep";
	    mesMMM[9] = "Oct";
	    mesMMM[10]= "Nov";
	    mesMMM[11]= "Dec";
		
		return mesMMM[(mesInt - 1)];
	}
	public static String getSaudacao() 
	{
		Date now = new Date();
		int hora = now.getHours();
		now = null;

		if		(hora >= 0  && hora < 12) return "Bom dia!";
		else if (hora >= 12 && hora < 18) return "Boa tarde!";
		else							  return "Boa noite!"; 
	}
	public static String paraBD (String var) throws Exception 
	{
		//recebe  "25/03/2002 10:20"
		//retorna "03/25/2002 10:20"
		
		if (var == null || var.trim().length() < 10)
		{
			return "";
		}
		
		String dia = var.substring(0,2);
		String mes = var.substring(3,5);
		String ano = var.substring(6,10);
		String hora = "";

		
		if (var.length() > 10 && var.length() < 17)
		{
			if(Data.verifyHour(var.substring(11, var.length())))
			{
				hora= var.substring(11, var.length());
			}
			else
			{
				hora = "";
			}
		}
		
		
		if (dia.equals("01") && mes.equals("01") && ano.equals("1900"))
			return "";
		
		return (ano+ "-" + mes  + "-" + dia + " " + hora);
	}

	public String paraBDTrunc (String var) throws Exception 
	{
		//recebe  "25/03/2002 10:20"
		//retorna "2002-03-25"
		
		if (var == null || var.trim().length() < 10)
		{
			return "";
		}
		
		String dia = var.substring(0,2);
		String mes = var.substring(3,5);
		String ano = var.substring(6,10);
		
		if (dia.equals("01") && mes.equals("01") && ano.equals("1900"))
			return "";
		
		return (ano+ "-" + mes  + "-" + dia);
	}
	public String deBDTrunc (String var) throws Exception 
	{
		//retorna "2002-03-25"
		//recebe  "25/03/2002"
		
		if (var == null || var.trim().length() < 10)
		{
			return "";
		}
		
		String ano = var.substring(0,4);
		String mes = var.substring(5,7);
		String dia = var.substring(8,10);
		if (dia.equals("01") && mes.equals("01") && ano.equals("1900"))
			return "";
		
		return (mes+ "/" + mes  + "/" + ano);
	}
	
	/*------------------------------------------------------------------------------------------------------
     //método : sumDays
      //autor : Orlando Fabricio Neto - 24/07/2002
	 //função : Soma dias
  //descrição : Este método tem por função somar uma qt de dias a uma data, retornando um String.
   //revisado : 
------------------------------------------------------------------------------------------------------*/
	public String sumDays(String startDate, int qtDays)  throws Exception 
	{
		int startDay, startMonth, startYear;
		String retorno;
		
		startDay = (int)Integer.parseInt(startDate.substring(0,2));
		startMonth = (int)Integer.parseInt(startDate.substring(3,5));
		startYear = (int)Integer.parseInt(startDate.substring(6,10));

		GregorianCalendar gc = new GregorianCalendar(startYear, startMonth-1, startDay+qtDays);

		retorno = (gc.get(GregorianCalendar.DAY_OF_MONTH) < 10)?("0"):("");
		retorno += new Integer(gc.get(GregorianCalendar.DAY_OF_MONTH)).toString() + "/";
		retorno += (gc.get(GregorianCalendar.MONTH)+1 < 10)?("0"):("");
		retorno += new Integer(gc.get(GregorianCalendar.MONTH) + 1).toString() + "/";
		retorno += new Integer(gc.get(GregorianCalendar.YEAR)).toString();

		gc = null;

		return retorno;
	}
	
	/**
	 * 
	 * Coloque aqui a descrição.<br>
	 * Data: 18/11/2003
	 * @param hora
	 * @param hours
	 * @return
	 * @author Ubirajara Moreira Neto
	 */
	public static String sumHours(String data, int hours){
		if(data.equals("")) return "";
		String []parts=data.split(" ");		
		String []dateParts=parts[0].split("/");
		String []timeParts=parts[1].split(":");
		
		int startDay, startMonth, startYear;
		int startHour, startMinutes;
		String retorno;
		DecimalFormat format=new DecimalFormat("00");
		
		startDay = (int)Integer.parseInt(dateParts[0]);
		startMonth = (int)Integer.parseInt(dateParts[1]);
		startYear = (int)Integer.parseInt(dateParts[2]);
		
		startHour = (int)Integer.parseInt(timeParts[0]);
		startMinutes = (int)Integer.parseInt(timeParts[1]);		

		GregorianCalendar gc = new GregorianCalendar(startYear, startMonth-1, startDay, startHour, startMinutes);
		gc.add(GregorianCalendar.HOUR_OF_DAY,hours);
		String result=format.format(gc.get(java.util.GregorianCalendar.DAY_OF_MONTH))+"/"+format.format(gc.get(java.util.GregorianCalendar.MONTH)+1)+"/"+format.format(gc.get(java.util.GregorianCalendar.YEAR))+" "+format.format(gc.get(java.util.GregorianCalendar.HOUR_OF_DAY))+":"+format.format(gc.get(java.util.GregorianCalendar.MINUTE));	
		return result;
	}	
	
	/**
	 * 
	 * Coloque aqui a descrição.<br>
	 * Este método tem a função de somar minutos a uma data
	 * Ex.: Recebe - 28/10/2006 15:00, 15
	 *      Retorna - 28/10/2006 15:15
	 * Data: 12/09/2006
	 * @param hora
	 * @param hours
	 * @return
	 * @author Anderson Augustinho
	 */
	public static String sumMinutes(String data, int minutes){
		if(data.equals("")) return "";
		String []parts=data.split(" ");		
		String []dateParts=parts[0].split("/");
		String []timeParts=parts[1].split(":");
		
		int startDay, startMonth, startYear;
		int startHour, startMinutes;
		String retorno;
		DecimalFormat format=new DecimalFormat("00");
		
		startDay = (int)Integer.parseInt(dateParts[0]);
		startMonth = (int)Integer.parseInt(dateParts[1]);
		startYear = (int)Integer.parseInt(dateParts[2]);
		
		startHour = (int)Integer.parseInt(timeParts[0]);
		startMinutes = (int)Integer.parseInt(timeParts[1]);		

		GregorianCalendar gc = new GregorianCalendar(startYear, startMonth-1, startDay, startHour, startMinutes);
		gc.add(GregorianCalendar.MINUTE,minutes);
		String result=format.format(gc.get(java.util.GregorianCalendar.DAY_OF_MONTH))+"/"+format.format(gc.get(java.util.GregorianCalendar.MONTH)+1)+"/"+format.format(gc.get(java.util.GregorianCalendar.YEAR))+" "+format.format(gc.get(java.util.GregorianCalendar.HOUR_OF_DAY))+":"+format.format(gc.get(java.util.GregorianCalendar.MINUTE));	
		return result;
	}
	
	/**
	 * 
	 * Coloque aqui a descrição.<br>
	 * Data: 18/11/2003
	 * @param date
	 * @param dia
	 * @return
	 * @author Ubirajara Moreira Neto
	 */
public static boolean isDiaDaSemana(String date, int dia){
	int[] tokensOfInitialDate;
	try{
		tokensOfInitialDate = Data.brokenDate(date);
	} catch(Exception e){
		return false;
	}	
	java.util.GregorianCalendar gcInitial = new java.util.GregorianCalendar(tokensOfInitialDate[2], tokensOfInitialDate[1], tokensOfInitialDate[0]);
	gcInitial.add(java.util.GregorianCalendar.DAY_OF_MONTH, 1);		
	return gcInitial.get(java.util.GregorianCalendar.DAY_OF_WEEK) == dia;
}
/**
 * Insira a descrição do método aqui.
 * Data de criação: (05/11/02 10:33:30)
 * @return boolean
 * @param hour java.lang.String
 */
public static boolean verifyHour(String hour)
{
	hour = hour.trim();
	
	if(hour == null || hour.length() != 5)
	{
		return false;
	}

	if(hour.indexOf(":")!= 2)
	{
		return false;
	}

	if(hour.indexOf(" ")!= -1)
	{
		return false;
	}
	
	String hora = hour.substring(0, 2);
	String minuto = hour.substring(3, 5);
	
	if(Integer.parseInt(hora) > 23){
		return false;
	}
	
	if(Integer.parseInt(minuto) > 59){
		return false;
	}

	return true;
}

public static String somaDiasUteis(String initialDate, int days) throws Exception
{
	int[] tokensOfInitialDate = Data.brokenDate(initialDate);	
	java.util.GregorianCalendar gcInitial = new java.util.GregorianCalendar(tokensOfInitialDate[2], tokensOfInitialDate[1], tokensOfInitialDate[0]);
	DecimalFormat format=new DecimalFormat("00");
	int i=0;
	int inc=days>0?1:-1;
	while(i!=days)
	{						
		gcInitial.add(java.util.GregorianCalendar.DAY_OF_MONTH, inc);		
		if(gcInitial.get(java.util.GregorianCalendar.DAY_OF_WEEK) != 1 && gcInitial.get(java.util.GregorianCalendar.DAY_OF_WEEK) != 7)
		{
			i+=inc;
		}
	}
	String result=format.format(gcInitial.get(java.util.GregorianCalendar.DAY_OF_MONTH))+"/"+format.format(gcInitial.get(java.util.GregorianCalendar.MONTH)+1)+"/"+format.format(gcInitial.get(java.util.GregorianCalendar.YEAR));
	return 	result;
}

/**
 * @author Rodrigo Francisco Wisnievski
 * @param mes
 * @return número de dias do mês passado como parametro
 * @throws Exception
 * Data: 29/04/2004
 */
public static int getDiasMes(int mes, int ano) {
	//String agora = getAgora(false);
	//int ano = Integer.parseInt(agora.substring(6));
	int dias_fevereiro = (((ano % 4) == 0) ? 29 : 28);
	int[] diasMes = {31, dias_fevereiro, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	return diasMes[mes - 1];
}

/**
 * @author Rodrigo Francisco Wisnievski
 * @param data
 * @return dia da semana
 * @throws Exception
 * Data: 29/04/2004
 */
public static int getDiaSemana(int dia, int mes, int ano) {
	Calendar c = Calendar.getInstance();
	c.setTime(new Date());
	c.set(Calendar.DAY_OF_MONTH, dia);
	c.set(Calendar.MONTH, mes - 1);
	c.set(Calendar.YEAR, ano);
	
	String diaSem[] = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", 
					"Quinta-feira", "Sexta-feira","Sábado"};
					
	return c.get(Calendar.DAY_OF_WEEK);
}

}
