import java.time.LocalDate;
import java.util.Scanner;


public class App_employee implements GlobalConstants{
    
    //fields ---------------------------------------------
    private  String sname;
    private  String sposition;
    private  int isalary;
    private  LocalDate ldyearOfEmployment;
    // ---------------------------------------------------

    // constructors

    App_employee(){
        sname = null;
        sposition = null;
        isalary = 0;
        ldyearOfEmployment = LocalDate.now();
    }

    App_employee(String user_name, String user_position, int user_salary, LocalDate user_date){
        sname = user_name;
        sposition = user_position;
        isalary = user_salary;
        ldyearOfEmployment = user_date;
    }

    // gets and sets
    public LocalDate getLDYearOfEmployment(){
        return ldyearOfEmployment;
    }

    public String getEmployeeName(){
        return sname;
    }

    public String getPostion(){
        return sposition;
    }

    // methodes randomingValue getUserValues

    public void setUserInformation(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a name of employee: "); sname = scan.next() + " " + scan.next();
        System.out.print("Enter a function: "); sposition = scan.next();
        System.out.print("Salary: "); isalary = scan.nextInt();
        System.out.print("Enter a year when employee start work (like 2001-01-01): "); 
        String str = scan.next(); 
        ldyearOfEmployment = LocalDate.parse(str, dtf);
    }
    
    // overrides
    @Override
    public String toString(){
        return "[ " + sname + " | " + sposition + " | " + isalary + " | " + ldyearOfEmployment + " ]"; 
    }
    
    public int compareTo(App_employee o){
        return this.getEmployeeName().compareTo(o.getEmployeeName());
    }
}