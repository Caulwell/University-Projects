package shapes;

import _4gons.LineSegment2d;

public class Triangle extends AbstractShape {

    LineSegment2d ab, bc, ca;
    public Triangle(LineSegment2d ab, LineSegment2d bc, LineSegment2d ca){
        this.ab = ab;
        this.bc = bc;
        this.ca = ca;

    }
    public boolean isInterior(Vec2d x){
        return false;
    }

    public double area(){
        double s = (ab.getVectorLength() + bc.getVectorLength() + ca.getVectorLength())/2;
        double s_a = s-ab.getVectorLength();
        double s_b = s-bc.getVectorLength();
        double s_c = s-ca.getVectorLength();
        return Math.sqrt(s * s_a * s_b * s_c);

    }

}
