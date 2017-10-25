/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author kael
 */
public class CustomIdGenerator implements IdentifierGenerator{
    protected String prefix;
    protected String s;
    protected String query;
    
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery(query);

            if(rs.next())
            {
                int id = rs.getInt(1);
                int correlativo = id+1;
                String cad = s+correlativo;
                String generatedId = prefix + cad.substring(cad.length()-s.length(), cad.length());
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
  
}
