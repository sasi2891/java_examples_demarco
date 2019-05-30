package org.protor.sandbox.salvatore.tests;

import java.util.ArrayList;
import java.util.List;

import org.protor.sandbox.salvatore.basic.C;
import org.protor.sandbox.salvatore.basic.ToyC;

public class TestBasic02 {
	public static void main(String[]args) {

		C c1 = new C();
		System.out.println(c1);
		System.out.println("--------------------");
		List<Double> l0=new ArrayList<>();
		l0.add(-55.0);
		l0.add(-45.0);

		C c2= new C(-10, true, 			//<---Abstract A
				-0.7, new int[] {1,1,1},   //<---Abstract B
				0.9, l0
				);				//<---C
		System.out.println(c2);
		List<C> nodes= new ArrayList<C>();
		nodes.add(c1);
		nodes.add(c2);
		ToyC tc=new ToyC();
		List<Double> numbers = tc.calculate1a(nodes, -20.0, 89.5);
		tc.setInnerList(numbers);
		System.out.println(tc);
	}
}
