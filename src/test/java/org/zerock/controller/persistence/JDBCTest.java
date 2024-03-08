package org.zerock.controller.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
  static {
    try {
      Class.forName("oracle.jdbc.OracleDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testConnection() {
    try(  Connection con = DriverManager.getConnection(
                          "jdbc:oracle:thin:@localhost:1521:XE",
                          "webdb",
                          "12345"
        )) {
      log.info(con);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }// end of testConnection()
  
}
