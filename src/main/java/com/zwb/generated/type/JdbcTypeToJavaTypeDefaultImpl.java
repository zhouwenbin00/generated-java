package com.zwb.generated.type;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** @Auther: zhouwenbin @Date: 2019/5/31 14:09 */
public class JdbcTypeToJavaTypeDefaultImpl implements JdbcTypeToJavaType {
  private Map<String, String> typeMap = new HashMap<>();

  public JdbcTypeToJavaTypeDefaultImpl() {
    this.typeMap.put("ARRAY", Object.class.getName());
    this.typeMap.put("BIGINT", Long.class.getName());
    this.typeMap.put("BINARY", "byte[]");
    this.typeMap.put("BIT", Boolean.class.getName());
    this.typeMap.put("BLOB", "byte[]");
    this.typeMap.put("BOOLEAN", Boolean.class.getName());
    this.typeMap.put("CHAR", String.class.getName());
    this.typeMap.put("CLOB", String.class.getName());
    this.typeMap.put("DATALINK", Object.class.getName());
    this.typeMap.put("DATE", Date.class.getName());
    this.typeMap.put("DATETIME", Date.class.getName());
    this.typeMap.put("DECIMAL", BigDecimal.class.getName());
    this.typeMap.put("DISTINCT", Object.class.getName());
    this.typeMap.put("DOUBLE", Double.class.getName());
    this.typeMap.put("FLOAT", Double.class.getName());
    this.typeMap.put("INTEGER", Integer.class.getName());
    this.typeMap.put("INT", Integer.class.getName());
    this.typeMap.put("JAVA_OBJECT", Object.class.getName());
    this.typeMap.put("LONGNVARCHAR", String.class.getName());
    this.typeMap.put("LONGVARBINARY", "byte[]");
    this.typeMap.put("LONGVARCHAR", String.class.getName());
    this.typeMap.put("LONGBLOB", "byte[]");
    this.typeMap.put("NCHAR", String.class.getName());
    this.typeMap.put("NCLOB", String.class.getName());
    this.typeMap.put("NVARCHAR", String.class.getName());
    this.typeMap.put("NULL", Object.class.getName());
    this.typeMap.put("NUMERIC", BigDecimal.class.getName());
    this.typeMap.put("OTHER", Object.class.getName());
    this.typeMap.put("REAL", Float.class.getName());
    this.typeMap.put("REF", Object.class.getName());
    this.typeMap.put("SMALLINT", Short.class.getName());
    this.typeMap.put("STRUCT", Object.class.getName());
    this.typeMap.put("TIME", Date.class.getName());
    this.typeMap.put("TIMESTAMP", Date.class.getName());
    this.typeMap.put("TINYINT", Byte.class.getName());
    this.typeMap.put("VARBINARY", "byte[]");
    this.typeMap.put("VARCHAR", String.class.getName());
  }

  @Override
  public String getJavaType(String jdbcType) {
    String javaType = this.typeMap.get(jdbcType.toUpperCase());
    if (javaType==null){
      throw new NullPointerException(jdbcType +"not exists");
    }
    return javaType.equals("byte[]") ? javaType : javaType.substring(javaType.lastIndexOf(".") + 1);
  }

  @Override
  public String getJavaClazz(String jdbcType) {
    String javaType = this.typeMap.get(jdbcType.toUpperCase());
    if (javaType==null){
      throw new NullPointerException(jdbcType +"not exists");
    }
    return javaType;
  }
}
