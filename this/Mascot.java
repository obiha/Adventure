//made by Josh Obiha
public class Mascot extends Thing {

    private boolean pick;
    protected Human h;

    public Mascot(String name, Location location, int value,boolean p){
       super(name,location,value);
       pick = p;
    }


    public String getNameOfMascot(){return name;}
    public Location getLocation(){       // this method returns the location of the method
        return location;
    }
    public int getValue(){return value;}
    public boolean getPickedUp(){return pick;}

    public void interact(Human h){
        if(getNameOfMascot().equals(h.getGoal().getName())) {
            System.out.println("You have the mascot");
        }
    }
    }
