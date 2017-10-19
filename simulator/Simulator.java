package simulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import tower.WeatherTower;
import aircraft.Aircraft;
import aircraft.AircraftFactory;
import aircraft.Flyable;
import java.util.*;

public class Simulator
{
	private List<String> scenario;
	private int cycles;
	private WeatherTower tower;

	Simulator() {
		tower = new WeatherTower();
	}

	public static void main(String[] args) {
		Simulator simulation = new Simulator();
		simulation.readScenario(args);
		simulation.checkScenario();
		simulation.loadScenario();
		simulation.startSimulation();
	}

	void readScenario(String[] args) {
		try {
			Path file = Paths.get(args[0]);
			scenario = Files.readAllLines(file);
		}
		catch (IOException e) {
			System.err.println("Error");
			System.exit(0);
		}
	}
	
	void checkScenario() {
		ListIterator<String> it = scenario.listIterator();
		if (!it.next().matches("[1-9][0-9]*") || !it.hasNext()) {
			System.err.println("Invalid scenario.");
			System.exit(0);
		}
		while (it.hasNext()) {
			if (!it.next().matches(
				"(Baloon|Helicopter|JetPlane) [a-zA-Z0-9]+ [0-9]+ [0-9]+ [0-9]+")) {
				System.err.println("Invalid scenario.");
				System.exit(0);
			}
		}
	}

	void loadScenario() {
		ListIterator<String> it = scenario.listIterator();
		cycles = Integer.parseInt(it.next());
		while (it.hasNext()) {
			String[] entry = it.next().split(" ");
			Flyable aircraft = AircraftFactory.newAircraft(entry[0], entry[1],
				Integer.parseInt(entry[2]),
				Integer.parseInt(entry[3]),
				Integer.parseInt(entry[4]));
			tower.register(aircraft);
		}
	}

	void startSimulation() {
		while (cycles-- != 0)
			tower.changeWeather();
	}
}