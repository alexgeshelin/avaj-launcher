package aircraft;

class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;
	static private long idCounter = 0;

	class Coordinates {

		private int longitude;
		private int latitude;
		private int height;

		Coordinates(int longitude, int latitude, int height) {
			this.longitude = longitude;
			this.latitude = latitude;
			this.height = height;
		}

		int getLongitude() {
			return this.longitude;
		}

		int getLatitude() {
			return this.latitude;
		}

		int getHeight() {
			return this.height;
		}
	}

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId(){
		idCounter++;
		return idCounter;
	}
}