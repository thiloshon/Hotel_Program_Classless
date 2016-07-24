import java.io.*;
import java.util.Scanner;

/**
 * Created by Thiloshon on 25-Apr-16.
 * Base Template from SDP 1 CW 2.
 * Later altered as to exclude Object Oriented Concepts.
 * This Class Deals with all the Interface Inputs and Interface Outputs.
 * Methods: welcomePage, start, modules, viewModules, addNewModules
 */
public class Interface {

    Scanner sc = new Scanner(System.in);
    String [] names = new String[10];
    String [] iD = new String[10];


    /**
     * The First output. Welcome page.
     */
    public void run() {


        //loadData(); // First load of data
        loadData();

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM ------------------------- THE HOTEL PROGRAM --------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                  WELCOME TO THE HOTEL PROGRAM");
        System.out.println("");

        start();

    }


    /**
     * The First Menu. Other methods calls this method often since this is the primary menu.
     */
    public void start() {

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choose your option:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("A Add New Customer To A Room");
        System.out.println("V View All Rooms");
        System.out.println("E View Empty Rooms");
        System.out.println("D Delete Customer From Room");
        System.out.println("F Find Room From Customer Name");
        System.out.println("S Store Program Array Data Into A Plain Text File");
        System.out.println("L Load Program Data Back From The File Into The Array");
        System.out.println("O View Rooms Ordered Alphabetically By Name");
        System.out.println("");

        String option;

        do {
            while (!sc.hasNextLine()) {
                System.out.println("Please Choose A Letter:");
                sc.next();
            }
            option = sc.nextLine();
            option=option.toUpperCase();

            if (!(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("V") ||option.equalsIgnoreCase("E") ||option.equalsIgnoreCase("D") ||option.equalsIgnoreCase("F") ||option.equalsIgnoreCase("S") ||option.equalsIgnoreCase("L") ||option.equalsIgnoreCase("O") )) {
                System.out.println("Please Choose Your Option Among The Letters Given Above:");
            }
        } while (!(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("V") ||option.equalsIgnoreCase("E") ||option.equalsIgnoreCase("D") ||option.equalsIgnoreCase("F") ||option.equalsIgnoreCase("S") ||option.equalsIgnoreCase("L") ||option.equalsIgnoreCase("O") ));


        switch (option) {
            case "A":
                addNewCustomer();
                break;
            case "V":
                viewRooms();
                break;
            case "E":
                displayEmptyRooms();
                break;
            case "D":
                deleteCustomer();
                break;
            case "F":
                findRoomFromName();
                break;
            case "S":
                saveData();
                break;
            case "L":
                loadData();
                break;


        }
    }





    /**
     * The Modules Menu. Has all the required functions of modules.
     */
    public void findRoomFromName() {
        System.out.println("Customer name Please: ");
        String name= sc.nextLine();

        for (int x=0; x<names.length; x++){
            if (names[x].equalsIgnoreCase(name)){
                System.out.println("The Room is " + (x+1) );
            }
        }



        start();

    }





    /**
     * Method to add new Student.
     */
    public void addNewCustomer() {

        System.out.println("Room Number Please: ");
        String roomNumber = sc.nextLine();

        System.out.println("Customer Name Please: ");
        String customerName = sc.nextLine();

        System.out.println("Customer ID Please: ");
        String customerID = sc.nextLine();

        names[ Integer.parseInt(roomNumber)-1]= customerName;
        iD[ Integer.parseInt(roomNumber)-1]= customerID;

        System.out.println(customerName + " of ID " + customerID+ " was added to room " + roomNumber);

        start();







    }


    /**
     * This method adds marks of the students.
     */
    public void viewRooms(){

        for (int x=0; x<names.length; x++){
            if (names[x]==null||names[x].equalsIgnoreCase("empty")||names[x].equalsIgnoreCase("null")){
                System.out.println("The Room " + (x+1) + " is Empty");
            }else {
                System.out.println("The Room " + (x+1) + " is Rented to " + names[x] + " of ID " + iD[x]);
            }
        }

        System.out.println("End of Record");

        start();

    }


    /**
     * This method gives the award of the student queried.
     */
    public void deleteCustomer() {
        System.out.println("Enter Room ID: ");
        String roomID = sc.nextLine();

        names[Integer.parseInt(roomID)]="Empty";
        System.out.println("Customer Deleted ");

        start();

    }


    /**
     * The method prints all the students enrolled.
     */
    public void displayEmptyRooms() {


        for (int x=0; x<names.length; x++){
            if (names[x]==null||names[x].equalsIgnoreCase("empty")||names[x].equalsIgnoreCase("null")){
                System.out.println("The Room " + (x+1) + " is Empty");
            }
        }

        System.out.println("End of Record");

        start();

    }


    /**
     * This method loads all the data from files.
     */
    public void loadData() {

        File file = new File("Data.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int x=0;
            while((line=br.readLine())!= null){



                String [] array = line.split("\\t");
                /*for(String st :array){
                    System.out.println(st);
                }*/

                names[x]=array[1];
                iD[x]=array[2];

                x++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Data Loading Terminated");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Data Loading Terminated");
        }
        System.out.println("Data Loaded Successfully");
        start();




    }


    /**
     * This method saves all the data to file.
     */
    public void saveData() {


        PrintWriter writer = null;
        try {
            writer = new PrintWriter("Data.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Doesn't Exist");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        for  (int x =0; x<names.length; x++){
            writer.print(x + ") \t");
            writer.print(names[x]);
            writer.print("\t" + iD[x]);
            writer.println("");
        }

        writer.flush();
        writer.close();


        System.out.println("Data Saved Successfully");

        start();


    }

}
