# EventTracker
Team 4 - NepCoders
The main objective of our app is:
- This app would have the admin and user login feature.
- This app is to keep track of all on-going and upcoming events around the campus for different organization.
- This app notifies the app users about the University events.
- This app would allow the calendar exchange feature.

Instruction:
* To run this app click the Login button two or more times. It goes to the new Activity of HomeActivity and Login as Admin Page
* This app has given Event button features, Profile features and event features.
* The Admin Login features allows the admin to create an event and Post it in the app.
We have Send the invitation to the instructor for both the database Backendless and Firebase Database as a owner.

Important API/Library
Backendless Android SDK 4.5.1
Firebase SDK 12.0.1
Firebase Database 12.0.1
Api - 27
Can run on Google Nexus API 25

        Admin
Test Credential- admin@nwmissouri.edu
Password- nimda

        User 
User Registration through application


Final Report:

Things Completed:
Admin can successfully upload the events descriptions.
The added form data is stored in firebase Database named "EventTracker"
User able to register with valid email through backendless database named "Login"
User able to login the app with valid email and password.
The home page consists of Events that has been added by admin in List View.
They can see the description of events by clicking the eventName
Responsive Interested and Uninterested Buttons on description.
If user is interested in any events those events would be added to listview in profile activity
In profile activity User is able to see their information like First name, Last Name and Email
User can logout from app through profile activity
If user forgot password, they can change their password.


Things uncomplete/ On Process:

*Google Calendar API
*College Database Integration
*Map/ GPS Locator
*Loading Images

Reasons:

- Google Calendar API needed the vast tools and the integration of the software in the Android Application. Adding into the application made a lot of critical errors and the app failure. The run time app would crash on loading the google calendar API.
- Map/GPS Locator needed majority of the time and it was difficult to find the proper resource and documentation to make it successful in the application.
- College Database Integration-College Database is a vast database system. It needed a lot of time and the memory to make the connection. This wasn’t possible with time that we had left and made the integration difficult. 
- Loading images- We git successful on uploading the images in the database but unable to get it back on to the page. Reason for not able to do it was it caused minor issues when we try to render it. We tried a lot of things but wasn’t able to render into the page on the spot where we wanted. 

We spent a lot of time on setting up the database in Firebase. Storing and retrieving data from the database also took a lot of time. If we had enough time and enough resources we would have been able to complete most of the functionality mentioned above. But the application  Event Tracker has the platform for the future improvement. More functionality can be added and can be improved.


