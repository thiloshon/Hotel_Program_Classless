import java.util.ConcurrentModificationException;
import java.util.Scanner;

/**
 * Created by Thiloshon on 25-Apr-16.
 * Base Template copied from SDP 1 CW 2.
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

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM -------------------------THE HOTEL PROGRAM");
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

            if (!(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("V") ||option.equalsIgnoreCase("D") ||option.equalsIgnoreCase("F") ||option.equalsIgnoreCase("S") ||option.equalsIgnoreCase("L") ||option.equalsIgnoreCase("O") )) {
                System.out.println("Please Choose Your Option Among The Letters Given Above:");
            }
        } while (!(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("V") ||option.equalsIgnoreCase("D") ||option.equalsIgnoreCase("F") ||option.equalsIgnoreCase("S") ||option.equalsIgnoreCase("L") ||option.equalsIgnoreCase("O") ));


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
            case "a":
                addNewCustomer();
                break;
            case "v":
                viewRooms();
                break;
            case "e":
                displayEmptyRooms();
                break;
            case "d":
                deleteCustomer();
                break;
            case "f":
                findRoomFromName();
                break;
            case "s":
                saveData();
                break;
            case "l":
                loadData();

        }
    }





    /**
     * The Modules Menu. Has all the required functions of modules.
     */
    public void findRoomFromName() {
        System.out.println("Customer name Please: ");
        String name= sc.nextLine();

        String id =null;
        for(Customer cus : FileHandler.getCustomerList()){
            if (cus.getName().equalsIgnoreCase(name)){
                id=cus.getiDNo();
            }
        }

        if (id==null){
            System.out.println("No such Customer");
        }else {
            for(Rent rt : FileHandler.getRentList()){
               if (rt.getCustomerID().equalsIgnoreCase(id)){
                   System.out.print(rt.getRoomID());
               }
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







    }


    /**
     * This method adds marks of the students.
     */
    public void viewRooms(){
        for (Room rm : FileHandler.getRoomList()){
            System.out.print(rm.getRoomID());
            for (Rent rent : FileHandler.getRentList()){
                if (rent.getRoomID().equalsIgnoreCase(rm.getRoomID())){
                    System.out.println(" Occupied by " + rent.getCustomerID());
                    break;
                }
            }
            System.out.println("");
        }

        start();

    }


    /**
     * This method gives the award of the student queried.
     */
    public void deleteCustomer() {
        System.out.println("Enter Customer ID: ");
        String cusID = sc.nextLine();

        try{
            for(Rent rt : FileHandler.getRentList()){
                if(rt.getCustomerID().equalsIgnoreCase(cusID)){
                    System.out.println("The Room is " + rt.getRoomID());
                    FileHandler.getRentList().remove(rt);
                    System.out.println("Rent Deleted!");
                }else {
                    System.out.println("No Such Rental!");
                }
            }
        }catch (ConcurrentModificationException e){

        }

        start();

    }


    /**
     * The method prints all the students enrolled.
     */
    public void displayEmptyRooms() {
        for (Room rm : FileHandler.getRoomList()){
            //System.out.print(rm.getRoomID());
            boolean isFree=true;
            for (Rent rent : FileHandler.getRentList()){
                if (rent.getRoomID().equalsIgnoreCase(rm.getRoomID())){
                    System.out.println("Occupied by " + rent.getCustomerID());
                    isFree=false;
                    break;
                }
            }
            if(isFree){
                System.out.println(rm.getRoomID());
            }

        }

    }


    /**
     * This method loads all the data from files.
     */
    public void loadData() {

        FileHandler.LoadCustomerDataFromFile();
        FileHandler.LoadRentDataFromFile();
        FileHandler.LoadRoomDataFromFile();
        System.out.println("Data Loaded Successfully");
        start();




    }


    /**
     * This method saves all the data to file.
     */
    public void saveData() {
        FileHandler.saveCustomerDataToFile();
        FileHandler.saveRentDataToFile();
        FileHandler.saveRoomDataToFile();

        System.out.println("Data Saved Successfully");

        start();


    }

}
