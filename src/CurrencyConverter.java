
import java.util.Scanner;

public class CurrencyConverter {
    private String sourceCurrency;
    private String targetCurrency;
    private double exchangeRate;
    private final Scanner scanner;
    private final ExchangeRateQuery exchangeRateQuery;

    public CurrencyConverter() {
        scanner = new Scanner(System.in);
        exchangeRateQuery = new ExchangeRateQuery();
        sourceCurrency = "";
        targetCurrency = "";
        exchangeRate = 0.0;
    }

    public void start() {

        int mainMenuSelection = -1;

        while (mainMenuSelection != 0) {

            displayMainMenu();
            mainMenuSelection = scanner.nextInt();

            switch (mainMenuSelection) {
                case 1:
                    chooseSourceCurrency();
                    break;
                case 2:
                    chooseTargetCurrency();
                    break;
                case 3:
                    executeConversion();
                    break;
                case 0:
                    System.out.println("Conversão finalizada. Volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("""
                
                ****************************************
                       CONVERSOR DE MOEDAS - MENU
                ****************************************
                
                1 - Escolha a moeda de origem
                2 - Escolha a moeda de destino
                3 - Insira o valor desejado
                0 - Sair
                
                ****************************************
                
                Selecione uma das opções:""");
    }

    private void chooseSourceCurrency() {
        System.out.println("""
                
                ****************************************
                      SELECIONE A MOEDA DE ORIGEM
                ****************************************
                
                1 - Dólar Americano (USD)
                2 - Dólar Canadense (CAD)
                3 - Euro (EUR)
                4 - Real (BRL)
                5 - Won Sul Coreano (KRW)
                6 - Iene (JPY)
                
                ****************************************
                
                Selecione uma das opções:""");

        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                sourceCurrency = "USD";
                break;
            case 2:
                sourceCurrency = "CAD";
                break;
            case 3:
                sourceCurrency = "EUR";
                break;
            case 4:
                sourceCurrency = "BRL";
                break;
            case 5:
                sourceCurrency = "KRW";
                break;
            case 6:
                sourceCurrency = "JPY";
                break;
            default: System.out.println("Opção inválida!");
        }

        exchangeRateQuery.setSourceCurrency(sourceCurrency);

        System.out.println("Sua moeda de origem selecionada é: " + sourceCurrency);
    }

    private void chooseTargetCurrency() {
        System.out.println("""
                
                ****************************************
                      SELECIONE A MOEDA DE DESTINO
                ****************************************
                
                1 - Dólar Americano (USD)
                2 - Dólar Canadense (CAD)
                3 - Euro (EUR)
                4 - Real (BRL)
                5 - Won Sul Coreano (KRW)
                6 - Iene (JPY)
                
                ****************************************
                
                Selecione uma das opções:""");

        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                targetCurrency = "USD";
                break;
            case 2:
                targetCurrency = "CAD";
                break;
            case 3:
                targetCurrency = "EUR";
                break;
            case 4:
                targetCurrency = "BRL";
                break;
            case 5:
                targetCurrency = "KRW";
                break;
            case 6:
                targetCurrency = "JPY";
                break;
            default: System.out.println("Opção inválida!");
        }

        exchangeRateQuery.setTargetCurrency(targetCurrency);

        System.out.println("Sua moeda de destino selecionada é: " + targetCurrency);
    }

    private void executeConversion() {

        System.out.println("Digite o valor desejado:");

        double valueToExchange = scanner.nextDouble();

        System.out.printf("""
                
                ****************************************
                Valor inserido: %.2f %s
                
                """, valueToExchange, sourceCurrency);

        exchangeRate = exchangeRateQuery.calculateExchangeRate(sourceCurrency, targetCurrency);
        System.out.println("Taxa de câmbio atual: " + exchangeRate);

        double exchangedValue = valueToExchange * exchangeRate;
        System.out.printf("\nValor convertido: %.2f %s\n", exchangedValue, targetCurrency);
    }
}