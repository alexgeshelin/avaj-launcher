package tower;

import java.util.ArrayList;
import aircraft.Aircraft;
import aircraft.Flyable;

class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable flyable : observers)
			flyable.updateConditions();
	}
}