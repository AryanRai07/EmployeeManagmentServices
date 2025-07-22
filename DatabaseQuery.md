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



CREATE TABLE IF NOT EXISTS employee_management.child_department
(
id serial PRIMARY KEY ,
name character varying,
department_id integer,
-- CONSTRAINT child_department_id_pkey PRIMARY KEY (id),
CONSTRAINT child_department_id_fkey FOREIGN KEY (department_id)
REFERENCES employee_management.department (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
)

TABLESPACE pg_default;



insert into employee_management.child_department(name,department_id)
values ( 'Instagram',1),
( 'Facebook',1),
('Twitter',1),
('Java',2),
('Node js',2),
('Angular',2),
('C',2);


update employee_management.department set name='Marketing' where id=1

update employee_management.department set name='Developer' where id=2

ALTER TABLE employee_management.employee_data 
DROP COLUMN emp_id;

ALTER TABLE employee_management.employee_data 
ADD COLUMN emp_id SERIAL PRIMARY KEY;
  


------Project DAta

CREATE TABLE IF NOT EXISTS employee_management.project_data(
project_id integer Primary key,
project_name character varying (50),
client_name character varying,
start_date timestamp with time zone,
lead_by_emp_id integer,
contact_person character varying,
contact_no character varying,
emil_id character varying,
created_on timestamp with time zone,
created_by integer,
CONSTRAINT lead_by_emp_id_fkey FOREIGN KEY (lead_by_emp_id)
REFERENCES employee_management.employee_data (emp_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
);