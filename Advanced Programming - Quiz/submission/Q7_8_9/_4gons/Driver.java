package _4gons;
import shapes.Vec2d;
import java.util.ArrayList;

public class Driver {

    ArrayList<_4gon> _4gonContainer = new ArrayList<_4gon>();

    public Driver(){

    }

    public void getPerimeters(){
        for(_4gon gon : _4gonContainer){
            System.out.println(gon.perimeter());
        }
    }

    public boolean convexCheck(_4gon quad){
        // get line segments
        LineSegment2d ab  = quad.getAb();
        LineSegment2d bc = quad.getBc();
        LineSegment2d cd = quad.getCd();
        LineSegment2d da = quad.getDa();

        // get angles
        double angle1 = ab.getAngle(bc);
        double angle2 = bc.getAngle(cd);
        double angle3 = cd.getAngle(da);
        double angle4 = da.getAngle(ab);

        double[] angles = {angle1,angle2,angle3,angle4};

        // Correcting inverse angle
        if(angle1 + angle2 + angle3 + angle4 < 360){
            int maxAngle = 0;
            for(int i = 0; i < 4; i++){
                if(angles[i] > angles[maxAngle]) maxAngle = i;
            }
            angles[maxAngle] = 360-angles[maxAngle];
        }
        // return true if all angles < 180, false otherwise
        return !(angles[0] > 180) && !(angles[1] > 180) &&
                !(angles[2] > 180) && !(angles[3] > 180);

    }

    public void add(_4gon quad){
        // convexity check - if true, add to container
        if(convexCheck(quad)) _4gonContainer.add(quad);
    }

    public void convexityTest(_4gon quad){
        // Demonstrating validity of convexity check
        System.out.println("convex: " + convexCheck(quad));

    }

    public static void main(String[] args){

        Driver driver = new Driver();

        Vec2d convexA = new Vec2d(3, 5);
        Vec2d convexB = new Vec2d(8, 5);
        Vec2d convexC = new Vec2d(8, 1);
        Vec2d convexD = new Vec2d(3, 1);
        _4gon convex4gon = new _4gon(convexA, convexB, convexC, convexD);

        Vec2d nonConvexA = new Vec2d(3, 5);
        Vec2d nonConvexB = new Vec2d(5, 2);
        Vec2d nonConvexC = new Vec2d(8, 2);
        Vec2d nonConvexD = new Vec2d(3, 1);
        _4gon nonConvex4gon = new _4gon(nonConvexA, nonConvexB, nonConvexC, nonConvexD);

//        driver.add(convex4gon);
//        driver.add(nonConvex4gon);
//        driver.getPerimeters();

        driver.convexityTest(convex4gon);
        System.out.println("area : " + convex4gon.area());
        driver.convexityTest(nonConvex4gon);
        System.out.println("area : " + nonConvex4gon.area());

    }

}
