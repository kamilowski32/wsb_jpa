INSERT INTO Address (id, city, address_Line1, address_Line2, postal_Code)
VALUES
   (1, 'Wrocław', 'Main Street 1', NULL, '50-001'),
   (2, 'Warsaw', 'Central Avenue 5', NULL, '00-123');
INSERT INTO Doctor (id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization, address_Id)
VALUES
   (1, 'John', 'Doe', '123456789', 'john.doe@example.com', 'DOC001', 'Cardiology', 1),
   (2, 'Alice', 'Smith', '987654321', 'alice.smith@example.com', 'DOC002', 'Pediatrics', 2);
INSERT INTO Patient (id, first_Name, last_Name, telephone_Number, email, patient_Number, date_Of_Birth, address_Id)
      VALUES
   (1, 'Tom', 'Hardy', '111222333', 'tom.hardy@example.com', 'PAT001', '1990-05-15', 1),
   (2, 'Emma', 'Watson', '444555666', 'emma.watson@example.com', 'PAT002', '1995-07-20', 2);
INSERT INTO Visit (id, description, time, doctor_Id, patient_Id)
      VALUES
(1, 'Routine check-up', '2024-12-01 10:00:00', 1, 1),
(2, 'Follow-up for flu', '2024-12-02 14:30:00', 2, 2);
INSERT INTO Medical_Treatment (id, description, type, visit_Id)
VALUES
    (1, 'Blood test', 'Lab', 1),
   (2, 'Prescription for flu medication', 'Prescription', 2);
