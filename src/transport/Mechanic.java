package transport;

import java.util.List;

public class Mechanic {
    private String name;
    private String company;
    private List<Transport> workingCar;

    public Boolean maintenance() {
        return false;
    }

    public Boolean fixCar() {
        return false;
    }

    public Mechanic(String name, String company, List<Transport> workingCar) {
        this.name = name;
        this.company = company;
        this.workingCar = workingCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Transport> getWorkingCar() {
        return workingCar;
    }

    public void setWorkingCar(List<Transport> workingCar) {
        this.workingCar = workingCar;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", workingCar=" + workingCar +
                '}';
    }
}
