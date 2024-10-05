//AIM: Write and test a program to select the number of students from Excel file(table) who have scored 60 or more in any one subject(or all subjects).

package excelread;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.NumberCell;

public class Excelreader {
    private String inputFile;

    // Set the input file path
    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    // Read the Excel file and count marks >= 60
    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        int count = 0;
        
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            
            // Loop over all rows and columns
            for (int j = 1; j < sheet.getRows(); j++) { // start from row 1 to skip the header
                boolean hasHighScore = false;

                for (int i = 1; i < sheet.getColumns() - 1; i++) { // skipping the name column
                    Cell cell = sheet.getCell(i, j);

                    // Check if the cell contains a number
                    if (cell instanceof NumberCell) {
                        NumberCell numberCell = (NumberCell) cell;
                        int mark = (int) numberCell.getValue();

                        // Check if mark is >= 60
                        if (mark >= 60) {
                            hasHighScore = true;
                        }
                    }
                }

                // If the student has one or more marks >= 60, increment count
                if (hasHighScore) {
                    count++;
                }
            }

            System.out.println("Total number of students who scored more than 60 in one or more subjects: " + count);

        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // Create an instance of Excelreader and set the input file
        Excelreader test = new Excelreader();
        test.setInputFile("C:\\Users\\Usman\\eclipseworkspace\\p5\\student.xls"); // put the path of the saved excel file

        // Read the file and process it
        test.read();
    }
}
