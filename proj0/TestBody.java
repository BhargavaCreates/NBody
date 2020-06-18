public class TestBody {
	public static void main(String[] args){
		Body earth = new Body(1.4960e+11,0.0000e+00,0.0000e+00,2.9800e+04,5.9740e+24,"earth.gif");
		Body mars  = new Body(2.2790e+11,0.0000e+00,0.0000e+00,2.4100e+04,6.4190e+23,"mars.gif");
		System.out.println("the force between Earth and mars is: ");
		System.out.println(earth.calcForceExertedBy(mars));
	}
}