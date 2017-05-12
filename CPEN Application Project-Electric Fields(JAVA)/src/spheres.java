//Class containing all the methods and variables to do
//the necessary computations for spherical objects.


public class spheres {
	// variables
	private double radius;       //radius of the sphere
	private double r;            //distance to point from center of object.
	private double chargeSphere;    
	public double sphereField;   //Magnitude
		
	//constants
	static final double EPSILON_0 =8.85e-12;              //Permittivity of free space
	static final double PI= Math.PI;
	                                     //Methods
	//gives radius of object
	public double getRadius(double radius){
		this.radius=radius;
		return radius;
	}
	
	//Receives the distance to the point required.
	public double getDistance (double r){
		this.r=r;
		return r;
	}
	
	//Receives the charge on the object.
	public double getCharge(double chargeSphere) {
		this.chargeSphere=chargeSphere;
		return chargeSphere;
	}	
	                                 //CONDUCTING SPHERE
	public void conductingSphere(double radius,double r) {
		//test cases
		if (r<radius) {
			sphereField=0;  //it is a conductor
			System.out.println("The Electric Field of the Conducting Sphere is "+sphereField+" N/C.");
		}
		else if (r>=radius){
			sphereField=(chargeSphere)/(4*PI*(EPSILON_0)*(Math.pow(radius, 2)));
System.out.println("The Electric Field of the Conducting Sphere is "+Math.abs(sphereField)+" N/C.");
		}
		
		else
		{
			System.out.println("ERROR.");
		}
    } //closing	
	                                   //UNIFORM SPHERE	
	public void uniformSphere(double radius,double r) {
		//test cases
		if (r<radius) {
			sphereField=(chargeSphere*r)/(4*PI*EPSILON_0*(Math.pow(radius, 3)));
System.out.println("The Electric Field of the Conducting Sphere is "+Math.abs(sphereField)+" N/C.");
		}
		else if (r>=radius){
			sphereField=(chargeSphere)/(4*PI*(EPSILON_0)*(Math.pow(radius, 2)));
System.out.println("The Electric Field of the Conducting Sphere is "+Math.abs(sphereField)+" N/C.");
		}
		
		else
		{
			System.out.println("ERROR.");
		}
    } //closing
}
	
	
	
	
	
	
	
	
	


