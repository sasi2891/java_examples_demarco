package org.protor.sandbox.salvatore.basic;

public abstract class AbstractA {
	protected int i;
	protected boolean b;
	public AbstractA() {
		System.out.println("AbstractA  >> constructor with no fields");
		inizialize(); 
	}
	public AbstractA(int i, boolean b) {
		System.out.println("AbstractA  >> constructor, with fields");
		this.i = i;
		this.b = b;
	}
	private void inizialize() {
		System.out.println("AbstractA >> initialize");
		this.i=0;
		this.b=false;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "AbstractA [i=" + i + ", b=" + b + "]";
	}
	
}
