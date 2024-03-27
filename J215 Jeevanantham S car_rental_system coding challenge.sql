create database car_rental_coding;
use car_rental_coding;
drop database car_rental_coding;


create table vehicle (vehicle_id int primary key,vehicle_make varchar(50),vehicle_model varchar(20),vehicle_year year,vehicle_dailyrate decimal(10,2),vehicle_status varchar(20),vehicle_passengercapacity int,vehicle_enginecapacity varchar(20));
drop table customer;
create table customer(customer_id int primary key,customer_firstname varchar(20),customer_lastname varchar(20),customer_email varchar(30),customer_phonenumber varchar(30) unique);

create table lease(lease_id int primary key,vehicle_id int ,customer_id int,lease_startdate date,lease_enddate date,lease_type varchar(20),
FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id),
FOREIGN KEY (customer_id) REFERENCES customer(customer_id));

create table payment(payment_id int,lease_id int,payment_date date,amount decimal(10,2),foreign key (lease_id) references lease(lease_id));

insert into vehicle values(1,'Toyota','Camry',2022,50.00,1,4,1450);
insert into vehicle values(2,'Honda','Civic',2023,45.00,1,7,1500);
insert into vehicle values(3,'Ford','Focus',2022,48.00,0,4,1400);
insert into vehicle values(4,'Nissan','Altima',2023,52.00,1,7,1200);
insert into vehicle values(5,'Chevrolet','Malibu',2022,47.00,1,4,1800);
insert into vehicle values(6,'Hyundai','Sonata',2023,49.00,0,7,1400);
insert into vehicle values(7,'BMW','3 Series',2023,60.00,1,7,2499);
insert into vehicle values(8,'Mercedes','C-class',2022,58.00,1,8,2599);
insert into vehicle values(9,'Audi','A4',2022,55.00,0,4,2500);
insert into vehicle values(10,'Lexus','Es',2023,54.00,1,4,2500);

select * from vehicle;


insert into customer values(1,'John','Doe','johndoe@example.com','555-555-5555');
insert into customer values(2,'Jane','Smith','Janesmith@example.com','555-123-4567');
insert into customer values(3,'Robert','Johnson','robert@example.com','555-789-1234');
insert into customer values(4,'Sarah','Brown','sarah@example.com','555-456-7890');
insert into customer values(5,'David','Lee','david@example.com','555-987-6543');
insert into customer values(6,'Laura','Hall','laura@example.com','555-234-5678');
insert into customer values(7,'Michael','Davis','michael@example.com','555-876-5432');
insert into customer values(8,'Emma','Wilson','emma@example.com','555-432-1098');
insert into customer values(9,'William','Taylor','william@example.com','555-321-6547');
insert into customer values(10,'Olivia','Adams','olivia@example.com','555-765-4321');

select * from customer;

insert into lease values(1,1,1,'2023-01-01','2023-01-05','Daily');
insert into lease values(2,2,2,'2023-02-15','2023-02,28','Monthly');
insert into lease values(3,3,3,'2023-03-10','2023-03-15','Daily');
insert into lease values(4,4,4,'2023-04-20','2023-04-30','Monthly');
insert into lease values(5,5,5,'2023-05-05','2023-05-10','Daily');
insert into lease values(6,4,3,'2023-06-15','2023-06-30','Monthly');
insert into lease values(7,7,7,'2023-07-01','2023-07-10','Daily');
insert into lease values(8,8,8,'2023-08-12','2023-08-15','Monthly');
insert into lease values(9,3,3,'2023-09-07','2023-09-10','Daily');
insert into lease values(10,10,10,'2023-10-10','2023-10-31','Monthly');

select * from lease;


insert into payment values(1,1,'2023-01-03',200.00);
insert into payment values(2,2,'2023-02-20',1000.00);
insert into payment values(3,3,'2023-03-12',75.00);
insert into payment values(4,4,'2023-04-25',900.00);
insert into payment values(5,5,'2023-05-07',60.00);
insert into payment values(6,6,'2023-06-18',1200.00);
insert into payment values(7,7,'2023-07-03',40.00);
insert into payment values(8,8,'2023-08-14',1100.00);
insert into payment values(9,9,'2023-09-09',80.00);
insert into payment values(10,10,'2023-10-25',1500.00);


