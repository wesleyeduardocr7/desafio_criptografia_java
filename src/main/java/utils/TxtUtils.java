package utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TxtUtils {

    public static void escreverEmArquivoTxt(String diretorio, String fraseDesCriptografada) {

        File arquivo = new File("src/main/"+diretorio+".txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fraseDesCriptografada);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
