public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static final double g = 6.67E-11;

	public Body(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		double dx = b.xxPos - xxPos;
		double dy = b.yyPos - yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}
	public double calcForceExertedBy(Body b){
		double r = Math.pow(calcDistance(b),2);
		return g*b.mass*mass/r;
	}
	public double calcForceExertedByX(Body b){
		double f = calcForceExertedBy(b);
		double r = calcDistance(b);
		double dx = b.xxPos - xxPos;
		return f*dx/r;
	}
	public double calcForceExertedByY(Body b){
		double f = calcForceExertedBy(b);
		double r = calcDistance(b);
		double dy = b.yyPos - yyPos;
		return f*dy/r;
	}
	public double calcNetForceExertedByX(Body[] allBodies){
		double fX = 0;
		for (int i = 0; i < allBodies.length; i++){
			if (!this.equals(allBodies[i])){
				fX += calcForceExertedByX(allBodies[i]);
			} 
		}
		return fX;
	}
	public double calcNetForceExertedByY(Body[] allBodies){
		double fY = 0;
		for (int i = 0; i < allBodies.length; i++){
			if (!this.equals(allBodies[i])){
				fY += calcForceExertedByY(allBodies[i]);
			} 
		}
		return fY;
	}
	public void update(double dt,double fX,double fY){
		double aX = fX/this.mass;
		double aY = fY/this.mass;
		this.xxVel = this.xxVel + aX*dt;
		this.yyVel = this.yyVel	+ aY*dt;
		this.xxPos = this.xxPos + xxVel*dt;
		this.yyPos = this.yyPos	+ yyVel*dt;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}