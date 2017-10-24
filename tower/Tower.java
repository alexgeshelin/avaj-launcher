package tower;

import java.util.ArrayList;
import java.util.Iterator;
import aircraft.Flyable;
import simulator.Simulator;

class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
		Simulator.log("Tower says: " + flyable.getSignature() +
				" registered to weather tower.");
	}

	public void unregister(Flyable flyable) {
		Simulator.log(flyable.getSignature() + " is landing.");
		Simulator.log("Tower says: " + flyable.getSignature() +
				" unregistered from weather tower.");
	}

	protected void conditionsChanged() {
		Iterator<Flyable> it = observers.iterator();

		while (it.hasNext()) {
			Flyable flyable = it.next();
			flyable.updateConditions();
			if (flyable.hasLanded())
				it.remove();
		}
	}
}