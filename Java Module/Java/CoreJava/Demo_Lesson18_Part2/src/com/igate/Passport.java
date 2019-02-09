package com.igate;

import java.util.Date;

public class Passport {
 int passportNumber;
 String name;
 Date validFrom;
@Override
public String toString() {
	return "Passport [passportNumber=" + passportNumber + ", name=" + name
			+ ", validFrom=" + validFrom + "]";
}
public int getPassportNumber() {
	return passportNumber;
}
public void setPassportNumber(int passportNumber) {
	this.passportNumber = passportNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getValidFrom() {
	return validFrom;
}
public void setValidFrom(Date validFrom) {
	this.validFrom = validFrom;
}
}
