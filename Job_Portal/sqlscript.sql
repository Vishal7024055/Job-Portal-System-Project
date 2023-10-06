create database job_portal2;

CREATE TABLE job_portal2.jobs (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(60) NULL,
  description VARCHAR(4500) NULL,
  category VARCHAR(45) NULL,
  status VARCHAR(45) NULL,
  location VARCHAR(45) NULL,
  pdate TIMESTAMP NULL DEFAULT now(),
  PRIMARY KEY (id));
  
  
  
CREATE TABLE job_portal2.user (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(60) NULL,
  qualificationl VARCHAR(450) NULL,
  email VARCHAR(45) NULL,
  password VARCHAR(80) NULL,
  location VARCHAR(100) NULL,
  role VARCHAR(45) NULL,
  PRIMARY KEY (id));

