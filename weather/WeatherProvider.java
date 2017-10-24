package weather;

import java.util.Random;
import aircraft.Aircraft.Coordinates;

public class WeatherProvider {
	private static WeatherProvider provider = null;

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

	public String getCurrentWeather(Coordinates coordinates) {
		return weather[this.random.nextInt(3)];
	}
}