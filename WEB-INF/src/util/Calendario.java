package util;

public class Calendario {

	public static String montaCalendario(String[] datas, int nrDia, int nrMes, int nrAno) throws Exception {
		//String[] datas = new String[42];
		
		int diasMes = Data.getDiasMes(nrMes, nrAno);
		String agora = Data.getAgora(false);
		int dia_hoje = Integer.parseInt(agora.substring(0,2));
		int mes_hoje = Integer.parseInt(agora.substring(3,5));
		int ano_hoje = Integer.parseInt(agora.substring(6,10));
		StringBuffer retorno = new StringBuffer();
		
				
		retorno.append("<table width='180' height='100' border='0' align='center'>");
		retorno.append("<tr height='30' bgcolor='#00310C' align='center'>");
		retorno.append("<td><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><strong>Dom</strong></font></td>"); 
		retorno.append("<td><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><strong>Seg</strong></font></td>");
		retorno.append("<td><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><strong>Ter</strong></font></td>");
		retorno.append("<td><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><strong>Qua</strong></font></td>");
		retorno.append("<td><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><strong>Qui</strong></font></td>");
		retorno.append("<td><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><strong>Sex</strong></font></td>");
		retorno.append("<td><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><strong>S&aacute;b</strong></font></td>");
		retorno.append("</tr>");		
		
		int qtLaudos = 0;
		int cont = 1;
		for (int i = 1; i <= 42; i++) {
			if ((i % 7) == 1) 
				retorno.append("<tr align='center'>");
						
			if ((Data.getDiaSemana(cont, nrMes, nrAno) <= i) && (cont <= diasMes)) {
				if ((cont == dia_hoje) && (nrMes == mes_hoje) && (nrAno == ano_hoje)) { //Dia de hoje
					if ((datas[cont - 1] != null)) //se Existir algum evendo ou chamado para o dia
						retorno.append("<td style='{font-size:9pt;border: #000000 1px solid; background-color: " + (nrDia == cont ? "#E5E5CD" : "#ffffff") + ";}'><a href='#' onclick='irParaDia("+cont+","+nrMes+","+nrAno+");'><strong>"+cont+"</strong><br><font size='1'>"+datas[cont - 1]+"</font></a></td>");
					else
						retorno.append("<td style='{font-size:9pt;border: #000000 1px solid; background-color: " + (nrDia == cont ? "#E5E5CD" : "#ffffff") + ";}'><a href='#' onclick='irParaDia("+cont+","+nrMes+","+nrAno+");'>"+cont+"</a></td>");
				} else {
					if ((Data.getDiaSemana(cont, nrMes, nrAno) == 1) || ((Data.getDiaSemana(cont, nrMes, nrAno) == 7))) //Sábado ou Domingo
						if ((datas[cont - 1] != null))
							retorno.append("<td  style='{font-size:9pt;border: #000000 0px solid;background-color:#CCCCCC}><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><a href='#' onclick='irParaDia("+cont+","+nrMes+","+nrAno+");'><strong>"+cont+"</strong></font><br><font size='1'>"+datas[cont - 1]+"</font></a></td>");
						else
							retorno.append("<td style='{font-size:9pt;border: #000000 0px solid;background-color:#CCCCCC}><font color='#FFFFFF' size='2' face='Arial, Helvetica, sans-serif'><a href='#' onclick='irParaDia("+cont+","+nrMes+","+nrAno+");'>"+cont+"</a></font></td>");
					else 
						if ((datas[cont - 1] != null))
							retorno.append("<td style='{font-size:9pt;border: #000000 0px solid; background-color: " + (nrDia == cont ? "#E5E5CD" : "#ffffff") + ";}'><a href='#' onclick='irParaDia("+cont+","+nrMes+","+nrAno+");'><strong>"+cont+"</strong><br><font size='1'>"+datas[cont - 1]+"</font></a></td>");
						else 
							retorno.append("<td style='{font-size:9pt;border: #000000 0px solid; background-color: " + (nrDia == cont ? "#E5E5CD" : "#ffffff") + ";}'><a href='#' onclick='irParaDia("+cont+","+nrMes+","+nrAno+");'>"+cont+"</a></td>");
				}
				cont++;				
			} else {
				retorno.append("<td bgcolor='#ffffff'>&nbsp;</td>"); 
			}
			
			if ((i % 7) == 0)
				retorno.append("</tr>");
		}
		retorno.append("</table>");
		
		return retorno.toString();
	}
}
