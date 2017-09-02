package be.axxes.hackaton.timesheets.util;

import be.axxes.hackaton.timesheets.model.Activity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PdfWriterTimesheet {

    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createPdf(String filename, Iterable<Activity> activities)
            throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(createTable(activities));
        // step 5
        document.close();
    }

    /**
     * Creates our first table
     * @return our first table
     */
    public static PdfPTable createTable(Iterable<Activity> activities) {

        DateFormat format = new SimpleDateFormat("DD dd");

        PdfPTable table = new PdfPTable(2);
        for (Activity activity: activities){

            table.addCell(activity.getDate().toString());
            table.addCell(String.valueOf(activity.getDuration()));
        }
        return table;
    }
}


