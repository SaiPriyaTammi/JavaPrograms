import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) throws IOException {
		List<String> employees=Files.lines(Paths.get("C:\\Users\\DELL\\Desktop\\Employees.txt"))
				.filter(x -> x.contains("24"))
				.collect(Collectors.toList());
				employees.forEach(x -> System.out.println(x));

	}

}