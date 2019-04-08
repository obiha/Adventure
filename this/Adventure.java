//Made by Vineet Abrol
import java.util.Scanner;
public class Adventure{

  public static void main(String[] args){
    System.out.println("");
    System.out.println("Welcome to JBSV's Game!");
    System.out.println("");
    System.out.println("Some OttawaU students have stolen the Raven get him back!\nMake your way through OttawaU's campus some Students \nwill aid you on the way others may challenge you, so be ready!\nOttawaU's mascot is very dangerous avoid it at all costs. \nThe Security Guard won't be a threat, until you retrieve the Raven\nafter that the Security Guard will become hostile avoid him at all costs. \nPick up items, and money to use on others or yourself Some doors\nare locked so find the key and find the Raven and escape the Campus!\nGood Luck! ");
    System.out.println("");
    System.out.println("");
    System.out.println("Which Demo would you like to run?\n1.Demo6\n2.DemoV\n3.DemoB\n4.DemoS\n5.DemoJ");
  Scanner input = new Scanner(System.in);
    int launch = input.nextInt();
 if(launch == 2){
   DemoV();
 }else if(launch == 1){
   Demo6();
 }else if(launch == 3){
   DemoB();
 }else if(launch == 4){
   DemoS();
 }else if(launch == 5){
   DemoJ();
 }
 }
      public static void DemoV(){
      World world = new World();
      Player human = new Human(world, "Carleton U Student", new Location(world,0,0), 1,2,
                                new java.util.ArrayList<Thing>(),world.getGoal() );
      Player gee_gee = new MascotOU(world, "Gee-Gee", new Location(world,0,1), 1,2,
                                new java.util.ArrayList<Thing>(),world.getGoal() );
      Thing poutine = new BuffDeBuff("Poutine",new Location(world,0,1),1,1);
        world.getRoom(world.getEntrance()).addPlayer(human);
        world.getRoom(world.getEntrance()).addThing(poutine);
        world.getRoom(world.getLobby()).addPlayer(gee_gee);

      while(true){

      human.play();
      if (human.getQuit() == true){
       System.out.println("Thanks for playing!");
       break;
     }
     gee_gee.play();
      if(human.getHealth()<=0){
        break;

      }
    }
  }
  public static void Demo6(){
    World world = new World();
    Player human = new Human(world, "Carleton U Student", new Location(world,0,0), 1,4,
                              new java.util.ArrayList<Thing>(),world.getGoal() );
    Player gee_gee = new MascotOU(world, "Gee-Gee", new Location(world,0,1), 1,2,
                              new java.util.ArrayList<Thing>(),world.getGoal() );
	Player student = new OttawaStudent(world,"OttawaUStudent", new Location(world,0,0),1,2,new java.util.ArrayList<Thing>(),null);
	world.getRoom(world.getAthletic()).addPlayer(student);
	Player security = new SecurityGuard(world,"CampusSecurity", new Location(world, 0, 0),1,2,new java.util.ArrayList<Thing>(),null);
	
    Thing poutine = new BuffDeBuff("Poutine",new Location(world,0,1),1,1);
    Thing key     = new Key(new Location(world,0,0));
    Thing mascot     = new Mascot("Raven",new Location(world,0,5),0,false);


      world.getRoom(world.getEntrance()).addPlayer(human);
      world.getRoom(world.getLobby()).addThing(poutine);
      world.getRoom(world.getLobby()).addPlayer(gee_gee);
      world.getRoom(world.getEntrance()).addThing(key);
      world.getRoom(world.getLocker()).addThing(mascot);
	   world.getRoom(world.getEntrance()).addPlayer(student);
	    world.getRoom(world.getEntrance()).addPlayer(security);

      while(true){

      human.play();
	  
      if (human.getQuit() == true){
       System.out.println("Thanks for playing!");
       break;
     }
	 student.play();
	 security.play();
     gee_gee.play();
     //vendor.play();
     //students.play();
      if(human.getHealth()<=0){
        break;

      }
    }
}
    public static void DemoB(){
      World world = new World();
      Player human = new Human(world, "Carleton U Student", new Location(world,0,0), 1,2,
                                new java.util.ArrayList<Thing>(),world.getGoal() );
      
      // Vendor.addSellableThings(new BuffDeBuff("Poutine",new Location(world,0,1),1,1));
      // Vendor.addSellableThings(new BuffDeBuff("Advil",new Location(world,100,100),2,2));
      // Vendor.addSellableThings(new BuffDeBuff("Energy Drink",new Location(world,100,100),1,2));
      // Vendor.addSellableThings(new BuffDeBuff("Coffee",new Location(world,100,100),3,3));
      Vendor v = new Vendor(world,new Location(world,0,1), new java.util.ArrayList<BuffDeBuff>());
      v.addSelling(new BuffDeBuff("Poutine",new Location(world,0,1),1,1));
      //VENDOR GOES HERE!
      Thing key = new Key(new Location(world,0,1),1);
        world.getRoom(new Location(world,0,1)).addPlayer(v);
        world.getRoom(world.getEntrance()).addPlayer(human);
        world.getRoom(world.getEntrance()).addThing(key);
        //world.getRoom(world.getLobby()).addPlayer(vendor);
      int game;
      while(true){

      game = human.play();
      while(game == 0){
        game = human.play();
      }
      if (human.getQuit() == true){
       System.out.println("Thanks for playing!");
       break;
     }
      if(human.getHealth()<=0){
        break;

      }
      v.play();
    }

    }
    public static void DemoS(){
      World world = new World();
      Player human = new Human(world, "Carleton U Student", new Location(world,0,0), 1,2,
                                new java.util.ArrayList<Thing>(),world.getGoal() );

      //Put your code here!
      while(true){

      human.play();
      if (human.getQuit() == true){
       System.out.println("Thanks for playing!");
       break;
     }
      if(human.getHealth()<=0){
        break;

      }
    }

    }
    public static void DemoJ(){
      World world = new World();
      Player human = new Human(world, "CarletonUStudent", new Location(world,0,0), 1,2,
                                new java.util.ArrayList<Thing>(),world.getGoal() );
								
	Player student = new OttawaStudent(world,"OttawaUStudent", new Location(world,0,0),1,2,new java.util.ArrayList<Thing>(),null);
	world.getRoom(world.getAthletic()).addPlayer(student);
      Thing mascot     = new Mascot("Raven",new Location(world,0,1),0,false);
        world.getRoom(world.getLobby()).addThing(mascot);
		world.getRoom(world.getEntrance()).addPlayer(student);
		


      //Put your code here!
      while(true){

      human.play();
	  
      if (human.getQuit() == true){
       System.out.println("Thanks for playing!");
       break;
	   
     }
      if(human.getHealth()<=0){
        break;

      }
	  student.play();
    }

    }

// Player students = new NeutralPlayers(world,"OttawaU Student",new Location(world,0,3),"",false,new java.util.ArrayList<Thing>(),new new java.util.ArrayList<Location>())
// world.getRoom(world.getAthletic()).addPlayer(students))

  //     Player vendor = new Vendor(world, new Location(world,0,2));
    //  world.getRoom(world.getCenter()).addPlayer(vendor);



}
