//package CJITS_Students;
//import java.beans.Statement;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Students_Info {
	public static void main(String[] args) {
		
		// Student class (OOP concept)
	
			class Student_Info implements Serializable {

		    private int id;
		    private String name;
		    private int age;
		    private String course;

		    public void Student(int id, String name, int age, String course){
		        this.id = id;
		        this.name = name;
		        this.age = age;
		        this.course = course;
		    }
			
		

		    public int getId() {return id; }
		    public String getName() { return name; }
		    public int getAge() { return age; }
		    public String getCourse() { return course; }

		    public void setName(String name) { this.name = name; }
		    public void setAge(int age) { this.age = age; }
		    public void setCourse(String course) { this.course = course; }

		    @Override
		    public String toString() {
		        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
		    }  
		}

		
		// Main Management System
			
		/*class StudentManagementSystem {
		    private static final String FILE_NAME = "students.dat";
		    public ArrayList<Student> studentList;
		    //import com.students.Student;
		    public StudentManagementSystem() {
		        studentList = loadStudents();
		    }

		    // Add a new student
		    public void addStudent(Student s) {
		        studentList.add(s);
		        saveStudents();
		        System.out.println("Student added successfully!");
		    }

		    // Update student details
		    public void updateStudent(int id, String newName, int newAge, String newCourse) {
		        for (Student s : studentList) {
		            if (s.getId() == id) {
		                s.setName(newName);
		                s.setAge(newAge);
		                s.setCourse(newCourse);
		                saveStudents();
		                System.out.println("Student updated successfully!");
		                return;
		            }
		        }
		        System.out.println("Student not found!");
		    }*/

		    // Delete student by ID
		    public void deleteStudent(int id) {
		        Iterator<Student> it = studentList.iterator();
		        while (it.hasNext()) {
		            if (it.next().getId() == id) {
		                it.remove();
		                saveStudents();
		                System.out.println("Student deleted successfully!");
		                return;
		            }
		        }
		        System.out.println("Student not found!");
		    }

		    // Search for a student
		    public void searchStudent(int id) {
		        for (Student s : studentList) {
		            if (s.getId() == id) {
		                System.out.println("Student Found: " + s);
		                return;
		            }
		        }
		        System.out.println("Student not found!");
		    }

		    // Display all students
		    public void displayStudents() {
		        if (studentList.isEmpty()) {
		            System.out.println("No student records available!");
		            return;
		        }
		        System.out.println("------ Student Records ------");
		        for (Student s : studentList) {
		            System.out.println(s);
		        }
		    }

		    // Save to file
		    private void saveStudents() {
		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
		            oos.writeObject(studentList);
		        } catch (IOException e) {
		            System.out.println("Error saving students: " + e.getMessage());
		        }
		    }

		    // Load from file
		    @SuppressWarnings("unchecked")
		    private ArrayList<Student> loadStudents() {
		        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
		            return (ArrayList<Student>) ois.readObject();
		        } catch (FileNotFoundException e) {
		            return new ArrayList<>();
		        } catch (Exception e) {
		            System.out.println("Error loading students: " + e.getMessage());
		            return new ArrayList<>();
		        }
		    }

		    // Main method
	    public static void main(String[] args) {
		       Scanner sc = new Scanner(System.in);
		//[5:10 pm, 28/10/2025] Bhavani: // Main method
		  // public static void main(String[] args) {
		     // Scanner sc = new Scanner(System.in);
		       
		       
		        StudentManagementSystem sms = new StudentManagementSystem();
	    
		        int choice;

		        do {
		            System.out.println("\n==== Student Management System ====");
		            System.out.println("1. Add Student");
		            System.out.println("2. Update Student");
		            System.out.println("3. Delete Student");
		            System.out.println("4. Search Student");
		            System.out.println("5. Display All Students");
		            System.out.println("6. Exit");
		            System.out.print("Enter your choice: ");
		            choice = sc.nextInt();

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter ID: ");
		                    int id = sc.nextInt();
		                    sc.nextLine();
		                    System.out.print("Enter Name: ");
		                    String name = sc.nextLine();
		                    System.out.print("Enter Age: ");
		                    int age = sc.nextInt();
		                    sc.nextLine();
		                    System.out.print("Enter Course: ");
		                    String course = sc.nextLine();
		                    sms.addStudent(new Student(id, name, age, course));
		                    break;

		                case 2:
		                    System.out.print("Enter ID to update: ");
		                    id = sc.nextInt();
		                    sc.nextLine();
		                    System.out.print("Enter New Name: ");
		                    name = sc.nextLine();
		                    System.out.print("Enter New Age: ");
		                    age = sc.nextInt();
		                    sc.nextLine();
		                    System.out.print("Enter New Course: ");
		                    course = sc.nextLine();
		                    sms.updateStudent(id, name, age, course);
		                    break;

		                case 3:
		                    System.out.print("Enter ID to delete: ");
		                    id = sc.nextInt();
		                    sms.deleteStudent(id);
		                    break;

		                case 4:
		                    System.out.print("Enter ID to search: ");
		                    id = sc.nextInt();
		                    sms.searchStudent(id);
		                    break;

		                case 5:
		                    sms.displayStudents();
		                    break;

		                case 6:
		                    System.out.println("Exiting... Goodbye!");
		                    break;

		                default:
		                    System.out.println("Invalid choice! Try again.");
		            }
		        } while (choice != 6);

		        sc.close();
		    }
		}
	}
}
	
		    
		
	

		

	


