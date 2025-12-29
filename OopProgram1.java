import java.util.*;
abstract class Vehical
{
	protected String vehicalName;
	protected double fuelUsed;
	protected double distance;
	protected double milage;
	
	public abstract void accessInput();
	abstract public void calcMilage();
	
	public void displayInfo()
	{
		System.out.println("Vehical : "+vehicalName);
		System.out.println("Milage = "+milage+" km/1");
	}
}
class Car extends Vehical
{
	public void accessInput()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Vehical Name");
		vehicalName = scan.next();
		System.out.println("Enter Fuel Used (liters):");
		fuelUsed = scan.nextFloat();
		System.out.println("Enter Distance (Km):");
		distance = scan.nextFloat();
	}
	public void calcMilage()
	{
		milage = (distance/fuelUsed)*0.9;		
	}
}
class Bike extends Vehical
{
	public void accessInput()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Vehical Name");
		vehicalName = scan.nextLine();
		System.out.println("Enter Fuel Used (liters) :");
		fuelUsed = scan.nextFloat();
		System.out.println("Enter Distance (Km):");
		distance = scan.nextFloat();
	}
	public void calcMilage()
	{
		milage = (distance/fuelUsed);
	}
}
class Truck extends Vehical
{
	public void accessInput()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Vehical Name");
		vehicalName = scan.nextLine();
		System.out.println("Enter Fuel Used (liters) :");
		fuelUsed = scan.nextFloat();
		System.out.println("Enter Distance (Km) :");
		distance = scan.nextFloat();
	}
	public void calcMilage()
	{
		milage = (distance/fuelUsed)*0.7;
	}
}
class AchivePolymorephism
{
	static void permit(Vehical ref)
	{
		ref.accessInput();
		ref.calcMilage();
		ref.displayInfo();
	}
}
class OopProgram1
{
	public static void main(String args[])
	{
		Car c = new Car();
		Bike b = new Bike();
		Truck t = new Truck();
		
		AchivePolymorephism.permit(c);
		AchivePolymorephism.permit(b);
		AchivePolymorephism.permit(t);
	}
}