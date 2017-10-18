package aircraft;

class Ballon extends Aircraft implements Flyable {

	WeatherTower tower;

	Ballon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	void updateConditions() {
		String weather = this.tower.getWeather(this.coordinates);
		if (weather == "SNOW")
		{

		}
		else if (weather == "SUN")
		{

		}
		else if (weather == "RAIN")
		{

		}
		else if (weather == "FOG")
		{

		}
		if (this.coordinate.getHeight() == 0)
			this.tower.unregister(this);
	}

	void registerTower(WeatherTower tower) {
		this.tower = tower;
	}
}