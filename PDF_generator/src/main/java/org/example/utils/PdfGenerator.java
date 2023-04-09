package org.example.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import org.example.models.Address;
import org.example.models.Person;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.io.File;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;


public class PdfGenerator {
    // Specify a font that supports Cyrillic characters
    private static final Font font = FontFactory.getFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 5);

    public static void generatePDF(List<Person> personalDataList, List<Address> addressList, String filename) {
        Document document = new Document();

        try {
            PdfPTable table = prepareTable(document, filename);

            // Add data to the table
            for (Person person : personalDataList) {
                // Personal data
                table.addCell(new Phrase(person.getFirstName(), font));
                table.addCell(new Phrase(person.getLastName(), font));
                table.addCell(new Phrase(person.getMiddleName(), font));
                table.addCell(new Phrase(person.getAgeAsString(), font));
                table.addCell(new Phrase(person.getGender().label, font));
                table.addCell(new Phrase(person.getBirthDate(), font));
                table.addCell(new Phrase(person.getBirthPlace(), font));

                // Address data
                Address address = addressList.get(personalDataList.indexOf(person));
                table.addCell(new Phrase(address.getPostalCode(), font));
                table.addCell(new Phrase(address.getCountry(), font));
                table.addCell(new Phrase(address.getRegion(), font));
                table.addCell(new Phrase(address.getCity(), font));
                table.addCell(new Phrase(address.getStreet(), font));
                table.addCell(new Phrase(address.getHouse(), font));
                table.addCell(new Phrase(address.getApartment(), font));

            }
            document.add(table);
            document.close();

            System.out.println("Файл создан. Путь: " + new File(filename).getAbsolutePath());

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static PdfPTable prepareTable(Document document, String filename)
            throws FileNotFoundException, DocumentException {
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();

        PdfPTable table = new PdfPTable(14);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);


        PdfPCell cell;

        // Table headers
        cell = new PdfPCell(new Phrase("Имя", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Фамилия", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Отчество", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Возраст", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Пол", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Дата рождения", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Место рождения", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Индекс", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Страна", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Область", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Город", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Улица", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Дом", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Квартира", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        return table;
    }
}
