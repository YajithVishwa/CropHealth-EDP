# CropHealth
An app to monitor the health of the crop.
## Developed by Sankara Subramaniyan, Aakash, Yajith Vishwa of TCE IT Department
SMART CROP MANAGEMENT SYSTEM 
REPORT
Submitted by
 
V. AAKASH (18IT001)
G.L. SANKARA SUBRAMANIYAN (18IT079)                              S. YAJITH VISHWA (18IT116)                                                        K. SURIYAN (18IT128)
 
in partial fulfillment for the completion of course Engineering Design Project
of
BACHELOR OF TECHNOLOGY
IN
INFORMATION TECHNOLOGY

 
 
 
THIAGARAJAR COLLEGE OF ENGINEERING, MADURAI–15
(A Govt. Aided, Autonomous Institution, Affiliated to Anna University)
 
 
MAY 2021



THIAGARAJAR COLLEGE OF ENGINEERING, MADURAI-15
(A Govt. Aided, Autonomous Institution, Affiliated to Anna University)
 
 
BONAFIDE CERTIFICATE
Certified that this project report “SMART CROP MANAGEMENT SYSTEM” is the bonafide work of “V. AAKASH (18IT001), G.L. SANKARA SUBRAMANIYAN (18IT079), S. YAJITH VISHWA (18IT116), K. SURIYAN (18IT128)” who carried out the project work under my supervision during the Academic Year 2020 -2021.
 
 
 
 
                                                                    SIGNATURE
                                                                    Mrs.R.Parkavi,
                                                      ASSISTANT PROFESSOR,
                                                                    INFORMATION TECHNOLOGY
                                                                    THIAGARAJAR COLLEGE OF
                                                                    ENGINEERING,
                                                                    MADURAI-15
 
TABLE OF CONTENTS
 
SL. NO.
DETAILS
PAGE NO.
1
ABSTRACT
5
2
PROBLEM DESCRIPTION
6 
3
BACKGROUND 
9
4
 DESIGN REQUIREMENTS	
9
5
 PROPOSED METHODOLOGY	
10 
6
UML DIAGRAMS 
 14
7
 FINAL IMPLEMENTATION
 23
8
TESTING AND VALIDATION 
 24
9
PERFORMANCE TEST RESULTS 
28
10
DEPLOYMENT
22
11
CONCLUSION
27
12
REFERENCE
29

 
 



1. ABSTRACT

Smart agriculture is an emerging concept, because IOT sensors are capable of providing information about agriculture fields and then act upon based on the user input.  Managing huge hectares of agricultural land is tedious also it needs huge manpower. Along with-it farmers are finding difficulty in choosing the right pesticides and fertilizers to the crops at right intervals which is highly necessary to increase the production rate of the field.  In this project, it is proposed to develop a Smart agriculture System that uses the advantages of cutting edge technologies such as Arduino, IOT and Wireless Sensor Network. The paper aims at making use of evolving technology i.e. IOT and smart agriculture using automation. Monitoring environmental conditions is the major factor to improve yield of efficient crops.  Early failure of crops plays a major impact in the agriculture domain and decides the GDP which is due to pests and shortage of water. To overcome the above problems, we are creating a smart agriculture management system which helps the farmers to manage and monitor crops online and to monitor the health of the field continuously to detect and prevent crop failures. 

Also, they perform basic actions like watering, fertilizing the field by an AI powered automated system which uses sensors to detect the humidity and water level and continuously monitors the crops.









2. PROBLEM DESCRIPTION
2.1 Problem Statement
Agriculture is one of the major industries to incorporate drones. Drones equipped with sensors and cameras are used for imaging, mapping and surveying the farms. There are ground based drones and aerial drones. Ground drones are bots that survey the fields on wheels. Aerial drones- formally known as unmanned aerial vehicles (UAVs) or unmanned aircraft systems (UASes) are flying robots. Drones can be remotely controlled remotely or they can fly automatically through software-controlled flight plans in their embedded systems, working in coordination with sensors and GPS. From the drone data, insights can be drawn regarding crop health, irrigation, spraying, planting, soil and field, plant counting and yield prediction and much more. Drones can either be scheduled for farm surveys (drone as a service) or can be bought and stored near farms where they can be recharged and maintained. After the surveys the drones need to be taken to nearby labs to analyze the data that has been collected.

2.2 Scope and Importance
Smart Agriculture allows farmers to maximize yields using minimum resources such as water, fertilizers, seeds etc. Solar powered and mobile operated pumps save the cost of electricity. Smart agriculture uses drones and robots which helps in many ways. This improves the data collection process and helps in wireless monitoring and control. It is a cost effective method. It delivers high quality crop production.
2.3 Subject Domain
The key areas are Internet of Things, Deep Learning, Mobile App Development.


