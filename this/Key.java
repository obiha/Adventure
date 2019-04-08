//Made by Brandon Guest
public class Key extends Thing{

    public Key(Location location, int master){
        super("Key", location, 5, setMaster(master));
    }

    public Key(Location location){
        super("Key", location, 5, 1);
    }

    public boolean getUsed(){
        if(this.getExtraField() == 1 || this.getExtraField() == 0){
            return false;
        }else{
            return true;
        }
    }

    //if key is a master it will have an extra value of 0, else if will have a value of 1
    private static int setMaster(int master){
        if(master == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public void setUsed(boolean used){
        if(this.getExtraField() != 0){
            if(used == true){
                this.setExtraField(-1);
            }else{
                this.setExtraField(1);
            }
        }
    }

    public void interact(Door d){
        //needs to be done
        d.setLocked(false);
        this.setUsed(true);
    }
}
