//Class to deal with Parallel plate systems.
public class parallelPlates {
	
	//variables
	private double dist;              //distance between plates
	private double length;
	private double width;
	private double area;              //Area of plates
	private double k;                 //Dielectric constant(>=1)
	private double chargePlate;       //Charge on either one of the plates.
	public double eField;             //E-Field magnitude
	public double capacitance;
	
	//constants
	static final double EPSILON_0 =8.85e-12;                     //Permittivity of free space
	static final double PI= Math.PI;	
	                                   //Methods
	
	//Area calculation
	public double getArea(double length,double width){
		this.area=length*width;
		return area;
	}
	//E-field
	public double get_eField(double eField){
		this.eField=eField;
		return eField;
	}
	
	//Charge
	public double getCharge(double chargePlate) {
		this.chargePlate= chargePlate;
		return chargePlate;
	}	
	                                         //CALCULATIONS	
	//E-Field
	public void display_elecField(double chargePlate, double area) {
		eField=chargePlate/(area*EPSILON_0);
		System.out.println("The Electric field is "+Math.abs(eField)+" N/C.");
	}
	
	//Capacitance
	public void getCapacitance (double k,double area,double dist){
		capacitance=(k*(EPSILON_0)*area)/(dist);
		System.out.println("The Capacitance is "+capacitance+ " Farads.");	
		}
	
}
