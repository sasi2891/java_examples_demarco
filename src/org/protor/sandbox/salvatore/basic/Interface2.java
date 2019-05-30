package org.protor.sandbox.salvatore.basic;

import java.util.List;

public interface Interface2 {

	public List <Double> calculate2a(List<C> l,double a);
	
	
	
	/**
	 * returns the list of eigenvalues for frequency range[a,b]
	 * @param listOfNodes
	 * @param lower limit for range
	 * @param upper limit for range
	 * @return list of eigenvalues
	 */
	public List<Double> calculate1a(List<C> listOfNodes,double a, double b);
	public double[] calculate2b(List<C> l);
}
