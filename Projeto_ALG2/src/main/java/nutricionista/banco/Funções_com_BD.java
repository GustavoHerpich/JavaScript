package nutricionista.banco;

public class Funções_com_BD {

    public static final String INSERT_cliente = "insert into cliente (nome, sexo, idade, email, celular, endereco) values (?, ?, ?, ?, ?, ?)";
    public static final String INSERT_alimentacao = "insert into alimentacao (descricao, periodo, grama, dia_semana, id_cliente) values (?, ?, ?, ?, ?)";
    public static final String INSERT_remedio = "insert into remedio (prescricao, dose_diaria, tempo_total, dia_semana, intervalos, id_cliente) values (?, ?, ?, ?, ?, ?)";
    public static final String INSERT_restricao = "insert into restricao (tipo, descricao, id_cliente) values (?, ?, ?)";


    public static final String UPDATE_cliente = "update nutricionista.Cliente set ";

    public static final String REMOVE_cliente = "delete from cliente where nome = ?";

    public static final String REMOVE_alimentacao = "delete from alimentacao where id = ?";
    public static final String REMOVE_restricao = "delete from restricao where id = ?";
    public static final String REMOVE_remedio = "delete from remedio where id = ?";


    public static final String SEARCH_cliente = "select * from cliente where nome = ?";
    public static final String SEARCH_alimentacao = "select * from alimentacao where id_cliente = ?";
    public static final String SEARCH_restricao = "select * from restricao where id_cliente = ?";
    public static final String SEARCH_remedio = "select * from remedio where id_cliente = ?";
}