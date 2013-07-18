package com.qsoft.banking.business;

import com.qsoft.banking.persistence.dao.BankAccountDAO;
import com.qsoft.banking.persistence.dao.TransactionDAO;
import com.qsoft.banking.persistence.model.BankAccountDTO;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 7/18/13
 * Time: 7:26 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DAOTest {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    BankAccountDAO bankAccountDAO;
    @Autowired
    TransactionDAO transactionDAO;
    @Qualifier("dataSourceTest")
    @Autowired
    DataSource dataSourcetest;
    IDatabaseTester iDatabaseTester;
    final String accountNumber="0123456789";
    final double balance = 100;
    @Before
    public void setup() throws Exception
    {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }

    private IDataSet readDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception
    {
        iDatabaseTester = new DataSourceDatabaseTester(dataSourcetest);
        iDatabaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        iDatabaseTester.setDataSet(dataSet);
        iDatabaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception
    {
        iDatabaseTester.onTearDown();
    }
    @Test
    public void testGetAccount() throws Exception {
        BankAccountDTO bankAccountDTO = bankAccountDAO.getAccount(accountNumber);
        assertEquals(accountNumber, bankAccountDTO.getAccountNumber());
        assertEquals(100.0, bankAccountDTO.getBalance());
        assertEquals(12345678, bankAccountDTO.getTimeStamp());
    }
}
