package Games.HangManWaleed; 

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.Random;

import javax.swing.SwingUtilities;

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
public class InputExcel {
	static int prevNum = -1;
	static int prevprevNum = -1;
	static char[] WordArray1 = new char[30];
	String Word;
	static String Hint1;
	static String Hint2;
	static String Hint3;
	static String Hint4;
	static String Hint5;

	

	public void Init() {
		for(int x =0; x<30;x++) {
			WordArray1[x] ='\0';
			
		}
	}
	public String CellRead() throws IOException {
			Init();
			FileInputStream xcel;
			xcel = new FileInputStream("HangMan.xlsx") ;
			Workbook HangManBook = new XSSFWorkbook(xcel);
			Sheet Sheet1 = HangManBook.getSheetAt(0);
			int RowNum = RandomNumNoRep();
			Row Word1 = Sheet1.getRow(RowNum);
			Cell Pos = Word1.getCell(0);
			Cell H1 =Word1.getCell(1);
			Cell H2 = Word1.getCell(2);
			Cell H3 = Word1.getCell(3);
			Cell H4 = Word1.getCell(4);
			Cell H5 = Word1.getCell(5);

			
			String HangWord = Pos.getStringCellValue();
			Hint1 = H1.getStringCellValue();
			Hint2 =H2.getStringCellValue();
			Hint3 =H3.getStringCellValue();
			Hint4 =H4.getStringCellValue();
			Hint5 =H5.getStringCellValue();

			Word = HangWord;
			HangManBook.close();
		return HangWord;
		
	}
	public int RandomNumNoRep() throws IOException {
		Random RanRow = new Random();
		int NoofWord = NoOfWords();
		int RandRowNum = RanRow.nextInt(NoofWord+1);
		while ((prevNum == RandRowNum) || (prevprevNum == RandRowNum)) {
			RandRowNum = RanRow.nextInt(NoofWord+1);
		}
		prevprevNum = prevNum;	
		prevNum = RandRowNum;
		
		return RandRowNum;
	}
	public int NoOfWords() throws IOException {
		FileInputStream xcel;
		xcel = new FileInputStream("HangMan.xlsx") ;
		Workbook HangManBook = new XSSFWorkbook(xcel);
		Sheet Sheet1 = HangManBook.getSheetAt(0);
		int WordCount = Sheet1.getLastRowNum();
		return WordCount;
	}
	public void StringtoCharArray() {
		
		char[] WordArray = new char[Word.length()];
		int len = WordArray.length;
		
		for(int i =0; i<WordArray.length; i++) {
			WordArray [i] = Word.charAt(i);
			WordArray1[i] = WordArray[i];
		}
	}
	public static void run() {
		
     try {
		new HangGame();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
            }
}
