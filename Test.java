package Json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
class Employee
{
int empId,empsal;
String empName;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public int getEmpsal() {
	return empsal;
}
public void setEmpsal(int empsal) {
	this.empsal = empsal;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empsal=" + empsal + ", empName=" + empName + "]";
}

}
class CompById implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.empId-o2.empId;
	}
}
public class Test {

	public static void main(String[] args) 
	{
		Employee empnew=null,empnew1=null;
		// TODO Auto-generated method stub
       String  emp="{\"empId\":45,\"empName\":\"Pramomd\",\"empsal\":2000}";
       String emp1="{\"empId\":1,\"empName\":\"Pramomd verma\",\"empsal\":4000}";
       try
       {
    	  ObjectMapper om=new ObjectMapper();
    	   empnew=om.readValue(emp,Employee.class);
    	   empnew1=om.readValue(emp1,Employee.class);
    	  System.out.println(empnew.toString());
    	  System.out.println(empnew1);
       }
       catch(Exception ee)
       {
    	   ee.printStackTrace();
       }
       List<Employee> list=new ArrayList();
       list.add(empnew);
       list.add(empnew1);
       Collections.sort(list,new CompById());
       System.out.println("After Sorting");
        for (Employee employee : list) 
        {
		System.out.println(employee);	
		}
	}

}
