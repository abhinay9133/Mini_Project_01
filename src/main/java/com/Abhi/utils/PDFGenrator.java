package com.Abhi.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Abhi.entities.CitizenPlans;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PDFGenrator {
	
	public void generatePDF(List<CitizenPlans> plans,FileOutputStream fos) {

		Document doc = new Document(PageSize.A4);

		PdfWriter.getInstance(doc, fos);

		doc.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph1 = new Paragraph("Citizen Plans",fontTitle);

		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

		doc.add(paragraph1);

		PdfPTable table = new PdfPTable(11);

		table.setWidthPercentage(100f);
		table.setWidths(new int[] {3,3,3,3,3,3,3,3,3,3,3});
		table.setSpacingBefore(5);

		PdfPCell cell = new PdfPCell();

		cell.setBackgroundColor(CMYKColor.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		cell.setPhrase(new Phrase("S.no",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Citizen Name",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Citizen gender",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Name",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Status",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Startdate",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Enddate",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Benefit Amount",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Denail Reason",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Terminated Date",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Terminated Reason",font));
		table.addCell(cell);

		for(CitizenPlans c : plans) {
			table.addCell(String.valueOf(c.getCitizenId()));
			table.addCell(c.getCitizenName());
			table.addCell(c.getCitizenGender());
			table.addCell(c.getPlanName());
			table.addCell(c.getPlanStatus());
			table.addCell(String.valueOf(c.getPlanStartDate()));
			table.addCell(String.valueOf(c.getPlanEndDate()));
			table.addCell(String.valueOf(c.getBenefitAmount()));
			table.addCell(c.getDenialReason());
			table.addCell(String.valueOf(c.getTermiantedDate()));
			table.addCell(c.getTerminationReason());
			
		}

		doc.add(table);

		doc.close();

	}

}
