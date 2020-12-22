import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadFileExample {

    public static void main(String[] args) {
        BufferedReader sourceFile = null;
        FileWriter copyFile = null;
        Date date = new Date();
        String strDateFormat = "yyyyMMddhhmmss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);

        try {
            String strCurrentLine;

            sourceFile = new BufferedReader(
                    new FileReader("C:\\Users\\dceaicovschi\\OneDrive - ENDAVA\\Documents\\Folder\\DEMO_SAMA\\BREG_MILA01_20201108012517_IN.csv"));

            copyFile = new FileWriter("C:\\Users\\dceaicovschi\\Downloads\\"
                    + "BREG_DimaPart_" + dateFormat.format(date) + "_in.csv");

            while ((strCurrentLine = sourceFile.readLine()) != null) {
                copyFile.write(strCurrentLine + "\n");
                System.out.println(strCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (sourceFile != null) {
                    sourceFile.close();
                }
                copyFile.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
