package aircraft;

public class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;
	static private long idCounter = 0;

	public class Coordinates {

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

		public void setLongitude(int longitude) {
			this.longitude = longitude;
		}

		public void setLatitude(int latitude) {
			this.latitude = latitude;
		}

		public void setHeight(int height) {
			if (height > 100)
				height = 100;
			else if (height < 0)
				height = 0;
			else
				this.height = height;
		}
	}

	protected Aircraft(String name, int longitude, int latitude, int height) {
		this.name = name;
		this.coordinates = this.new Coordinates(longitude, latitude, height);
		this.id = nextId();
	}

	private long nextId(){
		idCounter++;
		return idCounter;
	}
}