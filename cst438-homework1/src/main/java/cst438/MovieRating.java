/**
 * Movie Rating class. Used to create movie rating objects to be stored in the DB
 */

package cst438;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieRating {

  @Id
  @GeneratedValue
  private long id;

  @NotNull
  @Size(min = 3, max = 25)
  private String title;

  @NotNull
  @Max(5)
  @Min(1)
  private int rating;

  @NotNull
  @Size(min = 3, max = 25)
  private String reviewerName;

  private Date date;

  public MovieRating() {}

  public MovieRating(long id, String title, int rating, String reviewerName, Date date) {
    super();
    this.id = id;
    this.title = title;
    this.rating = rating;
    this.reviewerName = reviewerName;
    this.date = date;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getReviewerName() {
    return reviewerName;
  }

  public void setReviewerName(String reviewerName) {
    this.reviewerName = reviewerName;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
