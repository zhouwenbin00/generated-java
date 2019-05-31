package com.zwb.generated;

import com.zwb.generated.db.DBHelperDefalutImpl;
import com.zwb.generated.db.DBOperatorDefaultImpl;
import com.zwb.generated.type.JdbcTypeToJavaTypeDefaultImpl;
import freemarker.template.TemplateException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/** @Auther: zhouwenbin @Date: 2019/5/31 15:00 */
public class GeneratedCode {
  private String packagePath;
  private Properties properties;
  private String url;
  private String user;
  private String pwd;
  private String driver;

  public GeneratedCode() {}

  public void setPackagePath(String packagePath) {
    this.packagePath = packagePath;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public GeneratedCode(String propertiesName) throws IOException {
    if (propertiesName.equals("")) {
      throw new IllegalArgumentException("properties can’t be null");
    }
    File file = new File(propertiesName);
    InputStream inputStream = null;
    if (file.exists()) {
      inputStream = new FileInputStream(file);
    } else {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      InputStream resourceAsStream = loader.getResourceAsStream(propertiesName);
      if (resourceAsStream == null) {
        throw new FileNotFoundException("properties not exists");
      }
      inputStream = resourceAsStream;
    }
    properties = new Properties();
    properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    this.driver = properties.getProperty("driver");
    this.url = properties.getProperty("url");
    this.user = properties.getProperty("user");
    this.pwd = properties.getProperty("pwd");
    this.packagePath = properties.getProperty("packagePath");
  }

  public void generated() throws IOException, TemplateException {
    DBOperatorDefaultImpl dbOperator = new DBOperatorDefaultImpl(this.driver);
    dbOperator.setUrl(this.url);
    dbOperator.setUser(this.user);
    dbOperator.setPwd(this.pwd);
    DBHelperDefalutImpl dbHelper = new DBHelperDefalutImpl();
    dbHelper.setJdbcTypeToJavaTypeDefault(new JdbcTypeToJavaTypeDefaultImpl());
    dbHelper.setOperator(dbOperator);
    GeneratedJavaClass generatedJavaClass = new GeneratedJavaClass();
    generatedJavaClass.setDbHelper(dbHelper);
    generatedJavaClass.setPackagePath(this.packagePath);
    generatedJavaClass.generated();
  }
}
