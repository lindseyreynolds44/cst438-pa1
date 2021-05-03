package cst438;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRatingRepository extends CrudRepository<MovieRating, Long> {

  @Query("select m from MovieRating m order by title, date desc")
  ArrayList<MovieRating> findAllMovieRatingsOrderByTitleDateDesc();
}
