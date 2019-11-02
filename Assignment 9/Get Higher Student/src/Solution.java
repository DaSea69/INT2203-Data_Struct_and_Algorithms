import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
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

    @Override
    public int compareTo(Student that) {
        if (this.cgpa != that.cgpa) {
            return (this.cgpa > that.cgpa) ? 1 : -1;
        } else if (this.name.compareTo(that.name) != 0) {
            return this.name.compareTo(that.name);
        } else {
            return this.id < that.id ? 1 : -1; 
        }
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        final Queue<Student> queue = new PriorityQueue<>();
        for (String event : events) {
            String[] splitEvent = event.trim().split(" ");
            //System.out.println(splitEvent[0]);
            // for(String data: splitEvent) {
            //     System.out.println(data);
            // }
            if (splitEvent[0].compareTo("ENTER") == 0) {
                queue.add(new Student(Integer.parseInt(splitEvent[3]), splitEvent[1], Double.parseDouble(splitEvent[2])));
            } else {
                queue.poll();
            }
        }
        //System.out.println(queue.size());
        List<Student> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        } 
        Collections.reverse(result);
        return result;
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