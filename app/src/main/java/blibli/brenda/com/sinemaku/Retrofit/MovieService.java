package blibli.brenda.com.sinemaku.Retrofit;

import blibli.brenda.com.sinemaku.Response.ListResponse;
import blibli.brenda.com.sinemaku.Response.MovieResp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

  @GET("movie/popular")
  //call<> menandakan api call ini asyncrhonous & supaya ga error
  Call<ListResponse<MovieResp>> findPopularMovies(@Query("api_key") String apiKey);
}
