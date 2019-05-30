package org.protor.sandbox.agodemar.basic;

public abstract class AbstractA {
	protected int i;
	protected boolean b;

	public AbstractA() {
		System.out.println("AbstractA >> constructor with no fields");
		initialize();
	}
	
	public AbstractA(int i, boolean b) {
		System.out.println("AbstractA >> constructor, with fields");
		this.i = i;
		this.b = b;
	}

	private void initialize() {
		System.out.println("AbstractA >> initialize");
		this.i = 0;
		this.b = false;
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
