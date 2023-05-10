package com.Abhi.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import com.Abhi.entities.CitizenPlans;
import com.spire.data.table.DataTable;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

@Component
public class ExcelGenerator {
	
	public void generateExcel(FileOutputStream fos,List<CitizenPlans> lst) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Couses info");
		HSSFRow row = sheet.createRow(0);
		
		try {
			row.createCell(0).setCellValue("Id");
			row.createCell(1).setCellValue("Citizen_name");
			row.createCell(2).setCellValue("Citizen_gender");
			row.createCell(3).setCellValue("plan_name");
			row.createCell(4).setCellValue("plan_status");
			row.createCell(5).setCellValue("plan_start_date");
			row.createCell(6).setCellValue("plan_end_date");
			row.createCell(7).setCellValue("Benifit_amount");
			row.createCell(8).setCellValue("denial_reason");
			row.createCell(9).setCellValue("terminated_date");
			row.createCell(10).setCellValue("termination_reason");
			
			int dataRowIndex = 1;
			
			for(CitizenPlans c : lst) {
				HSSFRow dataRow = sheet.createRow(dataRowIndex);
				dataRow.createCell(0).setCellValue(c.getCitizenId());
				dataRow.createCell(1).setCellValue(c.getCitizenName());
				dataRow.createCell(2).setCellValue(c.getCitizenGender());
				dataRow.createCell(3).setCellValue(c.getPlanName());
				dataRow.createCell(4).setCellValue(c.getPlanStatus());
				
				if(c.getPlanStartDate() != null) {
					LocalDate localDate = c.getPlanStartDate();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
					String date1 = localDate.format(formatter);
					dataRow.createCell(5).setCellValue(date1);
				}
				if(c.getPlanEndDate() != null) {
					LocalDate localDate = c.getPlanEndDate();
					DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd LLLL yyyy");
					String date1 = localDate.format(formatter1);
					dataRow.createCell(6).setCellValue(date1);
				}
				
				if(c.getBenefitAmount() != null) {
					dataRow.createCell(7).setCellValue(c.getBenefitAmount());
				}
				
				if(c.getDenialReason() != null) {
					dataRow.createCell(8).setCellValue(c.getDenialReason());
				}
				
				if(c.getTermiantedDate() != null) {
					LocalDate localDate2 = c.getTermiantedDate();
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd LLLL yyyy");
					String date2 = localDate2.format(formatter2);
					dataRow.createCell(9).setCellValue(date2);		
				}
				if(c.getTerminationReason() != null) {
					dataRow.createCell(10).setCellValue(c.getTerminationReason());
				}
				dataRowIndex++;
			}
			workbook.write(fos);
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
