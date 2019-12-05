package com.forest.action;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * - 控制层 - Excel文件操作类
 * @author south wind
 * @version v1.0 2019年12月5日 上午8:02:04
 * - 表/功能：
 */
@Controller
@RequestMapping("excelFiles")
public class CommodityAndMemberExcelAction {
	
	private static Logger log = Logger.getLogger(CommodityAndMemberExcelAction.class); 
	
	@RequestMapping("/download")
	@ResponseBody
	public ResponseEntity<byte []> download(){
		try {
			FileInputStream is = new FileInputStream("/D:/Git/Files/template.xlsx");
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDispositionFormData("attachment", new String("学生导入模版.xlsx".getBytes("utf-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/excelUpload")
	public String excelUpload(MultipartFile file) {
		try {
			//将传入的文件转换成excel
			Workbook wb = new XSSFWorkbook(file.getInputStream());
			//获取sheet业的个数
			int sheets = wb.getNumberOfSheets();
			for(int i=0;i<sheets;i++) {
				//根据下标获取sheet页
				Sheet sheet = wb.getSheetAt(i);
				//获取当前sheet页的行数
				int rows = sheet.getPhysicalNumberOfRows();
				for(int j=1;j<rows;j++) {
					//根据下标获取行
					Row row = sheet.getRow(j);
					Cell nameCell = row.getCell(0);
					Cell ageCell = row.getCell(1);
					Cell birthdayCell = row.getCell(2);
					
					System.out.println(nameCell + "\t" + ageCell + "\t" + birthdayCell);
					System.out.println(nameCell.getStringCellValue() + "\t" + ageCell.getNumericCellValue() + "\t" + birthdayCell.getDateCellValue());
					
					/*Student stu = new Student();
					stu.setName(nameCell.getStringCellValue());
					Double age = ageCell.getNumericCellValue();
					stu.setAge(age.intValue());
					stu.setBirthday(birthdayCell.getDateCellValue());
					service.add(stu);*/
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/file/toPage";
	}
	
	/*@RequestMapping("/exportExcel")
	public ResponseEntity<byte []> exportExcel(Student stu){
		//查询出需要导出的学生
		List<Student> list = service.find(stu);
		//导出学生信息为excel
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		Row titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("学生姓名");
		titleRow.createCell(1).setCellValue("学生年龄");
		titleRow.createCell(2).setCellValue("学生生日");
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<list.size();i++) {
			Row row = sheet.createRow(i+1);
			Cell nameCell = row.createCell(0);
			nameCell.setCellValue(list.get(i).getName());
			Cell ageCell = row.createCell(1);
			ageCell.setCellValue(list.get(i).getAge());
			Cell birtydayCell = row.createCell(2);
			if(list.get(i).getBirthday()!=null) {
				birtydayCell.setCellValue(f.format(list.get(i).getBirthday()));
			}
			
		}
		HttpHeaders headers = new HttpHeaders();
		ByteArrayOutputStream bot = new ByteArrayOutputStream();
		try {
			wb.write(bot);
			headers.setContentDispositionFormData("attachment", new String("导出的学生信息.xlsx".getBytes("utf-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<byte[]>(bot.toByteArray(), headers, HttpStatus.OK);
	}*/
	
}
