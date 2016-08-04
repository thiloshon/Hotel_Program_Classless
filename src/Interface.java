import java.io.*;
import java.util.Scanner;

/**
 * Created by Thiloshon on 25-Apr-16.
 * Base Template from SDP 1 CW 2.
 * Later altered as to exclude Object Oriented Concepts.
 * This Class Deals with all the Interface Inputs and Interface Outputs.
 * Methods: Run, Start, Add procedure, View procedure, Display Empty rooms, Delete customer from room, Find room from
 * Customer name, Store program array data into a plain text file, Load program data back from the file into the array,
 * View rooms Ordered alphabetically by name.
 */
public class Interface {

    Scanner sc = new Scanner(System.in);
    String[] names = new String[10];
    String[] iD = new String[10];


    /**
     * The First output. Welcome page.
     */
    public void run() {


        //loadData(); // First load of data


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
            option = option.toUpperCase();

            if (!(option.equals("A") || option.equals("V") || option.equals("E") || option.equals("D") || option.equals("F")
                    || option.equals("S") || option.equals("L") || option.equals("O"))) {
                System.out.println("Please Choose Your Option Among The Letters Given Above:");
            }
        }
        while (!(option.equals("A") || option.equals("V") || option.equals("E") || option.equals("D")
                || option.equals("F") || option.equals("S") || option.equals("L") || option.equals("O")));


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
            case "O":
                sortData();
                break;


        }
    }

    /**
     * Method to add new Customer.
     */
    public void addNewCustomer() {

        System.out.println("Room Number Please: ");
        String roomNumber = sc.nextLine();

        System.out.println("Customer Name Please: ");
        String customerName = sc.nextLine();

        System.out.println("Customer ID Please: ");
        String customerID = sc.nextLine();

        names[Integer.parseInt(roomNumber) - 1] = customerName;
        iD[Integer.parseInt(roomNumber) - 1] = customerID;

        System.out.println(customerName + " of ID " + customerID + " was added to room " + roomNumber);

        start();


    }

    /**
     * This method views details of all Rooms.
     */
    public void viewRooms() {

        for (int x = 0; x < names.length; x++) {
            if (names[x] == null || names[x].equalsIgnoreCase("empty") || names[x].equalsIgnoreCase("null")) {
                System.out.println("The Room " + (x + 1) + " is Empty");
            } else {
                System.out.println("The Room " + (x + 1) + " is Rented to " + names[x] + " of ID " + iD[x]);
            }
        }

        System.out.println("End of Record");

        start();

    }

    /**
     * This method prints all the empty rooms.
     */
    public void displayEmptyRooms() {


        for (int x = 0; x < names.length; x++) {
            if (names[x] == null || names[x].equalsIgnoreCase("empty") || names[x].equalsIgnoreCase("null")) {
                System.out.println("The Room " + (x + 1) + " is Empty");
            }
        }

        System.out.println("End of Record");

        start();

    }

    /**
     * This method deletes the customer from room.
     */
    public void deleteCustomer() {
        System.out.println("Enter Room ID: ");
        String roomID = sc.nextLine();

        names[Integer.parseInt(roomID) - 1] = "null";
        System.out.println("Customer Deleted ");

        start();

    }

    /**
     * This method prints room number corresponding to the customer name.
     */
    public void findRoomFromName() {
        System.out.println("Customer name Please: ");
        String name = sc.nextLine();

        for (int x = 0; x < names.length; x++) {
            if (names[x].equalsIgnoreCase(name)) {
                System.out.println("The Room is " + (x + 1));
            }
        }


        start();

    }


    /**
     * This method loads all the data from files.
     */
    public void loadData() {

        boolean flag = false;
        File file = new File("Data.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int x = 0;
            while ((line = br.readLine()) != null) {


                String[] array = line.split("\\t");

                names[x] = array[1];
                iD[x] = array[2];

                x++;

            }
        } catch (FileNotFoundException e) {
            flag = true;
            System.out.println("Data Loading Terminated. File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            flag = true;
        }

        if (!flag) {
            System.out.println("Data Loaded Successfully");
        }

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

        for (int x = 0; x < names.length; x++) {
            writer.print(x + " \t");
            writer.print(names[x]);
            writer.print("\t" + iD[x]);
            writer.println("");
        }


        writer.close();
        System.out.println("Data Saved Successfully");

        start();


    }


    /**
     * This method sorts the customer name alphabetically.
     */
    public void sortData() {

        String[] tempArray = new String[10];
        int[] temporary2 = new int[10];

        for (int x = 0; x < 10; x++) {
            tempArray[x] = names[x];
            temporary2[x] = x;
        }

        for (int x = 1; x < tempArray.length; x++) {
            for (int y = 0; y < tempArray.length - x; y++) { // the improved version is (arr.length-x)
                if (tempArray[y].compareTo(tempArray[y + 1]) > 0) {

                    String temp = tempArray[y];
                    int temp2 = temporary2[y];

                    tempArray[y] = tempArray[y + 1];
                    temporary2[y] = temporary2[y + 1];

                    tempArray[y + 1] = temp;
                    temporary2[y + 1] = temp2;
                }

                /*
                Method 2: Using ASCII Codes:

                if((int)names[y].charAt(0)>names[y+1].charAt(0)){
                     String temp = names[y];
                     names[y]=names[y+1];
                     names[y+1]=temp;
                }

                */

                /*
                Method 3: Using ASCII Codes and Quick Sort:


                quickSort(tempArray, 0, tempArray.length - 1);
                System.out.println(tempArray);

                public static void quickSort(String[] a, int p, int r){
                    if(p<r)
                    {
                        int q=partition(a,p,r);
                        quickSort(a,p,q);
                        quickSort(a,q+1,r);
                    }
                }

                private static int partition(String[] a, int p, int r) {


                    int x = (int)a[p].charAt(0);
                    int i = p-1 ;
                    int j = r+1 ;

                    while (true) {
                        i++;
                        while ( i< r && (int)a[i].charAt(0) < x)
                            i++;
                        j--;
                        while (j>p && (int)a[j].charAt(0) > x)
                            j--;

                        if (i < j)
                            swap(a, i, j);
                        else
                            return j;
                    }
                }

                private static void swap(String[] a, int i, int j) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

                */
            }
        }

        for (int x = 0; x < 10; x++) {
            if (!(tempArray[x] == null || tempArray[x].equalsIgnoreCase("null"))) {
                System.out.println(tempArray[x] + " Rents Room no " + (temporary2[x] + 1));
            }

        }

        start();
        start();

    }


}
