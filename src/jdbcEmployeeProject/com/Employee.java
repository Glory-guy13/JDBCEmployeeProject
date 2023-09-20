package jdbcEmployeeProject.com;

public class Employee {
	
	private int eid;
	private String ename;
	private double sal;
	private long phno;
	public Employee(int eid, String ename, double sal, long phno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.phno = phno;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", phno=" + phno + "]";
	}
}
