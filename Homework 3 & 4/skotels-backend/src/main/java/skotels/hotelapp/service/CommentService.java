package skotels.hotelapp.service;

import skotels.hotelapp.DTO.HotelsCommentDTO;
import skotels.hotelapp.model.Comment;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.model.User;

import java.util.List;

public interface CommentService {
    List<Comment> findCommentsByHotel(Hotels hotel);
    List<Hotels> addNewComment(String comment, User user, Hotels hotel);
}
