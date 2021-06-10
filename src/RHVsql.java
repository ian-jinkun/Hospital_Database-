import java.sql.*;
import java.io.*;

public class RHVsql {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/customer-tracker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    static final String USER = "root";
    static final String PASS = "zhaojinkun";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // register JDBC
            Class.forName(JDBC_DRIVER);

            // open linking
            System.out.println("Connecting Database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // execute query
            System.out.println("Instantiate the Statement object...");
            stmt = conn.createStatement();
            String patientsTable;
            patientsTable = "SELECT * FROM patients";
            ResultSet rs = stmt.executeQuery(patientsTable);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int patientID = -1;
            System.out.println("Please Enter the patient number:");
            patientID = Integer.parseInt(br.readLine());

        
            // Expand the result set database
            while(rs.next()){
                //Retrieve by field
                int id  = rs.getInt("pid");
                String name = rs.getString("patient_name");
                int careCentreID = rs.getInt("care_centre_id");
                String careCentreName = null;
                int nurseChargeId = -1;
                String nurseChargeName = null;
                int treatmentID = -1;
                String treatmentName = null;
                int physicianID = -1;
                Date date = null;

                if(patientID == id){
                    PreparedStatement st = null;
                    String careCentresTable = "SELECT name, nurse_charge_id FROM care_centres WHERE cid=?";
                    st = conn.prepareStatement(careCentresTable);
                    st.setInt(1, careCentreID);
                    st.executeQuery();

                    ResultSet ct = st.executeQuery();

                    while(ct.next()){
                        careCentreName = ct.getString("name");
                        nurseChargeId = ct.getInt("nurse_charge_id");
                    }

                    if(nurseChargeId != -1){
                        PreparedStatement ns = null;
                        String nurseTable = "SELECT name FROM nurses WHERE nid=?";
                        ns = conn.prepareStatement(nurseTable);
                        ns.setInt(1, nurseChargeId);
                        ns.executeQuery();

                        ResultSet nt = ns.executeQuery();
                        while(nt.next()){
                            nurseChargeName = nt.getString("name");
                        }
                    }
                    PreparedStatement tt = null;
                    String TreatmentTable = "SELECT tid, physician_id, treatment_name, date FROM treatments WHERE patient_id = ?";
                    tt = conn.prepareStatement(TreatmentTable);
                    tt.setInt(1, id);
                    tt.executeQuery();

                    ResultSet mt = tt.executeQuery();
                    while(mt.next()){
                        treatmentID = mt.getInt("tid");
                        treatmentName = mt.getString("treatment_name");
                        physicianID = mt.getInt("physician_id");
                        date = mt.getDate("date");

                    }

                    System.out.print("Patient Number: " + id + '\n');
                    System.out.print("Patients Name: " + name + '\n');
                    System.out.print("Care Centre Name: " + careCentreName + '\n');
                    System.out.print("Nurse Charge Name: " + nurseChargeName + '\n');

                    System.out.print("Treatment ID" + "   " + "Treatment Name" + "   " +  "physicianID" + "   " +  "Date" + '\n');
                    System.out.print(treatmentID + "              " + treatmentName + "              " +  physicianID + "             " +  date);
                    System.out.print("\n");
                    break;
                }
            }
            // close
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// Nothing to do
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
