package org.protor.sandbox.agodemar.basic;

import java.util.Arrays;

public abstract class AbstractB extends AbstractA {
	
	protected double d;
	protected int[] ia;
	
	public AbstractB() {
		super();
		System.out.println("AbstractB >> constructor, with no fields");
		initialize();
		
	}
	public AbstractB(int i, boolean b, double d, int[] ia) {
		super(i, b);
		this.d = d;
		this.ia = ia;
		System.out.println("AbstractB >> constructor, with fields (i, b, d, ia)");
	}
	
	private void initialize() {
		System.out.println("AbstractB >> initialize");
		this.d = -1.0;
		this.ia = new int[] {0, 0, 0};
	}
	
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public int[] getIa() {
		return ia;
	}
	public void setIa(int[] ia) {
		this.ia = ia;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder(super.toString() + "\n");

		sb.append("AbstractB [d=" + d + ", ia=" + Arrays.toString(ia) + "]");
		
		return sb.toString();
	}
	

}
