// package com.skotels.cloudgateway;
//
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// public class FallBackMethodController {
//
//     @GetMapping("/userServiceFallBack")
//     public String userServiceFallBackMethod(){
//         return "User service is taking longer than expected. " +
//                 "Please try again later.";
//     }
//
//     @GetMapping("/hotelServiceFallBack")
//     public String hotelServiceFallBackMethod(){
//         return "Hotel service is taking longer than expected. " +
//                 "Please try again later.";
//     }
// }
//