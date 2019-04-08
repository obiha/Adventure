//Made by Brandon Guest
public class Door{
    private Location connection;
    private boolean locked;
    private String desc;

    public Door(Location connection, boolean locked){
        this.connection = connection;
        this.locked = locked;
        setDesc(locked);
    }

    public Door(Location connection){
        this.connection = connection;
        this.locked = false;
        setDesc(locked);
    }

    private void setDesc(boolean locked){
        if(locked == false){
            this.desc = "This door is unlocked.";
        }else if(locked == true){
            this.desc = "This door is locked.";
        }
    }

    public Location getConn(){
        return this.connection;
    }

    public boolean getLocked(){
        return this.locked;
    }

    public void setLocked(boolean newLock){
        this.locked = newLock;
    }

    public String getDesc(){
        return this.desc;
    }

}
