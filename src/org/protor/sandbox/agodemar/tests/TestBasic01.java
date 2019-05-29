package org.protor.sandbox.agodemar.tests;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.protor.sandbox.agodemar.basic.A;
import org.protor.sandbox.agodemar.basic.B;

public class TestBasic01 {

	public static void main(String[] args) {

		A a1 = new A();

		System.out.println(a1);

		a1.setI(1);
		System.out.println(a1);

		a1.setD(-0.5);
		System.out.println(a1);

		a1.setS("Oggetto A1");
		System.out.println(a1);

		A a2 = new A(2, 3.1415, "Oggetto A2");
		System.out.println(a2);

		System.out.println("-------------");

		B b1 = new B();
		System.out.println(b1);

		b1.setSa(new String[] {"de!", "si", "Pre"});
		System.out.println(b1);

		System.out.println("-------------");

		for (int k = 0; k < b1.getSa().length; k++)
			System.out.println(b1.getSa()[k]);

		String[] s1 = b1.getSa();

		System.out.println("-------------");
		s1[0] = "AAAAA";
		//		String[] s2 = new String[] {b1.getSa()[0], b1.getSa()[1], s1[2]};
		//		String[] s3 = new String[3];
		//		for (int k = 0; k < 3; k++)
		//			s3[k] = b1.getSa()[k];

		for (String s : b1.getSa())
			System.out.println(s);

		System.out.println("-------------");

		String[] s1a = Arrays.copyOf(b1.getSa(), b1.getSa().length+1);
		
		s1a[0] = "GGGGGG";

		for (String s : b1.getSa())
			System.out.println(s);

		s1a[3] = ">>>>>>>";
		System.out.println("-------------");
		for (String s : s1a)
			System.out.println(s.toUpperCase());
		
		//System.out.println(b1);

		// concatenate two arrays
		String[] s1b = ArrayUtils.addAll(s1, s1a); // needs Apache Commons Lang
		System.out.println("-------------");
		for (String s : s1b)
			System.out.println(s);
		
		int[] ia = new int[s1b.length];
		for (int k = 0; k < ia.length; k++)
			ia[k] = 100+k;
		
		for (int j : ia)
			System.out.println("j = " + j + ", --> " + s1b[j-100]);
		
	}

}








