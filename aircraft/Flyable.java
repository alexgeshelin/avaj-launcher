package aircraft;

import tower.WeatherTower;

public interface Flyable {

	void updateConditions();
	void registerTower(WeatherTower tower);
	String getSignature();
	boolean hasLanded();
}