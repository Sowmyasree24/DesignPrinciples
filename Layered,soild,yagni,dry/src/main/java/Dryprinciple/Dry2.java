package Dryprinciple;

class Dry {
	public void labclass() {

		System.out.println("lab class going on now");
		performOtherTasks();
		}

		public void theoryclass() {

		System.out.println("theory class going on now");
		performOtherTasks();
		}

		public void performOtherTasks() {

		System.out.println("Attendence is taken");
		System.out.println("Learning is done");
		System.out.println("teaching is done");
		
		}
}
public class Dry2{
	public static void main(String[] args) {
		Dry obj=new Dry();
		obj.labclass();
		obj.theoryclass();
	}

		
		
	}