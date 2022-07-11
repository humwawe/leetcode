package generator;


import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class Generator {
  static String name = "Count the Number of Ideal Arrays";

  static final String PROJECT_HOME = "src\\main\\java";
  static final String TEMPLATE = "generator\\template";
  static Set<String> keyPkgWord = new HashSet<>();
  static Map<String, String> templateMap = new HashMap<>();

  static final String FILE_EXISTS = "-1";

  static {
    name = name.trim();
    keyPkgWord.add("if");
    keyPkgWord.add("for");
    keyPkgWord.add("final");
    keyPkgWord.add("case");
  }

  public static void main(String[] args) throws IOException {

    String pkgName = generatePackage(name);
    String clzName = generateClass(name);

    templateMap.put("PACKAGE", pkgName);
    templateMap.put("CLASS", clzName);

    String outputFile = genOutput(pkgName, clzName);
    if (FILE_EXISTS.equals(outputFile)) {
      System.out.println("文件已存在，停止生成");
      return;
    }
    File file = new File(outputFile);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(PROJECT_HOME + File.separator + TEMPLATE)));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      String s = Util.simpleTemplate(line, templateMap, "");
      bufferedWriter.write(s);
      bufferedWriter.newLine();
    }
    bufferedReader.close();
    bufferedWriter.close();
  }

  private static String genOutput(String pkgName, String clzName) throws IOException {
    String path = PROJECT_HOME + File.separator + pkgName.replaceAll("\\.", "\\\\");
    File fileDirs = new File(path);
    String fileName = clzName + ".java";
    if (!fileDirs.exists()) {
      if (fileDirs.mkdirs()) {
        System.out.println("创建包路径 成功：" + path);
      } else {
        System.out.println("创建包路径 失败：" + path);
      }
    }
    File file = new File(path, fileName);
    if (!file.exists()) {
      if (file.createNewFile()) {
        System.out.println("创建类文件 成功：" + fileName);
      } else {
        System.out.println("创建类文件 失败：" + fileName);
      }
    } else {
      return FILE_EXISTS;
    }
    return path + File.separator + fileName;
  }

  private static String generateClass(String name) {
    String[] subPkg = name.split(" ");
    StringBuilder res = new StringBuilder();
    for (String s : subPkg) {
      if (s == null || s.isEmpty()) {
        continue;
      }
      res.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase());
    }
    return res.toString();
  }

  private static String generatePackage(String name) {
    String[] subPkg = name.split(" ");
    StringBuilder res = new StringBuilder();
    for (String s : subPkg) {
      if (s == null || s.isEmpty()) {
        continue;
      }
      if (!keyPkgWord.contains(s.toLowerCase())) {
        res.append(s.toLowerCase()).append(".");
      }
    }
    return res.substring(0, res.length() - 1);
  }
}
