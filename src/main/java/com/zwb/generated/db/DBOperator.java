package com.zwb.generated.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** 数据库操作 @Auther: zhouwenbin @Date: 2019/5/31 15:57 */
public interface DBOperator {

  /** 获取连接 */
  Connection getConnection();

  /** 关闭连接 */
  void close(Connection connection);

  /** 关闭Statement */
  void close(Statement statement);

  /** 关闭结果集 */
  void close(ResultSet resultSet);
}
