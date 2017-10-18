import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Simulator
{
	private static List<String> scenario;
	private static int cycles;
	public static void main(String[] args)
	{
		try
		{
			Path file = Paths.get(args[0]);
			scenario = Files.readAllLines(file);
		}
		catch (IOException e)
		{
			System.err.println("Error");
		}
		checkScenario();
	}
	
	static void checkScenario()
	{
		ListIterator<String> it = scenario.listIterator();
		if (!it.next().matches("[1-9][0-9]*") || !it.hasNext())
		{
			System.err.println("Invalid scenario.");
			System.exit(0);
		}
		while (it.hasNext())
		{
			if (!it.next().matches(
				"((Ballon)||(JetPlane)||(Helicopter)) [a-zA-Z_0-9]+ [0-9]+ [0-9]+ [0-9]+"))
			{
				System.err.println("Invalid scenario.");
				System.exit(0);
			}
		}
	}
}