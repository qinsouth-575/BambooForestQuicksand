package com.forest.action;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.forest.biz.ColorBiz;
import com.forest.biz.CommodityMDBiz;
import com.forest.biz.CommodityTypeBiz;
import com.forest.biz.SizeBiz;
import com.forest.entity.Color;
import com.forest.entity.CommodityDetails;
import com.forest.entity.CommodityMD;
import com.forest.entity.CommodityMain;
import com.forest.entity.CommodityType;
import com.forest.entity.Images;
import com.forest.entity.Size;

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
	
	@Autowired
	private CommodityMDBiz cmdb;
	
	@Autowired
	private CommodityTypeBiz ctb;
	
	@Autowired
	private ColorBiz cb;
	
	@Autowired
	private SizeBiz sb;
	
	@RequestMapping("/download")
	@ResponseBody
	public ResponseEntity<byte []> download(){
		log.debug("BambooForestQuicksand - CommodityAndMemberExcelAction - download - 商品管理 - 下载范本");
		try {
			FileInputStream is = new FileInputStream("/D:/Git/Files/poso2o_batch_upload.xlsx");
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDispositionFormData("attachment", new String("商品导入模版.xlsx".getBytes("utf-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/excelUpload")
	@ResponseBody
	public String excelUpload(MultipartFile file, int shopId) {
		log.debug("BambooForestQuicksand - CommodityAndMemberExcelAction - excelUpload - 商品管理 - 导入商品信息");
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
				for(int j = 1; j < rows; j++) {
					//根据下标获取行
					Row row = sheet.getRow(j);

					Cell ctNameCell = row.getCell(0);		//类别		- main
					Cell barCodeCell = row.getCell(1);		//条码
					Cell cmNameCell = row.getCell(2);		//商品名称	- main
					Cell articleNoCell = row.getCell(3);	//货号		- main
					Cell colorNameCell = row.getCell(4);	//颜色
					Cell sizeNameCell = row.getCell(5);		//尺码
					Cell salePriceCell = row.getCell(6);	//销售价	- main
					Cell quantityCell = row.getCell(7);		//数量
					Cell costPriceCell = row.getCell(8);	//进货成本	- main
					
					log.info(ctNameCell.getStringCellValue() + " - " + 
							barCodeCell.getStringCellValue() + " - " +  
							cmNameCell.getStringCellValue() +  " - " + 
							articleNoCell.getStringCellValue() +  " - " + 
							colorNameCell.getStringCellValue() +  " - " + 
							sizeNameCell.getStringCellValue() +  " - " + 
							salePriceCell.getStringCellValue() +  " - " + 
							quantityCell.getStringCellValue() +  " - " + 
							costPriceCell.getStringCellValue());

					Size size = sb.querySizeBySizeName(sizeNameCell.getStringCellValue()).get(0);
					Color color = cb.queryColors(colorNameCell.getStringCellValue()).get(0);
					Integer quantity = quantityCell.getColumnIndex();
					//详表单个信息
					CommodityDetails cd = new CommodityDetails(size.getSizeId(), size.getSizeName(), color.getColorId(), color.getColorName(), quantity, barCodeCell.getStringCellValue());
					List<CommodityDetails> cdList = new ArrayList<CommodityDetails>();
					cdList.add(cd);
					//图片
					Images image = new Images(12);
					List<Images> imgList = new ArrayList<Images>();
					imgList.add(image);
					//主商品
					CommodityType ct = ctb.querytImages(ctNameCell.getStringCellValue());
					BigDecimal salePrice = new BigDecimal(salePriceCell.getStringCellValue());
					BigDecimal costPrice = new BigDecimal(costPriceCell.getStringCellValue());
					CommodityMain cmd = new CommodityMain(articleNoCell.getStringCellValue(), cmNameCell.getStringCellValue(), salePrice, costPrice, ct.getCtId(), shopId, cdList, imgList);
					
					log.info("批量导入商品：" + cmd);
					
					cmdb.insertCommodityMainAndDetail(cmd);
				}
			}
			
			return "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}
	
	@RequestMapping("/exportExcel")
	public ResponseEntity<byte []> exportExcel(Integer shopId, Integer ctId, String ctName){
		log.debug("BambooForestQuicksand - CommodityAndMemberExcelAction - exportExcel - 商品管理 - 导出商品信息");
		log.info(shopId + " - " + ctId + " - " + ctName);
		CommodityMD cmd = new CommodityMD(ctName, shopId, ctId);
		log.info("主详类信息：" + cmd);
		//查询出需要导出的商品
		List<CommodityMD> commodityList = cmdb.queryMDListByDuo(cmd);
		log.info("主详类集合信息：" + commodityList);
		//导出商品信息为excel
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		Row titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("类别");				//ctName	String
		titleRow.createCell(1).setCellValue("商品编码（条码）");	//barCode	String
		titleRow.createCell(2).setCellValue("商品名称");			//cmName	String
		titleRow.createCell(3).setCellValue("货号");				//articleNo	String
		titleRow.createCell(4).setCellValue("颜色");				//colorName	String
		titleRow.createCell(5).setCellValue("尺码");				//sizeName	String
		titleRow.createCell(6).setCellValue("销售价");			//salePrice
		titleRow.createCell(7).setCellValue("数量");				//quantity
		titleRow.createCell(8).setCellValue("进货成本");			//costPrice
		//SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");	
		for(int i=0;i<commodityList.size();i++) {
			Row row = sheet.createRow(i+1);
			Cell ctNameCell = row.createCell(0);
			ctNameCell.setCellValue(commodityList.get(i).getCtName());
			
			Cell barCodeCell = row.createCell(1);
			barCodeCell.setCellValue(commodityList.get(i).getBarCode());
			
			Cell cmNameCell = row.createCell(2);
			cmNameCell.setCellValue(commodityList.get(i).getCmName());
			
			Cell articleNoCell = row.createCell(3);
			articleNoCell.setCellValue(commodityList.get(i).getArticleNo());
			
			Cell colorNameCell = row.createCell(4);
			colorNameCell.setCellValue(commodityList.get(i).getColorName());
			
			Cell sizeNameCell = row.createCell(5);
			sizeNameCell.setCellValue(commodityList.get(i).getSizeName());
			
			Cell salePriceCell = row.createCell(6);
			salePriceCell.setCellValue(commodityList.get(i).getSalePrice() + "");
			
			Cell quantityCell = row.createCell(7);
			quantityCell.setCellValue(commodityList.get(i).getQuantity() + "");
			
			Cell costPriceCell = row.createCell(8);
			costPriceCell.setCellValue(commodityList.get(i).getCostPrice() + "");
		}
		HttpHeaders headers = new HttpHeaders();
		ByteArrayOutputStream bot = new ByteArrayOutputStream();
		try {
			wb.write(bot);
			headers.setContentDispositionFormData("attachment", new String("导出的商品信息.xlsx".getBytes("utf-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<byte[]>(bot.toByteArray(), headers, HttpStatus.OK);
	}
	
}
