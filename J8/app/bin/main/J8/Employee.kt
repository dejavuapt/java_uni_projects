package J8

data class Employee(
    private var name: String, 
    private var position: Positions?, 
    private var salary: Int, 
    private var start_year: Int, 
){
    val position_string = position.toString()

    //getters and setters
    fun getName() = name  
    fun setName(value: String) {name = value}

    fun getPosition() = position_string
    fun setPosition(value: Positions) { position = value}
    //-------------------------------------------------


    companion object {
        private var version: Int = 1
    }

    private val employee_id: Int
    init{
        employee_id = version++
    }

    override fun toString(): String = "Id: $employee_id / Name: $name | Position: $position_string | Salary: $salary $ | Year to start company: $start_year y."   
}