package skotels.hotelapp.service;

import skotels.hotelapp.model.Comment;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.model.User;

import java.util.List;

public interface CommentService {
    List<Comment> getAllHotelComments(String hotelId);
    List<Comment> addNewComment(Hotels hotel, User user, String comment);
    List<Comment> deleteComment(String commentId);
}
