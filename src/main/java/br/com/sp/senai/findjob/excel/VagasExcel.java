package br.com.sp.senai.findjob.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import br.com.sp.senai.findjob.model.CadastroDeVagas;

public class VagasExcel  {

		  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		  static String[] HEADERs = { "id", "titulo", "descricao", "exigencia","desejavel", "telefone", "email" };
		  static String SHEET = "vagas";

	
			

		  public static boolean hasExcelFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }

		  public static List<CadastroDeVagas> excelToTutorials(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();

		      List<CadastroDeVagas> tutorials = new ArrayList<CadastroDeVagas>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        CadastroDeVagas cadVagas = new CadastroDeVagas;

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  cadVagas.setId((long) currentCell.getNumericCellValue());
		            break;

		          case 1:
		        	  cadVagas.set(currentCell.getStringCellValue());
		            break;

		          case 2:
		        	  cadVagas.setDescription(currentCell.getStringCellValue());
		            break;

		          case 3:
		        	  cadVagas.setPublished(currentCell.getBooleanCellValue());
		            break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        vagas.add(cadVagas);
		      }

		      workbook.close();

		      return vagas;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
		}
