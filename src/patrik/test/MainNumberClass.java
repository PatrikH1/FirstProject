package patrik.test;

import java.util.ArrayList;
import java.util.Arrays;

// En kommentar.
public class MainNumberClass {


	public static void main(String... args) {	

		// ArrayList<NumberClass> numberList = new ArrayList<NumberClass>();

		NumberClass  n1 = new NumberClass(10L, 20L);
		NumberClass  n2 = new NumberClass(20L, 30L);
		NumberClass  n3 = new NumberClass(40L, 50L);
		
		ArrayList<NumberClass> numberList = new ArrayList<NumberClass>(Arrays.asList(n1, n2, n3));
		
//		numberList.add(n1);
//		numberList.add(n2);
//		numberList.add(n3);
		
		numberList
		   .stream()
		   .forEach(n -> System.out.println("num1: " + n.getNum1() + " och num2: " + n.getNum2()));
		
		System.out.println("num1Sum: " + numberList
				   .stream()
				   .mapToLong(l -> l.getNum1()).sum());
		
		System.out.println("num2Sum: " + numberList
				   .stream()
				   .mapToLong(l -> l.getNum2()).sum());

		System.out.println("Sum total: " + numberList
				.stream()
				.mapToLong(l -> l.getNum1() + l.getNum2()).sum());

	}

}




