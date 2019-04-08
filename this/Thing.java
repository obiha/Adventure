import java.util.List;

/** This class holds non-player things in the world.
 *
 * This class should be abstract and team members should be
 * creating concrete subclasses.
 */
public abstract class Thing{
 protected String       name;
 protected Location     location;
 protected int          value;
 protected int          extraField;
 protected int          type;
 protected int          eaten;

 public Thing (String name){
	 this.name = name;
 }

 public Thing(String name, Location location, int value)
 {
  this.name = name;
  this.location = location;
   this.value = value;
 }

 public Thing(String name, Location location, int value, int e)
 {
  this.name = name;
  this.location = location;
   this.value = value;
  this.extraField = e;

 }

 public Thing(String name, Location location, int value, int e,int type)
 {
  this.name = name;
  this.location = location;
   this.value = value;
  this.extraField = e;
  this.type = type;
  this.eaten = eaten;
 }


 public String       getName(){ return name; }
 public Location     getLocation(){ return location; }
 public int          getValue(){ return value; }
 public int          getExtraField(){ return extraField;}
 public int          getType(){return type;}

 public void setLocation(Location location){
  this.location = location;
 }

 public void setValue(int v){
  this.value = v;
 }

 public void setExtraField(int ef){
  this.extraField = ef;
 }

 /** Allows for a Thing to interact with the room it is in (including all of the players and things in that room)
   */
 public void interact(){
   // allows for some interaction with room (and players/things in it)
 }

 /** Allows for interaction with thw current thing and a specified player
   *
   * @param p is a player that is interacting with this current thing
   */
 public void interact(Player p){
   // allows for some interaction with a player
 }
 @Override
 public String toString(){
   return name;
 }

 @Override
 public boolean equals(Object o){
   if( o instanceof Thing){
     return this.name.equals( ((Thing)o).name )
            && this.location.equals( ((Thing)o).location )
            && this.value == ((Thing)o).value
            && this.extraField == ((Thing)o).extraField;

   }else{
     return false;
   }
 }
}
