package jdbcEmployeeProject.com;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Employess are the real heros");
			System.out.println("1:To add a new Employee\n2:Display a Employee"
					+ "\n3:Display all employees\n4:Delete a employee"
					+ "\n5:Update \n6:Sort a Employee\n7Exit");
			
			int choice = sc.nextInt();
			
			if(choice==1) {
				System.out.println("Add Employee");
				System.out.println("Enter Employee id : ");
				int eid=sc.nextInt();
				System.out.println("Enter Employee name : ");
				String ename= sc.next();
				System.out.println("enter Employee salary");
				double sal = sc.nextDouble();
				System.out.println("Enter Employee Phone no [entered 10 numbers]");
				long phno = sc.nextLong();
				Employee e1 = new Employee(eid,ename,sal,phno);
				boolean ans = JdbcCodeImpl.add(e1);
				if(ans==true) {
					System.out.println("Employee details add succesfully");
				}
				else {
					System.out.println("Something is fissy");
				}
			}
			else if(choice==2) {
				System.out.println("1:To display a employe by name\n2:To display a employe by id");
				int c2 = sc.nextInt();
				if(c2==1) {
					System.out.println("enter Employe name to display details");
					String name = sc.next();
					JdbcCodeImpl.display_by_name(name);
				}
				else if(c2==2) {
					System.out.println("Enter Employee id to display is details");
					int id = sc.nextInt();
					JdbcCodeImpl.display_by_id(id);
				}
				else {
					System.out.println("enter valid details");
				}
			}
			else if(choice==3) {
				JdbcCodeImpl.display_all();
			}
			else if(choice==4) {	
				System.out.println("Enter eid to delete details of that employee");
				int eid = sc.nextInt();
				JdbcCodeImpl.delete(eid);
			}
			
			else if(choice==5) {
				System.out.println("~~~~~~~~~~~~~~~~~~\n1:To update name\n2:To update sal\n3:To update phno");
				int c3 = sc.nextInt();
				switch(c3) {
				case 1: System.out.println("Enterd employee id");
						int eid = sc.nextInt();
						JdbcCodeImpl.display_by_id(eid);
						System.out.println("Enter Employee Name to update");
						String ename = sc.next();
						JdbcCodeImpl.update_Name(ename, eid);
				break;
				case 2: System.out.println("Enterd employee id");
				int id = sc.nextInt();
				JdbcCodeImpl.display_by_id(id);
				System.out.println("Enter Employee sal to update");
				double e = sc.nextDouble();
				JdbcCodeImpl.update_Sal(e, id);
				break;
				
				case 3: System.out.println("Enterd employee id");
				int i = sc.nextInt();
				JdbcCodeImpl.display_by_id(i);
				System.out.println("Enter Employee sal to update");
				long phno = sc.nextLong();
				JdbcCodeImpl.update_Phno(phno, i);
				break;
				default:
					System.out.println("Entered Valid no:");
					break;
				}
			}
			else if(choice==6) {
				System.out.println("~~~~~~~~~~~~~~~~~~\n1:Sort by name\n2:Sort by sal\n3:Sort by phno");
				int c3 = sc.nextInt();
				if(c3==1) {
					JdbcCodeImpl.sortAsPerName();
				}
				else if(c3==2) {
				JdbcCodeImpl.sortAsPerSal();
				}
				else if(c3==3) {
				JdbcCodeImpl.sortAsPerPhone();
				}
				else {
					System.out.println("Enterd valid number");
				}
			}
			else if(choice==7) {
				System.out.println("Exit from app");
				break;
			}
			else {
				System.out.println("Enter valid number");
			}
		}
		
		sc.close();
	}

}
