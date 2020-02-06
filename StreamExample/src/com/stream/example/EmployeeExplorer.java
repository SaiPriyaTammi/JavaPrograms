package com.stream.example;

import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class EmployeeExplorer {

	public static List<Employee> employees;

	private static String toJson(Employee employee) {
		Gson gson = new Gson();
		String employeeJson = gson.toJson(employee);
		return employeeJson;
	}

	private static void getEmployees() {
		Gson gson = new Gson();
		//String filePath = "C:\\Users\\DELL\\Desktop\\Employee.txt";
		try {
			String fileContent = new String(Files.readAllBytes(Paths.get("C:\\Users\\DELL\\Desktop\\Employee.txt")));

			Employee[] employeeArray = gson.fromJson(fileContent,Employee[].class);
			employees = Arrays.asList(employeeArray);
			System.out.println(employees);

		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EmployeeExplorer.toJson(employee);
		EmployeeExplorer.getEmployees();
	}

}
