import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class PracticeRetrofit {
    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://programming-quotes-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Quote randomQuote = new Quote();

        try {
            randomQuote = apiService.getQuote().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (randomQuote != null) {
            System.out.println("--- A random quote from https://programming-quotes-api.herokuapp.com/ ---");
            System.out.println("ID: " + randomQuote.getId());
            System.out.println("Author: " + randomQuote.getAuthor());
            System.out.println("Quote text: " + randomQuote.getEn());
            System.out.println("---------------------------------- END ----------------------------------");
        }
    }
}
