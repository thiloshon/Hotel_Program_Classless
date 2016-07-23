import java.io.*;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 25-Apr-16.
 * This Class takes care of all File Handling. The methods are: saveStudentDataToFile, LoadStudentDataFromFile
 */
public class FileHandler {

    private static ArrayList<Customer> customerList = new ArrayList<Customer>();





    /**
     * This method saves the student objects in the binary format to the file.
     */
    public static void saveCustomerDataToFile(){
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Hotel Program\\src\\Customer.txt");


        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Customer cus : customerList) {
            try {
                oos.writeObject(cus);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * This method loads the student objects in the binary format from the file.
     */
    public static void LoadCustomerDataFromFile() {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Hotel Program\\src\\Customer.txt");
        FileInputStream fis = null;
        //System.out.print("hi1");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found1");
        }
        ObjectInputStream ois = null;


        try {

            if (fis.available() != 0) {
                //System.out.print("hi2");
                ois = new ObjectInputStream(fis);
                while (ois != null) {
                    try {
                        Customer st = (Customer) ois.readObject();
                        // for(Student stu : studentsList){
                        //    if(st.getiDNo()!=stu.getiDNo()){
                        customerList.add(st);
                        //   }
                        //  }


                      //  System.out.println("hi3");
                        //System.out.print(st);

                    } catch (EOFException e) {
                        break;
                    }


                }
            }
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

            //e3.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }



    /**
     * This method saves the Take objects in the binary format to the file.
     */
    public static void saveRoomDataToFile()  {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Hotel Program\\src\\Data.txt");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Room tke : roomList) {
            try {
                oos.writeObject(tke);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    /**
     * This method loads the take objects in the binary format from the file.
     */
    public static void LoadRoomDataFromFile()  {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Hotel Program\\src\\Data.txt");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found2");
        }
        ObjectInputStream ois = null;
        try {
            if (fis.available() != 0) {
                ois = new ObjectInputStream(fis);
                while (ois != null) {
                    try{
                        Room st = (Room) ois.readObject();
                        roomList.add(st);
                    }catch (EOFException e){
                    break;
                    }

                }
            }
        } catch (ClassNotFoundException cnfe) {
            //cnfe.printStackTrace();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }



    /**
     * This method save the module objects in the binary format to the file.
     */
    public static void saveRentDataToFile() {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Hotel Program\\src\\Rent.txt");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Rent mde : rentList) {
            try {
                oos.writeObject(mde);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            oos.flush();
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    /**
     * This method loads the module objects in the binary format from the file.
     */
    public static void LoadRentDataFromFile()  {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Hotel Program\\src\\Rent.txt");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found3");
        }
        ObjectInputStream ois = null;


        try {

            if (fis.available() != 0) {
                ois = new ObjectInputStream(fis);
                while (ois != null) {
                    try {
                        Rent mde = (Rent) ois.readObject();
                        rentList.add(mde);
                    } catch (EOFException e) {
                        break;
                    }

                }
            }
        } catch (ClassNotFoundException cnfe) {
            //cnfe.printStackTrace();
        } catch (Exception e) {
            // e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        //System.out.println("modules" + getModules());


    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public static ArrayList<Rent> getRentList() {
        return rentList;
    }

    public static ArrayList<Room> getRoomList() {
        return roomList;
    }
}
