package tower;

import aircraft.Aircraft.Coordinates;
import weather.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
	}

	public void changeWeather() {
		conditionsChanged();
	}
}