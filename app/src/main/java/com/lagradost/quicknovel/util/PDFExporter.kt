import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.canvas.PdfCanvas
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.property.TextAlignment

class PDFExporter {
    fun exportPDF(content: String, filePath: String) {
        val writer = PdfWriter(filePath)
        val pdf = PdfDocument(writer)
        val document = Document(pdf)

        // Add content to the PDF
        val paragraph = Paragraph(content)
            .setTextAlignment(TextAlignment.LEFT)
        document.add(paragraph)

        // Close the document
        document.close()
    }
}