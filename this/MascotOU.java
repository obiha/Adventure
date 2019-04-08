//Made by Vineet Abrol
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.*;

public class MascotOU extends Player{


	  private static boolean verbose = false;

	public MascotOU(World w, String name, Location location,int movement, int health,
               List<Thing>  things, Thing goal){
    super(w, name, location,movement, health, things, goal);
		}
	 	// Human h;
	public Location getMascotOULocation(){
		return location;
	}



	public int play(){
		String[] directions = {"n","s","e","w"};
		int max = directions.length;
		int actions = ThreadLocalRandom.current().nextInt(0,max);
		String action = directions[actions];
		switch( action.trim().charAt(action.trim().length()-1) ){
			case 'e' :
				if(verbose){System.err.print("Mascot was in " + this.getLocation());}
				this.w.getRoom(this.getLocation()).removePlayer(this);
				this.setLocation( this.getLocation().east() );
				this.w.getRoom(this.getLocation()).addPlayer(this);
				if(verbose){System.err.print("Mascot now in " + this.getLocation());}
				break;
			case 'w' :
				if(verbose){System.err.print("Mascot was in " + this.getLocation());}
				this.w.getRoom(this.getLocation()).removePlayer(this);
				this.setLocation( this.getLocation().west() );
				this.w.getRoom(this.getLocation()).addPlayer(this);
				if(verbose){System.err.print("Mascot now in " + this.getLocation());}
				break;
				case 'n' :
					if(verbose){System.err.print("Mascot was in " + this.getLocation());}
					this.w.getRoom(this.getLocation()).removePlayer(this);
					this.setLocation( this.getLocation().north() );
					this.w.getRoom(this.getLocation()).addPlayer(this);
					if(verbose){System.err.print("Mascot now in " + this.getLocation());}
					break;
				case 's' :
						if(verbose){System.err.print("Mascot was in " + this.getLocation());}
						this.w.getRoom(this.getLocation()).removePlayer(this);
						this.setLocation( this.getLocation().south() );
						this.w.getRoom(this.getLocation()).addPlayer(this);
						if(verbose){System.err.print("Mascot now in " + this.getLocation());}
						break;
						}
						for(int i = 0;i<this.w.getRoom(this.getLocation()).getPlayers().size();i++){
							if(this.w.getRoom(this.getLocation()).getPlayers().get(i) instanceof Human){
								this.interact(this.w.getRoom(getLocation()).getPlayers().get(i));
							}
						}
						// if(this.getLocation().equals(h.getLocation())){
						// 	interact();//Might need this. or h.
					// }
					return 8;

}

public void interact(Player p){
p.setHealth(p.getHealth()-1);
System.out.println("'Hahaha I got you!'-GeeGee.\nHealth: "+p.getHealth());
if (p.getHealth() <= 0){
	System.out.println("'Hahaha I got you!'-GeeGee.\nOttawaU's mascot caught you! GAME OVER!! ");
	//h.setgameover(); <---

//Add things to items list in vendor

}


	// allows for some interaction with anything in the room
}






}
