package org.protor.sandbox.salvatore.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C extends AbstractB{
	double f;
	List <Double> l;
	public C() {
		super();
		System.out.println("C >> constructor with no fields");
		inizialize();
	}
	public C(int i, boolean b, double d, int[] ia,
			double f, List<Double> l) {
		super(i, b, d, ia);
		this.f=f;
		this.l=l;
		System.out.println("C >> constructor with fields (i,b,d,ia,f,l)");
	}

	private void inizialize() {
		System.out.println("C >> inizialize");
		this.f= -3.1424214;
		this.l= new ArrayList<>();
	}
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder(super.toString()+ "\n");
		sb
		.append("C [f=" + this.f + ",")							
		.append("l=" + Arrays.toString(this.l.toArray()))
		.append("]");/*monade si fa perchè so che il primo append mi da una stringa
	 					e quindi posso ripetere l'operazione*/
		return sb.toString();
	}

}
