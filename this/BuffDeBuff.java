//Made by Vineet Abrol
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.*;
public class BuffDeBuff extends Thing{
	private BuffDeBuff f;
	private Location local;
	private String name;
	//private int value;
	//private Human h;

	private int buff;
	private int price;


	//

	public BuffDeBuff (String name, Location location, int buff,int price){
	super(name,location,buff,price); //ADD price
}
public String getBuffDeBuffName(){
	return name;
}
public Location getBuffDeBuffLocation(){
	return location;
}
public int getBuffValue(){
	return buff;
}


public int getPrice(){
	return price;
}






	public void interact(Player p){//Could be Human h
	p.setHealth(p.getHealth()+this.getValue());

	System.out.println("That food gave you a +"+this.getValue()+" boost to your health.\nHealth: "+p.getHealth());
}
	}














/*public final BuffDeBuff generateRandomBuffDebuff(Location location){
	switch((int)Math.random()*2){
		case 1: return new Poutine("Poutine",location,value);
		case 2: return new Blanket("Blanket",location,value);


}return new  Poutine("Poutine",location,value);
}
int[] poutineValue = {1,1,-1,1,1,-1,1,1,-1};
int[] shieldValue = {1,0,0,0,1,0,0,0,0,1};

		int pmax = poutineValue.length;
		int pvalue = ThreadLocalRandom.current().nextInt(0,pmax);



		int smax = shieldValue.length;
		int svalue = ThreadLocalRandom.current().nextInt(0,smax);
*/
