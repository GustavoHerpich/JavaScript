package nutricionista;

public class Consulta_Cadastro {
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) {
//        ArrayList<Cliente> lista_Cliente = new ArrayList();
//
//    }
//
//    public static ArrayList<Alimentação> busca_Alimentação(int id_cliente) throws IOException, SQLException {
//
//        ArrayList<Alimentação> alimentaçãos = new ArrayList<>();
//        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH_alimentacao);
//        statement.setInt (1, id_cliente);
//        ResultSet result = statement.executeQuery();
//        while (result.next()) {
//
//            Integer id = result.getInt("id");
//            String descricao = result.getString("descrição");
//            String periodo = result.getString("periodo");
//            Double grama = result.getDouble("grama");
//            String dia_semana = result.getString("dia_semana");
//            Alimentação alimentação = new Alimentação(descricao, periodo, grama, dia_semana);
//            alimentação.setId(id);
//            alimentaçãos.add(alimentação);
//
//        }
//
//
//        return alimentaçãos;
//    }
//
//    public static ArrayList<Remédios> busca_Remédios(int id_cliente) throws IOException, SQLException {
//
//        ArrayList<Remédios> remédios = new ArrayList<>();
//        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH_alimentacao);
//        statement.setInt (1, id_cliente);
//        ResultSet result = statement.executeQuery();
//        while (result.next()) {
//
//            Integer id = result.getInt("id");
//            String nome = result.getString("nome");
//            Double dose_diaria = result.getDouble("dose_diaria");
//            Double tempo_total = result.getDouble("tempo_total");
//            String dia_semana = result.getString("dia_semana");
//            Double intervalos = result.getDouble("intervalos");
//            Remédios remedio = new Remédios(nome, dose_diaria, tempo_total, dia_semana, intervalos);
//            remedio.setId(id);
//            remédios.add(remedio);
//
//        }
//
//        return remédios;
//    }
//
//    public static ArrayList<Restrição> busca_Restrição(int id_cliente) throws IOException, SQLException {
//
//        ArrayList<Restrição> restricao  = new ArrayList<>();
//        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH_alimentacao);
//        statement.setInt (1, id_cliente);
//        ResultSet result = statement.executeQuery();
//        while (result.next()) {
//
//            Integer id = result.getInt("id");
//            String tipo = result.getString("tipo");
//            String descricao = result.getString("descricao");
//            Restrição restrição = new Restrição(tipo, descricao);
//            restrição.setId(id);
//            restricao.add(restrição);
//
//        }
//
//        return restricao;
//    }
//
//
//
//
//    public static void deletar_Cliente() throws IOException, SQLException {
//        System.out.println("Qual o nome do seu cliente");
//        String cliente_Pesquisa = br.readLine();
//
//        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.REMOVE_cliente);
//        statement.setString (1, cliente_Pesquisa);
//        statement.executeUpdate();
//
//    }
//
//    public static void alterar_Cadastro() throws IOException, SQLException {
//        System.out.println("Qual o nome do seu cliente");
//        String cliente_Pesquisa = br.readLine();
//
//        PreparedStatement statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.SEARCH, Statement.RETURN_GENERATED_KEYS);
//        statement.setString (1, cliente_Pesquisa);
//        ResultSet result = statement.executeQuery();
//        if (!result.next()) {
//            System.out.println("Error");
//            return;
//        }
//        System.out.println("Qual o nome do seu cliente");
//        String altera_nome = br.readLine();
//        System.out.println("Qual o nome do seu sexo");
//        String altera_sexo = br.readLine();
//        System.out.println("Qual o nome do seu idade");
//        Integer altera_idade = Integer.parseInt(br.readLine());
//        System.out.println("Qual o nome do seu email");
//        String altera_email = br.readLine();
//        System.out.println("Qual o nome do seu celular");
//        Integer altera_celular = Integer.parseInt(br.readLine());
//        System.out.println("Qual o nome do seu endereco");
//        String altera_endereco = br.readLine();
//
//        statement = Conexão_Banco.getConnection().prepareStatement(Funções_com_BD.UPDATE_cliente);
//        statement.setString (1, altera_nome);
//        statement.setString (2, altera_sexo);
//        statement.setInt (3, altera_idade);
//        statement.setString (4, altera_email);
//        statement.setInt (5, altera_celular);
//        statement.setString (6, altera_endereco);
//        statement.executeQuery();
//
//
//
//    }

}
