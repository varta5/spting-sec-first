import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PracticeRetrofit {
    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://programming-quotes-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        printAllQuotesOfRandomAuthor(apiService);

    }

    public static void printRandomQuote(ApiService apiService) {
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

    public static void printAllQuotesOfRandomAuthor(ApiService apiService) {
        Map<String, AuthorWithQuoteCount> authorList;
        try {
            authorList = apiService.listAuthors().execute().body();
            System.out.println();
        } catch (IOException exception) {
            exception.printStackTrace();
            authorList = new HashMap<>();
        }
        List<String> listOfAuthors = authorList.keySet().stream().collect(Collectors.toList());
        Random random = new Random();
        List<Quote> quotesOfRandomAuthor = getAllQuotesOfAuthor(apiService, listOfAuthors.get(random.nextInt(listOfAuthors.size())));
        System.out.println("------------------- All quotes from " + quotesOfRandomAuthor.get(0).getAuthor() + " -------------------");
        for (Quote quote : quotesOfRandomAuthor) {
            System.out.println("ID: " + quote.getId());
            System.out.println("Quote text: " + quote.getEn());
        }
        System.out.println("---------------------------------- END ----------------------------------");
    }

    public static List<Quote> getAllQuotesOfAuthor(ApiService apiService, String author) {
        List<Quote> quoteList;
        try {
            quoteList = apiService.getQuotesOfAuthor(author).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            quoteList = new ArrayList<>();
        }
        return quoteList;
    }
}
