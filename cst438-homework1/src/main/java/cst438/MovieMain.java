/**
 * Main file for routing requests
 */


package cst438;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieMain {

  @Autowired
  MovieRatingRepository movieRatingRepository;

  /**
   * Display a form to rate a movie
   * 
   * @param model
   * @return view of movie form
   */
  @GetMapping("/movies/new")
  public String createRating(Model model) {
    MovieRating movieRating = new MovieRating();
    model.addAttribute("movieRating", movieRating);
    return "movie_form";
  }

  /**
   * Display all movie ratings, sorted by movie title and most recent rating first.
   * 
   * @param model
   * @return view of all ratings
   */
  @GetMapping("/movies")
  public String displayRatings(Model model) {
    Iterable<MovieRating> ratings = movieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
    model.addAttribute("ratings", ratings);
    return "ratings_list";
  }

  /**
   * Process the posting of a new rating
   * 
   * @param movieRating
   * @param result
   * @param model
   * @return view of the posted rating
   */
  @PostMapping("/movies/new")
  public String postRating(@Valid MovieRating movieRating, BindingResult result, Model model) {

    if (result.hasErrors()) {
      return "movie_form";
    }
    movieRating.setDate(new java.util.Date());
    movieRatingRepository.save(movieRating);
    return "movie_show";
  }

}