2.4 Society Relevancy
Smart agriculture is a new emerging field towards development and food security on increasing productivity, enhancing livelihoods and reducing and removing greenhouse gas emissions from the atmosphere.  Through an understanding in ecosystems, water, soil, weather, chemistry and plant & animal biology, they provide us with the things we need to survive.

3. BACKGROUND

Literature Survey

S.No
Title of the Paper
Author
Dataset Used and Methodology
Observations
1
Crop Yield Prediction and Efficient use of Fertilizers
Chaithra M Rao, 
Sanjay Kumar C 
KNN Algorithm,
crop Dataset (private dataset)
we get nearest matches of crop, rainfall, 
location and ph to test data from train data set in turn we 
predict the crops from it.
2
Impact of Deep Neural Network on Predicting 
Application Rate of Fertilizers
M.S. Suchithra and Maya L. Pai
Clustering Technique, Neural Network and Deep neural network
The recommendation 
model based on the Deep Neural Network (DNN) outperforms the Standard 
Neural Network classifier with an accuracy equal to 95.1 % (Urea), 95.05 % 
(MOP) and 96.7 % (Lime). Our model highlights the real possibility for 
forecasting the application rate of fertilizers.



3.2 Scope of the Problem
Smart Agriculture allows farmers to maximize yields using minimum resources such as water, fertilizers, seeds etc. Solar powered and mobile operated pumps save the cost of electricity. Smart agriculture uses drones and robots which helps in many ways. This improves the data collection process and helps in wireless monitoring and control. It is a cost effective method. It delivers high quality crop production.







3.3 Constraints and Limitations
Availability of internet continuously. Villages don't have internet and the bandwidth of the connection is slower.
Iot equipment and mobile apps need farmers to understand and learn to use the technology. This is a major challenge in adopting smart agriculture farming at large scale across the countries.
Users are not familiar with these technologies. They do not understand artificial intelligence or mobile apps.
Initial cost is quite high for farmers
The cost of maintenance is high.

4. DESIGN REQUIREMENTS
 Schedule





 Budget
The budget for the project is 15,000 INR and the cost includes
Google Cloud Platform’s Compute Engine
IoT devices like sensors and Arduino boards
Firebase subscription 

 Risk Factors
High technology dependencies.
Integration with vendors and suppliers is difficult.
Regulations and other checks done are not verified.
More chances of failures of minute devices like sensors.
Since the data is not encrypted, there is a possibility of data breach at the field level.  However, the data is encrypted in the http packet and in the database.

Team Members Roles and Responsibilities

G.L. Sankara Subramaniyan
App Development Process, IoT Stimulations
V. Aakash
Deep Learning Model development
S. Yajith Vishwa
App Development Process
K. Suriyan
Data collections and IoT circuit building



5. PROPOSED METHODOLOGY
Modules Description
Login
The login page should be the first page that users see in the Crop application. It should provide two text fields - one for entering an email and one for entering a password. If either of the text fields is left blank it is an error that must be reported to the user. If both fields are filled in but there is no record of the user name or the password is incorrect that must also be reported to the user. There would be google sign in button when you click that button the google account used as login account for the application.

Soil Type
After Login, the user has to choose a Soil and capture the soil in application. Then it redirects to the Crop page where there would be a list of crops which can be grown in that soil.

Field Monitoring

 The field is continuously monitored for humidity, temperature, water level, land acidity and equipment status.  The temperature and humidity is measured using a DHT11 sensor which is low-cost and less power consuming.   Soil moisture is measured using soil moisture sensors.  Land acidity is measured using a ph sensor.
   
     Dht11                   soil moisture sensor                        ph sensor
Location Detection
After login, location will be added to the user details using Global Positioning System which is a satellite navigation system used to determine the farm Latitude and Longitude position. Location involves country, State, District, Pin and suggest nearby pest shops.

Field IoT Layout


Layout
Linear Layout is a view group that aligns all children in a single direction, vertically or horizontally. Relative Layout is a view group that displays child views in relative positions .Grid View is a View Group that displays items in a two-dimensional, scrollable grid.



Intent
Android Intent is the message that is passed between components such as activities, content providers, broadcast receivers, services etc. It is generally used with startActivity() method to invoke activity, broadcast receivers etc

Menu
Menus are a common user interface component in many types of applications. A context menu is a floating menu that appears when the user performs a long-click on an element. It provides actions that affect the selected content or context frame.

