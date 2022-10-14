package br.com.sp.senai.findjob.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import br.com.sp.senai.findjob.model.CadastroDeVagas;

public class VagasExcel  {
	

		  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		  static String[] HEADERs = { "id", "titulo", "descricao", "exigencia","desejavel", "telefone", "email", "areaVaga" };
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

		      List<CadastroDeVagas> vagas = new ArrayList<CadastroDeVagas>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		       CadastroDeVagas cad = new CadastroDeVagas();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		
		          switch (cellIdx) {
		          case 0:
		        	  cad.setId((long) currentCell.getNumericCellValue());
		            break;

		          case 1:
		        	  cad.setTitulo(currentCell.getStringCellValue());
		            break;

		          case 2:
		        	  cad.setDescricao(currentCell.getStringCellValue());
		            break;

		          case 3:
		        	  cad.setExigencia(currentCell.getStringCellValue());
		            break;
		          case 4:
		        	  cad.setDesejavel(currentCell.getStringCellValue());
		            break;
		          case 5:
		        	  cad.setTelefone(currentCell.getStringCellValue());
		            break;
		          case 6:
		        	  cad.setEmail(currentCell.getStringCellValue());
		            break;
		          case 7:
		        	  cad.setAreaVaga(currentCell.getStringCellValue());
		            break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		       vagas.add(cad);
		      }

		      workbook.close(); 

		      return vagas;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
		}
