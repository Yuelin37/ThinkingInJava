package reusing;

//: reusing/Beetle.java
// The full process of initialization.
import static net.mindview.util.Print.*;

class Insect {
	private int i = 9;
	protected int j;

	Insect() {
		print("i = " + i + ", j = " + j);
		j = 39;
	}

	private static int x1 = printInit("static Insect.x1 initialized");

	static int printInit(String s) {
		print(s);
		return 47;
	}
}

public class Beetle extends Insect {
	private int k = printInit("Beetle.k initialized");

	public Beetle() {
		print("k = " + k);
		print("j = " + j);
	}

	private static int x2 = printInit("static Beetle.x2 initialized");

	public static void main(String[] args) {
		print("Beetle constructor");
		Beetle b = new Beetle();
		print("Ladybug constructor");
		Ladybug l = new Ladybug();
	}
} /*
	 * Output: static Insect.x1 initialized static Beetle.x2 initialized Beetle
	 * constructor i = 9, j = 0 Beetle.k initialized k = 47 j = 39
	 */// :~

// Ex24 (2) In Beetle.java, inherit a specific type of beetle from class Beetle,
// following the same format as the existing classes. Trace and explain the
// output.

class Ladybug extends Beetle {
	private int m = printInit("Ladybug.m initialized");
	public Ladybug(){
		print("m = " + m);
		print("j = " + j);
	}
	private static int x3 = printInit("static Ladybug.x1 initialized");
}