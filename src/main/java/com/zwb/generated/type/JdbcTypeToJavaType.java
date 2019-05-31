package com.zwb.generated.type;

/** jdbc类型转java类型 @Auther: zhouwenbin @Date: 2019/5/31 14:07 */
public interface JdbcTypeToJavaType {

  /** 获取java类型 */
  String getJavaType(String jdbcType);
  /** 获取java类型的class名称 */
  String getJavaClazz(String jdbcType);
}
