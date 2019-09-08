import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

class Cloc {
	public static void main(String[] args){
		System.out.print("File:");
		File file = new File(new Scanner(System.in).nextLine());
		List<String> lines = Files.readAllLines(file.toPath());
		int chars = 0;
		int words = 0;
		for(String line : lines){
			chars += line.length();
			words += line.split(" ").length;
		}
		System.out.println("characters" + chars +
				 "\nwords:" + words +
				 "\nlines:" + lines.size());
	}
}
