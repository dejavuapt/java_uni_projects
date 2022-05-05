import java.util.Comparator;

class SortByName implements Comparator<App_employee>{
    @Override
    public int compare(App_employee e1, App_employee e2){
        return e1.getEmployeeName().compareTo(e2.getEmployeeName());
    }
}