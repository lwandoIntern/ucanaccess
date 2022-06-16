package ucanAccessProject;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends RegisterCustomer{
    private String date;
    private String dGarments;
    private double pricesOfItems;
    private int totalStock;
    //private String gender;
    private int currentStcok;
    private int stockAfterD;


    public Register() {

    }

    public Register(String dt, int dGarments, double bPrice, int tStock, int cStock, int aStock) {
        date = dt;
        //dGarments = dGarments;

        //gender = gd;
        //differentGarments = dGarments;
        switch (dGarments){
            case 0:
                this.dGarments = "Select";
                break;
            case 1:
                this.dGarments = "Wedding garment";
                break;

            case 2:
                this.dGarments = "Traditional attire";
                break;

            case 3:
                this.dGarments = "Formal wear";
                break;

            case 4:
                this.dGarments = "Casual wear";
                break;

            case 5:
                this.dGarments = "Church clothes";
                break;

            case 6:
                this.dGarments = "Top";
                break;

            case 7:
                this.dGarments = "Jeans";
                break;

            case 8:
                this.dGarments = "Skirt";
                break;

            case 9:
                this.dGarments = "Blouse";
                break;

            case 10:
                this.dGarments = "Shorts";
                break;

            case 11:
                this.dGarments = "Dress";
                break;

            case 12:
                this.dGarments = "Pants";
                break;

            case 13:
                this.dGarments = "Jacket";
                break;


        }
        pricesOfItems = bPrice;
        totalStock = tStock;
        currentStcok = cStock;
        stockAfterD = aStock;

    }

    public void setDate(String dt){
        Date d;
        SimpleDateFormat s;
        //Date d2;
        //SimpleDateFormat s2;

        d = new Date();
        s = new SimpleDateFormat("yyyy-MM-dd");
        dt = s.format(d);

    }

    /*public void setGender(String gd){
     	gender = gd;
    }*/

    public void setDifferentGarments(int aGarments){
        switch (aGarments){
            case 1:
                dGarments = "Wedding garment";
                break;

            case 2:
                dGarments = "Traditional attire";
                break;

            case 3:
                dGarments = "Formal wear";
                break;

            case 4:
                dGarments = "Casual wear";
                break;

            case 5:
                dGarments = "Church clothes";
                break;

            case 6:
                dGarments = "Top";
                break;

            case 7:
                dGarments = "Jeans";
                break;

            case 8:
                dGarments = "Skirt";
                break;

            case 9:
                dGarments = "Blouse";
                break;

            case 10:
                dGarments = "Shorts";
                break;

            case 11:
                dGarments = "Dress";
                break;

            case 12:
                dGarments = "Pants";
                break;

            case 13:
                dGarments = "Jacket";
                break;


        }
    }

    public void setPricesOfItems(double pOfItems){
        pricesOfItems = pOfItems;
    }

    public void setTotalStock(int tStock){
        totalStock = tStock;
    }

    public void setCurrentStock(int cStock){
        currentStcok = cStock;
    }

    public void setStockAfterD(int aStock){
        stockAfterD = aStock;
    }

    public String getDate(){
        return date;
    }

    public String getDifferentGarments(){
        return dGarments;
    }

    public double getPricesOfItems(){
        return pricesOfItems;
    }

    public int getTotalStock(){
        return totalStock = 50;
    }

    public double getCurrentStock(){
        return currentStcok;
    }

    public double getStockAterD(){
        return stockAfterD;
    }

    /*public String getGender(){
		return gender;
    }*/

    public int deductions(){

        return stockAfterD = totalStock - currentStcok;
    }

	/*public String toString(){
            String headers1 = String.format("%-5s R%2.2f R%5.2f             R%5.2f        %-19s R%8.2f    R%4.2f    R%5.2f", date, fabricMeter,
            buttonprice, standardCharge, dGarments, pricesOfItems, finalPrice, depositPrice);
            return headers1;
	}*/

    ResultSet find(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
