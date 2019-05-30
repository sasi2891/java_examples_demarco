package org.protor.sandbox.salvatore.tests;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.protor.sandbox.salvatore.basic.A;
import org.protor.sandbox.salvatore.basic.B;

public class MYTestBasic01 {

	public static void main(String[] args) {
		A a1=new A();
		a1.setI(1);
		a1.setD(-0.5);
		a1.setS("Oggetto A1");

		
		A a2=new A(2,3.14,"oggetto A2");
		System.out.println(a2);
		System.out.println("-----------------------");
	    B b1=new B();
	    System.out.println(b1);
//	    String [] s1=b1.getSa();
//	    s1[0]="AAAAA"    mi fa la stessa cosa di quello sotto
	    
	    b1.setSa(new String[] {"de","si","pre"});
	    System.out.println(b1);
	    System.out.println("-----------------------");
	    for (int k=0;k<b1.getSa().length;k++)
	    	System.out.println(b1.getSa()[k]);
	    String [] s1=b1.getSa(); //questo s1 mi punta a b1.getSa non mi crea una copia se lo modifico modifico quello originario
	    
	    //for (String s : b1.getSa()) prendi un array generico s e assenagli il valore dopo i due punti
	    	                        //vado a sostituire questo for (int k=0;k<b1.getSa().lenght;k++);
	    b1.getSa()[0]="AAAAA"; //prendo il valore con get accedo alla posizione 0 e assegno la stringa AAAAA con il set avrei dovuto inserire un array di stringhe
	    System.out.println(b1);
	    String[] s1a = Arrays.copyOf(b1.getSa(), b1.getSa().length+1);
	    String[] s1b= ArrayUtils.addAll(s1, s1a);
	    System.out.println("----------");
	    for(String s: s1b)
	    	System.out.println(s);
	
	}

}
