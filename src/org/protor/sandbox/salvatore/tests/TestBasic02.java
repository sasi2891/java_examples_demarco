package org.protor.sandbox.salvatore.tests;

import java.util.ArrayList;
import java.util.List;

import org.protor.sandbox.salvatore.basic.C;

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


	}
}
