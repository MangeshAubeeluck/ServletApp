1.Name your database: mangesh.db

2.Create a table for the admin users by using the following cmd in dbeaver:
CREATE Table administrators(
Id real not null,
AdminName varchar(255),
AdminPassword varchar(255)
);

3.Insert those values on the administrators table:
INSERT into administrators values ('1','mangesh','madmin'),('2','gopal','gadmin');

4.Create a table for the client by using the following cmd in dbeaver:
CREATE Table clientData(
id real not null  ,
firstName varchar(255),
lastName varchar(255),
email varcahr(255),
amountDue real);

5.Insert those values in the clientData table:
INSERT into clientData values ('1','mangesh','aubeeluck','maubeeluck@iqera.com','800'),('2','lionel','messi','lmessi@iqera.com','850') ,('3','Christiano','ronaldo','cronaldo@iqera.com','600'),('4','paul','pogba','ppogba@iqera.com','75'),('5','juan','mata','jmata@iqera.com','500'),('8','Maroun','fellani','mfellani@iqera.com','230');

This is a screenshot of the sql command:
![image](https://user-images.githubusercontent.com/52622374/195083493-fa4d6768-9b97-4c85-82db-5c692c9c7202.png)


