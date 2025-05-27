
-- Tạo Database
CREATE DATABASE InfertilityDB;
GO
USE InfertilityDB;
GO

-- 1. Role
CREATE TABLE Role (
    role_id INT IDENTITY(1,1) PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

-- 2. User
CREATE TABLE [User] (
    user_id VARCHAR(20) PRIMARY KEY,
    full_name VARCHAR(100),
    gender VARCHAR(10),
    date_of_birth DATE,
    phone VARCHAR(20),
    email VARCHAR(100),
    address TEXT,
    role_id INT FOREIGN KEY REFERENCES Role(role_id)
);

-- 3. Account
CREATE TABLE Account (
    account_id VARCHAR(20)  PRIMARY KEY,
    user_id   VARCHAR(20) UNIQUE  FOREIGN KEY REFERENCES [User](user_id),
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    is_active BIT DEFAULT 1
);

-- 4. Treatment Services
CREATE TABLE Treatment_Services (
    service_id VARCHAR(20)  PRIMARY KEY,
	user_id VARCHAR(20) FOREIGN KEY REFERENCES [User](user_id),
    name VARCHAR(100),
    description TEXT,
    type VARCHAR(50),
    fee DECIMAL(12,2),
    duration_days INT
);

-- 5. Work Schedule
CREATE TABLE WorkSchedule (
    work_id VARCHAR(20)  PRIMARY KEY,
    doctor_id VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES [User](user_id),
    work_date DATE,
    shift VARCHAR(50)
);

-- 6. Booking
CREATE TABLE Booking (
    booking_id VARCHAR(20)  PRIMARY KEY,
    customer_id VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES [User](user_id),
    service_id VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES Treatment_Services(service_id),
    work_id VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES WorkSchedule(work_id),
    booking_date DATETIME DEFAULT GETDATE(),
    status VARCHAR(50) DEFAULT 'Pending',
    note TEXT
);

-- 7. Examination
CREATE TABLE Examination (
    exam_id VARCHAR(20)  PRIMARY KEY,
    booking_id   VARCHAR(20) UNIQUE  NOT NULL FOREIGN KEY REFERENCES Booking(booking_id),
    exam_date DATETIME,
    diagnosis TEXT,
    recommendation TEXT
);
-- 10. Medical Results
CREATE TABLE Medical_Results (
    result_id VARCHAR(20)  PRIMARY KEY,
	exam_id VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES Examination(exam_id),
    test_name VARCHAR(100),
    result_value VARCHAR(255),
    result_date DATE,
    staff_id VARCHAR(20) FOREIGN KEY REFERENCES [User](user_id)
);

-- 8. Treatment Schedule
CREATE TABLE Treatment_Schedules (
    schedule_id VARCHAR(20)  PRIMARY KEY,
    result_id VARCHAR(20) FOREIGN KEY REFERENCES Medical_Results(result_id),
    start_date DATE,
    end_date DATE,
    status VARCHAR(50),
    notes TEXT
);

-- 9. Treatment Progress
CREATE TABLE Treatment_Progress (
    progress_id VARCHAR(20)  PRIMARY KEY,
    schedule_id VARCHAR(20) FOREIGN KEY REFERENCES Treatment_Schedules(schedule_id),
    progress_date DATE,
    activity TEXT,
    doctor_note TEXT,
    status VARCHAR(50)
);



-- 11. Prescription
CREATE TABLE Prescription (
    prescription_id VARCHAR(20)  PRIMARY KEY,
    result_id  VARCHAR(20) UNIQUE  FOREIGN KEY REFERENCES Medical_Results(result_id),
    medicine_name VARCHAR(255),
    dosage VARCHAR(100),
    usage_instruction TEXT
);

-- 12. Invoice
CREATE TABLE Invoice (
    invoice_id VARCHAR(20)  PRIMARY KEY,
	booking_id   VARCHAR(20)  UNIQUE FOREIGN KEY REFERENCES Booking(booking_id),
    issued_date DATETIME DEFAULT GETDATE(),
    total_amount DECIMAL(12,2),
    status VARCHAR(50)
);

-- 13. Payment
CREATE TABLE Payment (
    payment_id VARCHAR(20)  PRIMARY KEY,
    invoice_id   VARCHAR(20)  UNIQUE FOREIGN KEY REFERENCES Invoice(invoice_id),
    
    paid_amount DECIMAL(12,2),
    paid_at DATETIME DEFAULT GETDATE(),
    method VARCHAR(50)
);

-- 14. Feedback & Ratings
CREATE TABLE Feedback_Ratings (
    feedback_id VARCHAR(20)  PRIMARY KEY,
    customer_id VARCHAR(20) FOREIGN KEY REFERENCES [User](user_id),
    staff_id VARCHAR(20) FOREIGN KEY REFERENCES [User](user_id),
    rating INT,
    comment TEXT,
    created_at DATETIME DEFAULT GETDATE()
);

-- 15. Notification
CREATE TABLE Notification (
    notification_id VARCHAR(20)  PRIMARY KEY,
	progress_id VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES Treatment_Progress(progress_id),
    content TEXT,
    sent_at DATETIME DEFAULT GETDATE(),
    is_read BIT DEFAULT 0
);
-- 16. Treatment Record (Liên kết lịch sử điều trị & kết quả)
CREATE TABLE Treatment_Record (
    record_id VARCHAR(20)  PRIMARY KEY,
    customer_id VARCHAR(20) FOREIGN KEY REFERENCES [User](user_id),
    result_id VARCHAR(20) FOREIGN KEY REFERENCES Medical_Results(result_id)
);

-- 17. Blog Posts
CREATE TABLE Blog_Posts (
    post_id VARCHAR(20)  PRIMARY KEY,
    manager_id VARCHAR(20) FOREIGN KEY REFERENCES [User](user_id),
    title NVARCHAR(255),
    content TEXT,
    created_at DATETIME DEFAULT GETDATE()
);