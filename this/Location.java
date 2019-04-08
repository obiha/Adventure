//Made by Vineet Abrol
/** Represents a place in a world. */
public class Location{
 protected World world;  // the world that the location lives in
 protected int row;
 protected int col;
 protected int[] max;


 /** Creates a new location in the world at the specified row and column */
 public Location(World w,int row, int col){
   this.world = w;
   this.row = row;
   this.col = col;
 }
 public World getWorld(){ return world;}
 public int getRow(){return row;}
 public int getCol(){return col;}

 /** Checks if another location is adjacent (connected with a door)
   * to this current location.
   *
   * @param other is another location
   * @return true if this location and the other location are adjacent to each other (connected with a door)
   */


 /** Returns location to the west (left) of the current location
   *
   * TODO: This will throw an ArrayIndexOutOfBoundsException
   *       You need to deal with this in some way.DONE!
   */

 public Location west(){
   if (col==0){
     return new Location(world,row,col);
   }else{

   return new Location(world, row, col-1);
 }}

 /** Returns location to the east (right) of the current location
   *
   * TODO: This will throw an ArrayIndexOutOfBoundsException
   *       You need to deal with this in some way.
   */
 public Location east(){
   if (col+1==world.getCol() ){
        return new Location(world,row,col);
   }else{
     return new Location(world, row, col+1);
 }}

 /** Returns location to the north (up) of the current location
   *
   * TODO: This will throw an ArrayIndexOutOfBoundsException
   *       You need to deal with this in some way. DONE!
   */
 public Location north(){
   if (row==0){
          return new Location(world,row,col);
  }else{

   return new Location(world, row-1, col);
 }}

 /** Returns location to the south (down) of the current location
   *
   * TODO: This will throw an ArrayIndexOutOfBoundsException
   *       You need to deal with this in some way.
   */
 public Location south(){
   if (row+1==world.getRow()){
          return new Location(world,row,col);
  }else{
return new Location(world, row+1, col);
 }}

 @Override
 public String toString(){
   return "("+row+","+col+")";
 }

 /** Two locations are equal to each other if they are in the
   * same world, have the same row and column.
   */
 @Override
 public boolean equals(Object o){
   if( o instanceof Location){
     return this.row == ((Location)o).row &&
            this.col == ((Location)o).col &&
            this.world.equals(((Location)o).world);
   }else{
     return false;
   }
 }

}
