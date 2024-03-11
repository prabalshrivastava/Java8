package readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

  public static void main(String[] args) throws IOException {
    File file = new File("/Users/pshrivastava/IdeaProjects/1.xls");
    FileInputStream fileInputStream = new FileInputStream(file);
    byte[] bytes = fileInputStream.readAllBytes();
    String str = new String(bytes);

    List<ExcelData> excelDataList = new ArrayList<>();

  }
}
class ExcelData{
  int custId;
  String custName;
}