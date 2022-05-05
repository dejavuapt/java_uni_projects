public class Employee {
    
    private String second_name;
    private String first_name;
    private int age;
    private int emp_id;
    private Positions posistion;

    Employee(String secondName, String firstName, int age, int emp_id, Positions position){
        second_name = secondName;
        first_name = firstName;
        this.age = age;
        this.emp_id = emp_id;
        this.posistion = position;
    }


    public String getSecondName(){
        return second_name;
    }
    public String getFirstName(){
        return first_name;
    }

    public Positions getPosistion(){
        return posistion;
    }

    public int getId(){
        return emp_id;
    }

    public void setPosition(Positions newPosition){
        posistion = newPosition;
    }

    @Override
    public String toString(){
        return second_name + " " + first_name + " " + age + " " + emp_id + " " + posistion.toString();
    }

    // @Override
    // public int compareTo(Employee o){

    // }

}
