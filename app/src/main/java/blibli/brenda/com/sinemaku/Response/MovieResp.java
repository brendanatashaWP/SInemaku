package blibli.brenda.com.sinemaku.Response;

import com.google.gson.annotations.SerializedName;

public class MovieResp {
  @SerializedName("poster_path")
  private String posterPath;

  private String title;

  @SerializedName("vote_average")
  private Double voteAverage;

  public String getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(Double voteAverage) {
    this.voteAverage = voteAverage;
  }
}
