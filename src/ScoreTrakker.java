import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
	ScoreTrakker() {
		students = new ArrayList<Student>();
	}
	
	void loadDataFile(String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			Scanner scanner = new Scanner(reader);
			int i = 0;
			while(scanner.hasNext()) {
				String first = scanner.next();
				String last = scanner.next();
				String name = first + " " + last;
				String s = scanner.next();
				try {
					int score = Integer.valueOf(s);
					students.add(new Student(name, score));
				} catch (NumberFormatException e) {
					System.out.println("Incorrect format for "+name+" not a valid score: "+s+"\n");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file: " + fileName);
		} 
	}
	
	void printInOrder() {
		System.out.println("Student Scores List");
		for(Student student : students) {
			System.out.println(student.toString());
		}
	}
	
	void processFiles() {
		
	}
	
	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.loadDataFile("scores.txt");
		st.printInOrder();
	}
}
