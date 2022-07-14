package _4gons;

import shapes.AbstractShape;
import shapes.Triangle;
import shapes.Vec2d;

class _4gon extends AbstractShape {
	private Vec2d a, b, c, d;
	private LineSegment2d ab, bc, cd, da;

	_4gon(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;

		this.ab = new LineSegment2d(a, b);
		this.bc = new LineSegment2d(b, c);
		this.cd = new LineSegment2d(c, d);
		this.da = new LineSegment2d(d, a);
	}

	// GETTERS
	public Vec2d getA() {
		return a;
	}

	public Vec2d getB() {
		return b;
	}

	public Vec2d getC() {
		return c;
	}

	public Vec2d getD() {
		return d;
	}

	public LineSegment2d getAb() {
		return ab;
	}

	public LineSegment2d getBc() {
		return bc;
	}

	public LineSegment2d getCd() {
		return cd;
	}

	public LineSegment2d getDa() {
		return da;
	}

	// ABSTRACTSHAPE METHODS
	@Override
	public boolean isInterior(Vec2d x) {
		return false;
	}
	@Override
	public double area(){
		// Compute area by splitting into two triangles and computing area of them
		LineSegment2d ab = this.ab;
		LineSegment2d bc = this.bc;

		LineSegment2d ca = new LineSegment2d(this.c, this.a);

		Triangle triangle1 = new Triangle(ab, bc, ca);

		LineSegment2d cd = this.cd;
		LineSegment2d da = this.da;


		Triangle triangle2 = new Triangle(cd, da, ca);

		double area = triangle1.area() + triangle2.area();
		return area;
	}

	float perimeter() {
		return a.minus(b).l2norm() + b.minus(c).l2norm() +
			c.minus(d).l2norm() + d.minus(a).l2norm();
	}
}

interface ValidityChecker {
	boolean isValid();
}

class Parallelogram extends _4gon implements ValidityChecker {

	Parallelogram(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
		super(a, b, c, d);  // reuse the constructor function
	}

	public boolean isValid() {
		//TODO: Insert logic for checking if this is a valid parallelogram
		return true;
	}
	@Override
	public double area() {
		return Math.abs(getA().getX()*getB().getY() - getA().getY()*getB().getX());
	}
}

class Rectangle extends Parallelogram {
	float l_a, l_b;

	Rectangle(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
		super(a, b, c, d);  // reuse the constructor function
		l_a = a.minus(b).l2norm();
		l_b = b.minus(c).l2norm();
	}

	public boolean isValid() {
		if (!super.isValid()) return false;
		//TODO: Insert logic for checking if this is a valid rectangle
		return true;
	}
}

class Square extends Rectangle {

	Square(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
		super(a, b, c, d);  // reuse the constructor function
	}
}
