Feature: Book a room

#@book
Scenario: Option to book a room is available on the page
Given I am on the home page
When I browse through the page
Then I have the option to book a room

@book
Scenario Outline: Option to book a room is available on the page for 2 nights
Given I am on the home page
When I browse through the page
And I have the option to book a room
And I click on the button Book this room 
And I fill the information needed: "<firstname>","<lastname>","<email>","<phone>"
And i select 2 availbles nights from the calendar
And I click on the button  Book
Then the popup Booking successful will diplay with the correct title "<Title>" and message "<Message>"
And the date display in the popup match the correct period


Examples: 
 |firstname| lastname      |  email                      |phone           | Title               | Message                                               |
 |    Aymen |  Ben Khalifa | testbook123@gmail.com       |+3244444444     | Booking Successful! | Congratulations! Your booking has been confirmed for: |