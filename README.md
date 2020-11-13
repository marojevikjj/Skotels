# Skotels
<h3><b>Software Design and Architecture</b></h3>
 <h4>Project for mapping and navigating through hotels in Skopje<h4>

## 1. Introduction

  <p>Finding a hotel can be tricky, especially last minute. Thankfully, there is a whole industry based on this issue. There are two main types of hotel applications. The first are the classic big companies like Marriot or Hilton and the second are more independent operations like Airbnb or Booking.com. Knowing that Skopje, the capital of Macedonia, is frequently visited by tourists from all over the world we decided to develop a web application which will show available accommodation in the city.
  
  The purpose of this document is to give a general insight of the scope and the requirements for the Skotels Web Application and to provide a base for the foundation of the project. The main goal of the project is to design a scalable and extensible system for managing the hotel activities. 
  
  The system will provide the information regarding the different types of accommodation in Skopje that are available and their status specific to availability. This web application will be intended for those who would like to find accommodation in Skopje. It will use navigation and geolocation to show all the hotels and motels in the area.
  
  Mainly, the code will be written in HTML and the Java Spring Framework and we will use non-relational databases - MongoDB to store information about the accommodation. Open data from OpenStreetMap will be used to fill the database.
  
  The developers and the testers can use this document as a reference for developing the design and test plan documents.</p>

  ## 2. Requirements
  ### 2.1 Functional Requirements
  <ol>
  <li>The system shall provide information about all hotels in a given area.</li>
  <li>The system shall provide a map with the location of each hotel.</li>
  <li>The system shall enable customers to review all details of the selected hotel.</li>
  <li>The system shall enable customers to check the availability of rooms.</li>
  <li>The system shall provide an option for booking a room in the selected hotel.</li>
  <li>The system shall redirect customers to the payment page after confirming the reservation.</li>
  <li>The system shall accept paying with credit and debit card.</li>
  <li>The system shall send an email notification of booking confirmation to the customer.</li>
  <li>The system shall allow customers to rate/write reviews about visited hotels.</li>
  <li>The system shall be available in English and Macedonian language.</li>
  </ol>

  ### 2.2 Non-functional Requirements
  <ol>
  <li>The system shall permit access to all users using a web browser that is version 4.0 or higher.</li>
  <li>The system shall be secured from the outside attacks and unauthorized access.</li>
  <li>The system shall be available 24 hours a day to enable user interactions.</li>
  <li>The system shall identify users before redirecting them to the payment method. </li>
  <li>Less than 15 seconds shall be needed for the system to proceed an action.</li>
  <li>The system shall support 2000 simultaneous users in normal workload.</li>
  <li>The system shall be written in Java Spring Framework.</li>
  <li>The systam shall use MongoDB database for storing data about hotels and clients.</li>
  </ol>
