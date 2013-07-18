package com.qsoft.banking.persistence.dao.impl;

import com.qsoft.banking.persistence.dao.TransactionDAO;
import com.qsoft.banking.persistence.model.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/16/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDAOImpl implements TransactionDAO{
    @Autowired
    TransactionDAO transactionDAO;
    @Override
    public void save(TransactionDTO capture) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionDTO> getAllTransacion(String accountNumber) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionDTO> getAllTransacion(String accountNumber, long start, long end) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionDTO> getAllTransacion(String accountNumber, int count) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
