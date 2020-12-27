package com.java8.features;

import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 

 */

public class Solution2 {

	interface AddMath {
		int add(int a, int b);
	}

	public static void main(String[] args) {
		System.out.println("Hello");
		AddMath addMath = (int a, int b) -> a*b;
		System.out.println(addMath.add(2, 3));
		List<Person> roster = new ArrayList<Person>();
		Person p1 = new Person("Ram", 24);
		p1.setGender(Person.Sex.MALE);
		roster.add(p1);
		roster.add(new Person("Shyam", 34));
//		printPersonsOlderThan(roster, 25);
		roster.add(new Person("Arun", 54));
		Collections.sort(roster, (Person o1, Person o2) ->  {
				return o1.getName().compareTo(o2.getName());
		});
		Collections.sort(roster, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for(Person p:roster)
			System.out.println(p.toString());
//		printPersonsWithinAgeRange(roster, 20, 45);
//		printPersons(
//			    roster, new CheckPersonEligibleForSelectiveService());
		
		/*printPersons(
			    roster,
			    new CheckPerson() {
			        public boolean test(Person p) {
			            return p.getGender() == Person.Sex.MALE
			                && p.getAge() >= 18
			                && p.getAge() <= 25;
			        }
			    }
			);*/
		
//		printPersonsWithPredicate(
//			    roster,
//			    p -> p.getGender() == Person.Sex.MALE
//			    && p.getAge() >= 18
//			    && p.getAge() <= 25
//			  );
	}
	
	public static void printPersonsWithPredicate(
		    List<Person> roster, Predicate<Person> tester) {
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            p.printPerson();
		        }
		    }
		}
	public static void printPersonsOlderThan(List<Person> roster, int age) {
	    for (Person p : roster) {
	        if (p.getAge() >= age) {
	            p.printPerson();
	        }
	    }
	}
	
	public static void printPersonsWithinAgeRange(
		    List<Person> roster, int low, int high) {
		    for (Person p : roster) {
		        if (low <= p.getAge() && p.getAge() < high) {
		            p.printPerson();
		        }
		    }
		}
	
	public static void printPersons(
		    List<Person> roster, CheckPerson tester) {
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            p.printPerson();
		        }
		    }
		}
}
