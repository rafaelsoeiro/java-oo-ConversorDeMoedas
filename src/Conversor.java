import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public void converte(String endereco) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ApiResponse apiResponse = gson.fromJson(json, ApiResponse.class);

        double valor = 0;
        if ("success".equals(apiResponse.getResult())) {
            valor=apiResponse.getConversion_result()/apiResponse.getConversion_rate();
            System.out.println("O valor "+ (String.format("%.2f", valor))+" ["+apiResponse.getBase_code()+"] corresponde a "+String.format("%.2f", apiResponse.getConversion_result())+" ["+apiResponse.getTarget_code()+"]");
        } else {
            System.out.println("Erro ao obter os dados: " + apiResponse.getResult());
        }
    }

}
