
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student s) {
		if(this.score < s.score) {
			return -1;
		}
		else if(this.score > s.score) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return name + " " + score;
	}
}
