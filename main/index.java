package main;
import affichage.*;
import java.util.Scanner;

// example of available commands : cal |cal 20 2020 |cal 2019 | date |
public class index{
	public static Scanner inp = new Scanner(System.in) ;

	public static void main(String[] args) {//MAIN 
		String userInp ;
		out : while(true) {
		CalendarObject affich = new CalendarObject();
		try {
		userInp = inp.nextLine();
		 switch(Ulti.type(userInp)) {
		 case 10 :
			 affich.Date();
			 break ;
		 case 20 :
			 affich.TodayInThisMonth();
			 break ;
		 case 2 :
			 affich.YearComplet(userInp);
			 break ;
		 case 3 :
			 affich.Month(userInp);
			 break ;
		 case 0 :
			 break out ;
		 default :
			 affich.HelpMenu();
			  ;
		 
		 	}
			}
			catch(Exception e) {
				affich.HelpMenu();
			}
		}
		System.out.print("\nexited programme...");
		
		
	}

}
