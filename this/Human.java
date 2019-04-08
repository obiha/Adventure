//Made by Brandon Guest
import java.util.List;
import java.util.Scanner;
//import com.sun.javafx.scene.traversal.Direction;

/** A human (user) players in the game */

public class Human extends Player{
  private boolean isAlive;
  private boolean quit;

  public boolean getQuit(){return this.quit;}
  public void setQuit(boolean q){ this.quit = q;  }

  public boolean getIsAlive(){
    return this.isAlive;
  }

  public void setIsAlive(boolean alive){
    this.isAlive = alive;
  }

  private static boolean verbose = true; // set true for debugging
  // set false for submitted code

  /** Creates a player in the game
    *
    * @param w is the world that the player lives in
    * @param name is the name of the player
    * @param location is where in the world the player is
    * @param health is the health of the player (which may or may not be relevant in your game)
    * @param things is a list of Thing objects that the player initially possesses
    * @param goal is the Thing that the human player is trying to retrieve in the game
    */
  public Human(World w, String name, Location location, int movement, int health,
               List<Thing>  things, Thing goal){
    super(w, name, location, movement, health, things, goal);
    this.isAlive = true;
    this.coins = 1;
  }

  public int peak(char direction){
    //check if there is a door in the direction
    //return the players in the next room
    Room init = this.w.getRoom(this.getLocation()); //returns the initial room
    List<Location> initLocs = init.getAdjacentRooms(); //returns a list of adjacent locations
    Room next;
    if(direction == 'e'){
      next = this.w.getRoom(this.getLocation().east());
    }else if(direction == 'n'){
      next = this.w.getRoom(this.getLocation().north());
    }else if(direction == 'w'){
      next = this.w.getRoom(this.getLocation().west());
    }else{// if(direction == 's'){
      next = this.w.getRoom(this.getLocation().south());
    }

    Location nextLoc = next.getLocation(); //returns the next location
    List<Door> initDoors = init.getDoors(); //returns a list of the doors in the initial room
    boolean doorExist = false;
    Door checkDoor;

    if(initLocs.contains(nextLoc)){ //check to make sure that the next location is a good location
      //loop through the doors and check if their connection location equals the nextLoc
      for(Door d: initDoors){
        if(nextLoc.equals(d.getConn())){
          doorExist = true;
          break;
        }
      }
    }

    if(doorExist == true){
      System.out.println("Players in adjacent room: " + next.printPlayers());
      return 1;
    }
    System.out.println("No room in that direction.");
    return 0;
    //peak into the rooms around the player
  }

