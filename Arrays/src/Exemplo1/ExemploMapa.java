package Exemplo1;

import java.util.HashMap;
import java.util.Map;

public class ExemploMapa {
    public static void main(String[] args) {
        HashMap<String, String> dicIngPor = new HashMap();

        dicIngPor.put("dog", "cachorro");
        dicIngPor.put("cat", "gato");

        for(Map.Entry<String, String> par:dicIngPor.entrySet()) {

            System.out.println(dicIngPor.keySet());

        }
    }
}
