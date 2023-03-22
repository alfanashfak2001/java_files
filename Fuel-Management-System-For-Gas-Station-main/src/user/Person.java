package user;

import java.util.Objects;

public class Person {
    private String nic;
    private String mobileNo;
    private String firstName;
    private String lastName;
    private String address;

    public Person(String nic, String mobileNo, String firstName, String lastName, String address) {
        this.nic = nic;
        this.mobileNo = mobileNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Person(String nic, String firstName) {
        this.nic = nic;
        this.firstName = firstName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return nic.equals(person.nic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nic);
    }
}
