import java.io.FileInputStream;
import java.io.FileOutputStream;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.testng.annotations.*;

public class exp5 {

    @BeforeClass
    public void setUp() throws Exception {
        // Setup code if needed
    }

    @Test
    public void testImportExport() throws Exception {
        // Use try-with-resources for automatic resource management
        try (FileInputStream fileInput = new FileInputStream("C:\\Users\\zamir\\zamir\\STQA\\marks.xlsx");
             FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\zamir\\zamir\\STQA\\results.xlsx")) {

            Workbook workbook = Workbook.getWorkbook(fileInput);
            Sheet sheet = workbook.getSheet(0);

            WritableWorkbook writableWorkbook = Workbook.createWorkbook(fileOutput);
            WritableSheet writableSheet = writableWorkbook.createSheet("result", 0);

            int rowCountOffset = 0;
            for (int i = 0; i < sheet.getRows(); i++) {
                // Only apply the check for rows after the first
                if (i >= 1) {
                    String cellContent = sheet.getCell(3, i).getContents();
                    int value = Integer.parseInt(cellContent);

                    // Skip writing this row if the value is less than 60
                    if (value < 60) {
                        rowCountOffset++;
                        continue;
                    }
                }

                // Write data to the new sheet
                for (int j = 0; j < sheet.getColumns(); j++) {
                    String cellContent = sheet.getCell(j, i).getContents();
                    Label label = new Label(j, i - rowCountOffset, cellContent);
                    writableSheet.addCell(label);
                }
            }

            writableWorkbook.write();
            writableWorkbook.close();
        } catch (Exception e) {
            e.printStackTrace(); // For debugging, log the exception
        }
    }
}
