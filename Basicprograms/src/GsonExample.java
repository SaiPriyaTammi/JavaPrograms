import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class GsonExample {


	public static void main(String[] args)  {
		Gson gson = new Gson();

		JsonArray jsonArray = new JsonArray();
		JsonParser parser = new JsonParser();

		ArrayList<Employee> employeesList = new ArrayList<>();

		Object obj;
		try {
			obj = parser.parse(new FileReader("employee.json"));
			jsonArray = (JsonArray) obj;
			String s= jsonArray.toString();
			System.out.println(s);
			
		Type collectionType = new TypeToken<ArrayList<Employee>>()
				{}.getType();
			employeesList= gson.fromJson(s, collectionType);
			System.out.println(employeesList);
			List<Employee> employeeStream = employeesList.stream().filter(n -> n.getName().endsWith("ya")).collect(Collectors.toList());
			List<Employee> employeeStream2 = employeesList.stream().filter(n -> n.getName().equals(n.getName())).collect(Collectors.toList());
			List<Integer> employeeStream3 = employeesList.stream().filter(n -> n.getAge() < 30).map(n -> n.getAge()).collect(Collectors.toList());
		    List<Employee> employeeStream4 =employeesList.stream()         
				  .filter(n -> n.getName().startsWith("S")) 
                  .collect(Collectors.toList());
			    System.out.println(employeeStream);
			    System.out.println(employeeStream2);
			    System.out.println(employeeStream3);
			    System.out.println(employeeStream4);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
