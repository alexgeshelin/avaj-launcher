package weather;

import java.util.Random

class WeatherProvider {
	private WeatherProvider provider = null;

	private Random random;

	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {
		this.random = new Random();
	}

	public static WeatherProvider getWeatherProvider() {
		if (provider == null)
			provider = new WeatherProvider();
		return provider;
	}

	public getCurrentWeather(Coordinates coordinates) {
		return weather[this.random.nextInt(3)];
	}
}