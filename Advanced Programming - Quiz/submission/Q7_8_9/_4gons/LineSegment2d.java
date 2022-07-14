package _4gons;

import shapes.Vec2d;

public class LineSegment2d {

    private Vec2d start;
    private Vec2d end;
    private double vectorLength;
    private Vec2d linevec;

    public LineSegment2d(Vec2d a, Vec2d b){
        this.start = a;
        this.end = b;
        this.linevec = end.minus(start);

        this.vectorLength = linevec.l2norm();

    }

    public double getVectorLength(){
        return this.vectorLength;
    }

    public Vec2d getStart(){
        return this.start;
    }

    public Vec2d getEnd(){
        return this.end;
    }

    public Vec2d getLinevec(){
        return this.linevec;
    }

    public double getDotProduct(LineSegment2d that){
        double x1 = this.end.getX() - this.start.getX();
        double x2 = that.getEnd().getX() - that.getStart().getX();

        double y1 = this.end.getY() - this.start.getY();
        double y2 = that.getEnd().getY() - that.getStart().getY();

        return x1*x2 + y1*y2;

    }

    public double getAngle(LineSegment2d that){
        double dotProduct = getDotProduct(that);

        double vector1Length = this.getVectorLength();
        double vector2Length = that.getVectorLength();
        double angle = Math.acos(dotProduct/(vector1Length * vector2Length));
        angle = Math.toDegrees(angle);
        return 180 - angle;
    }
}
