public class DadosJson {

    private String encryptedPhrase;
    private int numberOfDigits;
    private String outputDir;

    public DadosJson() {
    }

    public String getEncryptedPhrase() {
        return encryptedPhrase;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public String getOutputDir() {
        return outputDir;
    }

    @Override
    public String toString() {
        return "DadosJson{" +
                "encryptedPhrase='" + encryptedPhrase + '\'' +
                ", numberOfDigits=" + numberOfDigits +
                ", outputDir='" + outputDir + '\'' +
                '}';
    }
}
