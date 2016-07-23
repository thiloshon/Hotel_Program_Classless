/**
 * Created by Thiloshon on 25-Apr-16.
 * This Class is the model class of Student.
 *
 */
public class Customer implements java.io.Serializable {


    private String name;
    private String iDNo;
    private String numberOfMembers;


    public Customer(String name, String iDNo) {
        this.name = name;
        this.iDNo = iDNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDNo='" + iDNo + '\'' +
                ", name='" + name + '\'' +
                ", numberOfMembers='" + numberOfMembers + '\'' +
                '}';
    }

    public String getiDNo() {
        return iDNo;
    }



    public String getName() {
        return name;
    }


}
