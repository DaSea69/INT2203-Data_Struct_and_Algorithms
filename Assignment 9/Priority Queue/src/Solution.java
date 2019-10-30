import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.name = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {
    protected Queue queue;

    Priorities() {
        queue = new PriorityQueue<Student>(11, new StudentComparator());
    }
    
    List<Student> getStudents(List<String> events) {
        
    }
    
}

class StudentComparator implements Comparator<Student> {
    @Override
        public int compare(Student student1, Student student2) {
            if (student1.getCgpa() != student2.getCgpa()) {
                return student1.getCgpa() > student2.getCgpa() ? -1 : 1; 
            } else if (student1.getName() != student2.getName()) {
                return student1.getName().compareTo(student2.getName());
            } else {
                return student1.getId() > student2.getId() ? 1 : -1;
            }
        }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}