package com.project.stilgalleriet.services;

import com.project.stilgalleriet.models.Review;
import com.project.stilgalleriet.repositories.OrderRepository;
import com.project.stilgalleriet.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    OrderRepository orderRepository;

    //Create a new review
    public Review addReview(Review review){

        //Check if user already made review

        //Check if user is eligible for making a review(See if an order match the seller and buyer ids)


        return reviewRepository.save(review);
    }

    //Get all reviews
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    //Find review by ID
    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
    }

    //Get reviews by seller user ID, implemented later as Order need to be functional

    //Update a review
    public Review updateReview(String id, Review updatedReview){

        return reviewRepository.findById(id)
                .map(review -> {

                    //Validation annotations in model already check this value, we don't need to check it here
                    review.setRating(updatedReview.getRating());

                    if (updatedReview.getComment() != null){
                        review.setComment(updatedReview.getComment());
                    }
                    return reviewRepository.save(review);
                })
                .orElseThrow(); //Add exception handling
    }

    //Delete review
    public void deleteReview(String id){
        reviewRepository.deleteById(id);
    }

    public List<Review> findReviewByRatedUserId(String id){
       return reviewRepository.findByRatedUserId(id);
    }

}
