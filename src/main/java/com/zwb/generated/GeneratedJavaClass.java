package com.zwb.generated;

import com.zwb.generated.db.DBHelper;
import com.zwb.generated.utils.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** @Auther: zhouwenbin @Date: 2019/5/31 14:44 */
public class GeneratedJavaClass {
  private String packagePath;
  private String srcPath;
  private String path;

  private DBHelper dbHelper;

  public String getPackagePath() {
    return packagePath;
  }

  public void setPackagePath(String packagePath) {
    this.packagePath = packagePath;
  }

  public DBHelper getDbHelper() {
    return dbHelper;
  }

  public void setDbHelper(DBHelper dbHelper) {
    this.dbHelper = dbHelper;
  }

  public void generated() throws IOException, TemplateException {
    Configuration cfg = Configuration.getDefaultConfiguration();
    cfg.setDirectoryForTemplateLoading(
        new File(System.getProperty("user.dir") + "\\src\\main\\resources"));
    cfg.setObjectWrapper(new DefaultObjectWrapper());
    Template template = cfg.getTemplate("bean.ftl");
    List<String> tables = dbHelper.getTable();
    for (String tableName : tables) {
      Map root = dbHelper.getFeildMap(tableName);
      root.put("package", getPackagePath());
      File file = new File(getJavaClassGeneratedPath(tableName));
      if (!file.exists()) {
        file.createNewFile();
      }
      FileWriter fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
      template.process(root, bw);
      bw.flush();
      fw.close();
    }
  }

  private String getJavaClassGeneratedPath(String tableName) {
    String packagePath = getPackagePath();
    // todo
    String srcPath = System.getProperty("user.dir") + "\\src\\main\\java";

    this.srcPath = srcPath;
    //        System.out.println("srcPath:" + srcPath);
    packagePath = packagePath.replace(".", "\\");
    String path = srcPath + "\\" + packagePath;
    File file = new File(path);
    if (!file.exists()) {
      file.mkdirs();
    }
    this.path = path;
    String javaClassPath = path + "\\" + StringUtil.toCamelCase(1, tableName) + ".java";
    return javaClassPath;
  }
}
