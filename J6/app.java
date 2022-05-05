import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class app{


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

    private static ArrayList<Employee> arr_emps = new ArrayList<Employee>(emps);

    public static void main(String[] args) {
        

        emps.stream()
            .filter( emp -> emp.getPosistion().equals(Positions.FULLSTACK_GUY) )
            .forEach(emp -> System.out.println(emp.toString()));

        System.out.println("------------------------------------------------------------------------------");
        
        Map<Integer, String> collect = emps.stream().collect(Collectors.toMap(
            emp -> emp.getId(), 
            emp -> String.format("%s %s", emp.getSecondName(), emp.getFirstName())
        ));

        System.out.println(collect);
        System.out.println("------------------------------------------------------------------------------");

        emps.stream()
            .peek( emp -> { if (emp.getPosistion() == Positions.SYS_ADMIN) emp.setPosition(Positions.FULLSTACK_GUY); else emp.setPosition(Positions.WEB_DEVELOPER);})
            .forEach(emp -> System.out.println(emp.toString()));

    }
}