  public int makeMove(char direction){
  //check if room player is in has a door to x direction
    //check if the door is locked
      //ask player if he would like to unlock the door
        //unlock if he has a key
        //else print a message that says you dont have a key
    //else
      //move the player to the next room (how it is now)
  //else
    //message that says there is no door in that direction

    //next set of code is just this
    Room init = this.w.getRoom(this.getLocation()); //returns the initial room
    List<Location> initLocs = init.getAdjacentRooms(); //returns a list of adjacent locations
    Room next;
    if(direction == 'e'){
      next = this.w.getRoom(this.getLocation().east());
    }else if(direction == 'n'){
      next = this.w.getRoom(this.getLocation().north());
    }else if(direction == 'w'){
      next = this.w.getRoom(this.getLocation().west());
    }else{// if(direction == 's'){
      next = this.w.getRoom(this.getLocation().south());
    }
    // next = this.w.getRoom(this.getLocation().east()); //returns the room to the east --> NEEDS TO BE CHANGED
    Location nextLoc = next.getLocation(); //returns the next location
    List<Door> initDoors = init.getDoors(); //returns a list of the doors in the initial room
    boolean corrDoor = false;
    Door checkDoor = new Door(null,false);
    boolean lockedDoor = false;
    boolean keyUseable = false;
    Scanner in = new Scanner(System.in);
    int playerKey = 0;
    char playerUnlock = '_';

    if(initLocs.contains(nextLoc)){ //check to make sure that the next location is a good location
      //loop through the doors and check if their connection location equals the nextLoc
      for(Door d: initDoors){
        if(nextLoc.equals(d.getConn())){
          checkDoor = d;
          corrDoor = true;
          break;
        }
      }
      if(corrDoor == true){
        lockedDoor = checkDoor.getLocked();
        if(!lockedDoor){
          switch( direction ){
            case 'e' :
              if(verbose){System.err.print("human was in " + this.getLocation());}
              this.w.getRoom(this.getLocation()).removePlayer(this);
              this.setLocation( this.getLocation().east() );
              this.w.getRoom(this.getLocation()).addPlayer(this);
              if(verbose){System.err.println(" human now in " + this.getLocation());}
              return 1;
            case 'w' :
              if(verbose){System.err.print("human was in " + this.getLocation());}
              this.w.getRoom(this.getLocation()).removePlayer(this);
              this.setLocation( this.getLocation().west() );
              this.w.getRoom(this.getLocation()).addPlayer(this);
              if(verbose){System.err.println(" human now in " + this.getLocation());}
              return 1;
            case 's' :
              if(verbose){System.err.print("human was in " + this.getLocation());}
              this.w.getRoom(this.getLocation()).removePlayer(this);
              this.setLocation( this.getLocation().south() );
              this.w.getRoom(this.getLocation()).addPlayer(this);
              if(verbose){System.err.println(" human now in " + this.getLocation());}
              return 1;
            case 'n' :
              if(verbose){System.err.print("human was in " + this.getLocation());}
              this.w.getRoom(this.getLocation()).removePlayer(this);
              this.setLocation( this.getLocation().north() );
              this.w.getRoom(this.getLocation()).addPlayer(this);
              if(verbose){System.err.println(" human now in " + this.getLocation());}
              return 1;
            default:
              return 0;
            }
        }else{

          //ask player if he would like to use a key (if he has one --> check first)
          // for(Thing t: this.getThings()){//this is where i check if the key is a part of the game
          for(int i = 0;i<this.getThings().size();i++){
            if(this.getThings().get(i) instanceof Key){
              if(this.getThings().get(i).getExtraField() == 0){
                keyUseable = true;
                playerKey = i;
                break;
              }
            }
          }
          //   if(t instanceof Key){
          //     if(t.getMaster() == true){
          //       keyUseable = true;
          //       playerKey = t;
          //       break;
          //     }
          //   }
          // }

          if(keyUseable == false){
            for(int i = 0;i<this.getThings().size();i++){
              if(this.getThings().get(i).getExtraField() == 1){
                keyUseable = true;
                playerKey = i;
                break;
              }
            }
          }

          if(keyUseable == true){
            System.out.print("Would you like to use your key? (y/n)");
            playerUnlock = in.next().charAt(0);
          }

          // if(useKey == 'y'){
          //   playerUnlock = true
          // }//maybe this is pointless and should just check if they have a key
          if(playerUnlock == 'y'){
            // this.w.getRoom(this.getLocation()).getDoors().get(indexOf(checkDoor)).setLocked(false);
            Key k = (Key) this.getThings().get(playerKey);
            k.interact(this.w.getRoom(this.getLocation()).getDoors().get((this.w.getRoom(this.getLocation()).getDoors().indexOf(checkDoor))));
            //print door unlocked and move the player through the door like normal
            switch( direction ){
              case 'e' :
                if(verbose){System.err.print("human was in " + this.getLocation());}
                this.w.getRoom(this.getLocation()).removePlayer(this);
                this.setLocation( this.getLocation().east() );
                this.w.getRoom(this.getLocation()).addPlayer(this);
                if(verbose){System.err.println(" human now in " + this.getLocation());}
                return 1;
              case 'w' :
                if(verbose){System.err.print("human was in " + this.getLocation());}
                this.w.getRoom(this.getLocation()).removePlayer(this);
                this.setLocation( this.getLocation().west() );
                this.w.getRoom(this.getLocation()).addPlayer(this);
                if(verbose){System.err.println(" human now in " + this.getLocation());}
                return 1;
              case 's' :
                if(verbose){System.err.print("human was in " + this.getLocation());}
                this.w.getRoom(this.getLocation()).removePlayer(this);
                this.setLocation( this.getLocation().south() );
                this.w.getRoom(this.getLocation()).addPlayer(this);
                if(verbose){System.err.println(" human now in " + this.getLocation());}
                return 1;
              case 'n' :
                if(verbose){System.err.print("human was in " + this.getLocation());}
                this.w.getRoom(this.getLocation()).removePlayer(this);
                this.setLocation( this.getLocation().north() );
                this.w.getRoom(this.getLocation()).addPlayer(this);
                if(verbose){System.err.println(" human now in " + this.getLocation());}
                return 1;
              default:
                return 0;
              }
          }else{
            //print that the player hasn't used their key
            System.out.println("The door is locked. You have not used your key or made a move.");
            return 0;
          }
        }

      }else{
        //there is no door in that direction
        System.out.println("There is no door in that direction.");
        return 0;
      }
    }
    return 0;
  }

