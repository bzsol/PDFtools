import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Invalid command or no command at all!\nPlease use -help");
            System.exit(1);
        }
        List<String> parameters = Arrays.asList(args);
        if(parameters.contains("-help")){
            System.out.println("Merge: -merge");
            System.out.println("Help: -help");
            System.out.println("Merge by page: -advanced");
        }
        if(parameters.contains("-merge")){
            PDFMergerUtility merger = new PDFMergerUtility();
            FileOperator fileOperator = new FileOperator();
            File[] selected = fileOperator.ReadPDFs();
            for(var items : selected){
                try{
                    merger.addSource(items);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            merger.setDestinationFileName(fileOperator.getPath());
            try{
                merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
                System.out.println("Merge completed!");
                System.out.println("The file saved here: " + merger.getDestinationFileName());
                System.exit(0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
