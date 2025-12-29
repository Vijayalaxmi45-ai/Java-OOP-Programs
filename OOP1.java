abstract class Employee
{
    private int employeeId;
    private String employeeName;
    private String department;
    private float baseSalary;

    // Setters
    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public void setBaseSalary(float baseSalary)
    {
        this.baseSalary = baseSalary;
    }

    // Getters
    public int getEmployeeId()
    {
        return employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public String getDepartment()
    {
        return department;
    }

    public float getBaseSalary()
    {
        return baseSalary;
    }

    // Abstract method
    abstract void calculateSalary();

    public void displayEmployeeInfo()
    {
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Department: " + department);
    }
}

class PermanentEmployee extends Employee
{
    float bonus;
    float hra;
    float pfDeduction;
    float salary;

    void calculateSalary()
    {
        salary = getBaseSalary() + bonus + hra - pfDeduction;
        System.out.println("Permanent Employee Salary: " + salary);
    }
}

class ContractEmployee extends Employee
{
    int hoursWorked;
    int payPerHour;
    float salary;

    void calculateSalary()
    {
        salary = hoursWorked * payPerHour;
        System.out.println("Contract Employee Salary: " + salary);
    }
}

class EmployeesDet
{
    static void permit(Employee ref)
    {
        ref.calculateSalary();   // Runtime Polymorphism
    }
}

class OOP1
{
    public static void main(String args[])
    {
        PermanentEmployee pe = new PermanentEmployee();
        pe.setEmployeeId(101);
        pe.setEmployeeName("Amit");
        pe.setDepartment("IT");
        pe.setBaseSalary(30000);
        pe.bonus = 5000;
        pe.hra = 3000;
        pe.pfDeduction = 2000;

        ContractEmployee ce = new ContractEmployee();
        ce.setEmployeeId(102);
        ce.setEmployeeName("Ravi");
        ce.setDepartment("Support");
        ce.hoursWorked = 40;
        ce.payPerHour = 500;

        EmployeesDet.permit(pe);
        EmployeesDet.permit(ce);
    }
}
