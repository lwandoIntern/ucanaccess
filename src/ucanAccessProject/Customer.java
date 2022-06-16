package ucanAccessProject;

public class Customer {
    private String currentDate;
    private String iD;
    private String name;
    private String surname;
    private String customerEmail;
    private String phoneNo;
    private String tellerEmail;


    public Customer() {

    }

    public Customer(String date, String id, String names, String surnames, String custEmail, String phone, String tellerE) {
        currentDate = date;
        iD = id;
        name = names;
        surname = surnames;
        customerEmail = custEmail;
        phoneNo = phone;
        tellerEmail = tellerE;

    }
    public void setCurrentDate(String date){
        currentDate = date;
    }

    public void setID(String id){
        iD = id;
    }

    public void setName(String names){
        name = names;
    }

    public void setSurname(String surnames){
        surname = surnames;
    }

    public void setCustomerEmail(String custEmail){
        customerEmail = custEmail;
    }

    public void setPhoneNo(String phone){
        phoneNo = phone;
    }

    public void setTellerEmail(String tellerE){
        tellerEmail = tellerE;
    }

    public String getCurrentDate(){
        return currentDate;
    }

    public String getID(){
        return iD;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public String getTellerEmail(){
        return tellerEmail;
    }

}