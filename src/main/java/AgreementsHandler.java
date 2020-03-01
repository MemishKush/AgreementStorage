import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AgreementsHandler {


    public void storeAgreement(Agreement agreement) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(agreement.getName()));
        writer.append(agreement.toString());
        writer.close();
    }
}
