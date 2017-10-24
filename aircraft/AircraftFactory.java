package aircraft;

import aircraft.Balloon;
import aircraft.Aircraft.Coordinates;

public class AircraftFactory {

	static public Flyable newAircraft(String type, String name,
									  int longitude, int latitude, int height){
		Flyable aircraft = null;

		if (type.equals("Balloon"))
			aircraft = new Balloon(name, longitude, latitude, height);
		else if (type.equals("Helicopter"))
			aircraft = new Helicopter(name, longitude, latitude, height);
		else if (type.equals("JetPlane"))
			aircraft = new JetPlane(name, longitude, latitude, height);
		return aircraft;
	}
}