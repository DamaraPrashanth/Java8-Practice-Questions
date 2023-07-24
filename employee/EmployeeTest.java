package com.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		ArrayList<Employees> employeeList  = new ArrayList<Employees>();
		
		employeeList.add(new Employees(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employees(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
		employeeList.add(new Employees(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employees(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
		employeeList.add(new Employees(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
		employeeList.add(new Employees(6, "Cathy", 43, "Male", "Security", 2016, 10500.0));
		employeeList.add(new Employees(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
		employeeList.add(new Employees(8, "Suresh", 31, "Male", "Development", 2015, 34500.0));
		employeeList.add(new Employees(9, "Gita", 24, "Female", "Sales", 2016, 11500.0));
		employeeList.add(new Employees(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5));
		employeeList.add(new Employees(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employees(12, "Nithin", 25, "Male", "Development", 2016, 28200.0));
		employeeList.add(new Employees(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0));
		employeeList.add(new Employees(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5));
		employeeList.add(new Employees(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employees(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0));
		
		//1. How many male and female employees are there in the organization ?
		System.out.println("1. How many male and female employees are there in the organization ?");
		
		Map<String, Long> genderCount = employeeList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
		System.out.println(genderCount);
		
		//2. Print the name of all departments in the organization ?
		System.out.println("2. Print the name of all departments in the organization ?");
		
		employeeList.stream().map(e->e.getDepartment()).distinct().forEach(System.out::println);
		
		//3. What is the average age of male and female employees ?
		System.out.println("3. What is the average age of male and female employees ?");
		
		Map<String, Double> avgAge = employeeList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingInt(e->e.getAge())));
		System.out.println(avgAge);
		
		//4. Get the details of highest paid employee in the organization ?
		System.out.println("4. Get the details of highest paid employee in the organization ?");
		
		/*
		 * Optional<Employees> highPaid =
		 * employeeList.stream().max((e1,e2)->e1.getSalary().compareTo(e2.getSalary()));
		 * System.out.println(highPaid.get());
		 */
		
		Optional<Employees> highPaid = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.getSalary())));
		System.out.println(highPaid.get());
		
		//5. Get the names of all employees who have joined after 2015 ?
		
	}

}
