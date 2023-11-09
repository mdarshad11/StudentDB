package customsorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByMarks implements Comparator<Student>
{

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return  x.getMarks().compareTo(y.getMarks());
	}
	

}
