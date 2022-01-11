package bookinginfo;
import java.util.Date;



public class book {
private int registerno;
private String roomno;
private String email;
private long mobile;
private Date checkinDate;
private Date checkoutDate;
public book() {
super();
}
public book(int registerno, String roomno, String email, long mobile, Date checkinDate ,Date checkoutDate) {
super();
this.registerno = registerno;
this.roomno = roomno ;
this.email = email;
this.mobile = mobile;
this.checkinDate = checkinDate;
this.checkoutDate = checkoutDate;
}
public int getRegisterNo() {
return registerno;
}
public void setRegisterno(int registerno) {
this.registerno = registerno;
}
public String getRoomNo() {
return roomno;
}
public void setRoomno(String roomno) {
this.roomno = roomno;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public long getMobile() {
return mobile;
}
public void setMobile(long mobile) {
this.mobile = mobile;
}
public Date getCheckInDate() {
return checkinDate;
}
public void setCheckInDate(Date checkinDate) {
this.checkinDate = checkinDate;
}
public Date getCheckOutDate() {
return checkoutDate;
}
public void setCheckOutDate(Date checkoutDate) {
this.checkoutDate = checkoutDate;
}
@Override
public String toString() {
return "Customers [registerno=" + registerno + ", roomno=" + roomno + ", email=" + email + ", mobile=" + mobile + ", checkinDate="
+ checkinDate + ", checkoutDate=" + checkoutDate + "]";
}

}
