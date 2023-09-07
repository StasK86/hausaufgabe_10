package com.krigersv;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipFilesTests {
    private static String zip = "probe.zip";
    private static String pdfFile = "Beispieltest.pdf";
    private static String csvFile = "Beispieltest.csv";
    private static String xlsFile = "Beispieltest.xlsx";
    private static String substance = "Test case example";

    private static ClassLoader cl = ZipFilesTests.class.getClassLoader();

    private InputStream fileFromZip(String fileName) throws Exception {
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream(zip));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) { if (entry.getName().equals(fileName)) {return is;}
        }
        throw new Exception();
    }

    @Test
    @DisplayName("pdf")
    void findPdfZip() throws Exception {
        try (InputStream inputStream = fileFromZip(pdfFile)) {
            PDF pdf = new PDF(inputStream);
            String pdfText = pdf.text;
            assertThat(pdfText).startsWith(substance);
        }
    }

    @Test
    @DisplayName("csv")
    void findCsvZip() throws Exception {
        try (InputStream inputStream = fileFromZip(csvFile);
             CSVReader reader = new CSVReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String firstValue = reader.readNext()[0];
            assertThat(firstValue).contains(substance);
        }
    }

    @Test
    @DisplayName("xls")
    void findXlsZip() throws Exception {
        try (InputStream inputStream = fileFromZip(xlsFile)) {
            XLS xls = new XLS(inputStream);
            String firstCellValue = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
            assertThat(firstCellValue).contains(substance);
        }
    }
}