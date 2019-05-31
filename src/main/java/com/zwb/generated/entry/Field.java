package com.zwb.generated.entry;

/** @Auther: zhouwenbin @Date: 2019/5/30 21:36 */
public class Field {
  /** 属性名 */
  private String name;
  /** 类名 */
  private String clazz;
  /** 注释 */
  private String comment;

  public Field(String name, String clazz) {
    this.name = name;
    this.clazz = clazz;
  }

  public Field(String name, String clazz, String comment) {
    this.name = name;
    this.clazz = clazz;
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Field() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }
}
