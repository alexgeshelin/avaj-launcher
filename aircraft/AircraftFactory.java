package aircraft;

import aircraft.Ballon;

public class AircraftFactory {

	static public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
		Flyable aircraft;

		if (type.equals("Ballon"))
			aircraft = new Ballon(name, new Aircraft.Coordinates(longitude, latitude, height));
		else if (type.equals("Helicopter"))
			aircraft = new Helicopter(name, new Aircraft.Coordinates(longitude, latitude, height));
		else if (type.equals("JetPlane"))
			aircraft = new JetPlane(name, new Aircraft.Coordinates(longitude, latitude, height));
		return aircraft;
	}
}