select * from payment;


savepoint a;
rollback to a;

-- 1. Update the daily rate for a Mercedes car to 68. 
update vehicle 
set vehicle_dailyrate=68.00
where vehicle_make='Mercedes';

-- 2. Delete a specific customer and all associated leases and payments. 
delete from customer
where customer_id in (select l.customer_id from lease l join payment p on l.lease_id=1 group by customer_id); 

-- 3. Rename the "paymentDate" column in the Payment table to "transactionDate". 
alter table payment rename column payment_Date to transactionDate;

-- 4. Find a specific customer by email. 
select * from customer
where Customer_email='william@example.com';

-- 5. Get active leases for a specific customer.
select * from lease
where customer_id=3; 

-- 6. Find all payments made by a customer with a specific phone number. 
select * from payment 
where lease_id in (
select lease_id from lease
where customer_id =(
select customer_id 
from customer 
where customer_phonenumber='555-123-4567'));

-- 7. Calculate the average daily rate of all available cars. 
select avg(vehicle_dailyrate) as average 
from vehicle 
where vehicle_status=1;

-- 8. Find the car with the highest daily rate. 
select max(vehicle_dailyrate) Highestrate from vehicle;

-- 9. Retrieve all cars leased by a specific customer. 

select v.* 
from vehicle v
join lease l on v.vehicle_id=l.vehicle_id
where l.customer_id=3
group by vehicle_id; 

-- 10. Find the details of the most recent lease.
select * from lease
order by lease_startdate desc limit 1;

-- 11. List all payments made in the year 2023. 
select * 
from payment
where year(transactionDate)=2023;

-- 12. Retrieve customers who have not made any payments.
select * from customer
where customer_id not in(
select distinct customer_id from lease);

-- 13. Retrieve Car Details and Their Total Payments.
select v.vehicle_id,v.vehicle_make,v.vehicle_model,SUM(amount) AS TotalPayments
from vehicle v
JOIN lease l on v.vehicle_id =l.vehicle_id
JOIN Payment p  on l.lease_id = P.lease_id
group by  v.vehicle_id,v.vehicle_make,v.vehicle_model;

-- 14. Calculate Total Payments for Each Customer. 
select c.customer_id,c.customer_firstname,c.customer_lastname,c.customer_email,
c.customer_phonenumber,SUM(amount) AS TotalPayments
from customer c
JOIN lease l on c.customer_id =l.customer_id
JOIN Payment p  on l.lease_id = P.lease_id
group by c.customer_id,c.customer_firstname,c.customer_lastname,c.customer_email,
c.customer_phonenumber;

-- 15. List Car Details for Each Lease. 
select l.lease_id,v.vehicle_id,v.vehicle_make,v.vehicle_model,v.vehicle_year,v.vehicle_dailyrate,v.vehicle_status,
v.vehicle_passengercapacity,v.vehicle_enginecapacity
from lease l join vehicle v on l.vehicle_id=v.vehicle_id
order by l.lease_id;


-- 16. Retrieve Details of Active Leases with Customer and Car Information.
select c.customer_id,v.vehicle_id
from customer c
left outer join lease l on c.customer_id=l.customer_id
left outer join vehicle v on v.vehicle_id=l.vehicle_id
left outer join payment p on l.lease_id=p.lease_id
where p.transactiondate>l.lease_enddate
group by c.customer_id,v.vehicle_id;

-- 17. Find the Customer Who Has Spent the Most on Leases. 
select c.customer_id,c.customer_firstname,c.customer_lastname,c.customer_email,
c.customer_phonenumber,SUM(amount) AS TotalPayments
from customer c
JOIN lease l on c.customer_id =l.customer_id
JOIN Payment p  on l.lease_id = P.lease_id
group by c.customer_id,c.customer_firstname,c.customer_lastname,c.customer_email,
c.customer_phonenumber
order by TotalPayments desc limit 1;

-- 18.List All Cars with Their Current Lease Information.
select v.*,l.*
from vehicle v
left outer join lease l on v.vehicle_id=l.vehicle_id;







