CREATE DATABASE InfertilityDB
USE InfertilityDB

-- SQL Server Script: Infertility Treatment Management and Monitoring System

-- 1. Role Table
CREATE TABLE Role (
    role_id INT IDENTITY(1,1) PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL -- e.g., Admin, Manager, Doctor, Staff, Customer
);

-- 2. User Table
CREATE TABLE [User] (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    full_name VARCHAR(100),
    gender VARCHAR(10),
    date_of_birth DATE,
    phone VARCHAR(20),
    email VARCHAR(100),
    address TEXT,
    role_id INT FOREIGN KEY REFERENCES Role(role_id)
);

-- 3. Account Table
CREATE TABLE Account (
    account_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT FOREIGN KEY REFERENCES [User](user_id),
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    is_active BIT DEFAULT 1
);

-- 4. Service Table
CREATE TABLE Service (
    service_id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    type VARCHAR(50),
    fee DECIMAL(12,2),
    duration_days INT
);

-- 5. Appointment Table
CREATE TABLE Appointment (
    appointment_id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT FOREIGN KEY REFERENCES [User](user_id),
    doctor_id INT FOREIGN KEY REFERENCES [User](user_id),
    appointment_date DATETIME,
    status VARCHAR(50),
    note TEXT
);

-- 6. TreatmentSchedule Table
CREATE TABLE TreatmentSchedule (
    schedule_id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT FOREIGN KEY REFERENCES [User](user_id),
    doctor_id INT FOREIGN KEY REFERENCES [User](user_id),
    service_id INT FOREIGN KEY REFERENCES Service(service_id),
    start_date DATE,
    end_date DATE,
    status VARCHAR(50),
    notes TEXT
);

-- 7. TreatmentProgress Table
CREATE TABLE TreatmentProgress (
    progress_id INT IDENTITY(1,1) PRIMARY KEY,
    schedule_id INT FOREIGN KEY REFERENCES TreatmentSchedule(schedule_id),
    date DATE,
    activity TEXT,
    doctor_note TEXT,
    status VARCHAR(50)
);

-- 8. LabResult Table
CREATE TABLE LabResult (
    result_id INT IDENTITY(1,1) PRIMARY KEY,
    schedule_id INT FOREIGN KEY REFERENCES TreatmentSchedule(schedule_id),
    test_name VARCHAR(100),
    result_value VARCHAR(255),
    result_date DATE,
    staff_id INT FOREIGN KEY REFERENCES [User](user_id)
);

-- 9. WorkSchedule Table
CREATE TABLE WorkSchedule (
    work_id INT IDENTITY(1,1) PRIMARY KEY,
    staff_id INT FOREIGN KEY REFERENCES [User](user_id),
    work_date DATE,
    shift VARCHAR(50)
);

-- 10. Feedback Table
CREATE TABLE Feedback (
    feedback_id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT FOREIGN KEY REFERENCES [User](user_id),
    doctor_id INT FOREIGN KEY REFERENCES [User](user_id),
    rating INT,
    comment TEXT,
    created_at DATETIME DEFAULT GETDATE()
);

-- 11. Notification Table
CREATE TABLE Notification (
    notification_id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT FOREIGN KEY REFERENCES [User](user_id),
    content TEXT,
    sent_at DATETIME DEFAULT GETDATE(),
    is_read BIT DEFAULT 0
);

-- 12. Invoice Table
CREATE TABLE Invoice (
    invoice_id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT FOREIGN KEY REFERENCES [User](user_id),
    schedule_id INT FOREIGN KEY REFERENCES TreatmentSchedule(schedule_id),
    issued_date DATETIME DEFAULT GETDATE(),
    total_amount DECIMAL(12,2),
    status VARCHAR(50)
);

-- 13. Payment Table
CREATE TABLE Payment (
    payment_id INT IDENTITY(1,1) PRIMARY KEY,
    invoice_id INT FOREIGN KEY REFERENCES Invoice(invoice_id),
    paid_amount DECIMAL(12,2),
    paid_at DATETIME DEFAULT GETDATE(),
    method VARCHAR(50)
);