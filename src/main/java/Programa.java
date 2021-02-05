import com.google.gson.Gson;
import utils.DescriptografarUtils;
import utils.StringUtils;
import utils.TxtUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Programa {

    public static void main(String[] args) {

        String dadosJsonParaLeitura = getDadosJson();
        DadosJson dadosJson = new Gson().fromJson(dadosJsonParaLeitura, DadosJson.class);
        String frasseCriptografada = dadosJson.getEncryptedPhrase();
        int chaveDeDeslocamento = dadosJson.getNumberOfDigits() * -1;

        String diretorioFraseDescriptografada = dadosJson.getOutputDir()+ "/frases_descriptografada";

        String fraseCriptografadaSemNumeros = StringUtils.retirarCaracteresNumericos(frasseCriptografada);

        String fraseCriptografadaSemNumerosEComTodosOsCaracteresMinusculos = fraseCriptografadaSemNumeros.toLowerCase();

        String fraseDescriptografada = DescriptografarUtils.descriptografar(fraseCriptografadaSemNumerosEComTodosOsCaracteresMinusculos, chaveDeDeslocamento);

        TxtUtils.escreverEmArquivoTxt(diretorioFraseDescriptografada, fraseDescriptografada);
    }

    public static String getDadosJson() {
        try {
            return String.join(" ",
                    Files.readAllLines(
                            Paths.get("src/main/resources/settings_confidencial.json"),
                            StandardCharsets.UTF_8)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
