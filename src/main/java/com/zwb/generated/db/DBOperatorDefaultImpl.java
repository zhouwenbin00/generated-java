package com.zwb.generated.db;

import java.sql.*;

/** @Auther: zhouwenbin @Date: 2019/5/31 17:18 */
public class DBOperatorDefaultImpl implements DBOperator {
  private String url;
  private String user;
  private String pwd;
  private String driver;

  public DBOperatorDefaultImpl(String driver) {
    try {
      checkNotNull(driver);
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Connection getConnection() {
    Connection connection = null;
    try {

      String url = getUrl();
      checkNotNull(url);
      String user = getUser();
      checkNotNull(user);
      String pwd = getPwd();
      checkNotNull(pwd);

      connection = DriverManager.getConnection(url, user, pwd);

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  @Override
  public void close(Connection connection) {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void close(Statement statement) {
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void close(ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  private void checkNotNull(String s) {
    if (s == null || s.equals("")) {
      throw new NullPointerException(s + " no configuration");
    }
  }
}
