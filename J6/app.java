import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class app{

    private static Positions dev_attribute = Positions.SYS_ADMIN;
    private static int dev_N = 2;

    private static List<Employee> emps = List.of(
        new Employee("Smith", "Michael", 43, 243, Positions.SYS_ADMIN),
        new Employee("Bosh", "Joe", 32, 513, Positions.WEB_DEVELOPER),
        new Employee("Gagarin", "Mark", 41, 5234, Positions.FULLSTACK_GUY),
        new Employee("Plahota", "Embriel", 32, 6554, Positions.SYS_ADMIN),
        new Employee("Smith", "Sam", 21, 314, Positions.SYS_ADMIN),
        new Employee("Lolic", "Jone", 56, 543, Positions.FULLSTACK_GUY),
        new Employee("Jackson", "Andrew", 32, 435, Positions.WEB_DEVELOPER),
        new Employee("Bosh", "Eric", 43, 765, Positions.WEB_DEVELOPER),
        new Employee("London", "July", 53, 856, Positions.SYS_ADMIN),
        new Employee("Laputenko", "Vladislav", 45, 129, Positions.FULLSTACK_GUY)
    );

    //private static ArrayList<Employee> arr_emps = new ArrayList<Employee>(emps);

    public static void main(String[] args) {
        
        //filter
        System.out.println("----------/filter");
        emps.stream()
            .filter( emp -> emp.getPosistion().equals(dev_attribute) )
            .forEach(emp -> System.out.println(emp.toString()));

        System.out.println("----------/map");
        //map
        Map<Integer, String> collect = emps.stream().collect(Collectors.toMap(
            emp -> emp.getId(), 
            emp -> String.format("%s %s", emp.getSecondName(), emp.getFirstName())
        ));
        //ppek
        System.out.println(collect);
        System.out.println("----------/peek");

        emps.stream()
            .peek( emp -> { if (emp.getPosistion() == dev_attribute) emp.setPosition(Positions.FULLSTACK_GUY); else emp.setPosition(Positions.WEB_DEVELOPER);})
            .forEach(emp -> System.out.println(emp.toString()));


        //limit: first N copies
        System.out.println("----------/limit: first N copies");
        emps.stream()
            .limit(dev_N)
            .forEach(emp -> System.out.println(emp.toString()));

        //skip: check N last copies
        System.out.println("----------/skip: check N last copies");
        emps.stream()
            .skip(emps.size() - dev_N)
            .forEach(emp -> System.out.println(emp.toString()));


        //to array
        System.out.println("----------/to arr");
        emps.stream().toArray();

        //check that all equals dev_attribute
        System.out.println("----------/check that all equals dev_attribute");
        displayTrueOrFalse(emps.stream()
                                    .allMatch(emp -> emp.getPosistion().equals(dev_attribute)));

        //check that at least one equals dev_attribute
        System.out.println("----------/check that at least one equals dev_attribute");
        displayTrueOrFalse(emps.stream()
                                    .anyMatch(emp -> emp.getPosistion().equals(Positions.WEB_DEVELOPER)));
        

        //find min and max 
        System.out.println("----------/find min");
        Employee var = emps.stream().min(Comparator.comparing(Employee::getId)).get();
        System.out.println(var.toString());
    }   


    private static void displayTrueOrFalse(boolean user_bool){
        if(user_bool) System.out.println("True"); else System.out.println("False");
    }
}