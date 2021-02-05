package utils;
import java.util.Arrays;
import java.util.List;

public class DescriptografarUtils {

    public static String descriptografar(String texto, int chaveDeDescolamento) {

        if (texto.isEmpty())
            throw new IllegalArgumentException();
        try {

            StringBuilder textoCifrado = new StringBuilder();

            int tamanhoTexto = texto.length();

            Integer n[] = new Integer[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
            List<Integer> numerosASCII = Arrays.asList(n);

            for (int c = 0; c < tamanhoTexto; c++) {

                int letraCifradaASCII;

                int letraASCII = texto.charAt(c);

                if (letraASCII != 32 && !numerosASCII.contains(letraASCII)) {
                    letraCifradaASCII = ((int) texto.charAt(c)) + chaveDeDescolamento;
                } else {
                    letraCifradaASCII = letraASCII;
                }

                while (letraCifradaASCII > 126){
                    letraCifradaASCII -= 94;
                }

                textoCifrado.append((char) letraCifradaASCII);
            }

            return textoCifrado.toString().toLowerCase();

        } catch (Exception e) {
            throw new UnsupportedOperationException("Não foi possível Executar Operação");
        }
    }
}
