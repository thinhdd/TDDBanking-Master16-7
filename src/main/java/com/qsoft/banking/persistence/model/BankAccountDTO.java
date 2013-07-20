package com.qsoft.banking.persistence.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/16/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table (name= "bank_account")
@SequenceGenerator(name = "seq_id1", sequenceName = "seq_id1", initialValue = 1, allocationSize = 1)
public class BankAccountDTO {
    @GeneratedValue (strategy = GenerationType.AUTO, generator = "seq_id1")
    @Id
    @Column(name= "id")
    private Integer id;
    @Column(name= "account_number")
    private String accountNumber;
    @Column(name = "balance")
    private double balance;
    @Column(name= "open_time_stamp")
    private long timeStamp;
    static Calendar calendar = Calendar.getInstance();
    public BankAccountDTO(String accountNumber) {
        this.accountNumber=accountNumber;
        this.balance=10.0;
        this.timeStamp=12l;
//        timeStamp=calendar.getTimeInMillis();
        //To change body of created methods use File | Settings | File Templates.
    }

    public BankAccountDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;  //To change body of created methods use File | Settings | File Templates.
    }

    public double getBalance() {
        return this.balance;  //To change body of created methods use File | Settings | File Templates.
    }

    public void setBalance(double amount) {
        this.balance = this.balance+amount;
    }

    public long getTimeStamp() {
        return this.timeStamp;  //To change body of created methods use File | Settings | File Templates.
    }
    public static void setCalendar(Calendar calendars)
    {
        calendar = calendars;
    }

    public void setTimeStamp(long resultSet) {
        this.timeStamp=resultSet;
        //To change body of created methods use File | Settings | File Templates.
    }
}
