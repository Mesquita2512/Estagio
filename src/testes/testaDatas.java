package testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testaDatas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub  Date dt = new Date();
		Date dt = new Date();
		try {
			 dt = new SimpleDateFormat("dd/MM/yyyy").parse("22/10/2021");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Today:    "+dt);
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        dt = c.getTime();
        
        System.out.println("Tomorrow: "+dt);
	}

}
