import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;
import java.util.Map;

public interface ApiService {
    @GET("quotes/random")
    Call<Quote> getQuote();

    @GET("authors")
    Call<Map<String, AuthorWithQuoteCount>> listAuthors();

    @GET("quotes/author/{author}")
    Call<List<Quote>> getQuotesOfAuthor(@Path("author") String author);
}