  /** Plays a turn for this player
    *
    * For computer players will have the AI for that player.
    * For human player querie user for input and then react
    * appropriately for the input.
    */
  @Override
  public int play(){
    int done;
    if(verbose){System.err.println("the room has " + w.getRoom(getLocation()).getPlayers() + " player(s).");}
    if(verbose){System.err.println("the room has " + w.getRoom(getLocation()).getThings() + " thing(s).");}
    Scanner in = new Scanner(System.in);
    System.out.print("What would you like to do? [type h <enter> for help] ");
    String action = in.nextLine();
    if( action.trim().equals("h") ){
      help();
      return 0;
    }else if(action.trim().equals("l") ){
      look();
      return 1;
    }else if(action.trim().charAt(0) == 'g'){
      done = this.makeMove(action.trim().charAt(action.trim().length()-1) );
      return done;
    }else if(action.trim().charAt(0) == 'w'){
      this.printInventory();
      return 0;
    }else if(action.trim().charAt(0) == 'p'){
      if(action.length()>1){
        String item = action.substring(1).trim();
        List<Thing> roomThings = this.w.getRoom(this.getLocation()).getThings();
        for(Thing t: roomThings){
          if(item.equals(t.getName())){
            this.w.getRoom(this.getLocation()).removeThing(t);
            this.addThing(t);
            return 1;
          }
        }
        return 0;
      }
      //otherwise could do a try catch statement
      // Arrays.toString(list.toArray())
        // action.substring(1).equals()
        //check if it there is an item in the room where the player is (if so where it is in the list)
        //remove it from the room
        //add it to the player
    }else if(action.trim().charAt(0) == 'd'){
      if(action.length()>1){
        String item = action.substring(1).trim();
        List<Thing> playerThings = this.getThings();
        for(Thing t: playerThings){
          if(item.equals(t.getName())){
            this.w.getRoom(this.getLocation()).addThing(t);
            this.removeThing(t);
            return 0;
          }
        }
        return 0;
      }
        //check if player has an item with name x
        //if yes, where in the list
        // remove the item from the player
        //add the item to the room
    }else if(action.trim().charAt(0) == 't'){

        //check if player x is in the room
        //get that player object
        if(action.length()>1){
          for(Player p: this.w.getRoom(this.getLocation()).getPlayers()){          
            if(p.getName().equals(action.substring(1).trim())){
              this.interact(p);
              return 1;
            }
          }
        }
        return 0;
        //talk to the player
    }else if(action.trim().charAt(0) == 'c'){
      if(action.length()>1){
        if(action.trim().charAt(1) == 't'){
          this.w.getRoom(this.getLocation()).printThings();
          return 0;
        }else if(action.trim().charAt(1) == 'p'){
          this.w.getRoom(this.getLocation()).printPlayers();
          return 0;
        }
      }
      return 0;
    }else if(action.trim().charAt(0) == 'i'){
        //inspect adjacent rooms for other players
        switch( action.trim().charAt(1) ){
          case 'e' :
            done = this.peak('e');
            return done;
          case 'n':
            done = this.peak('n');
            return done;
          case 's':
            done = this.peak('s');
            return done;
          case 'w':
            done = this.peak('w');
            return done;
        }
    }else if(action.trim().charAt(0) == 'u'){
      if(action.length()>1){
        for(Thing t: this.getThings()){
          if(t.getName().equals(action.substring(1).trim())){
            t.interact(this);
            this.removeThing(t);
            return 1;
          }
        }
        return 0;
      }
      return 0;
    }else if (action.trim().charAt(0) =='q'){
      this.setQuit(true);
      return 1;
    }
    return 0;
  }


  public void look(){
    String s = "You are currently in ";
    s += w.getRoom(getLocation()).toString();
    s+= " and have a health of "+getHealth();
    System.out.println(s);
  }

  public void interact(Player p){
    p.interact(this);
    // if(p instanceof Vendor){
    //   p.interact();
    //   //show vendor inventory
    //   //ask what the player wants to buy (or c to cancel)
    //   //check if the player has enough money to buy said thing
    // }else if(p instanceof SecurityGuard){
    //   p.interact();
    //   //security just says that he doesn't have time for you
    // }else if(p instanceof Student){
    //   p.interact();
    //   //student
    // }else if(p instanceof Mascot){
    //   p.interact();
    // }
  }

  public void help(){
    String s = "Your options are:\n ";
    s += "'h' for help \n ";
    s += "'l' to look around the room and to see your health level\n ";
    s += "'g x' to go in direction x (x can be n,e,s,w) \n ";
    s += "'w' to list what you have and to see your health level \n ";
    s += "'d x' to drop thing x (x can be the name of the item) \n ";
    s += "'p x' to pick up thing x (x can be the name of the item) \n ";
    s += "'t x' to interact with player x (x can be the name of the player) \n ";
    s += "'c t' to check the things in the room \n ";
    s += "'c p' to check the players in the room \n ";
    s += "'i x' to check which player types are in the adjacent rooms (where x is the direction n,e,s,w) \n ";
    s += "'u x' to use item (where x is the name of the item \n ";
    s += "'q' to quit";
    System.out.println(s);
  }

}
