# Project 1 -TRMS

Project Description
TRMS, or Tuition Reimbursement Management System is a full-stack web application that allows employees to submit requests for reimbursements for courses, events, and certifications. These requests can then be approved or rejected by the employee's direct supervisor, department head, and a benefits coordinator while the employee is able to track the status of their requests.

Technologies Used
Java - version 1.8
Javalin
Hibernate/JDBC
Maven
Postman
PostgreSQL
JavaScript
HTML
CSS
JUnit

Features

Users can successfully login with valid credentials
Users can submit reimbursement requests
Users can view thier own reimbursement requests details with status updates depending on role (pending/submitted/approved by supervisors/approved by department head/approved by benefits coordinators), other details such as how much amount has been reimbursed and any additional details required
Users can upload grade/presentations/additional files/documents required at the end of thier event
Users depending on thier role can view all filtered reimbursement requests from employees that report to them or in case of department head all requests from employees who belong to that department
Users can approve the requests or ask for additional information from requestor


To-do list:

Users are automatically given urgent notice to approve if start date of course event is <2 weeks
Users are automatically approved if not approved by supervisors/department head/benefits coordinators in a timely manner
Users if role is benefits coordinators can change the reimbursement amount

Getting Started
(include git clone command) 
git clone https://github.com/prita5085/Project_1_TRMS.git

(include all environment setup steps)
On Eclipse IDE, create Maven project
Add models, dao, services, controller layers in packages
Add Javalin, postgreSQL, driver Junit, hibernate dependencies in pom.xml
Visual Studio code for front-end code

Usage
Steps to use the project. 
-Start the javalin server
-Open Visual studio code and run the website from login.html page. 
-Login as a user with valid credentials
-If user role is employee click on reimbursement forms navigation tab on the left panel
-Fill out reimbursement form with details and click on submit
-Click on form status tab on left panel to view all requests submitted and thier approval statuses
-Click on actions required tab on left panel to view any requests submitteed by employee who reports to this user
-Approve or request for additional information or deny request
-delete request or upload files as required such as grades/presentations/additonal information


Contributors
Solo Project
