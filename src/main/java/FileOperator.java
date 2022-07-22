import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileOperator extends Component implements FileOperations {

    @Override
    public  File[] ReadPDFs() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new PDFFilter());
        if(fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION ){
            return fileChooser.getSelectedFiles();
        }
        return null;
    }

    @Override
    public String getPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify where to save the PDF");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileFilter(new PDFFilter());
        if (fileChooser.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
        }
        return null;
    }
}
