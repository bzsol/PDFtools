import java.io.File;

public class PDFFilter extends javax.swing.filechooser.FileFilter{
    @Override
    public boolean accept(File f) {
        return f.getName().endsWith(".pdf");
    }

    @Override
    public String getDescription() {
        return "*.pdf";
    }
}
