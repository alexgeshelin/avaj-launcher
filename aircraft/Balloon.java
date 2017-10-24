package aircraft;

import simulator.Simulator;
import tower.WeatherTower;

class Balloon extends Aircraft implements Flyable {

	private WeatherTower tower;
	private String[] message = {"My basket is full of snow.",
								"What a sunny day.",
								"My balloon is having a shower.",
								"I feel like a hedgehog."};

	Balloon(String name, int longitude, int latitude, int height) {
		super(name, longitude, latitude, height);
	}

	public void updateConditions() {
		String weather = this.tower.getWeather(this.coordinates);
		if (weather.equals("SNOW")) {
			Simulator.log("Balloon#" + this.name +"(" + this.id + "): "
					+ message[0]);
			this.coordinates.setHeight(this.coordinates.getHeight() - 15);
		}
		else if (weather.equals("SUN")) {
			Simulator.log("Balloon#" + this.name +"(" + this.id + "): "
					+ message[1]);
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
			this.coordinates.setHeight(this.coordinates.getHeight() + 4);
		}
		else if (weather.equals("RAIN")) {
			Simulator.log("Balloon#" + this.name +"(" + this.id + "): "
					+ message[2]);
			this.coordinates.setHeight(this.coordinates.getHeight() - 5);
		}
		else if (weather.equals("FOG")) {
			Simulator.log("Balloon#" + this.name +"(" + this.id + "): "
					+ message[3]);
			this.coordinates.setHeight(this.coordinates.getHeight() - 3);
		}
		if (this.coordinates.getHeight() == 0)
			this.tower.unregister(this);
	}

	public void registerTower(WeatherTower tower) {
		this.tower = tower;
	}

	public String getSignature() {
		String signature = "Balloon" + "#" + this.name + "(" + this.id + ")";
		return signature;
	}

	public boolean hasLanded() {
		if (this.coordinates.getHeight() == 0)
			return true;
		else
			return false;
	}
}