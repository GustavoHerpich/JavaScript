public class Cifra_Cesar {
    private String textoNormal;
    private int chave;
    private String textoCifrado;

    public Cifra_Cesar(String textoNormal, int chave) {
        this.textoNormal = textoNormal;
        this.chave = chave;
        this.textoCifrado = criptografar(textoNormal, chave);
    }

    public Cifra_Cesar(String textoNormal) {
        this(textoNormal, 0);
    }

    public String getTextoNormal() {
        return textoNormal;
    }

    public void setTextoNormal(String textoNormal) {
        this.textoNormal = textoNormal;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public String getTextoCifrado() {
        return textoCifrado;
    }

    public void setTextoCifrado(String textoCifrado) {
        this.textoCifrado = textoCifrado;
    }

    private String criptografar(String texto, int chave) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String textoCifrado = "";
        for (char c : texto.toCharArray()) {
            int index = alfabeto.indexOf(c);
            if (index == -1) {
                textoCifrado += c;
            } else {
                int novoIndex = (index + chave) % 26;
                if (novoIndex < 0) {
                    novoIndex += 26;
                }
                textoCifrado += alfabeto.charAt(novoIndex);
            }
        }
        return textoCifrado;
    }
}

