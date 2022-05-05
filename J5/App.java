import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class App implements GlobalConstants{


    public static void main(String[] args) throws IOException{
        App_org userOrganization = new App_org("null");
        boolean isbreak = false;
        Scanner scan = new Scanner(System.in);
        char isContinue = 'y';
        System.out.println("Hello! My name is Ilya And it's 5 lab about \nclasses [var0] Employee and Organization");
        while(isContinue == 'y'){
            System.out.println("What you wanna? \n 1) Get org from file \n 2) Create new org");
            
            switch(scan.nextInt()){
                case 1: 
                    System.out.println("Set name:");
                    String str_name = scan.next();
                    userOrganization = new App_org(str_name);
                    System.out.println("Write file *.txt:");
                    String str_file = scan.next(); 
                    userOrganization.setInfoOrganizationFromFile(str_file);
                    userOrganization.display();
                    break;
                case 2:
                    System.out.print("Set name: "); 
                    userOrganization = new App_org(scan.next());
                    System.out.println("Add new employee: ");
                    char stopSymbol = 'y';
                    while(stopSymbol != 'n'){
                        App_employee temp = new App_employee();
                        temp.setUserInformation();
                        userOrganization.add(temp);
                        System.out.println("[if you wanna stop write n or continue y]");

                        stopSymbol = scan.next().toCharArray()[0];
                    }
                    userOrganization.display();
                    break;

                default:
                    System.out.println("error");
                    isbreak = true;
            }

            if(isbreak) { break;}

            System.out.println("What you wanna next? \n 1) sorting with your data \n 2) sort second name \n 3) find employees user's position ");

            switch(scan.nextInt()){
                case 1: 
                    System.out.println("Enter a year: (like yyyy-MM-DD): ");
                    userOrganization.customDisplay(LocalDate.parse(scan.next(),dtf));
                    break;

                case 2: 
                    userOrganization.sort();
                    userOrganization.display();
                    break;

                case 3:
                    System.out.println("Enter a position: ");
                    String str = scan.next();
                    userOrganization.getEmployeeUserPosition(str);
                    break;

                default:
                    System.out.println("error");
                    isbreak = true;
            }

            if(isbreak) { break;}
            System.out.print("wanna continue? y/n ");
            isContinue = scan.next().toCharArray()[0];


        }
        scan.close();
        
    }
}