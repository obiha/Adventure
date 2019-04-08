//Made by Syed Ahmed
package game.world;

import java.util.List;

public class currency extends Thing {



	public currency(int value) {
		super(value);
	this.value=value;

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
