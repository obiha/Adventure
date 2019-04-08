//Made by Brandon Guest
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Vendor extends Player{
    //relationships of items to value
    // private static BuffDeBuff[] sellableThings = {new BuffDeBuff("Poutine",new Location(w,0,1),1,1))};
    // private static List<Integer> sellableThingPrices = new java.util.ArrayList<Integer>(getSellableThings().get(0));
    private static String[] vendorNames ={"Bob","Cole","Carla"};
    private List<BuffDeBuff> selling;
    // protected Thing poutine,pizza,candy;

    public String[] getVendorNames(){
        return vendorNames;
    }

    // List<String> x = new ArrayList<>(Arrays.asList("xyz", "abc"));
    //both of the above lists need to be initiated
    public Vendor(World w, Location location, List<BuffDeBuff> selling){
        super(w,null, location,100,0, null, null);
        this.name = this.getVendorNames()[(int) Math.random() * this.getVendorNames().length] + " the Merchant";
        this.selling = selling;
        this.goal = null;
    }

    public int getPrice(BuffDeBuff t){
        for(BuffDeBuff item: this.getSelling()){
            if(item.equals(t)){
                int index = this.getSelling().indexOf(item);
                return this.getSelling().get(index).getExtraField();
            }
        }
        return -1;
    }

    public void addSelling(BuffDeBuff b){
        this.selling.add(b);
    }

    public void removeSelling(BuffDeBuff b){
        this.selling.remove(b);
    }

    public List<BuffDeBuff> getSelling(){
        return this.selling;
    }

    @Override
    public String printInventory() {
        String s = "Current items in" + this.getName() + "'s inventory: ";
        for(int i=0;i<this.getSelling().size();i++){
          s += this.getSelling().get(i).getName() + " : " + this.getPrice(this.getSelling().get(i)) + " coin";
        }
        System.out.println(s);
        return s;
    }

    @Override
    public void interact(Player p){
        System.out.println("here");
        if(p instanceof Human){
            this.printInventory();
            Scanner in = new Scanner(System.in);
            System.out.print("If you would like to buy an item, type the name of the item, otherwise type 'c' to cancel: ");
            String buy = in.next();
            if(buy.length() == 1 && buy.charAt(0) == 'c'){
                System.out.println("Purchase cancelled.");
            }else{
                for(BuffDeBuff t: this.getSelling()){
                    if(t.getName().equals(buy)){
                        if(p.getCoins()>=this.getPrice(t) && this.getPrice(t) != -1){
                            p.setCoins(-this.getPrice(t));
                            p.addThing( t);
                            System.out.println("You bought " + t.getName() + "!");
                            // this.removeSelling(t);
                            break;
                        }else{
                            System.out.println("You do not have enough coins or the item you requested doesn't exist.");
                        }
                    }
                }
            }
        // }else if(p instanceof NeutralPlayers){
        //     System.out.println("Hello!");
        // }else if(p instanceof SecurityGuard){
        //     System.out.println("Great work officer!");
      }else if(p instanceof MascotOU){
            System.out.println("Always good to see a fellow Gee-Gee!");
        }
      //show vendor inventory
      //ask what the player wants to buy (or c to cancel)
      //check if the player has enough money to buy said thing
    }

    // public static List<BuffDeBuff> getSellableThings(){return sellableThings;}
    // public static void addSellableThings(BuffDeBuff b){ Vendor.getSellableThings().add(b);}
    // public static List<Integer> getSellableThingPrices(){return sellableThingPrices;}
    // public static void addSellableThingsPrices(Integer p){Vendor.getSellableThingPrices().add(p);}
}
