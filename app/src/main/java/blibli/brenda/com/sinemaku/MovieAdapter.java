package blibli.brenda.com.sinemaku;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import blibli.brenda.com.sinemaku.Response.MovieResp;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieVH> {

  private List<MovieResp> data;

  class MovieVH extends RecyclerView.ViewHolder {

    ImageView imgPoster;
    TextView txtRating;

    public MovieVH(View itemView) {
      super(itemView);
      imgPoster = itemView.findViewById(R.id.poster_image);
      txtRating = itemView.findViewById(R.id.txtRating);
    }
  }

  public MovieAdapter(List<MovieResp> data) {
    this.data = data;
  }

  @Override
  public MovieVH onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.itemlistmovie, parent, false);
    return new MovieVH(itemView);
  }

  //mapping data
  @Override
  public void onBindViewHolder(MovieVH holder, int position) {
    MovieResp item = data.get(position);
    holder.txtRating.setText(String.valueOf(item.getVoteAverage()));
    Glide.with(holder.imgPoster.getContext()).load("http://image.tmdb.org/t/p/w185/" + item.getPosterPath()).into(holder.imgPoster);
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

}
