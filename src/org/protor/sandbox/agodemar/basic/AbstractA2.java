package org.protor.sandbox.agodemar.basic;

public abstract class AbstractA2 {
	protected int i;
	protected boolean b;

	public AbstractA2() {
		System.out.println("AbstractA2 >> constructor with no fields");
		initialize();
	}
	
	public AbstractA2(int i, boolean b) {
		System.out.println("AbstractA2 >> constructor, with fields");
		this.i = i;
		this.b = b;
	}

	private void initialize() {
		System.out.println("AbstractA2 >> initialize");
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

}
