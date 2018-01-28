import Enums.*;
import Product.Review;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ReviewTest {

    Review review;

    @Before
    public void before(){
        review = new Review(Rating.FIVE);
    }

    @Test
    public void canGetRatingValue(){
        assertEquals(5, review.getRatingValue());
    }

    @Test
    public void canSetRatingDescription(){
        review.setReviewDetails("It was a good movie");
        assertEquals("It was a good movie", review.getReviewDetails());
    }

    @Test
    public void canSetHelpful(){
        review.setHelpful(ReviewHelpful.YES);
        review.setHelpful(ReviewHelpful.YES);
        review.setHelpful(ReviewHelpful.YES);
        review.setHelpful(ReviewHelpful.NO);
        assertEquals(3, review.getHelpful().size());
    }

    @Test
    public void canGetScore(){
        review.setHelpful(ReviewHelpful.YES);
        review.setHelpful(ReviewHelpful.YES);
        review.setHelpful(ReviewHelpful.YES);
        review.setHelpful(ReviewHelpful.NO);
        assertEquals(3, review.getHelpFulScore());
    }

    @Test
    public void canSetComment(){
        review.setComment("I agree with this review");
        review.setComment("This review is a lie!!");
        ArrayList<String> list = new ArrayList<>();
        list.add("I agree with this review");
        list.add("This review is a lie!!");
        assertEquals(list, review.getComments());
    }

    @Test
    public void canGetDate(){
        assertEquals(new java.util.Date(System.currentTimeMillis()), review.getReviewDate());
    }


}
