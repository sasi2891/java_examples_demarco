package org.protor.sandbox.salvatore.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToyC implements Interface1,Interface2{
	private List<Double> innerList;
	

	public ToyC() {
		this.innerList = new ArrayList<>();
	}


	public ToyC(List<Double> l) {
		this.innerList=l;
	}


	@Override
	public List<Double> calculate2a(List<C> l, double a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> calculate1a(List<C> listOfNodes, double a, double b) {
		List<Double> result=new ArrayList<>();
		for (C node: listOfNodes) {
		result.addAll(node.getAllNumbers(a,b));
	}
		return result;
	}
	@Override
	public double[] calculate2b(List<C> l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> calculate1a(List<C> l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> calculate1b(AbstractB[] bb) {
		// TODO Auto-generated method stub
		return null;
	} //implementando l'interfaccia dico a questa classe che mi deve utilizzare obbligatoriamente quiei metodi "come un contratto"

	public List<Double> getInnerList() {
		return innerList;
	}

	public void setInnerList(List<Double> innerList) {
		this.innerList = innerList;
	}


	@Override
	public String toString() {
		return "ToyC [innerList=" + Arrays.toString(this.innerList.toArray()) + "]";
	}

}
