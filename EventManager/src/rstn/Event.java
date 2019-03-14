package rstn;

/* Date: 08/15/2018
Author: Rustin Winger
Description: Stores event object for use in EventManager program
*/

public class Event {
	
	public String id;
	public String type;
	public String datetime;
	public String address;
	public String sector;
	public String zone;
	
	public Event (String a, String b, String c, String d, String e, String f) {
		id = a;
		type = b;
		datetime = c;
		address = d;
		sector = e;
		zone = f;
	}
}
