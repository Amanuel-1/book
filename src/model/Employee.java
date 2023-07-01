package model;

class Employee extends Person{
    private Double salary;
    private JobPosition job;
    public Employee() {};
    public Employee(String name){
        setName(name);
    }
}