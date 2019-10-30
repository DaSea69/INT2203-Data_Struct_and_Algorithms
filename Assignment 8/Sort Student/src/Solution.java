import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
        }
        
        Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				if (student1.getCgpa() != student2.getCgpa()) {
					return student1.getCgpa() > student2.getCgpa() ? -1 : 1; 
				} else if (student1.getFname() != student2.getFname()) {
					return student1.getFname().compareTo(student2.getFname());
				} else {
					return student1.getId() > student2.getId() ? 1 : -1;
				}
			}
        });
      
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}

		in.close();
	}
}



