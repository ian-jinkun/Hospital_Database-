# Hospital_System_Database
**This project simulates the use of an information system in the hospital, which consists of paper-based documents and small independent databases developed by several departments.**

The hospital depends primarily on four groups of people: employees, physicians, patients, and volunteers. Of course, some common attributes are shared by all of these groups: person_ID (identifier), name, address, birth date, and phone number. Each group also has at least one unique attribute of its own. Employees have a date hired, volunteers have a skill, physicians have a specialty and a pager number, and patients have a contact date (date of the first contact with the hospital). Some people may belong to two or more of these groups at a given time.

The EER diagram has been uploaded.

The relational model of my given ER is represented as such, below. Note, Primary Keys are the underlined attributes and Foreign Keys are marked as bold attributes.
- PERSON (Person_ID, Name, Address, Birth_Date, Phone_Number)
- VOLUNTEER (Volunteer_Person_ID, Skill)
- PATIENT (Patient_Person_ID, Physican_Person_ID, Contact_Date)
- EMPLOYEE (Employee_Person_ID)
- NURSE (Employee_Person_ID, Care_Centre_Name,Nurse_In_Charge_FLag)
- STAFF (Employee_Person_ID, Job)
- TECHNICIAN (Employee_Person_ID, Skill)
- PHYSICIAN (Physican_Person_ID, Specialty, Pager_Number)
- OUTPATIENT (Patient_Person_ID)
- RESIDENT_PATIENT (Patient_Person_ID, Bed_Number)
- BED (Bed_Number, Care_Centre_Name, Room_Number)
- VISIT (Date, Patient_Person_ID, Comments)
- CARE_CENTRE (Care_Centre_Name, Care_Centre_Location)
- ITEM (Item_Number, Item_Number, Unit_Cost)
- LABORARTORY (Lab_Name, Lab_Location, Patient_Health_Information)
- TEM_CONSUMED_BY_PATIENT (Patient_ID, Item_Number, Date, Quantity, Total_Cost)
- EMPLOYEE_WORK_IN_CARE_CENTRE (Care_Centre_Name, Employee_Person_ID, Hours_Per_Week)
- PHYSICIAN_WORK_IN_CARE_CENTRE (Physican_Person_ID, Care_Centre_Name, Assigned_Date)
- ECHNICIAN_WORK_IN_LABORARTORY (Employee_Person_ID, Lab_Name, Assigned_Date)
- TREATMENT (Treatment_ID, Patient_Person_ID, Physican_Person_ID, Treatment_Date, Treatment_Name, Treatment_Number, Treatment_Time, Treatment_Result)

The project will be run to enter a patient's ID so that other information associated with him can be retrieved.

**For example, the input patient ID is 2, and the result is as follow**

Connecting Database...

Instantiate the Statement object...

Please Enter the patient number:

2

Patient Number: 2

Patients Name: PN2

Care Centre Name: CC2

Nurse Charge Name: N2

Treatment ID Treatment Name physicianID Date

2 TN2 2 2020-09-21

Goodbye!
