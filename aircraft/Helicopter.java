package aircraft;

import tower.WeatherTower;

class Helicopter extends Aircraft implements Flyable {

	private WeatherTower tower;
	private String[] message = {"I'm covered in snowflakes",
								"This is hot",
								"It is raining heavily",
								"I can't see anything"};

	Helicopter(String name, int longitude, int latitude, int height) {
		super(name, longitude, latitude, height);
	}

	public void updateConditions() {
		String weather = this.tower.getWeather(this.coordinates);
		if (weather.equals("SNOW")) {
			System.out.println("Helicopter#" + this.name +"(" + this.id + "): "
					+ message[0]);
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
		}
		else if (weather.equals("SUN")) {
			System.out.println("Helicopter#" + this.name +"(" + this.id + "): "
					+ message[1]);
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
		}
		else if (weather.equals("RAIN")) {
			System.out.println("Helicopter#" + this.name +"(" + this.id + "): "
					+ message[2]);
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
		}
		else if (weather.equals("FOG")) {
			System.out.println("Helicopter#" + this.name +"(" + this.id + "): "
					+ message[3]);
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
		}
		if (this.coordinates.getHeight() == 0)
			this.tower.unregister(this);
	}

	public void registerTower(WeatherTower tower) {
		this.tower = tower;
	}
}