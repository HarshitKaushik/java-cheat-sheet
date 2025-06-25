public class InterfaceFirst {

  public interface Flyable {

    void fly();

    // interface support private methods, static methods, default methods since Java 8

    default String presentId() {
      String id = "The flying class name: " + this.getClass();
      System.out.println(id);
      return id;
    }
  }

  public class Aeroplane implements Flyable {
  
    public void fly() {
      System.out.println("The aeroplane is flying...");
    }
  }

  public class Drone implements Flyable {
    
    public void fly() {
      System.out.println("The drone is flying...");
    }
  }

  public static void main(String[] args) {
    InterfaceFirst first = new InterfaceFirst();
    Aeroplane aeroplane = first.new Aeroplane();
    aeroplane.presentId();
    Drone drone = first.new Drone();
    drone.presentId();
  }
}