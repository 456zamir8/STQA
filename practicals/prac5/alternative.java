package excelwrite;

import jxl.*; // used for WorkbookSettings, Workbook
import jxl.write.*; // used for WriteException, WritableWorkbook, WritableSheet, Label
import jxl.write.Number; // used for Number
import java.io.*; // used for IOException, File
import java.util.Locale; // used for Locale

public class Excelwriter {
    public static void main(String[] args) throws IOException, WriteException {
        // Data initialization
        String header[] = {"Student Name", "Subject1", "Subject2", "Subject3", "Total"};
        String sname[] = {"Carls", "James", "Paul", "Philip", "Smith", "Thomson", "Rhodey", "Stark", "Gary", "AnneMarie"};
        
        // Marks for 3 subjects for each student
        int marks[][] = {
            {50, 60, 70}, {45, 55, 65}, {60, 70, 80}, {55, 65, 75}, {70, 80, 90},
            {45, 50, 55}, {67, 77, 87}, {78, 88, 98}, {89, 79, 69}, {90, 85, 95}
        };
        
        File file = new File("student.xls");
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        
        // Creating header row
        for (int c = 0; c < header.length; c++) {
            Label l = new Label(c, 0, header[c]);
            excelSheet.addCell(l);
        }

        // Filling student names and marks
        for (int r = 1; r <= sname.length; r++) {
            // Filling student names in column 1
            Label nameLabel = new Label(0, r, sname[r - 1]);
            excelSheet.addCell(nameLabel);

            // Filling marks for each subject
            int total = 0;
            for (int c = 1; c <= 3; c++) {
                Number mark = new Number(c, r, marks[r - 1][c - 1]);
                excelSheet.addCell(mark);
                total += marks[r - 1][c - 1]; // Calculate total marks
            }

            // Filling total in column 5
            Number totalMarks = new Number(4, r, total);
            excelSheet.addCell(totalMarks);
        }

        // Write and close the workbook
        workbook.write();
        workbook.close();
        System.out.println("Excel File Created!!!!!");
    }
}
