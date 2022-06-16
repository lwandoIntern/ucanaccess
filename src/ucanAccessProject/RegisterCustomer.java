package ucanAccessProject;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JFrame;
import java.util.*;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
//import adpproject1.ServerApp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

//import adpproject.Register;

public class RegisterCustomer extends JFrame implements ActionListener{
    private JLabel lblContentLoading;
    JMenuBar menuBar;
    JMenu addMenu, deleteMenu, sorted_list_of_moviesMenu, sorted_list_of_available_moviesMenu, sorted_list_of_customerMenu, list_movies_that_start_with__Menu, rent_movieMenu, exitMenu;
    JMenuItem StockTaking, customerItem, customerItem1, movieItem2, exitItem, openSortedMoviesItem, openAvailableMoviesItem, openSortedCustomerItem, openMoviesThatStartWithItem, openRentMovieItem, openExitItem;
    private JButton btnReadyMade;
    private JLabel photo = new JLabel();

    //FashionDesign fd;
    //ArrayList<FashionDesign> fList = new ArrayList<FashionDesign>();
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    static public class Prac9 extends JPanel implements ActionListener, ItemListener
    {
        private JTextField txtCurrentDate;
        private JLabel lblCurrentDate;
        private JButton btnDisplay;
        private JButton btnCalculate;
        private JButton btnReturn;
        private JLabel lblClothingItem;
        private JLabel lblTotalStock;
        private JTextField txtTotalStock;
        private JComboBox cmbClothingItem;
        private JLabel lblCurrentStock;
        private JTextField txtCurrentStock;
        private JLabel lblStockAfterD;
        private JTextField txtStockAfterD;
        private JTextField txtPrice;
        private JTextField txtStockAmount;
        private JLabel lbl0;
        private JLabel lbl2;
        int total;
        DefaultTableModel dm21 = new DefaultTableModel();
        private JTable jt1;
        private JScrollPane jps1;
        //static private Register fd1;
        Date d1;
        SimpleDateFormat s1;
        //Step 1 a
        private Socket server;
        private Scanner keyIn = new Scanner(System.in);

        Connection con = null;
        Statement stmt = null;
        // ArrayList<Register> fList1 = new ArrayList<Register>();

        /**Create a new instance of ClientApp */
        public Prac9()
        {
            //construct preComponents
            String[] cmbClothingItemItems = {"SELECT","Wedding garment", "Traditional attire", "Formal wear", "Casual wear", "Top", "Jeans", "Skirt", "Shirt", "Blouse", "Shorts", "Dress", "Pants", "Jacket", "Church clothes"};
            //String[] jListItems = {};
            Object[] columns = {"Date", "Clothing Item","Price" , "Total Stock", "Current Items", "Stock After Deductions"};
            dm21.setColumnIdentifiers(columns);
            //jt.setModel(dm2);

            String[][] data = {};
            jt1 = new JTable(data,columns)
            {
                public boolean isCellEditable(int data, int columns){
                    return false;
                }
            };
            jt1.setPreferredScrollableViewportSize(new Dimension(450, 63));
            jt1.setFillsViewportHeight(true);

            jps1 = new JScrollPane(jt1);
            jt1.setRowHeight(17);
            add (jps1);
            //construct preComponents
            //String[] cmbClothingItemItems = {};

            //construct components

            lblCurrentDate = new JLabel ("Current Date:");
            lblClothingItem = new JLabel ("Clothing Item:");
            lblTotalStock = new JLabel ("Total Stock:");
            lblCurrentStock = new JLabel ("Current Items:");
            lblStockAfterD = new JLabel ("Stock After Deductions:");
            txtTotalStock = new JTextField (5);
            txtStockAmount = new JTextField(5);
            txtPrice = new JTextField (5);
            txtCurrentDate = new JTextField (5);
            cmbClothingItem = new JComboBox (cmbClothingItemItems);
            txtCurrentStock = new JTextField (5);
            txtStockAfterD = new JTextField (5);
            btnDisplay = new JButton ("Add");
            btnCalculate = new JButton ("Calculate");
            btnReturn = new JButton ("Main menu");
            lbl0 = new JLabel("");
            lbl2 = new JLabel("");

            //adjust size and set layout
            setPreferredSize (new Dimension (885, 510));
            setLayout (null);
        /*Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);*/

            //add components

            add (txtCurrentDate);
            txtCurrentDate.setEditable(false);
            add (lblCurrentDate);
            add (btnDisplay);
            add (btnCalculate);
            add (lblClothingItem);
            add (lblTotalStock);
            add (txtTotalStock);
            txtTotalStock.setEditable(false);
            add(txtStockAmount);
            //txtStockAmount.setEditable(false);
            add (cmbClothingItem);
            add (lblCurrentStock);
            add (txtCurrentStock);
            add (lblStockAfterD);
            add (txtStockAfterD);
            txtStockAfterD.setEditable(false);
            add (txtPrice);
            txtPrice.setEditable(false);
            add (btnReturn);
            add(lbl0);
            add(lbl2);

            cmbClothingItem.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getSource()==cmbClothingItem){
                        if(cmbClothingItem.getSelectedItem().equals("Wedding garment")){
                            txtPrice.setText("1500.00");
                            int amount = 50;
                            for (int i = 0; i < 10; i++) {

                            }
                            txtStockAmount.setText(Integer.toString(amount));
                        }else if(cmbClothingItem.getSelectedItem().equals("Traditional attire")){
                            txtPrice.setText("1000.00");
                            int amount1 = 100;
                            txtStockAmount.setText(Integer.toString(amount1));
                        }else if(cmbClothingItem.getSelectedItem().equals("Formal wear")){
                            txtPrice.setText("1100.00");
                            int amount2 = 55;
                            txtStockAmount.setText(Integer.toString(amount2));

                        }else if(cmbClothingItem.getSelectedItem().equals("Casual wear")){
                            txtPrice.setText("700.00");
                            int amount3 = 200;
                            txtStockAmount.setText(Integer.toString(amount3));

                        }else if(cmbClothingItem.getSelectedItem().equals("Top")){
                            txtPrice.setText("100.00");
                            int amount4 = 300;
                            txtStockAmount.setText(Integer.toString(amount4));

                        }else if(cmbClothingItem.getSelectedItem().equals("Jeans")){
                            txtPrice.setText("300.00");
                            int amount5 = 350;
                            txtStockAmount.setText(Integer.toString(amount5));

                        }else if(cmbClothingItem.getSelectedItem().equals("Skirt")){
                            txtPrice.setText("200.00");
                            int amount6 = 360;
                            txtStockAmount.setText(Integer.toString(amount6));

                        }else if(cmbClothingItem.getSelectedItem().equals("Shirt")){
                            txtPrice.setText("150.00");
                            int amount7 = 400;
                            txtStockAmount.setText(Integer.toString(amount7));

                        }else if(cmbClothingItem.getSelectedItem().equals("Blouse")){
                            txtPrice.setText("250.00");
                            int amount8 = 370;
                            txtStockAmount.setText(Integer.toString(amount8));

                        }else if(cmbClothingItem.getSelectedItem().equals("Shorts")){
                            txtPrice.setText("250.00");
                            int amount9 = 70;
                            txtStockAmount.setText(Integer.toString(amount9));

                        }else if(cmbClothingItem.getSelectedItem().equals("Dress")){
                            txtPrice.setText("150.00");
                            int amount10 = 350;
                            txtStockAmount.setText(Integer.toString(amount10));

                        }else if(cmbClothingItem.getSelectedItem().equals("Pants")){
                            txtPrice.setText("350.00");
                            int amount11 = 700;
                            txtStockAmount.setText(Integer.toString(amount11));

                        }else if(cmbClothingItem.getSelectedItem().equals("Jacket")){
                            txtPrice.setText("4500.00");
                            int amount12 = 310;
                            txtStockAmount.setText(Integer.toString(amount12));

                        }else if(cmbClothingItem.getSelectedItem().equals("Church clothes")){
                            txtPrice.setText("500.00");
                            int amount13 = 1000;
                            txtStockAmount.setText(Integer.toString(amount13));


                        }

                    }
                }

            });
            //Attempt to establish connection to server
       /* try
        {
            //Step 1 b
            //Create socket to Server
            server = new Socket("127.0.0.1", 12345);

        }catch(IOException ioe)
        {
            System.out.println("IOException: " + ioe.getMessage());
        }
        */
            final Object[] row1 = new Object[6];

            btnDisplay.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnDisplay){
                        try{
                            d1 = new Date();
                            s1 = new SimpleDateFormat("yyyy-MM-dd");
                            txtCurrentDate.setText(s1.format(d1));

                            String dates1 = txtCurrentDate.getText();
                            txtCurrentDate.setText(dates1);
                            int abCategory = 0;
                            cmbClothingItem.setSelectedItem(Integer.toString(abCategory));
                            switch (cmbClothingItem.getSelectedIndex()){
                                case 0:
                                    abCategory = 0;
                                    break;

                                case 1:
                                    abCategory = 1;
                                    break;

                                case 2:
                                    abCategory = 2;
                                    break;

                                case 3:
                                    abCategory = 3;
                                    break;

                                case 4:
                                    abCategory = 4;
                                    break;

                                case 5:
                                    abCategory = 5;
                                    break;

                                case 6:
                                    abCategory = 6;
                                    break;

                                case 7:
                                    abCategory = 7;
                                    break;

                                case 8:
                                    abCategory = 8;
                                    break;

                                case 9:
                                    abCategory = 9;
                                    break;

                                case 10:
                                    abCategory = 10;
                                    break;

                                case 11:
                                    abCategory = 11;
                                    break;

                                case 12:
                                    abCategory = 12;
                                    break;

                                case 13:
                                    abCategory = 13;
                                    break;

                                default:
                                    break;

                            }
                            if(abCategory == 2){
                                abCategory = 3;
                            }

                            double price = Double.parseDouble(txtPrice.getText());
                            txtPrice.setText(Double.toString(price));
                            int current = Integer.parseInt(txtCurrentStock.getText());
                            txtCurrentStock.setText(Integer.toString(current));
                            //int deductions = total - current;
                            //txtStockAfterD.setText("" + deductions);

                            int stockAmount = Integer.parseInt(txtStockAmount.getText());
                            txtStockAmount.setText(Integer.toString(stockAmount));
                            int stock = stockAmount - current;
                            txtTotalStock.setText("" + stock);
                            total = Integer.parseInt(txtTotalStock.getText());
                            txtTotalStock.setText(Integer.toString(total));
                            int deductions = total;
                            txtStockAfterD.setText("" + deductions);
                            int after = Integer.parseInt(txtStockAfterD.getText());
                            txtStockAfterD.setText(Integer.toString(after));

                            // fd1 = new Register(dates1, abCategory, price, total, current, after);
                            //ArrayList<>:
                            // fList1.add(fd1);

                            String dbURL = "jdbc:ucanaccess://";
                            String filename = "C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\StockTaking1.accdb";
                            dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
                            String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";


                            //String name = txtName.getText();

                            //String surname = txtSurname.getText();

                            String create_Table_stmt="create table StockTaking1 (ID  INTEGER, Dates  VARCHAR(30), ClothingItem  VARCHAR(60), Price FLOAT, TotalStock  VARCHAR(60), CurrentStock VARCHAR(60), StockAfterDeductions VARCHAR(60))";
                            String insert_Values_stmt="insert into StockTaking1 values   (1, '"+dates1+"','"+abCategory+"', '"+price+"', '"+total+"', '"+current+"', '"+after+"')";
                            String update_Values_stmt="UPDATE StockTaking1 SET Dates='"+dates1+"'  ClothingItem='"+abCategory+"'   Price='"+price+"'  TotalStock='"+total+"'  CurrentStock= '"+current+"' WHERE StockAfterDeductions='"+after+"' ";
                            String retrieve_Values_qry="SELECT * FROM StockTaking1";


                            System.out.println("About to Load the JDBC Driver....");
                            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                            //Class.forName(driverName);
                            System.out.println("Driver Loaded Successfully....");
                            System.out.println("About to get a connection....");
                            Connection con = DriverManager.getConnection(dbURL, "","");
                            System.out.println("Connection Established Successfully....");
                            // create a java.sql.Statement so we can run queries
                            System.out.println("Creating statement Object....");
                            Statement s = con.createStatement();
                            System.out.println("Statement object created Successfully....");

                            System.out.println("About to execute SQL stmt....");
                            s.executeUpdate(insert_Values_stmt); // execute the SQL statement
                            System.out.println("SQL stmt executed....");
                            ResultSet rs = s.executeQuery(retrieve_Values_qry); // select the data from the table

                            if (rs != null) // if rs == null, then there is no ResultSet to view
                                while ( rs.next() ) // this will step through our data row-by-row
                                {
                                    System.out.println("Data from column_name: "
                                            + rs.getString(1) + " "+rs.getString(2) );
                                }
                            System.out.println("SQL statement executed  Successfully....");

                            System.out.println("About to close Statement....");
                            s.close(); // close the Statement to let the database know we're done with it
                            con.close(); // close the Connection to let the database know we're done with it
                            System.out.println("Statement closed successfully....");


                            row1[0] = txtCurrentDate.getText();
                            row1[1] = cmbClothingItem.getSelectedItem();
                            row1[2] = Double.parseDouble(txtPrice.getText());
                            row1[3] = Integer.parseInt(txtTotalStock.getText());
                            row1[4] = Integer.parseInt(txtCurrentStock.getText());
                            row1[5] = Integer.parseInt(txtStockAfterD.getText());

                            //jList table:
                            jt1.setModel(dm21);

                            // if(fList1.size() <= 30){
                            //dm2.addElement(String.format("%-5s  %-5s   %-5s   %-5s   %-5s   %-5s   %-5s   %-5s", "Date","Fabric Meter","Button Price","Base Charge","Garments","PricesOfItems","FinalPrice","Deposit\n"));
                            dm21.addRow(row1);
                            //System.out.println(dm2.toString());
                            // }else{
                            //    JOptionPane.showMessageDialog(null, "display list is full");
                            // }
                            //jList.getModel().toString();
                            //The connection has been established - now send/recieve

       /* try
        {

            //Step 2 a
            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();

            //Step 2 b
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

             /*sendData("2*" + txtCurrentDate.getText());
             sendData("3*" + cmbClothingItem.getSelectedItem());
             //sendData("3*" + txtPrice.getText());
             sendData("4*" + txtTotalStock.getText());
             sendData("5*" + txtCurrentStock.getText());
             sendData("6*" + txtStockAfterD.getText());
             RegisterCustomer data;
            data = (RegisterCustomer)in.readObject();
            jps1.add(data);*/
                            //Step 3 a Communicate outwards
            /*String mesg = "";
            String response = "";
            String response1 = "";
            String response2 = "";
            String response3 = "";
            String response4 = "";
            String response5 = "";

            do{
                //System.out.println("Please type in a string for the server: ");
                //mess = keyIn.nextLine();
                //1
                out.writeObject(txtCurrentDate.getText());
                out.writeObject(cmbClothingItem.getSelectedItem());
                out.writeObject(txtPrice.getText());
                out.writeObject(txtTotalStock.getText());
                out.writeObject(txtCurrentStock.getText());
                out.writeObject(txtStockAfterD.getText());

                //out.flush(;

                //Step 3 b Communicate receiving inwards
                //4
                response = (String)in.readObject();
                System.out.println("Server said>> " + response);

                response1 = (String)in.readObject();
                System.out.println("Server said>> " + response1);

                response2 = (String)in.readObject();
                System.out.println("Server said>> " + response2);

                response3 = (String)in.readObject();
                System.out.println("Server said>> " + response3);

                response4 = (String)in.readObject();
                System.out.println("Server said>> " + response4);

                response5 = (String)in.readObject();
                System.out.println("Server said>> " + response5);

               /* txtCurrentDate.setText("");
                txtPrice.setText("");
                txtTotalStock.setText("");
                txtCurrentStock.setText("");
                txtStockAfterD.setText("");
                txtStockAmount.setText("");*/

            /*}while(!response.equals("TERMINATE")||!response1.equals("TERMINATE")||!response2.equals("TERMINATE")||!response3.equals("TERMINATE")||!response4.equals("TERMINATE")||!response5.equals("TERMINATE"));
            //Step 4: Close down
            out.close();
            in.close();
            server.close();

        }catch(IOException ioe)
        {
            System.out.println("IOException: " + ioe.getMessage());
        }catch(ClassNotFoundException cnfe)
        {
            System.out.println("ClassNotFoundException: " + cnfe.getMessage());
        }*/
                            txtCurrentDate.setText("");
                            txtPrice.setText("");
                            txtTotalStock.setText("");
                            txtCurrentStock.setText("");
                            txtStockAfterD.setText("");
                            txtStockAmount.setText("");
                        }catch(Exception ex){
                            System.out.println("An era occurred while loading...");

                        }
                    }//if Statement
                }
            });

            btnCalculate.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnCalculate){
                        d1 = new Date();
                        s1 = new SimpleDateFormat("yyyy-MM-dd");
                        txtCurrentDate.setText(s1.format(d1));

                        String dates1 = txtCurrentDate.getText();
                        int abCategory = 0;
                        switch (cmbClothingItem.getSelectedIndex()){
                            case 0:
                                abCategory = 0;
                                break;

                            case 1:
                                abCategory = 1;
                                break;

                            case 2:
                                abCategory = 2;
                                break;

                            case 3:
                                abCategory = 3;
                                break;

                            case 4:
                                abCategory = 4;
                                break;

                            case 5:
                                abCategory = 5;
                                break;

                            case 6:
                                abCategory = 6;
                                break;

                            case 7:
                                abCategory = 7;
                                break;

                            case 8:
                                abCategory = 8;
                                break;

                            case 9:
                                abCategory = 9;
                                break;

                            case 10:
                                abCategory = 10;
                                break;

                            case 11:
                                abCategory = 11;
                                break;

                            case 12:
                                abCategory = 12;
                                break;

                            case 13:
                                abCategory = 13;
                                break;

                            default:
                                break;

                        }
                        if(abCategory == 2){
                            abCategory = 3;
                        }

                        double price = Double.parseDouble(txtPrice.getText());

                        int current = Integer.parseInt(txtCurrentStock.getText());
                        //int deductions = total - current;
                        //txtStockAfterD.setText("" + deductions);

                        int stockAmount = Integer.parseInt(txtStockAmount.getText());
                        int stock = stockAmount - current;
                        txtTotalStock.setText("" + stock);
                        total = Integer.parseInt(txtTotalStock.getText());
                        int deductions = total;
                        txtStockAfterD.setText("" + deductions);
                        int after = Integer.parseInt(txtStockAfterD.getText());

                    }

                }

            });

            btnReturn.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnReturn){
                        RegisterCustomer r = new RegisterCustomer();
                    }
                }
            });



            //set component bounds (only needed by Absolute Positioning)
            txtCurrentDate.setBounds (175, 40, 135, 25);
            lblCurrentDate.setBounds (15, 35, 100, 25);
            btnDisplay.setBounds (15, 270, 100, 25);
            btnCalculate.setBounds (210, 265, 100, 25);
            lblClothingItem.setBounds (15, 80, 100, 25);
            lblTotalStock.setBounds (15, 125, 100, 25);
            txtStockAmount.setBounds (175, 125, 135, 25);
            cmbClothingItem.setBounds (175, 80, 135, 25);
            txtTotalStock.setBounds(315, 125, 100, 25);
            lblCurrentStock.setBounds (15, 170, 100, 25);
            txtCurrentStock.setBounds (175, 165, 135, 25);
            lblStockAfterD.setBounds (15, 215, 145, 25);
            txtStockAfterD.setBounds (175, 210, 135, 25);
            txtPrice.setBounds (315, 80, 100, 25);
            btnReturn.setBounds (115, 315, 100, 25);
            jps1.setBounds (420, 5, 460, 315);
            lbl0.setBounds (175, 100, 100, 25);
            lbl2.setBounds (175, 145, 100, 25);

            txtTotalStock.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try{
                        int i = Integer.parseInt(txtTotalStock.getText());
                        lbl0.setText("");

                    }catch(NumberFormatException e1){
                        lbl0.setText("Invalid number");

                    }
                }});

            txtCurrentStock.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try{
                        int i = Integer.parseInt(txtCurrentStock.getText());
                        lbl2.setText("");

                    }catch(NumberFormatException e1){
                        lbl2.setText("");

                    }
                }});

        }
   /* public void sendData(String mess)
    {
        try
        {
            //Step 2 a
            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();

            //Step 2 b
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject(mess);

        }catch(IOException ioe)
        {
            System.out.println("IOException: " + ioe.getMessage());
        }
    }
    public void communicate()
    {
        //The connection has been established - now send/recieve
        try
        {
            //Step 2 a
            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();

            //Step 2 b
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            //Step 3 a Communicate outwards
            String mess = "";
            String response = "";

            do{
                System.out.println("Please type in a string for the server: ");
                mess = keyIn.nextLine();
                //1
                out.writeObject(mess);
                //out.flush(;

                //Step 3 b Communicate receiving inwards
                //4
                response = (String)in.readObject();
                System.out.println("Server said>> " + response);

            }while(!response.equals("TERMINATE"));
            //Step 4: Close down
            out.close();
            in.close();
            server.close();

        }catch(IOException ioe)
        {
            System.out.println("IOException: " + ioe.getMessage());
        }catch(ClassNotFoundException cnfe)
        {
            System.out.println("ClassNotFoundException: " + cnfe.getMessage());
        }
    }*/

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }


    }
    public class MyPanel extends JPanel {
        private JButton btnAdd;
        private JButton btnSearch;
        private JTextField txtName;
        private JTextField txtCustomerEmail;
        private JButton btnClearSearch;
        private JButton btnMainMenu;
        private JButton btnUpdate;
        private JButton btnDelete;
        private JLabel lblCustomerEmeail;
        private JLabel lblPhoneNo;
        private JLabel lblTellEmail;
        private JLabel lblID;
        private JLabel lblCurrentDate;
        private JTextField txtPhoneNo;
        private JTextField txtTellerEmail;
        private JTextField txtID;
        private JTextField txtCurrentDate;
        private JLabel lblName;
        private JLabel lblSurname;
        private JTextField txtSurname;
        private JTextField txtSearch;
        private JTextArea jcomp6;
        DefaultTableModel dm21 = new DefaultTableModel();
        private JTable jt1;
        private JScrollPane jps1;

        Date d1;
        SimpleDateFormat s1;

        Connection con = null;
        Statement stmt = null;

        public MyPanel() {
            //String[] jListItems = {};
            Object[] columns = {"Date","Cust ID","Cust Name","Cust Surname","Cust Email","Cust Phone No","Teller Email"};
            dm21.setColumnIdentifiers(columns);
            //jt.setModel(dm2);

            String[][] data = {};
            jt1 = new JTable(data,columns)
            {
                public boolean isCellEditable(int data, int columns){
                    return false;
                }
            };
            jt1.setPreferredScrollableViewportSize(new Dimension(450, 63));
            jt1.setFillsViewportHeight(true);

            jps1 = new JScrollPane(jt1);
            jt1.setRowHeight(17);
            add (jps1);

            //construct components
            btnAdd = new JButton ("Add");
            btnSearch = new JButton ("Search");
            lblName = new JLabel ("Name:");
            lblSurname = new JLabel ("Surname:");
            txtSurname = new JTextField (5);
            txtCustomerEmail = new JTextField (5);
            jcomp6 = new JTextArea (5, 5);
            btnClearSearch = new JButton ("Clear Text");
            btnMainMenu = new JButton ("Main Menu");
            btnUpdate = new JButton ("Update");
            btnDelete = new JButton ("Delete");
            lblCustomerEmeail = new JLabel ("Email:");
            txtName = new JTextField (5);
            lblPhoneNo = new JLabel ("Phone No.:");
            lblTellEmail = new JLabel ("Teller Email:");
            lblID = new JLabel ("ID:");
            lblCurrentDate = new JLabel ("Date:");
            txtPhoneNo = new JTextField (5);
            txtTellerEmail = new JTextField (5);
            txtID = new JTextField (5);
            txtCurrentDate = new JTextField (5);
            txtCurrentDate.setEditable(false);

            //adjust size and set layout
            setPreferredSize (new Dimension (885, 510));
            setLayout (null);

            //add components
            add (btnAdd);
            add (btnSearch);
            add (lblName);
            add (lblSurname);
            add (txtSurname);
            add (txtCustomerEmail);
            add (jcomp6);
            add (btnClearSearch);
            add (btnMainMenu);
            add (btnUpdate);
            add (btnDelete);
            add (lblCustomerEmeail);
            add (txtName);
            add (lblPhoneNo);
            add (lblTellEmail);
            add (lblID);
            add (lblCurrentDate);
            add (txtPhoneNo);
            add (txtTellerEmail);
            add (txtID);
            add (txtCurrentDate);


            btnSearch.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
            /*Function f = new Function();
            ResultSet rs = null;
            String ln = "CustomerID";

            rs = f.find(txtID.getText());
            try{
                if(rs.next()){
                    txtCurrentDate.setText(rs.getString("Dates"));
                    txtID.setText(rs.getString("CustomerID"));
                    txtName.setText(rs.getString("CustomerName"));
                    txtSurname.setText(rs.getString("CustomerSurname"));
                    txtCustomerEmail.setText(rs.getString("CustomerEmail"));
                    txtPhoneNo.setText(rs.getString("CustomerPhoneNo"));
                    txtTellerEmail.setText(rs.getString("TellerEmail"));

                }else{
                    JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
                }
             //txtName.setText("");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }*/
                    String dbURL = "jdbc:ucanaccess://";
                    String filename = "C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\CustomerD.accdb";
                    dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
                    String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
                    //PreparedStatement preparedStatement;
                    try {
                        //String selectSQL = "Select * from CustomerD where CustomerID=?";
                        Connection con = DriverManager.getConnection(dbURL, "","");
                        String sql = "Select * from CustomerD where CustomerID = ?";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, txtID.getText());
                        //preparedStatement.setInt(1, 1001);
                        ResultSet rs = pst.executeQuery();

                        if(rs.next()){
                            txtCurrentDate.setText(rs.getString("Dates"));
                            txtID.setText(rs.getString("CustomerID"));
                            txtName.setText(rs.getString("CustomerName"));
                            txtSurname.setText(rs.getString("CustomerSurname"));
                            txtCustomerEmail.setText(rs.getString("CustomerEmail"));
                            txtPhoneNo.setText(rs.getString("CustomerPhoneNo"));
                            txtTellerEmail.setText(rs.getString("TellerEmail"));
                        }else{
                            JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "An era occurred while loding...");
                    }

                }

            });

            final Object[] row1 = new Object[7];

            btnAdd.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){

                    if(e.getSource() == btnAdd){

                        try
                        {
                            //theQuery("INSERT INTO  CustomerD Dates='"+txtCurrentDate.getText()+"',CustomerID='"+txtID.getText()+"',CustomerName='"+txtName.getText()+"',CustomerSurname='"+txtSurname.getText()+"',CustomerEmail='"+txtCustomerEmail.getText()+"',CustomerPhoneNo='"+txtPhoneNo.getText()+"',where TellerEmail='"+txtTellerEmail.getText());
                            String dbURL = "jdbc:ucanaccess://";
                            String filename = "C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\CustomerDetails.accdb";
                            dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
                            String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";

                            d1 = new Date();
                            s1 = new SimpleDateFormat("yyyy-MM-dd");
                            txtCurrentDate.setText(s1.format(d1));

                            String dates1 = txtCurrentDate.getText();
                            txtCurrentDate.setText(dates1);
                            String iD = txtID.getText();
                            txtID.setText(iD);
                            String name = txtName.getText();
                            txtName.setText(name);
                            String surname = txtSurname.getText();
                            txtSurname.setText(surname);
                            String email = txtCustomerEmail.getText();
                            txtCustomerEmail.setText(email);
                            String phoneNumber = txtPhoneNo.getText();
                            txtPhoneNo.setText(phoneNumber);
                            String tellerEmail = txtTellerEmail.getText();
                            txtTellerEmail.setText(email);

                            String create_Table_stmt="create table customerdetails (ID  INTEGER, Dates  VARCHAR(30), CustomerID VARCHAR(60), CustomerName  VARCHAR(30), CustomerSurname  VARCHAR(30), CustomerEmail  VARCHAR(30), CustomerPhoneNo VARCHAR(60), TellerEmail VARCHAR(60))";
                            String insert_Values_stmt="insert into customerdetails values   (1, '"+dates1+"', '"+iD+"', '"+name+"',  '"+surname+"', '"+email+"', '"+phoneNumber+"', '"+tellerEmail+"')";
                            String update_Values_stmt="UPDATE customerdetails SET Dates='"+dates1+"' CustomerID='"+iD+"' CustomerName='"+name+"'  CustomerSurname='"+surname+"'   CustomerEmail='"+email+"' CustomerPhoneNo='"+phoneNumber+"'  WHERE TellerEmail='"+tellerEmail+"'";
                            String retrieve_Values_qry="SELECT * FROM customerdetails";


                            System.out.println("About to Load the JDBC Driver....");
                            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                            //Class.forName(driverName);
                            System.out.println("Driver Loaded Successfully....");
                            System.out.println("About to get a connection....");
                            Connection con = DriverManager.getConnection(dbURL, "","");
                            System.out.println("Connection Established Successfully....");
                            // create a java.sql.Statement so we can run queries
                            System.out.println("Creating statement Object....");
                            Statement s = con.createStatement();
                            System.out.println("Statement object created Successfully....");

                            System.out.println("About to execute SQL stmt....");
                            s.executeUpdate(insert_Values_stmt); // execute the SQL statement
                            System.out.println("SQL stmt executed....");
                            ResultSet rs = s.executeQuery(retrieve_Values_qry); // select the data from the table

                            if (rs != null) // if rs == null, then there is no ResultSet to view
                                while ( rs.next() ) // this will step through our data row-by-row
                                {
                                    System.out.println("Data from column_name: "
                                            + rs.getString(1) + " "+rs.getString(2) );
                                }
                            System.out.println("SQL statement executed  Successfully....");

                            System.out.println("About to close Statement....");
                            s.close(); // close the Statement to let the database know we're done with it
                            con.close(); // close the Connection to let the database know we're done with it
                            System.out.println("Statement closed successfully....");

                            JOptionPane.showMessageDialog(null, "ADDED SUCCESFULLY");

                   /* txtCurrentDate.setText("");
                    txtID.setText("");
                    txtName.setText("");
                    txtSurname.setText("");
                    txtCustomerEmail.setText("");
                    txtPhoneNo.setText("");
                    txtTellerEmail.setText("");*/
                        }
                        catch (Exception ex)
                        {
                            System.out.println("An era occurred while loding...");
                        }
                        //table information
                        row1[0] = txtCurrentDate.getText();
                        row1[1] = txtID.getText();
                        row1[2] = txtName.getText();
                        row1[3] = txtSurname.getText();
                        row1[4] = txtCustomerEmail.getText();
                        row1[5] = txtPhoneNo.getText();
                        row1[6] = txtTellerEmail.getText();
                        jt1.setModel(dm21);
                        dm21.addRow(row1);

                    }
                }
            });

            btnClearSearch.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnClearSearch){
                        txtCurrentDate.setText("");
                        txtID.setText("");
                        txtName.setText("");
                        txtSurname.setText("");
                        txtCustomerEmail.setText("");
                        txtPhoneNo.setText("");
                        txtTellerEmail.setText("");
                    }
                }
            });

            btnMainMenu.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnMainMenu){
                        RegisterCustomer r = new RegisterCustomer();
                    }
                }
            });

            jt1.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    int i = jt1.getSelectedRow();
                    txtCurrentDate.setText(dm21.getValueAt(i, 0).toString());
                    txtID.setText(dm21.getValueAt(i, 1).toString());
                    txtName.setText(dm21.getValueAt(i, 2).toString());
                    txtSurname.setText(dm21.getValueAt(i, 3).toString());
                    txtCustomerEmail.setText(dm21.getValueAt(i, 4).toString());
                    txtPhoneNo.setText(dm21.getValueAt(i, 5).toString());
                    txtTellerEmail.setText(dm21.getValueAt(i, 6).toString());
                }
            });

            btnUpdate.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnUpdate){

                        //try{
                        //theQuery("INSERT INTO  CustomerD Dates='"+txtCurrentDate.getText()+"',CustomerID='"+txtID.getText()+"',CustomerName='"+txtName.getText()+"',CustomerSurname='"+txtSurname.getText()+"',CustomerEmail='"+txtCustomerEmail.getText()+"',CustomerPhoneNo='"+txtPhoneNo.getText()+"',where TellerEmail='"+txtTellerEmail.getText());

                        //String sql = "UPDATE CustomerD SET CustomerID='"+txtID.getText()+"' CustomerName='"+txtName.getText()+"'  CustomerSurname='"+txtSurname.getText()+"'   CustomerEmail='"+txtCustomerEmail.getText()+"' CustomerPhoneNo='"+txtPhoneNo.getText()+"' TellerEmail='"+txtTellerEmail.getText()+"'";
                        //con = DriverManager.getConnection(dbURL, "","");
                        //PreparedStatement pst = con.prepareStatement(sql);
                        //pst.execute();
                        //JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED");
                        //theQuery("Update CustomerD SET Dates='"+txtCurrentDate.getText()+"',CustomerID='"+txtID.getText()+"',CustomerName='"+txtName.getText()+"',CustomerSurname='"+txtSurname.getText()+"',CustomerEmail='"+txtCustomerEmail.getText()+"',CustomerPhoneNo='"+txtPhoneNo.getText()+"',where TellerEmail='"+txtTellerEmail.getText());

            /*int i = jt1.getSelectedRow();
            if(i>=0){

                dm21.setValueAt(txtCurrentDate.getText(), i, 0);
                dm21.setValueAt(txtID.getText(), i, 1);
                dm21.setValueAt(txtName.getText(), i, 2);
                dm21.setValueAt(txtSurname.getText(), i, 3);
                dm21.setValueAt(txtCustomerEmail.getText(), i, 4);
                dm21.setValueAt(txtPhoneNo.getText(), i, 5);
                dm21.setValueAt(txtTellerEmail.getText(), i, 6);
            }else{
                JOptionPane.showMessageDialog(null, "UPDATED");
            }
            }catch(Exception ex){

                JOptionPane.showMessageDialog(null, "UPDATE ERROR");
            }*/
                        String id = txtID.getText();
                        try {
                            String dbURL = "jdbc:ucanaccess://";
                            String filename = "C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\CustomerDetails.accdb";
                            dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
                            String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";

                            d1 = new Date();
                            s1 = new SimpleDateFormat("yyyy-MM-dd");
                            txtCurrentDate.setText(s1.format(d1));

                            String dates1 = txtCurrentDate.getText();
                            txtCurrentDate.setText(dates1);
                            String iD = txtID.getText();
                            txtID.setText(iD);
                            String name = txtName.getText();
                            txtName.setText(name);
                            String surname = txtSurname.getText();
                            txtSurname.setText(surname);
                            String email = txtCustomerEmail.getText();
                            txtCustomerEmail.setText(email);
                            String phoneNumber = txtPhoneNo.getText();
                            txtPhoneNo.setText(phoneNumber);
                            String tellerEmail = txtTellerEmail.getText();
                            txtTellerEmail.setText(email);

                            String create_Table_stmt="create table customerdetails (ID  INTEGER, Dates  VARCHAR(30), CustomerID VARCHAR(60), CustomerName  VARCHAR(30), CustomerSurname  VARCHAR(30), CustomerEmail  VARCHAR(30), CustomerPhoneNo VARCHAR(60), TellerEmail VARCHAR(60))";
                            String insert_Values_stmt="insert into customerdetails values   (1, '"+dates1+"', '"+iD+"', '"+name+"',  '"+surname+"', '"+email+"', '"+phoneNumber+"', '"+tellerEmail+"')";
                            String update_Values_stmt="update customerdetails set Dates='"+dates1+"' CustomerID='"+iD+"' CustomerName='"+name+"'  CustomerSurname='"+surname+"'   CustomerEmail='"+email+"' CustomerPhoneNo='"+phoneNumber+"' TellerEmail='"+tellerEmail+"' WHERE ID=1";
                            String retrieve_Values_qry="SELECT * FROM customerdetails";


                            System.out.println("About to Load the JDBC Driver....");
                            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                            //Class.forName(driverName);
                            System.out.println("Driver Loaded Successfully....");
                            System.out.println("About to get a connection....");
                            Connection con = DriverManager.getConnection(dbURL, "","");
                            System.out.println("Connection Established Successfully....");
                            // create a java.sql.Statement so we can run queries
                            System.out.println("Creating statement Object....");
                            Statement s = con.createStatement();
                            System.out.println("Statement object created Successfully....");

                            System.out.println("About to execute SQL stmt....");
                            String sql = "DELETE * FROM CustomerD WHERE CustomerID='"+id+"'";
                            con = DriverManager.getConnection(dbURL, "","");
                            PreparedStatement pst = con.prepareStatement(sql);
                            pst.executeUpdate();
                            s.executeUpdate(insert_Values_stmt); // execute the SQL statement
                            System.out.println("SQL stmt executed....");
                            ResultSet rs = s.executeQuery(retrieve_Values_qry); // select the data from the table

                            if (rs != null) // if rs == null, then there is no ResultSet to view
                                while ( rs.next() ) // this will step through our data row-by-row
                                {
                                    System.out.println("Data from column_name: "
                                            + rs.getString(1) + " "+rs.getString(2) );
                                }
                            System.out.println("SQL statement executed  Successfully....");

                            System.out.println("About to close Statement....");
                            s.close(); // close the Statement to let the database know we're done with it
                            con.close(); // close the Connection to let the database know we're done with it
                            System.out.println("Statement closed successfully....");

                            JOptionPane.showMessageDialog(null, "UPDATED SUCCESFULLY");

                            //String selectSQL = "Select * from CustomerD where CustomerID=?";
                            //Connection con = DriverManager.getConnection(dbURL, "","");

                   /* int row = jt1.getSelectedRow();
                    String value = (jt1.getModel().getValueAt(row, 0).toString());
                    String query = "Update CustomerD SET  Dates=?, CustomerID=?, CustomerName=?, CustomerSurname=?, CustomerEmail=?, CustomerPhoneNo=?, TellerEmail=? where ID="+value;
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, txtCurrentDate.getText());
                    pst.setString(2, txtID.getText());
                    pst.setString(3, txtName.getText());
                    pst.setString(4, txtSurname.getText());
                    pst.setString(5, txtCustomerEmail.getText());
                    pst.setString(6, txtPhoneNo.getText());
                    pst.setString(7, txtTellerEmail.getText());
                    pst.execute();
                    //DefaultTableModel model = (DefaultTableModel)jt1.getModel();
                    //dm21.setRowCount(0);
                    //Show.User();
                    JOptionPane.showMessageDialog(null, "INSERTED SUCCESSFULLY");*/
                            int i = jt1.getSelectedRow();
                            if(i>=0){

                                dm21.setValueAt(txtCurrentDate.getText(), i, 0);
                                dm21.setValueAt(txtID.getText(), i, 1);
                                dm21.setValueAt(txtName.getText(), i, 2);
                                dm21.setValueAt(txtSurname.getText(), i, 3);
                                dm21.setValueAt(txtCustomerEmail.getText(), i, 4);
                                dm21.setValueAt(txtPhoneNo.getText(), i, 5);
                                dm21.setValueAt(txtTellerEmail.getText(), i, 6);
                            }else{
                                JOptionPane.showMessageDialog(null, "PROCESS COMPLETED");

                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "An era occurred while loding...");
                        }
                    }
                }
            });

            btnDelete.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnDelete){
                        String dbURL = "jdbc:ucanaccess://";
                        String filename = "C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\CustomerDetails.accdb";
                        dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
                        String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
                        String id = txtID.getText();
                        try{
                            String sql = "DELETE * FROM CustomerDetails WHERE CustomerIDetails='"+id+"'";
                            con = DriverManager.getConnection(dbURL, "","");
                            PreparedStatement pst = con.prepareStatement(sql);
                            //pst.setString(1, sql);
                            //pst.setString(1, txtCurrentDate.getText());
                            //pst.setString(2, txtID.getText());
                    /*pst.setString(3, txtName.getText());
                    pst.setString(4, txtSurname.getText());
                    pst.setString(5, txtCustomerEmail.getText());
                    pst.setString(6, txtPhoneNo.getText());
                    pst.setString(7, txtTellerEmail.getText());*/
                            pst.executeUpdate();
                            //theQuery("DELETE FROM CustomerD where Dates='"+txtCurrentDate.getText()+"',CustomerID='"+txtID.getText()+"',CustomerName='"+txtName.getText()+"',CustomerSurname='"+txtSurname.getText()+"',CustomerEmail='"+txtCustomerEmail.getText()+"',CustomerPhoneNo='"+txtPhoneNo.getText()+"',where TellerEmail='"+txtTellerEmail.getText());

                            //JOptionPane.showMessageDialog(null, "SUCCESSFULLY DELETED");

                            int i = jt1.getSelectedRow();
                            if(i>=0){
                                dm21.removeRow(i);
                                JOptionPane.showMessageDialog(null, "DATA DELETED");
                            }else{
                                JOptionPane.showMessageDialog(null, "DELETE ERROR");
                            }
                        }catch(Exception ex){

                            JOptionPane.showMessageDialog(null, "DATA NOT DELETED");

                        }
                    }
                }
            });

            //set component bounds (only needed by Absolute Positioning)
            btnAdd.setBounds (15, 385, 100, 20);
            btnSearch.setBounds (15, 425, 100, 20);
            lblName.setBounds (15, 115, 100, 25);
            lblSurname.setBounds (10, 165, 100, 25);
            txtSurname.setBounds (135, 155, 100, 25);
            txtCustomerEmail.setBounds (135, 205, 100, 25);
            jps1.setBounds (240, 15, 625, 380);
            btnClearSearch.setBounds (120, 425, 100, 20);
            lblCustomerEmeail.setBounds (10, 210, 100, 25);
            txtName.setBounds (135, 105, 100, 25);
            lblPhoneNo.setBounds (10, 265, 100, 25);
            lblTellEmail.setBounds (10, 320, 100, 25);
            lblID.setBounds (15, 70, 100, 25);
            lblCurrentDate.setBounds (15, 10, 100, 25);
            txtPhoneNo.setBounds (135, 260, 100, 25);
            txtTellerEmail.setBounds (135, 310, 100, 25);
            txtID.setBounds (135, 60, 100, 25);
            txtCurrentDate.setBounds (135, 15, 100, 25);
            btnMainMenu.setBounds (120, 385, 100, 20);
            btnUpdate.setBounds (15, 455, 100, 20);
            btnDelete.setBounds (120, 455, 100, 20);
        }
  /* public ArrayList<Customer> getUsersList(){
       ArrayList<Customer> usersList = new ArrayList<Customer>();
       String dbURL = "jdbc:ucanaccess://";
       String filename = "C:\\Users\\phumelela\\Desktop\\ADPProject1\\src\\adpproject1\\CustomerD.accdb";
       dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
       String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
       String query = "SELECT * FROM 'CustomerD'";
       Statement st;
       ResultSet rs;
       try{
       Connection con = DriverManager.getConnection(dbURL, "","");
       st = con.createStatement();
       rs = st.executeQuery(query);
       Customer customer;
       while(rs.next()){
           customer = new Customer(rs.getString("Dates"),rs.getString("CustomerD"),rs.getString("CustomerName"),rs.getString("CustomerSurname"),rs.getString("CustomerEmail"),rs.getString("CustomerPhoneNo"),rs.getString("TellerEmail"));
           usersList.add(customer);
       }
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "ERROR OCCURRED!");
       }
       return usersList;
      }

    public void Show_User_In_Table(){
    ArrayList<Customer> list = getUsersList();
    Object[] row = new Object[7];
    for(int i=0;i<list.size();i++){
    row[0] = list.get(i).getCurrentDate();
    row[1] = list.get(i).getID();
    row[2] = list.get(i).getName();
    row[3] = list.get(i).getSurame();
    row[4] = list.get(i).getCustomerEmail();
    row[5] = list.get(i).getPhoneNo();
    row[6] = list.get(i).getTellerEmail();
    dm21.addRow(row);
    }
   }

   public void executeSQLQuery(String query, String message){
   String dbURL = "jdbc:ucanaccess://";
   String filename = "C:\\Users\\phumelela\\Desktop\\ADPProject1\\src\\adpproject1\\CustomerD.accdb";
   dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
   String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
   Statement st;
   try{
   Connection con = DriverManager.getConnection(dbURL, "","");
   st = con.createStatement();
   if(st.executeUpdate(query)==1){
   JOptionPane.showMessageDialog(null, "DATA "+message+" SUCCESFULLY");
   }else{
       JOptionPane.showMessageDialog(null, "DATA NOT"+message);
   }

   }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "DATA FAILURE");
   }

  }
   /* public class Function{
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        public ResultSet find(String s){
            try{
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\phumelela\\Desktop\\ADPProject1\\src\\adpproject1\\CustomerD.accdb");
            ps = con.prepareStatement("Select * from CustomerD where CustomerID = ?");
            ps.setString(1, s);
            rs = ps.executeQuery();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return rs;
        }

    }*/

    /*public void theQuery(String query){
     String dbURL = "jdbc:ucanaccess://";
     String filename = "C:\\Users\\phumelela\\Desktop\\ADPProject1\\src\\adpproject1\\CustomerD.accdb";
     dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
     String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
    try{

        con = DriverManager.getConnection(dbURL, "","");
        stmt = con.createStatement();
        stmt.executeUpdate(query);

        JOptionPane.showMessageDialog(null, "QUERY EXECUTED");

    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "ERROR OCCURRED");
    }
    }*/


    }

    public class PaymentSlip extends JPanel implements ActionListener {
        private JButton btnOnScreenDisplay;
        private JButton btnDisplaySlip;
        private JLabel lblFashion;
        private JLabel lblFabric;
        private JLabel lblButtons;
        private JLabel lblGender;
        private JRadioButton rdbMale;
        private JRadioButton rdbFemale;
        private JComboBox cmbItemPrices;
        private JLabel lblFinalPrice;
        private JLabel lblDeposit;
        private JTextField txtFabricMeter;
        private JTextField txtNoButtons;
        //private JComboBox cmbGarments;
        private JTextField txtFinalPrice;
        private JTextField txtDeposite;
        private JLabel lblStandardPrice;
        private JTextField txtBasePrice;
        private JTextField txtItemPrice;
        private JTextField txtCurrentDate;
        private ButtonGroup rbnGroup;
        private JLabel lbl1;
        private JLabel lbl2;
        private JLabel lbl3;
        private JButton lblName;
        DefaultTableModel dm2 = new DefaultTableModel();
        //private JList jList = new JList(dm2);
        private JTable jt;
        private JScrollPane jps;
        //FashionDesign fd;
        Date d1;
        SimpleDateFormat s1;
        //ArrayList<FashionDesign> fList = new ArrayList<FashionDesign>();

        Connection con = null;
        Statement stmt = null;

        public PaymentSlip() {
            //construct preComponents
            String[] cmbItemPricesItems = {};
            //String[] jListItems = {};
            Object[] columns = {"Date", "Fabric Meter Price", "Accessories Price", "Standard Charge", "Garment(s)", "Cost Of Item", "Final Price", "Deposit"};
            dm2.setColumnIdentifiers(columns);
            //jt.setModel(dm2);

            String[][] data = {};
            jt = new JTable(data,columns)
            {
                public boolean isCellEditable(int data, int columns){
                    return false;
                }
            };
       /* public Component prepareRender(TableCellRender r, int data, int columns){
        	Component c super.prepareRender(r, data, columns);
        	if(data % 2 == 0)
        		c.setBackground(Color.WHITE);
        		else
        			c.setBackground(Color.LIGHT_GREY);
        			if(isCellSelected(data, columns))
        				c.setBackground(Color.BLACK);
        				return c;

        }*/
            jt.setPreferredScrollableViewportSize(new Dimension(450, 63));
            jt.setFillsViewportHeight(true);

            jps = new JScrollPane(jt);
            //jt.setBackground(Color.white);
            //jt.setForeground(Color.black);
            //Font font = new Font("",1,12);
            //jt.setFont(font);
            jt.setRowHeight(17);
            add (jps);
            //construct components
            btnOnScreenDisplay = new JButton ("Add Data");
            btnDisplaySlip = new JButton ("Calculate");
            lblFashion = new JLabel ("Current date:");
            lblFabric = new JLabel ("Fabric(s) meter(s) price:");
            lblButtons = new JLabel ("No. of accessorie(s) price (& extras):");
            lblGender = new JLabel ("Gender:");
            rdbMale = new JRadioButton ("Male");
            rdbFemale = new JRadioButton ("Female");
            cmbItemPrices = new JComboBox (cmbItemPricesItems);
            lblFinalPrice = new JLabel ("Final price:");
            lblDeposit = new JLabel ("Deposit price(half of final):");
            lbl1 = new JLabel ("");
            lbl2 = new JLabel ("");
            lbl3 = new JLabel ("");
            txtFabricMeter = new JTextField (5);
            txtNoButtons = new JTextField (5);
            txtFinalPrice = new JTextField (5);
            txtDeposite = new JTextField (5);
            lblStandardPrice = new JLabel ("Standard charge price:");
            lblName = new JButton("Main Menu");
            txtBasePrice = new JTextField (5);
            txtItemPrice = new JTextField (5);
            txtCurrentDate = new JTextField (5);
            rbnGroup = new ButtonGroup();
            //jList = new JList(jListItems);

            //adjust size and set layout
            setPreferredSize (new Dimension (885, 510));
            setLayout (null);

            //add components
            add (btnOnScreenDisplay);
            add (btnDisplaySlip);
            add (lblFashion);
            add (lblFabric);
            add (lblButtons);
            add (lblGender);
            add (lbl1);
            add (lbl2);
            add (lbl3);
            add (rdbMale);
            add (rdbFemale);
            add (cmbItemPrices);
            add (lblFinalPrice);
            add (lblDeposit);
            add (txtFabricMeter);
            add (txtNoButtons);
            //add (cmbGarments);
            add (txtFinalPrice);
            txtFinalPrice.setEditable(false);
            add (txtDeposite);
            txtDeposite.setEditable(false);
            add (lblStandardPrice);
            add (txtBasePrice);
            //txtBasePrice.setEditable(false);
            add (txtItemPrice);
            txtItemPrice.setEditable(false);
            add (txtCurrentDate);
            txtCurrentDate.setEditable(false);
            rbnGroup.add(rdbMale);
            rbnGroup.add(rdbFemale);
            //add (jps);
            add(lblName);

            //adding items for a gender selected:
            rdbMale.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getSource()==rdbMale){
                        cmbItemPrices.removeAllItems();
                        cmbItemPrices.addItem("Male Selection");
                        cmbItemPrices.addItem("Wedding garment");
                        cmbItemPrices.addItem("Traditional attire");
                        cmbItemPrices.addItem("Formal wear");
                        cmbItemPrices.addItem("Casual wear");
                        cmbItemPrices.addItem("Church clothes");
                        cmbItemPrices.addItem("Shirt");
                        cmbItemPrices.addItem("Jeans");
                        cmbItemPrices.addItem("Top");
                        cmbItemPrices.addItem("Pants");
                        cmbItemPrices.addItem("Jacket");

                    }
                }

            });

            rdbFemale.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getSource()==rdbFemale){
                        cmbItemPrices.removeAllItems();
                        cmbItemPrices.addItem("Female Selection");
                        cmbItemPrices.addItem("Wedding garment");
                        cmbItemPrices.addItem("Traditional attire");
                        cmbItemPrices.addItem("Formal wear");
                        cmbItemPrices.addItem("Casual wear");
                        cmbItemPrices.addItem("Church clothes");
                        cmbItemPrices.addItem("Top");
                        cmbItemPrices.addItem("Jeans");
                        cmbItemPrices.addItem("Skirt");
                        cmbItemPrices.addItem("Blouse");
                        cmbItemPrices.addItem("Shorts");
                        cmbItemPrices.addItem("Dress");
                        cmbItemPrices.addItem("Pants");
                        cmbItemPrices.addItem("Jacket");

                    }
                }

            });

            cmbItemPrices.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getSource()==cmbItemPrices){
                        if(cmbItemPrices.getSelectedItem().equals("Wedding garment")){
                            txtItemPrice.setText("1500.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Traditional attire")){
                            txtItemPrice.setText("1000.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Formal wear")){
                            txtItemPrice.setText("1100.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Casual wear")){
                            txtItemPrice.setText("700.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Top")){
                            txtItemPrice.setText("100.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Jeans")){
                            txtItemPrice.setText("300.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Skirt")){
                            txtItemPrice.setText("200.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Shirt")){
                            txtItemPrice.setText("150.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Blouse")){
                            txtItemPrice.setText("250.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Shorts")){
                            txtItemPrice.setText("250.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Dress")){
                            txtItemPrice.setText("150.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Pants")){
                            txtItemPrice.setText("350.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Jacket")){
                            txtItemPrice.setText("4500.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Church clothes")){
                            txtItemPrice.setText("500.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Wedding garment")){
                            txtItemPrice.setText("1500.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Traditional attire")){
                            txtItemPrice.setText("1000.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Formal wear")){
                            txtItemPrice.setText("1100.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Casual wear")){
                            txtItemPrice.setText("700.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Top")){
                            txtItemPrice.setText("100.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Jeans")){
                            txtItemPrice.setText("300.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Skirt")){
                            txtItemPrice.setText("200.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Shirt")){
                            txtItemPrice.setText("150.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Blouse")){
                            txtItemPrice.setText("250.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Shorts")){
                            txtItemPrice.setText("250.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Dress")){
                            txtItemPrice.setText("150.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Pants")){
                            txtItemPrice.setText("350.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Jacket")){
                            txtItemPrice.setText("4500.00");
                        }else if(cmbItemPrices.getSelectedItem().equals("Church clothes")){
                            txtItemPrice.setText("500.00");
                        }

                    }
                }

            });

            final Object[] row = new Object[8];
            //adding display buttons:
            btnOnScreenDisplay.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ie){
                    if(ie.getSource() == btnOnScreenDisplay){
                        try{
                            d1 = new Date();
                            s1 = new SimpleDateFormat("yyyy-MM-dd");
                            txtCurrentDate.setText(s1.format(d1));

                            String dates1 = txtCurrentDate.getText();
                            txtCurrentDate.setText(dates1);
                            double fabricMeters1 = Double.parseDouble(txtFabricMeter.getText());
                            txtFabricMeter.setText(Double.toString(fabricMeters1));
                            double buttonPrices1 = Double.parseDouble(txtNoButtons.getText());
                            txtNoButtons.setText(Double.toString(buttonPrices1));
                            double standardCharges1 = Double.parseDouble(txtBasePrice.getText());
                            txtBasePrice.setText(Double.toString(standardCharges1));
                            int abCategory = 0;
                            cmbItemPrices.setSelectedItem(Integer.toString(abCategory));
                            switch (cmbItemPrices.getSelectedIndex()){
                                case 0:
                                    abCategory = 0;
                                    break;

                                case 1:
                                    abCategory = 1;
                                    break;

                                case 2:
                                    abCategory = 2;
                                    break;

                                case 3:
                                    abCategory = 3;
                                    break;

                                case 4:
                                    abCategory = 4;
                                    break;

                                case 5:
                                    abCategory = 5;
                                    break;

                                case 6:
                                    abCategory = 6;
                                    break;

                                case 7:
                                    abCategory = 7;
                                    break;

                                case 8:
                                    abCategory = 8;
                                    break;

                                case 9:
                                    abCategory = 9;
                                    break;

                                case 10:
                                    abCategory = 10;
                                    break;

                                case 11:
                                    abCategory = 11;
                                    break;

                                case 12:
                                    abCategory = 12;
                                    break;

                                case 13:
                                    abCategory = 13;
                                    break;

                                default:
                                    break;

                            }
                            if(abCategory == 2){
                                abCategory = 3;
                            }

                            double pOfItems1 = Double.parseDouble(txtItemPrice.getText());
                            txtItemPrice.setText(Double.toString(pOfItems1));
                            double total = fabricMeters1 + buttonPrices1 + standardCharges1 + pOfItems1;
                            txtFinalPrice.setText("" + total);
                            double dHalf = total / 2;
                            txtDeposite.setText("" + dHalf);
                            double fPrices1 = Double.parseDouble(txtFinalPrice.getText());
                            txtFinalPrice.setText(Double.toString(fPrices1));
                            double dPrices1 = Double.parseDouble(txtDeposite.getText());
                            txtDeposite.setText(Double.toString(dPrices1));

                            String dbURL = "jdbc:ucanaccess://";
                            String filename = "C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\CustomMade.accdb";
                            dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";
                            String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";


                            //String name = txtName.getText();

                            //String surname = txtSurname.getText();

                            String create_Table_stmt="create table CustomMade (ID  INTEGER, Dates  VARCHAR(30), FabricMeterPrice  FLOAT, AccessoriesPrices  FLOAT, StandardCharge FLOAT, GarmentName VARCHAR(60), ItemPrice FLOAT, FinalPrice FLOAT, Deposite FLOAT)";
                            String insert_Values_stmt="insert into CustomMade values   (1, '"+dates1+"','"+fabricMeters1+"',  '"+buttonPrices1+"', '"+standardCharges1+"', '"+abCategory+"', '"+pOfItems1+"', '"+fPrices1+"', '"+dPrices1+"')";
                            String update_Values_stmt="UPDATE CustomMade SET Dates='"+dates1+"'  FabricMeterPrice='"+fabricMeters1+"'   AccessoriesPrices='"+buttonPrices1+"'  StandardCharge='"+standardCharges1+"'  GarmentName= '"+abCategory+"' ItemPrice='"+pOfItems1+"'  FinalPrice='"+fPrices1+"'  WHERE Deposite='"+dPrices1+"'";
                            String retrieve_Values_qry="SELECT * FROM CustomMade";


                            System.out.println("About to Load the JDBC Driver....");
                            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                            //Class.forName(driverName);
                            System.out.println("Driver Loaded Successfully....");
                            System.out.println("About to get a connection....");
                            Connection con = DriverManager.getConnection(dbURL, "","");
                            System.out.println("Connection Established Successfully....");
                            // create a java.sql.Statement so we can run queries
                            System.out.println("Creating statement Object....");
                            Statement s = con.createStatement();
                            System.out.println("Statement object created Successfully....");

                            System.out.println("About to execute SQL stmt....");
                            s.executeUpdate(insert_Values_stmt); // execute the SQL statement
                            System.out.println("SQL stmt executed....");
                            ResultSet rs = s.executeQuery(retrieve_Values_qry); // select the data from the table

                            if (rs != null) // if rs == null, then there is no ResultSet to view
                                while ( rs.next() ) // this will step through our data row-by-row
                                {
                                    System.out.println("Data from column_name: "
                                            + rs.getString(1) + " "+rs.getString(2) );
                                }
                            System.out.println("SQL statement executed  Successfully....");

                            System.out.println("About to close Statement....");
                            s.close(); // close the Statement to let the database know we're done with it
                            con.close(); // close the Connection to let the database know we're done with it
                            System.out.println("Statement closed successfully....");


                            //fd = new FashionDesign(dates1, fabricMeters1, buttonPrices1, standardCharges1, abCategory, pOfItems1, fPrices1, dPrices1);
                            //ArrayList<>:
                            //fList.add(fd);
                            row[0] = txtCurrentDate.getText();
                            row[1] = Double.parseDouble(txtFabricMeter.getText());
                            row[2] = Double.parseDouble(txtNoButtons.getText());
                            row[3] = Double.parseDouble(txtBasePrice.getText());
                            row[4] = cmbItemPrices.getSelectedItem();
                            row[5] = txtItemPrice.getText();
                            row[6] = txtFinalPrice.getText();
                            row[7] = txtDeposite.getText();
                            //jList table:
                            jt.setModel(dm2);

                            //if(fList.size() <= 10){
                            //dm2.addElement(String.format("%-5s  %-5s   %-5s   %-5s   %-5s   %-5s   %-5s   %-5s", "Date","Fabric Meter","Button Price","Base Charge","Garments","PricesOfItems","FinalPrice","Deposit\n"));
                            dm2.addRow(row);
                            //System.out.println(dm2.toString());
                            //}else{
                            //    JOptionPane.showMessageDialog(null, "display list is full");
                            //}
                            //jList.getModel().toString();

                            txtBasePrice.setText("");
                            txtItemPrice.setText("");
                            txtFabricMeter.setText("");
                            txtNoButtons.setText("");
                            txtFinalPrice.setText("");
                            txtDeposite.setText("");
                        }catch(Exception ex){

                            System.out.println("An era occurred while loading...");
                        }
                    }

                }
            });


            btnDisplaySlip.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnDisplaySlip){
                        d1 = new Date();
                        s1 = new SimpleDateFormat("yyyy-MM-dd");
                        txtCurrentDate.setText(s1.format(d1));

                        String dates1 = txtCurrentDate.getText();
                        double fabricMeters1 = Double.parseDouble(txtFabricMeter.getText());
                        double buttonPrices1 = Double.parseDouble(txtNoButtons.getText());
                        double standardCharges1 = Double.parseDouble(txtBasePrice.getText());
                        int abCategory = 0;
                        switch (cmbItemPrices.getSelectedIndex()){
                            case 0:
                                abCategory = 0;
                                break;

                            case 1:
                                abCategory = 1;
                                break;

                            case 2:
                                abCategory = 2;
                                break;

                            case 3:
                                abCategory = 3;
                                break;

                            case 4:
                                abCategory = 4;
                                break;

                            case 5:
                                abCategory = 5;
                                break;

                            case 6:
                                abCategory = 6;
                                break;

                            case 7:
                                abCategory = 7;
                                break;

                            case 8:
                                abCategory = 8;
                                break;

                            case 9:
                                abCategory = 9;
                                break;

                            case 10:
                                abCategory = 10;
                                break;

                            case 11:
                                abCategory = 11;
                                break;

                            case 12:
                                abCategory = 12;
                                break;

                            case 13:
                                abCategory = 13;
                                break;

                            default:
                                break;

                        }
                        if(abCategory == 2){
                            abCategory = 3;
                        }

                        double pOfItems1 = Double.parseDouble(txtItemPrice.getText());
                        double total = fabricMeters1 + buttonPrices1 + standardCharges1 + pOfItems1;
                        txtFinalPrice.setText("" + total);
                        double dHalf = total / 2;
                        txtDeposite.setText("" + dHalf);

                    }

                }
            });

            lblName.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == lblName){
                        RegisterCustomer r = new RegisterCustomer();
                    }
                }
            });

            //set component bounds (only needed by Absolute Positioning)
            btnDisplaySlip.setBounds (20, 375, 140, 25);
            btnOnScreenDisplay.setBounds (20, 420, 140, 25);
            lblFashion.setBounds (20, 5, 190, 50);
            lblFabric.setBounds (20, 55, 210, 25);
            lblButtons.setBounds (20, 95, 210, 25);
            lblGender.setBounds (170, 165, 100, 25);
            rdbMale.setBounds (15, 195, 100, 25);
            rdbFemale.setBounds (255, 195, 70, 25);
            cmbItemPrices.setBounds (20, 240, 160, 25);
            lblFinalPrice.setBounds (20, 285, 100, 25);
            lblDeposit.setBounds (20, 330, 150, 25);
            txtFabricMeter.setBounds (255, 55, 70, 25);
            txtNoButtons.setBounds (255, 95, 70, 25);
            txtItemPrice.setBounds (255, 235, 70, 25);
            txtFinalPrice.setBounds (255, 275, 70, 25);
            txtDeposite.setBounds (255, 320, 70, 25);
            lblStandardPrice.setBounds (20, 135, 140, 25);
            txtBasePrice.setBounds (255, 135, 70, 25);
            jps.setBounds (326,  45, 570, 420);
            txtCurrentDate.setBounds (255, 10, 115, 25);
            lbl1.setBounds (255, 10, 115, 65);
            lbl2.setBounds (255, 10, 115, 150);
            lbl3.setBounds (255, 10, 115, 230);
            lblName.setBounds (20, 460, 140, 25);

            txtFabricMeter.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try{
                        double i = Double.parseDouble(txtFabricMeter.getText());
                        lbl1.setText("");

                    }catch(NumberFormatException e1){
                        lbl1.setText("Invalid amount");

                    }
                }});

            txtNoButtons.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try{
                        double i = Double.parseDouble(txtNoButtons.getText());
                        lbl2.setText("");

                    }catch(NumberFormatException e1){
                        lbl2.setText("Invalid amount");

                    }
                }});

            txtBasePrice.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try{
                        double i = Double.parseDouble(txtBasePrice.getText());
                        lbl3.setText("");

                    }catch(NumberFormatException e1){
                        lbl3.setText("Invalid amount");

                    }
                }});

        }



        //The open, read, write and close buffer and file readers:


        //____________________________________________________________________________
        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }




    public RegisterCustomer() {

        super ("Main menu");

        lblContentLoading = new JLabel ("EAGLES GROOMING TILL APP'S CONTENT LOADING...");
        lblContentLoading.setText("EAGLES GROOMING TILL APP'S CONTENT LOADING...");
        lblContentLoading.setBounds(165, 100, 400, 60);
        photo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\images (8).jpg"));
        photo.setBounds(150, 140, 1000, 250);
        btnReadyMade = new JButton ("Loading Ready Made");
        //add(btnReadyMade);

       /* btnReadyMade.addActionListener(new ActionListener(){

        	public void actionPerformed(ActionEvent e){
                    if(e.getSource() == btnReadyMade){
                new Prac9();
                JFrame  frame = new JFrame ("Main menu");
                frame.setBounds(100, 150, 800, 573);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Prac9());
                frame.pack();
                frame.setVisible(true);
                new RegisterCustomer().setVisible(false);
                    }
        	}
       	});*/


        btnReadyMade.setBounds(200, 205, 440, 90);
        add(photo);
        add(lblContentLoading);
        //String[] cmbClothingItems = {};
        //construct preComponents
        menuBar = new JMenuBar();
        addMenu = new JMenu("Add Details");
        deleteMenu = new JMenu("Add Orders");
        sorted_list_of_moviesMenu = new JMenu("Sorted list of movies");
        sorted_list_of_available_moviesMenu = new JMenu("Sorted list of available movies");
        sorted_list_of_customerMenu = new JMenu("Sorted list of customer");
        list_movies_that_start_with__Menu = new JMenu("List movies that start with..");
        rent_movieMenu = new JMenu("Rent Movie");
        exitMenu = new JMenu("Exit");
        // exitMenu = setMnemonic(KeyEvent.VK_X);

        StockTaking = new JMenuItem("Stock Taking");
        customerItem = new JMenuItem("Customer Details");
        customerItem1 = new JMenuItem("Types of Orders");
        movieItem2 = new JMenuItem("Movie");
        openSortedMoviesItem = new JMenuItem("View sorted list of movies");
        openAvailableMoviesItem = new JMenuItem("View available movies");
        openSortedCustomerItem = new JMenuItem("View sorted customer list");
        openMoviesThatStartWithItem = new JMenuItem("View movies that start with...");
        openRentMovieItem = new JMenuItem("Rent a movie");
        openExitItem = new JMenuItem("Exit program");


        menuBar.add(addMenu);
        menuBar.add(deleteMenu);
        menuBar.add(sorted_list_of_moviesMenu);
        menuBar.add(sorted_list_of_available_moviesMenu);
        menuBar.add(sorted_list_of_customerMenu);
        menuBar.add(list_movies_that_start_with__Menu);
        menuBar.add(rent_movieMenu);
        menuBar.add(exitMenu);

        addMenu.add(StockTaking);
        addMenu.add(customerItem);
        deleteMenu.add(customerItem1);
        deleteMenu.add(movieItem2);
        menuBar.add(exitMenu);
        sorted_list_of_moviesMenu.add(openSortedMoviesItem);
        sorted_list_of_available_moviesMenu.add(openAvailableMoviesItem);
        sorted_list_of_customerMenu.add(openSortedCustomerItem);
        list_movies_that_start_with__Menu.add(openMoviesThatStartWithItem);
        rent_movieMenu.add(openRentMovieItem);
        exitMenu.add(openExitItem);

        this.setJMenuBar(menuBar);

        StockTaking.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //CustomerForm customerForm = new CustomerForm();
                /*d1 = new Date();
                s1 = new SimpleDateFormat("yyyy-MM-dd");
                txtCurrentDate.setText(s1.format(d1));*/
                JFrame  frame = new JFrame ("Ready made item orders");
                frame.setBounds(100, 150, 800, 573);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Prac9());
                frame.pack();
                frame.setVisible(true);

                //ServerApp prac = new ServerApp();
                //while
                // prac.processClient();


            }

        });

        customerItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //DvdForm dvdForm = new DvdForm();
                JFrame  frame = new JFrame ("Main menu");
                frame.setBounds(100, 150, 800, 573);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new MyPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });

        customerItem1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                JFrame  frame = new JFrame ("Customized item orders");
                frame.setBounds(100, 150, 800, 573);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new PaymentSlip());
                frame.pack();
                frame.setVisible(true);

            }
        });

        movieItem2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //DeleteDvdForm dvdForm5 = new DeleteDvdForm();
            }
        });
        //SORTED MOVIES
        openSortedMoviesItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //SortedMovieList sortedMovie2 = new SortedMovieList();
            }
        });

        //AVAILABLE MOVIES
        openAvailableMoviesItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //AvailableSortedListMovies availableMovie2 = new AvailableSortedListMovies();
            }
        });
        //CUSTOMER LIST
        openSortedCustomerItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //SortedListOfCustomer customer2 = new SortedListOfCustomer();
            }
        });
        //MOVIES THAT START WITH...

        openMoviesThatStartWithItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //ListMoviesThatStartWith moviesThatStartWith2 = new ListMoviesThatStartWith();
            }
        });
        //RENT MOVIE
        openRentMovieItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                //RentMovie rentmovie4 = new RentMovie();
            }
        });

        //EXITS THE PROGRAM
        openExitItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                if (e.getSource().equals(openExitItem)){
                    System.exit(0);
                }


            }
        });

        //adjust size and set layout
       /* setPreferredSize (new Dimension (1800, 1000));
        setLayout (null);

        setSize(900, 600);
        setLocation(15, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/
        //adjust size and set layout
        setPreferredSize (new Dimension (845, 573));
        setLayout (null);

        setSize(900, 600);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }



    public static void main (String[] args) {
        JFrame  frame = new JFrame ("Main menu");
        new RegisterCustomer();

        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add (new RegisterCustomer());
        // frame.pack();
        //frame.setVisible (true);

    }

}
