package booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Booking.com.ConnDemo;




public class book implements book {

Connection connection;
public book() {
this.connection = Conn.createConn();
}



@Override
public int addCustomers(Customers customers) {
int result=0;
try {
PreparedStatement ps = connection.prepareStatement("insert into Customers values(?,?,?,?,?,?)");
ps.setInt(1, customers.getRegisterNo());
ps.setString(2, customers.getRoomNo());
ps.setString(3, customers.getEmail());
ps.setLong(4, customers.getMobile());
java.sql.Date checkind = new java.sql.Date(customers.getCheckInDate().getTime());
ps.setDate(5, checkind);
java.sql.Date checkoutd = new java.sql.Date(customers.getCheckOutDate().getTime());
ps.setDate(6, checkoutd);
result = ps.executeUpdate();
} catch (Exception e) {
System.out.println("Error in Add Customers...: "+e);
}
return result;
}



@Override
public List<Customers> getALLCustomers() {
List<Customers> aList = new ArrayList<>();
try {
Statement st = connection.createStatement();
ResultSet rs = st.executeQuery("select * from Customers");
while(rs.next()) {
Customers customers = new Customers();
customers.setRegisterno(rs.getInt(1));
customers.setRoomno(rs.getString(2));
customers.setEmail(rs.getString(3));
customers.setMobile(rs.getLong(4));
customers.setCheckInDate(rs.getDate(5));
customers.setCheckOutDate(rs.getDate(6));
aList.add(customers);
}
} catch (Exception e) {
System.out.println("Error in Get All : "+e);
}
return aList;
}



@Override
public Customers getCustomersByRegisterNo(int registerno) {
Customers customers = new Customers();
try {
PreparedStatement pst = connection.prepareStatement("select * from Customers where registerno=?");
pst.setInt(1, registerno);
ResultSet rs = pst.executeQuery();
if(rs.next()) {
customers.setRegisterno(rs.getInt(1));
customers.setRoomno(rs.getString(2));
customers.setEmail(rs.getString(3));
customers.setMobile(rs.getLong(4));
customers.setCheckInDate(rs.getDate(5));
customers.setCheckOutDate(rs.getDate(6));
}
} catch (Exception e) {
System.out.println("Error in Get By RegisterNo : "+e);
}
return customers;
}



@Override
public int updateCustomers(Customers customers1) {
int update = 0;
try {
String qry = ("Update Customers values set name = ?, email = ?,mobile = ?,where id= ?");
PreparedStatement ps = connection.prepareStatement(qry);
ps.setInt(1, customers1.getRegisterNo());
ps.setString(2, customers1.getRoomNo());
ps.setString(3, customers1.getEmail());
ps.setLong(4, customers1.getMobile());
java.sql.Date checkind = new java.sql.Date(customers1.getCheckInDate().getTime());
ps.setDate(5, checkind);
java.sql.Date checkoutd = new java.sql.Date(customers1.getCheckOutDate().getTime());
ps.setDate(6, checkoutd);
update = ps.executeUpdate();
} catch (Exception e) {
System.out.println("Error in Update Customers...: "+e);
}
return update;
}



@Override
public int deleteCustomers(int registerno) {
int delete =0;
Customers customers3 = new Customers();
try {
PreparedStatement pst = connection.prepareStatement("select * from customers where registerno=?");
pst.setInt(1, registerno);
ResultSet rs = pst.executeQuery();
if(rs.next()) {
customers3.setRegisterno(rs.getInt(1));
customers3.setRoomno(rs.getString(2));
customers3.setEmail(rs.getString(3));
customers3.setMobile(rs.getLong(4));
customers3.setCheckInDate(rs.getDate(5));
customers3.setCheckOutDate(rs.getDate(6));
}
} catch (Exception e) {
System.out.println("Error in delete Customers...: "+e);
}
return delete;
}



}