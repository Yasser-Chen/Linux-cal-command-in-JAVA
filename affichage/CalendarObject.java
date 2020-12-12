package affichage;

import java.util.*;
import java.util.GregorianCalendar;

public class CalendarObject  {
	Calendar date  ; 
	public CalendarObject(){
		Home();
		this.date = new GregorianCalendar();
	}
	
 	public void Date(){
	System.out.println(date.getTime()+"\n");
	}
	
	
 	private void Home(){
	System.out.print("\n$home> ");
	}
	
	
	public void TodayInThisMonth() {
	
		int startingDay = date.getFirstDayOfWeek();
		if(startingDay ==6) startingDay = 1;
		else startingDay+=2;
		Outiles.outPutMonth(	startingDay,
				date.get(Calendar.DAY_OF_MONTH),
				date.get(Calendar.MONTH),
				date.get(Calendar.YEAR),
				true,
				date.getActualMaximum(Calendar.WEEK_OF_MONTH)
				);		
	}

	
	public void YearComplet(String commande) {//cal 2020
		commande = Outiles.prepare(commande);
		String segments[] = new String(commande).split(" ");
		int year = Integer.parseInt(segments[1]);
		int [] indexOfStartingDay = new int [12];
		int day = 1;
		int indexOfTheMonth = 1;
		int [] NumberOfWeeks = new int [12];
		
		if(year <=9999 && year >=1){
			for(int i=0;i<12;i++) {
				
		date.set(year,i,1);
		indexOfStartingDay[i] = Outiles.asIndex(date.getTime().toString());;
		if(indexOfStartingDay[i] ==6) indexOfStartingDay[i] = 1;
		else indexOfStartingDay[i]+=2;

		NumberOfWeeks[i]=date.getActualMaximum(Calendar.WEEK_OF_MONTH);


			}
		 Outiles.outPutYear(	indexOfStartingDay,
						day,//must be 1 in default
						indexOfTheMonth,
						year ,
						false,
						NumberOfWeeks
						);
		}
		else HelpMenu();

	}
	

	public void Month(String commande) {//cal 12 2020
		commande = Outiles.prepare(commande);
		String segments[] = new String(commande).split(" ");
		int month = Integer.parseInt(segments[1]);
		int year = Integer.parseInt(segments[2]);
		
if(month >= 1 && month <=12 && year <=9999 && year >=1){
		date.set(year,month-1,1);
		int startingDay = Outiles.asIndex(date.getTime().toString());
		if(startingDay ==6) startingDay = 1;
		else startingDay+=2;
		Outiles.outPutMonth(	startingDay,
				date.get(Calendar.DAY_OF_MONTH),
				date.get(Calendar.MONTH),
				date.get(Calendar.YEAR),
				false,
				date.getActualMaximum(Calendar.WEEK_OF_MONTH)
				);
}else HelpMenu();
	}
	
	
	public void HelpMenu() {//errore
		System.out.println("Help Menu  \n		syntax : cal [[Month] Year ]");
	}
}

