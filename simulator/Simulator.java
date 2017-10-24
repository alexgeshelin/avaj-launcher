package simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
	static private BufferedWriter file;

	static {
		try
		{
			file = new BufferedWriter(new FileWriter("simulation.txt"));
		}
		catch (IOException e)
		{
			System.err.println("Error: Failed to create file.");
			System.exit(0);
		}
	}

	Simulator() {
		tower = new WeatherTower();
	}

	public static void main(String[] args) {
		if (args.length == 0)
		{
			System.err.println("Give scenario as an argument.");
			System.exit(0);
		}
		Simulator simulation = new Simulator();
		simulation.readScenario(args);
		simulation.checkScenario();
		simulation.loadScenario();
		simulation.startSimulation();
		try {
			file.close();
		}
		catch (IOException e) {
			System.err.println("Error: Failed to close file");
		}
	}

	public static void log(String entry) {
		try {
			file.write(entry);
			file.newLine();
		}
		catch (IOException e)
		{
			System.err.println("Error: Failed writing to file.");
			System.exit(0);
		}
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
				"(Balloon|Helicopter|JetPlane) [a-zA-Z0-9]+ [0-9]+ [0-9]+ [0-9]+")) {
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
			aircraft.registerTower(this.tower);
		}
	}

	void startSimulation() {
		while (cycles-- != 0)
			tower.changeWeather();
	}
}