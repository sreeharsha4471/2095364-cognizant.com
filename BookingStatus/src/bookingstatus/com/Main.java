package bookingstatus.com;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



import booking.com.Customers;
import booking.com.CustomersDao;
import booking.com.CustomersDaoImpl;

static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) throws ParseException {

CustomersDao custoDao = new CustomersDaoImpl();
do {
System.out.println("Select the Options below :");
System.out.println(
" 1.Add Customers \n 2.View All Bookings \n 3.View All Customers \n 4.View By Customers RegisterNo \n 5. Update Customers \n 6. Delete Customers \n 7. Exit");
int option = scanner.nextInt();
switch (option) {
case 1:
Customers customers = inputMet();
int result = custoDao.addCustomers(customers);
if (result > 0) {
System.out.println("Customers Details Added Successfully....");
} else {
System.out.println("Try to Add Again....");
}
break;
case 2:
List<Customers>bookingList = custoDao.getALLCustomers();
for(Customers custo : bookingList) {
System.out.println(custo);
}
break;
case 3:
List<Customers>custoList = custoDao.getALLCustomers();
for(Customers custo : custoList) {
System.out.println(custo);
}
break;
case 4:
System.out.print("Enter Customers RegisterNo :");
int registerno = scanner.nextInt();
Customers customers2 = custoDao.getCustomersByRegisterNo(registerno);
System.out.println(customers2);
break;
case 5:
Customers customers1 = inputMet();
int Update = custoDao.updateCustomers(customers1);
if (Update > 0) {
System.out.println("Customers Details updated Successfully....");
} else {
System.out.println("Try to update Again....");
}
break;
case 6:
System.out.print("Enter Customers ID :");
int delete= scanner.nextInt();
@SuppressWarnings("unused")
int associates3 = custoDao.deleteCustomers(delete);
if (delete > 0)
System.out.println("Customers Details Deleted Successfully.....");
else
System.out.println("Try to Delete Again.....");
break;
}
System.out.println("Do you want to Continue 1. Yes \t 2. No");
}while (scanner.nextInt() == 1);
}

static Customers inputMet() throws ParseException {
System.out.println("Enter Customers Details :");
System.out.print("RegisterNo :");
int registerno = scanner.nextInt();
System.out.println("RoomNo : ");
String roomno = scanner.next();
System.out.println("Email : ");
String email = scanner.next();
System.out.println("Mobile : ");
long mobile = scanner.nextLong();
System.out.println("CheckIn Date (dd/MM/yyyy): ");
String checkind = scanner.next();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date checkinDate = sdf.parse(checkind);
System.out.println("CheckOut Date (dd/MM/yyyy): ");
String checkoutd = scanner.next();
SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
Date checkoutDate = sdf1.parse(checkoutd);
Customers customers= new Customers(registerno,roomno, email, mobile, checkinDate, checkoutDate);
return customers;
}


}