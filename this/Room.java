//Made by Brandon Guest and Josh Obiha
import java.util.List;

public class Room{
  protected String         description;
  protected Location       location;
  protected List<Location> adjacent;
  protected List<Player>   people;
  protected List<Thing>    things;
  protected List<Door>     doors;

  public Room(String description, Location location, List<Location> adjacent,
              List<Player> people, List<Thing> things, List<Door> doors)
  {
    this.description = description;
    this.location = location;
    this.adjacent = adjacent;
    this.people = people;
    this.things = things;
    this.doors = doors;
  }

  /* getters */
  public Location       getLocation(){ return location; }
  public List<Location> getAdjacentRooms(){ return adjacent; }
  public List<Player>   getPlayers(){ return people; }
  public List<Thing>    getThings(){ return things; }
  public List<Door>     getDoors(){ return doors;  }

  public void addDoor(Door d){
    this.doors.add(d);
  }

  public String look(){
    // return a string describing the room
    // (what is in it, what exits you have, etc)
    return this.toString();
  }


  public void addPlayer(Player p){
    this.people.add(p);
  }

  public void removePlayer(Player p){
    this.people.remove(p);
  }

  /** add a thing t to the current room */
  public void addThing(Thing t){
    this.things.add(t);
  }

  public void removeThing(Thing t){
    this.things.remove(t);
  }

  public String printPlayers(){
    String s = "Current players in the room: ";
    for(Player p: this.getPlayers()){
      s += p.toString() + "\t";
    }
    System.out.println(s);
    return s;
  }

  public String printThings(){
    String s = "Current things in the room: ";
    for(Thing t: this.getThings()){
      s += t.toString() + "\t";
    }
    System.out.println(s);
    return s;
  }

  @Override
  public String toString(){
    return description;
  }
}
