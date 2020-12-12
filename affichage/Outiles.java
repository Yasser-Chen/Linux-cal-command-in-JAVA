package affichage;

public class Outiles {
		
	   static boolean isBisextil(int year){
	        if(year % 4 == 0){
	            if( year % 100 == 0) {
	                if   ( year % 400 == 0) return  true;
	                else return false;
	             }
	            else return true;
	        }
	        else return false;
	   }
	   
	   
	   public static void outPutYear(	int[] indexOfStartingDay,
			   							int day,//must be 1 in default
			   							int indexOfTheMonth,
			   							int year ,
			   							boolean addSelection,
			   							int[] NumberOfWeeks
			   							){
		   if(!addSelection) {day=-1;}
		   System.out.print("\n                               "+year);
		   
			   String[] months = {" January ", " February", "  March  ", "  April  ", "   May   ", "   June  ", "   July  ", "  August ", "September", " October ", " November", " December "};
				int[][] lastDayOfMonth = {{31,28,31,30,31,30,31,31,30,31,30,31},{31,29,31,30,31,30,31,31,30,31,30,31}} ;
				int Bi ;
				
				if(isBisextil(year)) {
				Bi = 1;
				}
				else {
				Bi = 0;
				}
			   //start inserting numbers

				int [] count = new int[] {1,1,1,1,1,1,1,1,1,1,1,1};
				int [] counteur = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0};
				String MONTH1;
				String MONTH2;
				String MONTH3;
			
				int moi = 0;
				
			for(int k = 0;k<4;k++) {	//------------------------------------------------------------
				
				
				System.out.print("\n     "+months[moi]);
				System.out.print("              "+months[moi+1]);
				System.out.print("              "+months[moi+2]+"\n");
				outPutDaysOfTheWeek();					
				System.out.print("   ");				
				outPutDaysOfTheWeek();
				System.out.print("   ");				
				outPutDaysOfTheWeek();
				System.out.print("\n");
				
				for(int i=1;i<=6;i++) { //-----------------------------------------------
					MONTH3 = "";
					MONTH2 = "";
					MONTH1 = "";
					for(int j=1;j<=8;j++) {//---------------------------------------------------------
						counteur[moi]++;counteur[moi+1]++;counteur[moi+2]++;
											
						
						
											//----------------Month 1
						
						
						
						if(i<=NumberOfWeeks[moi]) {
							if(!isLast(counteur[moi])){ 
								if(counteur[moi]<indexOfStartingDay[moi] || count[moi]  > lastDayOfMonth[Bi][moi]) {
									MONTH1=MONTH1+"   ";
								}
								else {
									MONTH1 = MONTH1 + formatOutPut(count[moi],count[moi]==day,moi==indexOfTheMonth);
									count[moi]++;
								}
							}
						}
						else {MONTH1="                     ";}
						
										
											
											//----------------Month 2
						
											
						
						if(i<=NumberOfWeeks[moi+1]) {
							if(!isLast(counteur[moi+1])){
								if(counteur[moi+1]<indexOfStartingDay[moi+1] || count[moi+1]   > lastDayOfMonth[Bi][moi + 1]) {
									MONTH2=MONTH2+"   ";
								}
								else {
									MONTH2 = MONTH2 + formatOutPut(count[moi+1],count[moi+1]==day,moi==indexOfTheMonth);
									count[moi+1]++;
								}
							}
								
						}
						else {MONTH2="                     ";}
						
						
											
											//-----------------Month 3
							
						
											
						if(i<=NumberOfWeeks[moi+2]) {
							if(!isLast(counteur[moi+1])) {
								if(counteur[moi+2]<indexOfStartingDay[moi+2] || count [moi+2]  > lastDayOfMonth[Bi][moi + 2]) {
									MONTH3=MONTH3+"   ";
									}
								else {
									MONTH3 = MONTH3 + formatOutPut(count[moi +2],count[moi+2]==day,moi==indexOfTheMonth);
									count[moi+2]++;
								}
							}	
						}
						else {MONTH3="                     ";}
											
											

						//for every single day
						}
					System.out.print(MONTH1+"  "+MONTH2+"  "+MONTH3+"\n");
					//end of a week

				}//end of 3 months
					
				moi+=3 ;

	   		}//end of the year
	   }
	   
	   
	   public static void outPutMonth(	int indexOfStartingDay,
						int day,//must be 1 in default
						int indexOfTheMonth,
						int year ,
						boolean addSelection,
						int NumberOfWeeks
						
						){
			String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			int[][] lastDayOfMonth = {{31,28,31,30,31,30,31,31,30,31,30,31},{31,29,31,30,31,30,31,31,30,31,30,31}} ;
			int Bi ;
			if(isBisextil(year)) {
			Bi = 1;
			}
			else {
			Bi = 0;
			}
			
			int count = 1;
			int counteur =0;
			System.out.println("\n   "+months[indexOfTheMonth]+" "+year+"   ");
			outPutDaysOfTheWeek();
			for(int i=1;i<= NumberOfWeeks;i++) {
				System.out.println();
				for(int j=1;j<=7;j++) {
					counteur++;
					if(counteur<indexOfStartingDay || count  > lastDayOfMonth[Bi][indexOfTheMonth]) {
						System.out.print("   ");
					}else {
						if(addSelection){
							if(day == count) {
								System.out.print("'"+count+"' ");count++;
							}
							else {formatOutPut(count);count++;}
						
						}
						else {formatOutPut(count);count++;}
					}
					
				}
				//end of a line
			}
	   	}
	   
	   
	   public static void formatOutPut(int number){
		   if(number%10==number) {
			   System.out.print(" "+number +" ");
		   }
		   else {
			   System.out.print(number +" ");
		   }
	   }	   
	   public static String formatOutPut(int number,boolean selectedDay,boolean selectedMonth){
		   if(selectedDay && selectedMonth) {
			   if(number%10==number) {
				   return ("' "+number +"'");//SELECTION
			   }
			   else {
				   return ("'"+number +"'");//SELECTION
			   }
		   }
		   else {
			   if(number%10==number) {
				   return (" "+number +" ");
			   }
			   else {
				   return (number +" ");
			   }
		   }
	   }
	   

	    public static String prepare(String  commande){
		     return new String(new String(commande).trim()).replaceAll( "\s+" , " ");

	   }

	    
	    
	    private static void outPutDaysOfTheWeek() {
	    	System.out.print("SU MO TU WE TH FR SA");
	    }
	    public static int asIndex(String a){
	    	a = new String(a).substring(0,2); ;
	    	String[] days = {"Su","Mo","Tu","We","Th","Fr","Sa"};
	    	for(int i =0;i<days.length;i++)
	    	if(a.equals(new String(days[i]))) {
	    		return i-1;
	    	}
	    	return -1;
	    }
	    
	    public static int MAX(int i,int j,int k) {
	    	
	    		  if(i > j && i > k)
	    		  {
	    		    return i;
	    		  }
	    		  else if (j > k)
	    		  {
	    		    return j;
	    		  }
	    		  else
	    		  {
	    		    return k;
	    		  }
	    		
	    }
	    public static boolean isLast(int day) {
	    	day +=1;
	    	if(day%7==0)return true;
	    	return false;
	    }
	    
}

