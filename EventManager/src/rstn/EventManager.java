package rstn;

/* Date: 08/15/2018
Author: Rustin Winger
Description: This program analyses a file of Seattle city incident data and allows user to search it
*/

import java.io.File;
import java.util.Scanner;

public class EventManager {
	
	static int lineNum = 0;
	static Event events[] = new Event[530616];
	
	//scans file and stores data as objects in an array
	//prints total number of events and events by year
	public static void main(String[] args) {
		try {
		File file = new File("Seattle_911_Incidents.csv");
	
		Scanner fileScanner = new Scanner(file);
	
		int lineNumber = 0;
		
		while(fileScanner.hasNextLine()) {
			
			String total = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(total);
			
			lineScanner.useDelimiter(",");
			
			events[lineNumber] = new Event(lineScanner.next(), lineScanner.next(), 
					lineScanner.next(), lineScanner.next(), 
					lineScanner.next(), lineScanner.next());
			
			lineNumber++;
		}
		Scanner sc = new Scanner(System.in);
		int twentyFifteen = 0;
		int twentySixteen = 0;
		int twentySeventeen = 0;
		
		for (int i=0; i<lineNumber; i++) {
	
			if (events[i].datetime.contains("/15 ")) {
				twentyFifteen++;
			}
			else if (events[i].datetime.contains("/16 ")) {
				twentySixteen++;
			}
			else if (events[i].datetime.contains("/17 ")) {
				twentySeventeen++;
			}
		}			
		System.out.println("Total events: "+ (lineNumber-1));
		System.out.println("2015: " + twentyFifteen);
		System.out.println("2016: " + twentySixteen);
		System.out.println("2017: " + twentySeventeen);
		System.out.println("Total events: "+ (lineNumber-1));
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("Seattle 911 Event Search Manager:");
		userContinue();
	}
		catch (Exception e) {
			System.out.println("File not found");
}
}	 
	//allows user to search data by specific date
	public static void dateSearch(int c) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date (dd/mm/yy):");
		String date = sc.nextLine();
		int count = 0;
		
		for(int i=0; i<events.length; i++) {

			if (events[i].datetime.contains(date)) {
				count++;
				System.out.println("Event-" + count + "------------------------");
				System.out.println("Type:" + events[i].type);
				System.out.println("Date:" + events[i].datetime);
				System.out.println("Time:" + events[i].datetime);
				System.out.println("Address:" + events[i].address);
				System.out.println("Sector:" + events[i].sector);
				System.out.println("Zone:" + events[i].zone);
			}
		}
		if (count == 0) {
			System.out.println("No records found");
		}
		else {
			System.out.println(count + " events.");
		}
		System.out.println();
	}
	
	//allows user to search data by keyword and sector
	public static void typeSearch(int c) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter keyword for type:");
		String keyword = sc.nextLine();
		System.out.print("Enter sector:");
		String sector = sc.nextLine();
		int count = 0;
		
		for(int i=0; i<events.length; i++) {

			if (events[i].type.toLowerCase().contains(keyword.toLowerCase()) && 
					(events[i].sector.toLowerCase().contains(sector.toLowerCase()))) {
				count++;
				System.out.println("Event-" + count + "------------------------");
				System.out.println("Type:" + events[i].type);
				System.out.println("Date:" + events[i].datetime);
				System.out.println("Time:" + events[i].datetime);
				System.out.println("Address:" + events[i].address);
				System.out.println("Sector:" + events[i].sector);
				System.out.println("Zone:" + events[i].zone);
			}
		}
		if (count == 0) {
			System.out.println("No records found");
		}
		else {
			System.out.println(count + " events.");
		}
		System.out.println();
	}
	
	//method that loops to allow user to continue searching or quit
	public static void userContinue() {
		
		Scanner sc = new Scanner (System.in);
		char cont = 'Y';
		
		while (cont == 'Y') {
			
			System.out.println("1- Search by Date");
			System.out.println("2- Search by Type");
			System.out.println("3- Quit");
			System.out.print("Choose a search operation:");
			
			int c = sc.nextInt();
			
			if(c==3) {
				System.out.println("Stay safe!");
				System.exit(0);
			}
			
			if(c==1) {
				dateSearch(c);
			
			}
			else if(c==2) {
				typeSearch(c);
			}	
		System.out.print("Would you like to continue? Enter Y/N:");
		cont = sc.next().charAt(0);
		cont = Character.toUpperCase(cont);
		
		}	
	}
}

