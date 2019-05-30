package org.protor.sandbox.agodemar.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C extends AbstractB {
	
	double f;
	List<Double> l;
	
	public C() {
		super();
		System.out.println("C >> constructor with no fields");
		initialize();
	}
	
	public C(int i, boolean b, double d, int[] ia, 
			double f, List<Double> l) {
		super(i, b, d, ia);
		this.f = f;
		this.l = l;
		System.out.println("C >> constructor with fields (i, b, d, ia, f, l)");
	}
	
	private void initialize() {
		System.out.println("C >> initialize");
		this.f = -3.1415;
		this.l = new ArrayList<>();
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(super.toString() + "\n");

		return sb
				.append("C [f=" + this.f + ", ")
				.append("l=" + Arrays.toString(this.l.toArray()))
				.append("]") .toString();
	}

	
}
