package com.zwb.generated.db;

import com.zwb.generated.entry.Field;
import com.zwb.generated.utils.StringUtil;
import com.zwb.generated.type.JdbcTypeToJavaType;

import java.sql.*;
import java.util.*;

/** @Auther: zhouwenbin @Date: 2019/5/31 15:56 */
public class DBHelperDefalutImpl implements DBHelper {
  private DBOperator operator;
  private JdbcTypeToJavaType jdbcTypeToJavaTypeDefault;

  @Override
  public List<String> getTable() {
    List<String> tableNames = new ArrayList<>();
    Connection connection = operator.getConnection();
    ResultSet rs = null;
    try {
      DatabaseMetaData metaData = connection.getMetaData();
      rs = metaData.getTables(null, null, null, new String[] {"TABLE"});
      while (rs.next()) {
        tableNames.add(rs.getString(3));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      operator.close(rs);
      operator.close(connection);
    }
    return tableNames;
  }

  @Override
  public Map getFeildMap(String tableName) {
    List<Field> fields = new ArrayList<>();
    Set<String> imports = new HashSet<>();

    Connection connection = operator.getConnection();
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;
    try {
      pstmt = connection.prepareStatement("show full columns from " + tableName);
      resultSet = pstmt.executeQuery();
      while (resultSet.next()) {
        String jdbcType = resultSet.getString("Type");
        jdbcType =
            !jdbcType.contains("(") ? jdbcType : jdbcType.substring(0, jdbcType.indexOf("("));
        String javaType = jdbcTypeToJavaTypeDefault.getJavaType(jdbcType);
        fields.add(
            new Field(resultSet.getString("Field"), javaType, resultSet.getString("Comment")));
        if (javaType.equals("Date") || javaType.equals("BigDecimal")) {
          imports.add(jdbcTypeToJavaTypeDefault.getJavaClazz(jdbcType));
          imports.add("java.util.Arrays");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      operator.close(resultSet);
      operator.close(pstmt);
      operator.close(connection);
    }
    Map root = new HashMap<>();
    root.put("className", StringUtil.toCamelCase(1, tableName));
    root.put("fields", fields);
    root.put("imports", imports);
    return root;
  }

  public DBOperator getOperator() {
    return operator;
  }

  public void setOperator(DBOperator operator) {
    this.operator = operator;
  }

  public JdbcTypeToJavaType getJdbcTypeToJavaTypeDefault() {
    return jdbcTypeToJavaTypeDefault;
  }

  public void setJdbcTypeToJavaTypeDefault(JdbcTypeToJavaType jdbcTypeToJavaTypeDefault) {
    this.jdbcTypeToJavaTypeDefault = jdbcTypeToJavaTypeDefault;
  }
}
