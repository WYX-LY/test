
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperate {
public static void main(String[] args) {
	System.out.println("aaaaaaaaaaaaaaa");
	System.out.println("aaaaaaaaaaaaa");
	List<String> vec=new chaxunjiemian().getSelectall("select * from student");
	File file =new File("D:\\DAIMA\\test\\1.xlsx");
	 Workbook workbook=new XSSFWorkbook();//创建工作簿对象
	  Sheet sheet = workbook.createSheet("test1");//创建工作表对象
	  for(int i=0;i<vec.size();i++){
		  Row row = sheet.createRow(i);// 创建行对象，下标从0开始
		  for(int j=0;j<vec.get(i).size();j++){
			    Cell cell = row.createCell(j);//创建单元格，从0开始
			    cell.setCellValue(vec.get(i).get(j)+"");//单元格设置内容
		  }
	  }
	  
	 FileOutputStream fos;
	try {
		fos = new FileOutputStream(file);
		workbook.write(fos);//将内容写入到指定的excel文档
	  fos.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//创建输出流对象
}
	
}