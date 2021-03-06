public class Atom {
    public static double readRadius(String filename){
        In in = new In(filename);
        int n = in.readInt();
        double r = in.readDouble();
        return r;
    }
    public static Body[] readBodies(String filename){
        In in = new In(filename);
        int n = in.readInt();
        double r = in.readDouble();

        Body[] bodies = new Body[n];

        for (int i = 0;i < n; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass  = in.readDouble();
            String imgFileName = in.readString();
            bodies[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
        return bodies;
    }

    public static void main(String[] args){
        double T  		= Double.parseDouble(args[0]);
        double dt       = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double r = -2.50e+11;
        StdDraw.setScale(-r,r);
        //StdDraw.picture(0,0,"images/starfield.jpg");

        for(Body b: bodies){
            b.draw();
        }
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while(time != T){
            Double[] xForces = new Double[9];
            Double[] yForces = new Double[9];
            for(int i = 0;i < 9;i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for(int i = 0;i < 9;i++){
                bodies[i].update(dt,xForces[i],yForces[i]);
            }
            //StdDraw.picture(0,0,"images/starfield.jpg");
            for(Body b: bodies) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            //StdAudio.play("audio/2001.wav");
            time += dt;
            StdDraw.clear();
        }

    }
}

















