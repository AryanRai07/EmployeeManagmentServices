// DataBase Query's

CREATE SCHEMA IF NOT EXISTS employee_management;

create table employee_management.role_master (
  id integer Primary key,
  role character varying
);

create table employee_management.gender(
id integer,
gender_name character varying
);

 create table employee_management.department(
	id integer PRIMARY key,
	name character varying);



insert into employee_management.role_master (id, role)
values 
  (1, 'Admin'),
  (2, 'Employee ');



insert into employee_management.gender (id, gender_name)
values 
  (1, 'Female'),
  (2, 'Male'),
  (3, 'Transgender');

    insert into employee_management.department(id ,name)
  values (1, 'Physics Department'),
  (2, 'Mathmetics Department');
  

 -- select * from employee_management.department;

--  select * from employee_management.gender;

 -- select * from employee_management.user_master;




create table employee_management.employee_data (
  emp_id integer Primary key,
  name character varying (50),
  email character varying,
  contact character varying(10),
  dept_id integer,
  gender integer,
  role integer,
  password character varying,
  created_on timestamp with time zone,
  created_by integer
  );

  insert into employee_management.employee_data values(
1, 'Aman','aman@gmail.com','8913456709',1,2,1,'321@Aman',now(),1 );

  insert into employee_management.employee_data values(
2, 'Ansh','ansh@gmail.com','8319013920',2,2,2,'321@Ansh',now(),1 );


-- select * from employee_management.employee_data


  