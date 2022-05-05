import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class App_org implements GlobalConstants{
    
    
    //fields 
    private final String sname;
    private ArrayList<App_employee> alemployees;
    
    //constructors 
    App_org(String user_name){
        sname = user_name;
        alemployees = new ArrayList<>();
    }
    
    App_org(String user_name, String fileName) throws IOException{
        sname = user_name;
        alemployees = new ArrayList<>();
        this.setInfoOrganizationFromFile(fileName);
    }  
    
    public void add(App_employee e){
        alemployees.add(e);
    }

    public int size(){
        return alemployees.size();
    }

    public String getNameOrganization(){
        return sname;
    }

    public void sort(){
        alemployees.sort((o1,o2) -> o1.compareTo(o2));
    }

    //print informations

    public void display(){
        System.out.println("Organization name: " + sname);
        for( var e: alemployees){
            System.out.println(e.toString());
        }
    }

    public void customDisplay(LocalDate user_ldyear){
        int emp_count = 0;

        System.out.println("Organization name: " + sname + " | Earlier than " + user_ldyear + " :");
        for( var e: alemployees){
            if(e.getLDYearOfEmployment().compareTo(user_ldyear) <= 0){
                System.out.println(e.toString());
                emp_count++;
            }
        }
        if(emp_count == 0){
            System.out.println("Has nope employees who start work earlier than " + user_ldyear);
        }
    }
    
    // methodes getFileData 

    public void setInfoOrganizationFromFile(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        while((line = br.readLine()) != null){
            String[] temp_data = line.split(" ");
            alemployees.add(new App_employee(temp_data[0]+ " " +temp_data[1],temp_data[2],
                    Integer.valueOf(temp_data[3]),LocalDate.parse(temp_data[4],dtf)));
        }
        br.close();
    }

    // myself methodes
    public void getEmployeeUserPosition(String user_postion){
        int emp_count = 0;

        System.out.println("Employees that position is: " + user_postion);
        for( var e: alemployees){
            if(e.getPostion().compareTo(user_postion) == 0){
                System.out.println(e.toString());
                emp_count++;
            }
        }
        if(emp_count == 0){
            System.out.println("Not exist employees that have " + user_postion +  " position");
        }
    }

}
