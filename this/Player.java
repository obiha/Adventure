//Made by Brandon Guest
import java.util.List;

/** Players in the game
  *
  * Each member of your team should implement their own
  * unique Player subtype. Your group should also have a human player.
  */

public abstract class Player{
 protected World        w;    // world that player lives in
 protected String       name;
 protected Location     location;
 protected int          movement = 1;
 protected List<Thing>  things;
 protected Thing        goal;
 protected int          health;
 protected int coins;

 /** Creates a player in the game
  *
  * @param w is the world that the player lives in
  * @param name is the name of the player
  * @param location is where in the world the player is
  * @param health is the health of the player (which may or may not be relevant in your game)
  * @param things is a list of Thing objects that the player initially possesses
  * @param goal is the Thing that the human player is trying to retrieve in the game
  */
 public Player(World w, String name, Location location, int movement,int health,List<Thing>  things, Thing goal)
 {
  this.w = w;
  this.name = name;
  this.location = location;
  this.movement = movement;
  this.things = things;
  this.goal = goal;
  this.health = health;
  this.coins = 0;
 }



  public int getCoins(){
    return this.coins;
  }
  protected boolean quit = false;

public boolean getQuit(){
  return quit;
}



  public void setCoins(int add){
    this.coins += add;
  }
 /** Getter for a player's world */
 public World        getWorld(){ return w; }

 /** Getter for a player's name */
 public String       getName(){ return name; }

 /** Getter for a player's location */
 public Location     getLocation(){ return location; }

 /** Getter for a player's health */
 public int          getMovement(){ return movement; }

 /** Getter for a player's list of things */
 public List<Thing>  getThings(){ return things; }

 /** Getter for a player's goal */
 public Thing        getGoal(){ return goal; }

 public int         getHealth(){return health;}

 /** Plays a turn for this player
   *
   * For computer players will have the AI for that player.
   * For human player querie user for input and then react
   * appropriately for the input.
   */

 public boolean checkRoom(int direction){
  Room init = this.w.getRoom(this.getLocation()); //returns the initial room
  List<Location> initLocs = init.getAdjacentRooms(); //returns a list of adjacent locations
  Room next;
  if(direction == 0){
    next = this.w.getRoom(this.getLocation().east());
  }else if(direction == 1){
    next = this.w.getRoom(this.getLocation().north());
  }else if(direction == 2){
    next = this.w.getRoom(this.getLocation().west());
  }else{// if(direction == 3){
    next = this.w.getRoom(this.getLocation().south());
  }
  // next = this.w.getRoom(this.getLocation().east()); //returns the room to the east --> NEEDS TO BE CHANGED
  if(next != null){
    Location nextLoc = next.getLocation(); //returns the next location
    List<Door> initDoors = init.getDoors(); //returns a list of the doors in the initial room
    boolean corrDoor = false;
    Door checkDoor;

    if(initLocs.contains(nextLoc)){ //check to make sure that the next location is a good location
      //loop through the doors and check if their connection location equals the nextLoc
      for(Door d: initDoors){
        if(nextLoc.equals(d.getConn())){
          checkDoor = d;
          corrDoor = true;
          break;
        }
      }
    }
    return corrDoor;
  }else{
    return false;
  }
 }

