package booking;
import java.util.List;



public interface Customers {



public int addCustomers(Customers customers);
public List<Customers> getALLCustomers();
public Customers getCustomersByRegisterNo(int registerno);
public int updateCustomers(Customers customers);
public int deleteCustomers(int registerno);

}
