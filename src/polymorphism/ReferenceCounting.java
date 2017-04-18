package polymorphism;

//: polymorphism/ReferenceCounting.java
// Cleaning up shared member objects.
import static net.mindview.util.Print.*;

class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;

	public Shared() {
		print("Creating " + this);
	}

	public void addRef() {
		refcount++;
		System.out.println("addRef()...");
		System.out.println("refcount: " + refcount);
	}

	protected void dispose() {
		if (--refcount == 0)
			print("Disposing " + this);
		System.out.println("refcount: " + refcount);
	}

	public String toString() {
		return "Shared " + id;
	}
	
	protected void finalize() {
	    if(refcount != 0)
	      System.out.println(this + " is still in use...");
	    // Normally, you'll also do this:
	    // super.finalize(); // Call the base-class version
	  }
}

class Composing {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;

	public Composing(Shared shared) {
		print("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
	}

	protected void dispose() {
		print("disposing " + this);
		shared.dispose();
	}

	public String toString() {
		return "Composing " + id;
	}
}

public class ReferenceCounting {
	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composing = { new Composing(shared), new Composing(shared), new Composing(shared),
				new Composing(shared), new Composing(shared) };
		for (Composing c : composing)
			c.dispose();
		(new Shared()).addRef();
		System.gc();
	}
} /*
	 * Output: Creating Shared 0 Creating Composing 0 Creating Composing 1
	 * Creating Composing 2 Creating Composing 3 Creating Composing 4 disposing
	 * Composing 0 disposing Composing 1 disposing Composing 2 disposing
	 * Composing 3 disposing Composing 4 Disposing Shared 0
	 */// :~
