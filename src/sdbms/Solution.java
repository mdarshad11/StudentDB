package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Student Database Project");
		System.out.println("========================================");
		Scanner scan=new Scanner(System.in);
		//Upcasting to achieve abstraction
		StudentManagementSystem sms=new StudentManagementSystemImp();
		while(true)//infinte loop
		{
			System.out.println("Enter the choice");
			System.out.println("1:Add Student\n2:removeStudent\n3:removeAllStudent\n4:displayStudent\n5:displayAllStudent\n6:updateStudent\n7::countStudent\n8:sortStudent\n9:findStudentWithHigherMarks\n10:findStudentWithLowestMarks \n11:EXIT");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.removeStudent();
				break;
			case 3:
				sms.removeAllStudent();
				break;
			case 4:
				sms.displayStudent();
				break;
			case 5:
				sms.displayAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.findStudentWithHigherMarks();
				break;
			case 10:
				sms.findStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("thank you!!");
				System.exit(0);
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

			}//end of switch statement
			
			System.out.println("--------------");


		}//end of while loop



	}//end main()

}//end of class

