import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        String consulta="";

        String MOEDA_ATUAL = "", MOEDA_DESTINO = "", valor = "";
       
        String BASE_URL = "https://v6.exchangerate-api.com/v6/";
        //GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
        int escolha = 0;

        do {
            System.out.println("***************************************************");
            System.out.println("Bem Vindo(a) ao Conversor de Moedas!\n");
            System.out.println("1 - Dolar >> Peso Argentino");
            System.out.println("2 - Peso Argentino >> Dolar");
            System.out.println("3 - Dolar >> Real Brasileiro");
            System.out.println("4 - Real Brasileiro >> Dolar");
            System.out.println("5 - Dolar >> Peso Colombiano");
            System.out.println("6 - Peso Colombiano >> Dolar");
            System.out.println("7 - Sair");
            System.out.println("Escolha uma opção: ");
            escolha = scanner.nextInt();
            if(escolha!=7){
                System.out.println("Digite o valor que deseja converter: ");
                valor = scanner.next();
            }
            switch (escolha) {
                case 1:
                    consulta = BASE_URL+API_KEY+"pair/USD/ARS/"+valor;
                    //System.out.println(consulta);
                    conversor.converte(consulta);
                    break;
                case 2:
                    consulta = BASE_URL+API_KEY+"pair/ARS/USD/"+valor;
                    //System.out.println(consulta);
                    conversor.converte(consulta);
                    break;
                case 3:
                    consulta = BASE_URL+API_KEY+"pair/USD/BRL/"+valor;
                    //System.out.println(consulta);
                    conversor.converte(consulta);
                    break;
                case 4:
                    consulta = BASE_URL+API_KEY+"pair/BRL/USD/"+valor;
                    //System.out.println(consulta);
                    conversor.converte(consulta);
                    break;
                case 5:
                    consulta = BASE_URL+API_KEY+"pair/USD/COP/"+valor;
                    //System.out.println(consulta);
                    conversor.converte(consulta);
                    break;
                case 6:
                    consulta = BASE_URL+API_KEY+"pair/COP/USD/"+valor;
                    //System.out.println(consulta);
                    conversor.converte(consulta);
                    break;
                case 7:
                    System.out.println("Encerrando ... ");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (escolha != 7);
        System.out.println("Fim. ");
    }
}
