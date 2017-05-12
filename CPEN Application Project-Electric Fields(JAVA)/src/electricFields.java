/*
 *Author: Ahnaf Tazwar Ayub 
 *Computer Engineering Application project: 'The Electro-calculator'
 *ABOUT THIS PROGRAM: 
 *This program utilizes Gauss's Law to calculate Electric Field magnitude values
 *for 3 different given shapes at any valid point in space.
 *Capacitance can also be calculated for a 2-parallel-plate system with a dielectric.
 *Dielectric value can be specified.
 *Both conductors and uniformly charged objects are dealt with.
 *
 * USER input values-(depending on chosen option)
 *(1)Parallel plate system--dimensions(m),charge on plate(C) and/or 
 *   Electric Field value(N/C),
 *   distance between plates(m) and Dielectric constant value.
 *(2)Spherical shape-- radius(m), distance to chosen point from center of sphere(m),
 *   charge on sphere(C).
 *(3)Cylindrical shape--radius(m), distance to chosen point from center of cylinder(m),
 *Linear charge density(C/m)
 *The links to the equations used are given at the bottom.
                                                               */
import java.util.Scanner;        

public class electricFields {
	
	public static void main (String args[]) {
		
		                             //Objects
		Scanner input=new Scanner(System.in); 
		parallelPlates plates=new parallelPlates();
		spheres sphere=new spheres();
		cylinders cylinder=new cylinders();
		
		//Welcome message
		System.out.println("Welcome to the Electro-calculator!");
		
		
		//FIRST Prompt to user to make a choice between shapes(or to quit)
		//  1-Parallel Plates, 2-Spheres, 3-Cylinder , 4-QUIT
		
		System.out.println("Please choose between the following options:");
		System.out.println("Enter a NUMBER corresponding to your choice.");
System.out.println("(1)Parallel plates\t(2)Charged sphere\t(3)Charged cylinder\t(4)QUIT");
		int decision=input.nextInt();  //user choice between shapes
		             
		//To ensure user gives proper input, if by chance they do not follow instructions.
		while(decision!=1 && decision !=2 && decision !=3 &&decision!=4) {
			System.out.println("Please choose a valid type between the following options:");
			System.out.println("Enter a NUMBER corresponding to your choice.");
System.out.println("(1)Parallel plates\t(2)Charged sphere\t(3)Charged cylinder(4)QUIT");
			 decision=input.nextInt();
		}		
		
//To ensure user has the choice to repeatedly give input as long as they don't quit.		
while(decision!=4){  
					
		                       //PARALLEL PLATES Chosen
		if(decision==1){
		//Prompts for Plate dimensions
		System.out.println("Negative dimension values will be regarded as positive, if entered.");	
		System.out.println("Please enter the length of one of the plates(in metres):");
		double length=input.nextDouble();
		System.out.println("Please enter the width of atleast one of the plates(in metres):");
		double width=input.nextDouble();
		
		length=Math.abs(length);
		width=Math.abs(width);   //To ensure that any negative values entered by the user
		                         //are converted to positive values.  
		
		double area=plates.getArea(length, width);
		
		//Prompt for decision
		System.out.println("What would you like to calculate?");
		System.out.println("Electric Field(E)\tCapacitance(C)");
		char choice=input.next().charAt(0);
		
		while(choice !='E' && choice !='C') {     //So that user gives valid input.
			 System.out.println("INVALID choice.Please choose correctly.");
				System.out.println("Electric Field(E)\tCapacitance(C)");
				 choice=input.next().charAt(0);
				
		 }
		
		//Do Appropriate calculations
		switch(choice) {
		case 'E':
			System.out.println("Please enter the charge(in Coulombs) on the plates.");
			double chargePlate= input.nextDouble();   //user
			plates.display_elecField( chargePlate, area);
			break;
		case 'C':
			System.out.println("Please enter the distance(meters) between the plates.");
			double dist= input.nextDouble();   //user
			//to ensure a negative value of distance is not entered
			while(dist<0) {
		System.out.println("This value cannot be negative!Please enter a positive value:");
		dist=input.nextDouble();
			}
			
			
			System.out.println("Please enter the dielectric constant between the plates.");
			double k= input.nextDouble();   //user
			      //TEST to ensure that the user enters a value >= 1 for k.
			while(k<1) {
System.out.println("Dielectric constant must be greater than or equal to 1.");
System.out.println("Please enter an appropriate value:");
 k= input.nextDouble();
			      }			
			plates.getCapacitance( k, area, dist);
			break;	
			default:
				System.out.println("ERROR:Computation not possible.");	
				break;
		}
}	//END
		                               //SPHERE chosen
		else if(decision==2) {			
			//get basic information for computation
			System.out.println("Enter the radius(in meters) of the sphere:");	
			double radius=input.nextDouble();
			sphere.getRadius(radius);
			
			//To ensure the user puts in a POSITIVE radius value.
			while(radius<0){
				System.out.println("Negative values of radius are invalid.");
				System.out.println("Please enter a POSITIVE value for radius:");
				radius =input.nextDouble();
			}
			
			System.out.println("Enter the charge(in Coulombs) on the sphere:");
			double chargeSphere=input.nextDouble();
			sphere.getCharge(chargeSphere);
			
			
			System.out.println("Enter the distance(in meters) from the center of the sphere "+
			"at which you wish to find the Electric field magnitude:");
			double r=input.nextDouble();
			sphere.getDistance(r);
			
			//To ensure the user puts in a POSITIVE distance value.
			while(r<0){
				System.out.println("Negative values of distance are invalid.");
				System.out.println("Please enter a POSITIVE value for distance:");
				r =input.nextDouble();
			}
			
			System.out.println("Please choose between the two options:");
			System.out.println("C(Conductor)\tU(Uniformly charged)");
			char sphereCall =input.next().charAt(0);   //to get decision
			
			//To ensure the user puts in a valid response
			while(sphereCall!='C'&& sphereCall!='U'){
				System.out.println("Please choose a valid option between the two:");
				System.out.println("C(Conductor)\tU(Uniformly charged)");
				sphereCall =input.next().charAt(0);
			}			
			if(sphereCall=='C') {
				sphere.conductingSphere(radius, r);
				}
			else if(sphereCall=='U') {
				sphere.uniformSphere(radius, r);
			}
			else {
			System.out.println("ERROR in computation.");
			}
		}	
		                             //CYLINDER chosen
			else if(decision==3)	{				
				//get basic information for computation
				System.out.println("Enter the radius(in meters) of the cylinder:");	
				double radius2=input.nextDouble();
				cylinder.getRadiusCyl(radius2);
				
				//To ensure the user puts in a POSITIVE radius value.
				while(radius2<0){
					System.out.println("Negative values of radius are invalid.");
					System.out.println("Please enter a POSITIVE value for radius:");
					radius2 =input.nextDouble();
				}
				
				System.out.println("Enter the linear charge density(in C/m) on the sphere:");
				double linDensity=input.nextDouble();
				cylinder.getDensity(linDensity);
				
				
				System.out.println("Enter the distance(in meters) from the center of the cylinder "+
				"at which you wish to find the Electric field magnitude.");
				double r2=input.nextDouble();
				cylinder.getDistanceCyl(r2);
				
				//To ensure the user puts in a POSITIVE distance value.
				while(r2<0){
					System.out.println("Negative values of distance are invalid.");
					System.out.println("Please enter a POSITIVE value for distance:");
					r2 =input.nextDouble();
				}
				
				System.out.println("Please choose between the two options:");
				System.out.println("C(Conductor)\tU(Uniformly charged)");
				char cylCall =input.next().charAt(0);   //to get decision
				
				//To ensure the user puts in a valid response
				while(cylCall!='C'&& cylCall!='U'){
					System.out.println("Please choose a valid option between the two:");
					System.out.println("C(Conductor)\tU(Uniformly charged)");
					cylCall =input.next().charAt(0);
				}				
				if(cylCall=='C') {
					cylinder.conductingCylinder(radius2, r2, linDensity);
					}
				else if(cylCall=='U') {
					cylinder.uniformCylinder(radius2, r2, linDensity);
				}
				else {
				System.out.println("ERROR in computation.");
				}
			}
		//To give the user a chance to do calculations again.
		System.out.println(" ");
		System.out.println("Please choose between the following options:");
		System.out.println("Enter a NUMBER corresponding to your choice.");
System.out.println("(1)Parallel plates\t(2)Charged sphere\t(3)Charged cylinder\t(4)QUIT");
		decision=input.nextInt();  //user choice between shapes
		}
		
		System.out.println("Thank you for using the Electro-calculator!");  //exit message
		
		
		}
	}
                                //Citation
/*Gauss's Law was used to compute these results.
 * I made a quick reference to the links provided below:
 * http://hyperphysics.phy-astr.gsu.edu/hbase/electric/gaulaw.html#c4
 * http://hyperphysics.phy-astr.gsu.edu/hbase/electric/elesph.html#c2
 * http://hyperphysics.phy-astr.gsu.edu/hbase/electric/elesph.html#c3
 * http://hyperphysics.phy-astr.gsu.edu/hbase/electric/elecyl.html#c2
 * http://hyperphysics.phy-astr.gsu.edu/hbase/electric/elecyl.html#c3
 * http://hyperphysics.phy-astr.gsu.edu/hbase/electric/elesht.html#c2
 */
			
	

