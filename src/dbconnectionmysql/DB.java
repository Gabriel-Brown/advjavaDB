/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbconnectionmysql;

import java.sql.*;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author gb011
 */
public class DB {
    static final String DATABASE_URL = "jdbc:sqlserver://CTASV20r2drw:1433;"
            +"databasename=Advanced_Java;"
            +"user=DrWoodcock;"
            +"password=panWobble1;"
            +"instancename=mssqlserver2012;";
    
    public void simpleRequest()
    {
        String SQL = "Select CID, Customer.Name as 'Customer', Address, sales.Name as 'Rep'"
                +"from Customer, Sales"
                +"where Customer.SalesSID = Sales.SID";
        
        runSQL(SQL);
    }
    
    public void runSQL(String SQL)
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try
        {
            Class.forName("com.microsft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfCol = metaData.getColumnCount();

                //System.out.println(metaData.getColumnName(i).toString().trim());
                while (resultSet.next())
                {
                    for (int j = 1; j <= numberOfCol; j++)
                    {
                        System.out.print(resultSet.getObject(j).toString().trim());
                    }
                }
            
            
        }
        catch(Exception ex)
        {
            System.out.println("OUCH!!!!");
        }
        
    }
}
