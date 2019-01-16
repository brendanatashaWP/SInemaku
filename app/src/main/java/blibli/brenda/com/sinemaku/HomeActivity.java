package blibli.brenda.com.sinemaku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import blibli.brenda.com.sinemaku.Response.ListResponse;
import blibli.brenda.com.sinemaku.Response.MovieResp;
import blibli.brenda.com.sinemaku.Retrofit.MovieService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

  private MovieService movieService;
  private MovieAdapter movieAdapter;
  private RecyclerView recyclerView;
  private LinearLayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    recyclerView = findViewById(R.id.rvMovie);
    layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    recyclerView.setLayoutManager(layoutManager);

    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/3/")
      .addConverterFactory(GsonConverterFactory.create())
      .build();
    movieService = retrofit.create(MovieService.class);

    movieService.findPopularMovies("4bbbfeaa56287e045385e892563e7168")
      .enqueue(new Callback<ListResponse<MovieResp>>() {
      @Override
      public void onResponse(Call<ListResponse<MovieResp>> call,
                             Response<ListResponse<MovieResp>> response) {
        //HTTP 200
        if (response.isSuccessful()) {
          ListResponse<MovieResp> responseContent = response.body();
          movieAdapter = new MovieAdapter(responseContent.getResults());
          recyclerView.setAdapter(movieAdapter);
        } else {
          Toast.makeText(HomeActivity.this, "HTTP error", Toast.LENGTH_SHORT).show();
        }
      }

      @Override
      public void onFailure(Call<ListResponse<MovieResp>> call,
                            Throwable t) {
        //kasih toast error
        Toast.makeText(HomeActivity.this, "HTTP error", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
