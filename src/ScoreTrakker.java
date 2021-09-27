import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	ScoreTrakker() {
		students = new ArrayList<Student>();
	}
	
	void loadDataFile(String fileName) throws FileNotFoundException{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(fileName);
		Scanner scanner = new Scanner(reader);
		while(scanner.hasNext()) {
			String first = scanner.next();
			String last = scanner.next();
			String name = first + " " + last;
			String s = scanner.next();
			try {
				int score = Integer.parseInt(s);
				students.add(new Student(name, score));
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format for "+name+" not a valid score: "+s+"\n");
			}
		}
	}
	
	void printInOrder() {
		System.out.println("Student Scores List");
		for(Student student : students) {
			System.out.println(student.toString());
		}
		System.out.println("");
	}
	
	void processFiles() {
		for(String file : files) {
			try {
				loadDataFile(file);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + file);
			}
		}
	}
	
	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}
}
