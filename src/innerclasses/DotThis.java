package innerclasses;
//: innerclasses/DotThis.java

// Qualifying access to the outer-class object.

public class DotThis {
	void f() {
		System.out.println("DotThis.f()");
	}

	public class Inner {
		public DotThis outer() {
			return DotThis.this;
			// A plain "this" would be Inner's "this"
		}
		
		void f() {
			System.out.println("Inner.f()");
		}
	}

	public Inner inner() {
		return new Inner();
	}

	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
		
		DotThis.Inner dtii = dt.new Inner();
		dtii.f();
		dtii.outer().f();
	}
} /*
	 * Output: DotThis.f()
	 */// :~
