public class TesteCarro {

    public static void main(String[] args) {
        Carro gol = new Carro();
        Carro uno = new Carro();
        Carro HB20 = new Carro();

        gol.marca = "Wolkswagen";
        gol.cor = "branca";
        gol.placa = "XYZ9803";
        uno.marca = "Fiat";
        uno.cor = "vermelha";
        uno.placa = "ABC4445";
        HB20.marca = "Hyundi";
        HB20.cor = "Vermelho";
        HB20.placa = "EWQ3215";
        System.out.println(gol);
        System.out.println(uno);
        System.out.println(HB20);
        gol.ligar();
        gol.acelerarAte(20);
        gol.mudarMarcha('2');
        System.out.println(gol);
        System.out.println(uno);
        uno.ligar();
        gol.acelerarAte(50);
        gol.mudarMarcha('3');
        uno.acelerarAte(10);
        uno.mudarMarcha('2');
        System.out.println(gol);
        System.out.println(uno);
        HB20.ligar();
        HB20.mudarMarcha('2');
        HB20.acelerarAte(20);
        System.out.println(HB20);
        HB20.ano = 1970;
        HB20.dono = "Gustavo";
        System.out.println(HB20);
    }
}
