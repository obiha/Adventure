//Made by Syed Ahmed and Vineet Abrol
public class World{
	protected Room[][] rooms;
	protected Location entrance,lobby,center,athletic,gym,locker;
	protected Thing    goal;

	public World(){
	  Room r1 = new Room("the entrance", new Location(this,0,0),
					  new java.util.ArrayList<Location>(),
						new java.util.ArrayList<Player>(),
						new java.util.ArrayList<Thing>(),
						new java.util.ArrayList<Door>());
	  Room r2 = new Room("Main Lobby", new Location(this,0,1),
						new java.util.ArrayList<Location>(),
						new java.util.ArrayList<Player>(),
						new java.util.ArrayList<Thing>(),
						new java.util.ArrayList<Door>());


		Room r3 = new Room("University Center", new Location(this,0,2),
						new java.util.ArrayList<Location>(),
						new java.util.ArrayList<Player>(),
						new java.util.ArrayList<Thing>(),
						new java.util.ArrayList<Door>());

		Room r4 = new Room("Athletic Center", new Location(this,0,3),
										new java.util.ArrayList<Location>(),
										new java.util.ArrayList<Player>(),
										new java.util.ArrayList<Thing>(),
										new java.util.ArrayList<Door>());

		Room r5 = new Room("Gym", new Location(this,0,4),
														new java.util.ArrayList<Location>(),
														new java.util.ArrayList<Player>(),
														new java.util.ArrayList<Thing>(),
														new java.util.ArrayList<Door>());

		Room r6 = new Room("Locker Room", new Location(this,0,5),
																		new java.util.ArrayList<Location>(),
																		new java.util.ArrayList<Player>(),
																		new java.util.ArrayList<Thing>(),
																		new java.util.ArrayList<Door>());

		r1.getAdjacentRooms().add(r2.getLocation());
	  r2.getAdjacentRooms().add(r3.getLocation());
		r2.getAdjacentRooms().add(r1.getLocation());
	  r3.getAdjacentRooms().add(r4.getLocation());
		r3.getAdjacentRooms().add(r2.getLocation());
	  r4.getAdjacentRooms().add(r5.getLocation());
		r4.getAdjacentRooms().add(r3.getLocation());
	  r5.getAdjacentRooms().add(r6.getLocation());
		r5.getAdjacentRooms().add(r4.getLocation());
	  r6.getAdjacentRooms().add(r5.getLocation());

	  r1.getDoors().add(new Door(r2.getLocation(),false));
	  r2.getDoors().add(new Door(r1.getLocation(),false));
		r2.getDoors().add(new Door(r3.getLocation(),true));
		r3.getDoors().add(new Door(r2.getLocation(),false));
		r3.getDoors().add(new Door(r4.getLocation(),false));
		r4.getDoors().add(new Door(r3.getLocation(),false));
		r4.getDoors().add(new Door(r5.getLocation(),false));
		r5.getDoors().add(new Door(r4.getLocation(),false));
		r5.getDoors().add(new Door(r6.getLocation(),false));
		r6.getDoors().add(new Door(r5.getLocation(),false));

		rooms = new Room[1][6];
    rooms[0][0] = r1;
    rooms[0][1] = r2;
    rooms[0][2] = r3;
    rooms[0][3] = r4;
    rooms[0][4] = r5;
    rooms[0][5] = r6;
	  entrance = r1.getLocation();
    lobby = r2.getLocation();
		center = r3.getLocation();
		athletic = r4.getLocation();
		gym = 		r5.getLocation();
		locker = r6.getLocation();

	}

	public World(String worldFileName){
	  // create world described in file worldFileName
	}

	public Location getEntrance(){
	  return entrance;
	}
  public Location getLobby(){
    return lobby;
  }
	public Location getCenter(){
		return center;
	}
	public Location getAthletic(){
		return athletic;
	}
	public Location getGym(){
		return gym;
	}
	public Location getLocker(){
		return locker;
	}

	public int getCol(){
	  return rooms.length > 0 ? rooms[0].length:0;
	}
	public int getRow(){
	  return rooms.length;
	}

	public Thing getGoal(){ return goal;}

	/** returns room of spcified Player */
	public Room getRoom(Player p){
	  int r = p.getLocation().getRow();
	  int c = p.getLocation().getCol();
	  return rooms[r][c];
	}
	/** returns room of specified location
	  *
	  * @return the room that this is at this location in this world.
	  *         Returns null if there is no such room.
	  */
	public Room getRoom(Location location){
	  return rooms[location.getRow()][location.getCol()];
	}
  }
