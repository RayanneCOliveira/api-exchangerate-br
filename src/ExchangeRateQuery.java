import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateQuery {

    private final String apiKey = "5de534c3ede12f71ce431115";
    private String sourceCurrency;
    private String targetCurrency;
    private double exchangeRate;

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double calculateExchangeRate (String sourceCurrencyCode, String targetCurrencyCode) {

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + sourceCurrency + "/" + targetCurrency;
        JsonObject jsonResponse;

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            jsonResponse = gson.fromJson(response.body(), JsonObject.class);

            return exchangeRate = jsonResponse.get("conversion_rate").getAsDouble();

        } catch (Exception e) {

            System.out.println("Ocorreu um erro: Não foi possível obter a taxa de câmbio.");
        }
        return exchangeRate;
    }
}