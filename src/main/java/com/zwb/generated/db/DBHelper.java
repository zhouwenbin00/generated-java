package com.zwb.generated.db;

import java.util.List;
import java.util.Map;

/** 数据库帮助类 @Auther: zhouwenbin @Date: 2019/5/31 15:53 */
public interface DBHelper {

  /** 获取数据库全部表名 */
  List<String> getTable() ;

  /** 获取表的全部列属性 */
  Map getFeildMap(String table);
}
