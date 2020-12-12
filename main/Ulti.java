package main;

import affichage.Outiles;

public class Ulti {
	static String date = new String("date");
	static String cal = new String("cal");
	static String exit = new String("exit");
	public static int type(String str) {
	str = Outiles.prepare(str);
	if(str.equals(exit)) {return 0;}
	if(str.equals(date)) {return 10;}
	if(str.equals(cal)) {return 20;}
	if(str.charAt(0)!='c' || str.charAt(1)!='a' || str.charAt(2)!='l' || str.charAt(3) !=' ') {return -1 ;}
	if( countRepeat(str,' ') == 1 ){return 2;}
	if( countRepeat(str,' ') == 2) {return 3;}
	return -1;
	}
	
	public static int countRepeat(String STR, char find){
	 int nb = 0;
	 for (int i=0; i < STR.length(); i++)
	 {
	 if (STR.charAt(i) == find)
	 nb++;
	 }
	 return nb;
	}

}
