package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;
import customsorting.StudentNotFoundException;

public class StudentManagementSystemImp implements StudentManagementSystem
{
	//key -> Student Id -> <String> & value -> Student Object -> <Student>
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	Scanner sc=new Scanner(System.in);
	@Override
	public void addStudent()
	{
		//Accepting age
		System.out.println("Enter the age");
		int age=sc.nextInt();

		//Accepting name
		System.out.println("Enter the name");
		String name=sc.next();

		//Accepting marks
		System.out.println("Enter the Marks");
		double marks=sc.nextDouble();

		//Creating a Student instance(object)
		Student std=new Student(age, name, marks);

		//Adding Entry (Student Id & Student Object) into the DB(Map)
		db.put(std.getId(), std);

		System.out.println("Student Record Inserted Successfully");
		System.out.println("Your Student ID is:"+std.getId());



	}
	@Override
	public void removeStudent()
	{
		//Accepting Student Id ->jsp101,Jsp101, JSP101
		System.out.println("Enter the Student Id:");//key
		String id=sc.next();//String id=sc.next().toUpperCase();
		//converting ID -> toUpperCase()
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student Record:");
			System.out.println(db.remove(id));
			System.out.println("Student Recrod Remove Successfull");
		}
		else
		{

			try
			{
				//StudentNotFoundException  ->custom message
				String message="NO students Recordes Found ";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}

	}
	@Override
	public	void removeAllStudent()
	{
		if(!db.isEmpty())
		{
			System.out.println("No of Student Records:"+db.size());
			db.clear();
			System.out.println("Student Records Delected Successfull");
		}
		else
		{
			try
			{
				//StudentNotFoundException  ->custom message
				String message="NO students Recordes Found to Remove";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public	void displayStudent()
	{
		//Accepting Student Id ->jsp101,Jsp101, JSP101
		System.out.println("Enter the Student Id:");//key
		String id=sc.next();//String id=sc.next().toUpperCase();
		//converting ID -> toUpperCase()
		id=id.toUpperCase();

		//checking if id is persent or not (id ->key)
		if(db.containsKey(id))// db.containsKey(jsp101)
		{
			System.out.println("Student Record Persent");
			Student s=db.get(id);//getting Student Object based on id
			System.out.println("Student Details:");
			System.out.println("===============================");
			System.out.println("Id:"+s.getId());
			System.out.println("Age:"+s.getAge());
			System.out.println("Name:"+s.getName());
			System.out.println("Marks:"+s.getMarks());
			// System.out.println(s);-> as toString() is Overriden
		}
		else
		{
			try
			{
				//StudentNotFoundException  ->custom message
				String message="Student with "+id+ " is not Found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}



	}
	@Override
	public void displayAllStudent()
	{
		//display student records when DB is not Empty
		if(!db.isEmpty()) {
			System.out.println("Student records are as follows:");
			System.out.println("------------------------------");

			Set<String> keys=db.keySet();//JSP101 JSP102 JSP103...........
			for(String key:keys)
			{
				//priting student objects as toString is Overridden
				System.out.println(db.get(key));
			}
		}
		else
		{
			try
			{
				//StudentNotFoundException  ->custom message
				String message="NO student Recorde to Display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void updateStudent()
	{
		//Accepting Student Id ->jsp101,Jsp101, JSP101
		System.out.println("Enter the Student Id:");//key
		String id=sc.next();//String id=sc.next().toUpperCase();
		//converting ID -> toUpperCase()
		id=id.toUpperCase();
		if(db.containsKey(id))// db.containsKey(jsp101)
		{
			Student s=db.get(id);
			System.out.println("1:Update Age:\n2:Update Name\n3:Update Markes");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Age:");
				int age=sc.nextInt();
				s.setAge(age);
				System.out.println("Age Update Successfull");
				break;
			case 2:
				System.out.println("Enter Name:");
				String name=sc.next();
				s.setName(name);
				System.out.println("Name Update Successfull");
				break;
			case 3:
				System.out.println("Enter Marks:");
				double marks=sc.nextDouble();
				s.setMarks(marks);
				System.out.println("Marks Update Successfull");
				break;
			default:
				try
				{
					String message="Invaild Choice ,kindly Enter Valid Choice!";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}

		}
		else
		{

			try
			{
				//StudentNotFoundException  ->custom message
				String message="Syudent with Id"+id+"is not Found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void countStudent()
	{
		System.out.println("Available Student Record:"+db.size());

	}
	@Override
	public void sortStudent()
	{
		//object of ArrayList & reference of List sotring student objects
		List<Student>list=new  ArrayList<Student>();

		//converting map into Set (keys) using keySet()
		Set<String> keys=db.keySet();

		//traversing keys from Set
		for(String key :keys)
		{
			Student s=db.get(key);//getting value (Student Object)
			list.add(s);//Adding value(Student Object) into list
			//list.add(db.get(key))
		}
		System.out.println("1:Sort Student By ID\n2:Sort Student By Age");
		System.out.println("3:Sort Student By Name\n4:Sort Student By Marks");
		System.out.println("Enter choice:");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			Collections.sort(list, new SortStudentById());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 2:
			Collections.sort(list, new SortStudentByAge());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 3:
			Collections.sort(list, new SortStudentByName());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 4:
			Collections.sort(list, new SortStudentByMarks());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		default:
			try
			{
				String message="Invaild Choice Exception";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}
	}
	@Override
	public 	void findStudentWithHigherMarks()
	{

		List<Student>list=new  ArrayList<Student>();
		Set<String> keys=db.keySet();

		for(String key :keys)
		{
			Student s=db.get(key);
			list.add(s);
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Highest Marks:"+list.get(list.size()-1));


	}
	@Override
	public void findStudentWithLowestMarks()
	{

		List<Student>list=new  ArrayList<Student>();
		Set<String> keys=db.keySet();

		for(String key :keys)
		{
			Student s=db.get(key);
			list.add(s);
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Lowest Marks:"+list.get(0));


	}

}