 public int play(){
  int action = (int) (Math.random() * 4);
  int playerNum = 0;
  if(action == 4){
    int numPlayersInRoom = this.w.getRoom(this.getLocation()).getPlayers().size();
    if(numPlayersInRoom>1){
      playerNum = (int) (Math.random() * numPlayersInRoom) - 1;
      if(playerNum == -1){
        playerNum = numPlayersInRoom - 1;
      }
      if(this.w.getRoom(this.getLocation()).getPlayers().get(playerNum) instanceof Human){
        action = (int) Math.random() * 3;
      }else if((this.equals(this.w.getRoom(this.getLocation()).getPlayers().get(playerNum)))){
        action = (int) (Math.random() * 3);
      }
    }else{
      action = (int) (Math.random() * 3);
    }
  }
  if(action<4){
    while(this.checkRoom(action)){

      action = (int) (Math.random() * 3);
      this.checkRoom(action);
    }
  }
  switch( action ){
    case 0 :
      System.err.print(this.getName() + " was in " + this.getLocation());
      this.w.getRoom(this.getLocation()).removePlayer(this);
      this.setLocation( this.getLocation().east() );
      this.w.getRoom(this.getLocation()).addPlayer(this);
      System.err.println(" " + this.getName() + " now in " + this.getLocation());
      return 1;
    case 1 :
      System.err.print(this.getName() + " was in " + this.getLocation());
      this.w.getRoom(this.getLocation()).removePlayer(this);
      this.setLocation( this.getLocation().west() );
      this.w.getRoom(this.getLocation()).addPlayer(this);
      System.err.println(" " + this.getName() + " now in " + this.getLocation());
      return 1;
    case 2 :
      System.err.print(this.getName() + " was in " + this.getLocation());
      this.w.getRoom(this.getLocation()).removePlayer(this);
      this.setLocation( this.getLocation().south() );
      this.w.getRoom(this.getLocation()).addPlayer(this);
      System.err.println(" " + this.getName() + " now in " + this.getLocation());
      return 1;
    case 3 :
      System.err.print(this.getName() + " was in " + this.getLocation());
      this.w.getRoom(this.getLocation()).removePlayer(this);
      this.setLocation( this.getLocation().north() );
      this.w.getRoom(this.getLocation()).addPlayer(this);
      System.err.println(" " + this.getName() + " now in " + this.getLocation());
      return 1;
    case 4 :
      System.err.print(this.getName() + " is interacting with " + this.w.getRoom(this.getLocation()).getPlayers().get(playerNum).getName());
      this.interact(this.w.getRoom(this.getLocation()).getPlayers().get(playerNum));
      return 1;
    default:
      return 0;
    }
 }


 /** Moves a player from one location to a new location
   *
   * @param newLocation is the new location that the player will be moved to
   * @return true if the move was successful and false otherwise (e.g. when trying to move from one
   *         location to another that are not connected)
   */
 public boolean move(Location newLocation){
   // move from current location to new location
   // should only be allowed to move if the locations are connected
   // (with a door that can opened)
   return false;
 }

 /** sets a player's current location
  *
  * @param location is the Location to set for the player
  */
 public void setLocation(Location location){
  this.location = location;
 }

 /** Setter for a player's health
   *
   * @param h is the new health of the player
   */
 public void setMovement(int m){
  this.movement = m;
 }
 public void setHealth(int h){
   this.health = h;
 }

 /** Adds a thing to the player's list of things
   *
   * @param t isa thing to add to the player's list of things
   */
 public void addThing(Thing t){
  this.things.add(t);
 }

 /** Remove a thing from a player's list of things
   *
   * @param t is a thing to be removed from the player's list of things
   * @return true if remove was successful and false otherwise (i.e., if the player
   *              does not have this thing in their list).
   */
 public boolean removeThing(Thing t){
  return this.things.remove(t);
 }

 /** Change the player's goal in the game (setter for goal)
   *
   * @param g is the new goal for this player
   * @return the previous goal of the player
   */
 public Thing newGoal(Thing g){
  Thing old = this.goal;
  this.goal = goal;
  return old;
 }


 /** Allows for interaction with this player and another player
   *
   * @param p is a player that is interacting with this player
   */
 public void interact(Player p){
   // allows for some interaction with a player
 }

 /** Allows for interaction with this player and some thing
   *
   * @param t is a thing that this player is interacting with
   */
 public void interact(Thing t){
   // allows for some interaction with a player
 }


 /** Allows for interaction with this player and the room it is in
   *
   */
 public void interact(){
   // allows for some interaction with anything in the room
 }

 public String printInventory(){
   String s = "Current items in " + this.getName() + "'s inventory: ";
  for(Thing t: this.getThings()){
    s += t.toString() + "\t";

  }
  System.out.println(s);
  return s;
 }















 @Override
 public String toString(){
   return name;
 }

 /** Two players are the same if they have the same name, location and health. */
 @Override
 public boolean equals(Object o){
   if( o instanceof Player){
     return this.name.equals( ((Player)o).name )
            && this.location.equals( ((Player)o).location )
            && this.movement == ((Player)o).movement;

   }else{
     return false;
   }
 }


}
