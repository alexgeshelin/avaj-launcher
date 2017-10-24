package aircraft;

import simulator.Simulator;
import tower.WeatherTower;

class JetPlane extends Aircraft implements Flyable {

	private WeatherTower tower;
	private String[] message = {"I am piercing through snow.",
								"I should have taken my sunglasses.",
								"Turning windshields on.",
								"Wish i had headlights."};

	JetPlane(String name, int longitude, int latitude, int height) {
		super(name, longitude, latitude, height);
	}

	public void updateConditions() {
		String weather = this.tower.getWeather(this.coordinates);
		if (weather.equals("SNOW")) {
			Simulator.log("JetPlane#" + this.name +"(" + this.id + "): "
					+ message[0]);
			this.coordinates.setHeight(this.coordinates.getHeight() - 7);
		}
		else if (weather.equals("SUN")) {
			Simulator.log("JetPlane#" + this.name +"(" + this.id + "): "
					+ message[1]);
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
		}
		else if (weather.equals("RAIN")) {
			Simulator.log("JetPlane#" + this.name +"(" + this.id + "): "
					+ message[2]);
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
		}
		else if (weather.equals("FOG")) {
			Simulator.log("JetPlane#" + this.name +"(" + this.id + "): "
					+ message[3]);
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
		}
		if (this.coordinates.getHeight() == 0)
			this.tower.unregister(this);
	}

	public void registerTower(WeatherTower tower) {
		this.tower = tower;
	}

	public String getSignature() {
		String signature = "JetPlane" + "#" + this.name + "(" + this.id + ")";
		return signature;
	}

	public boolean hasLanded() {
		if (this.coordinates.getHeight() == 0)
			return true;
		else
			return false;
	}
}