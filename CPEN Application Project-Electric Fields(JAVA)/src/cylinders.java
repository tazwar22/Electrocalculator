//Class containing all the methods and variables to do
//the necessary computations for cylindrical objects.


public class cylinders {
		// variables
		private double radius2;       //radius of the Cylinder
		private double r2;            //distance to point from center of object    
		public double cylinderField;
		
		private double linDensity; //Linear charge density of cylinder(C/m)
		
		
		//constants
		static final double EPSILON_0 =8.85e-12;         //Permittivity of free space
		static final double PI= Math.PI;
		                                     //METHODS		
		//gives radius of object
		public double getRadiusCyl(double radius2){
			this.radius2=radius2;
			return radius2;
		}
		
		//get distance TO point.
		public double getDistanceCyl (double r2){
			this.r2=r2;
			return r2;
		}
		//Linear charge density
	public double getDensity (double linDensity){
		this.linDensity=linDensity;
		return linDensity;
		}
	                                //CONDUCTING CYLINDER	
	public void conductingCylinder(double radius2,double r2,double linDensity) {
		//test cases
		if (r2<radius2) {
			cylinderField=0;  //it is a conductor
System.out.println("The Electric Field of the Conducting Cylinder is "+Math.abs(cylinderField)+" N/C.");
		}
		else if (r2>=radius2){
			cylinderField=(linDensity)/(2*PI*EPSILON_0*r2);
			
System.out.println("The Electric Field of the Conducting Cylinder is "+Math.abs(cylinderField)+" N/C.");
		}	
		else
		{
			System.out.println("ERROR.");
		}
    } //closing
	
	                              //UNIFORM CYLINDER
	public void uniformCylinder(double radius2,double r2,double linDensity) {
		//test cases
		if (r2<radius2) {
			cylinderField=(linDensity*r2)/(2*PI*EPSILON_0*Math.pow(radius2, 2));
System.out.println("The magnitude of the Electric Field of the uniformly charged Cylinder is "+Math.abs(cylinderField)+" N/C.");
		}
		else if (r2>=radius2){
			cylinderField=(linDensity)/(2*PI*EPSILON_0*r2);
System.out.println("The magnitude of the Electric Field of the uniformly charged Cylinder is "+Math.abs(cylinderField)+" N/C.");
		}		
		else
		{
			System.out.println("ERROR.");
		}
    } //closing
}
