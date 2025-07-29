use hospital_management_system;
select * from login;
select * from patient_info;
select * from ROOM;
create table department(
Department varchar(50),
Phone_no varchar(20)
);
insert into department values
("Surgical Department","123456789"),
("Nursing Department","123456789"),
("Operation Threater Complex (OT)","123456789"),
("Paramedical Department","123456789");

select * from department;
 create table EMP_INFO(
name varchar(50),
age varchar(50),
Phone_no varchar(20),
salary varchar(20),
gmail varchar(50),
CNIC varchar(50)
);
 insert into EMP_INFO values
 ("Doctors1","30","123456789","50000","gr@gmail.com","123456781010"),
 ("Doctors2","33","123456789","60000","gr@gmail.com","123456781010");


create table Ambulance(
name varchar(20), 
gender varchar(20),
car_name varchar(20),
Available varchar(20),
Location varchar(20)
);
insert into Ambulance values ("deepak","Male","Eidhi","Available","Section 5"),("sunny","Male","Eidhi","Available","Section 6");
select * from Ambulance;



