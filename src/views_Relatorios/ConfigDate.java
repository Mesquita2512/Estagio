package views_Relatorios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConfigDate {

	public Date confDataEmp(Date data_Entrega) {
		// formatando a data final
		SimpleDateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
		String dataFiMTests = formatado.format(data_Entrega);

		try {
			data_Entrega = new SimpleDateFormat("dd/MM/yyyy").parse(dataFiMTests);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// incrementa um dia a data
		Calendar c = Calendar.getInstance();
		c.setTime(data_Entrega);
		c.add(Calendar.DATE, 0);
		data_Entrega = c.getTime();
		return data_Entrega;
	}

	public Date confDatFim(Date data_Fim) {

		// incrementa um dia a data
		Calendar c = Calendar.getInstance();
		c.setTime(data_Fim);
		c.add(Calendar.DATE, 1);
		data_Fim = c.getTime();
		
		return data_Fim;
	}
	
	public Date confDatIni(Date data_Ini) {

		// incrementa um dia a data
		Calendar c = Calendar.getInstance();
		c.setTime(data_Ini);
		c.add(Calendar.DATE, -1);
		data_Ini = c.getTime();
		
		return data_Ini;
	}

}
