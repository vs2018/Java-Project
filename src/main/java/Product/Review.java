package Product;

import Enums.Rating;
import Enums.ReviewHelpful;

import java.util.ArrayList;
import java.util.Date;

public class Review {

    Rating rating;
    String reviewDetails;
    ArrayList<String> comments;
    ReviewHelpful helpful;
    ArrayList<ReviewHelpful> helpfulList;
    Date reviewDate;

    public Review(Rating rating){
        this.rating = rating;
        this.reviewDate = new java.util.Date(System.currentTimeMillis());
        this.reviewDetails = null;
        this.comments = new ArrayList<>();
        this.helpfulList = new ArrayList<>();
    }

    public Rating getRating() {
        return rating;
    }

    public Date getReviewDate(){
        return this.reviewDate;
    }

    public int getRatingValue(){
        return rating.getValue();
    }

    public String getReviewDetails() {
        return reviewDetails;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public ArrayList<ReviewHelpful> getHelpful() {
        return helpfulList;
    }

    public void setReviewDetails(String reviewDetails) {
        this.reviewDetails = reviewDetails;
    }

    public void setHelpful(ReviewHelpful helpful) {
        if (helpful.getValue() == 1) {
            helpfulList.add(helpful);
        }
    }

    public int getHelpFulScore(){
        return getHelpful().size();
    }

    public void setComment(String comment) {
        this.comments.add(comment);
    }
}
