import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ClassExample implements Serializable,Cloneable {

    public static int publicStaticIntField          = 1;
    protected static int staticIntField             = 2;
    public static String publicStaticStringField    = "publicStaticStringField";
    private static String staticStringField         = "privateStaticStringField";

    protected ClassExample() {

    }


    public ClassExample(int id) throws ClassCastException, ArithmeticException {

    }

    public ClassExample(int id, String name) throws RemoteException, SQLException {

    }

    public ClassExample(int id, String name, String address) throws InterruptedException {

    }

    public void add(int firstElement, int secondElement , String result) throws ClassNotFoundException, ClassCastException{
        System.out.println("Add - demo method for Reflection API");
    }

    public String search(String searchString) throws ArithmeticException, InterruptedException{
        System.out.println("Search - demo method for Reflection API");

        return null;
    }

    public void delete(String deleteString) throws SQLException {
        System.out.println("Delete - demo method for Reflection API");
    }

}
