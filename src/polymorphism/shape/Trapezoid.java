package polymorphism.shape;
import static net.mindview.util.Print.*;
public class Trapezoid extends Shape {
	@Override
	public void draw() {
		print("Trapezoid.draw()");
	}

	@Override
	public void erase() {
		print("Trapezoid.erase()");
	}
	
	@Override
	public void fill(){
		print("Trapezoid.fill()");
	}
}
