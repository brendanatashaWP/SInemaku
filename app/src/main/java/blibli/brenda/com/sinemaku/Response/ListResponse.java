package blibli.brenda.com.sinemaku.Response;

import java.util.List;

public class ListResponse<T> {
  private List<T> results;

  public List<T> getResults() {
    return results;
  }

  public void setResults(List<T> results) {
    this.results = results;
  }
}