Notification
A notification is a message you can display to the user outside of your application's normal UI. Android Toast class provides a handy way to show users alerts

Widgets
A widget is a small gadget or control of your android application placed on the home screen. Widgets can be very handy as they allow you to put your favorite applications on your home screen in order to quickly access them.

Database
The Firebase Realtime Database is a cloud-hosted database in which data is stored as JSON. The data is synchronized in real-time to every connected client. ... The Firebase Realtime Database is a NoSQL database from which we can store and sync the data between our users in real-time.



Location
A location can consist of a latitude, longitude, timestamp, and other information such as bearing, altitude and velocity.

Multimedia
Android multimedia framework includes support for playing variety of common media types, so that you can easily integrate audio, video and images into your applications
5.2 Benefits
No need of watchman in Field
Low-cost Build Setup
Online Monitoring
Application alert.
Online Portal for farmers
















6. UML DIAGRAMS

Use Case Diagram









Sequence Diagram





Class Diagram














State Transition Diagram



7. FINAL IMPLEMENTATION

TECHNOLOGY STACK:
FRONT END:
	A mobile application has been developed with a user-interactive UI through which users can access the developed modules and functionalities.

DATABASE:
Firebase real-time database has been used to store and retrieve the data. The data from sensors is connected at a specified interval with an edge device and is stored in firebase which is then delivered to the user via mobile app. Also, authentication/login is provided in the mobile app which collectively uses firebase authentication service.
BACKEND:
	Python flask is majorly used as a backend service. The trained deep learning models have been deployed as a REST API with flask. Based on the user’s input image a JSON response is delivered. The flask server has been containerized and deployed as microservices with Kubernetes on google cloud platform which comes with load balancing services.












8. TESTING AND VALIDATIONS
UNIT TESTING
APP UNIT TESTING
The Android mobile app is tested by our mobile developers in android studio with the help of emulators. Each Activity is tested individually and verified by the developers.

API UNIT TESTING
After hosting the flask application, We have tested using postman by giving distinct images of crop and disease.




DATABASE TESTING
We Have used Firebase Database to store details and sensor data. So for unit testing we have enabled analytics and crashlytics to test them on production itself. The log has also been verified at the final stage.
       2.	INTEGRATION TESTING  
	The Flask app is hosted in GCP with help of container technology and verified using postman. The Android application is installed in various devices and verified.


      3.	USABILITY TESTING
	The Android application is given to low educated people to use our application
. 

9. PERFORMANCE TEST RESULT
1. PERFORMANCE OF DEEP LEARNING MODELS:
Disease Predictor - 83% validation accuracy
Soil Predictor - 95.5% validation accuracy

2. PERFORMANCE OF MOBILE APP AND API:
	Our cloud REST API comes with load balancing and auto-scaling capabilities so far we haven’t seen any deviation/slow in the performance of the mobile app even when multiple requests have been made.

As of future work, we need to gather more images, apply data augmentations, hyperparameter tuning and re-train the model to get more accurate predictions thereby suggesting the best crop/pesticides to the user.

10. DEPLOYMENT
Features Used in Application 
Camera Intent API
Firebase Database(Backend as Service)
Containerization Technology (Kubernetes)
Notification Service
Google Maps
Google SignIn(SSO)

Design Pictures

Login
 


Soil Capture

Dashboard


Location Detection


Disease Finder

Code Report
Github :  https://github.com/YajithVishwa/CropHealth-EDP

11. CONCLUSION

 The proposed system can be used for any type of land in any location where a network is available. If the model is further trained with many sample images for each type of soil disease, then almost all known diseases can be classified and reported. Combined with Data Analytics, fields can be best used for the current season or environment and can prevent underutilization. As part of the future , a new section will be implemented in a mobile app which gathers local news that is related to agriculture, rainfall and other necessary things for the farmers based on web scraping and other techniques. Further crop recommendation systems can be improved by using the information such as the crops that will be at peak price after n months, rainfall forecast data nearby field data and other things which give the robust option. Further a E-Agri module can be added to mobile app for ordering and delivering of necessary seeds, pesticides and fertilizers which saves the time and effort of farmers
12. REFERENCES

Annamaria Castrignano: Agricultural Internet of Things and Decision Support for Precision Smart Farming (2020)
https://play.google.com/store/apps/details?id=com.criyagen&hl=en_IN&gl=US
https://www.smartfarmingtech.com/
https://www.iotforall.com/iot-applications-in-agriculture
https://www.sciencedirect.com/science/article/pii/S1877050916315216
https://ieeexplore.ieee.org/abstract/document/8442535
https://www.sciencedirect.com/science/article/pii/S2590005620300333


