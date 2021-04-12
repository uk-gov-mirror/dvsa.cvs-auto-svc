package vott.databaseIntegrity;

import org.junit.Before;
import org.junit.Test;
import vott.DataMethods;
import vott.DatabaseConnection;
import vott.databaseModels.TestResult;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class TestResultTests {

    private DatabaseConnection db =  new DatabaseConnection();

    //Setup Test Container
    @Before
    public void before() throws SQLException {
        db.AWSConnection();
    }

    @Test
    public void TestResultInsertExistingDataTest() throws SQLException {

        //Create new data object
        TestResult tr = new TestResult();

        ResultSet startingRS = db.startingResultSet("test_result");
        int startingRowCount = DataMethods.getResultSetLength(startingRS);

        //Capture data from first row of results
        startingRS.first();
        ResultSetMetaData rsmd = startingRS.getMetaData();
//        tr.setTestResult(startingRS);

        //create insert query using first row from the DB
        String insertQuery = tr.createInsertQuery();
        int update = db.dbUpdate(insertQuery);

        ResultSet endRS = db.endResultSet("test_result");
        int endRowCount = DataMethods.getResultSetLength(endRS);

        startingRS.first();
        endRS.first();
        int colCount = rsmd.getColumnCount();
        for (int i = 1; i <= colCount; i++){
            assertThat(startingRS.getString(i), equalTo(endRS.getString(i)));
        }

        startingRS.last();
        endRS.last();
        for (int i = 1; i <= colCount; i++){
            assertThat(startingRS.getString(i), equalTo(endRS.getString(i)));
        }

        assertThat(startingRowCount, equalTo(endRowCount));
        assertThat(update, equalTo(1));

    }

    @Test
    public void TestResultInsertNewDataTest() throws SQLException {

        String query = "SELECT * FROM test_result";

        ResultSet startingRS = db.dbQuery(query);
        int startingLength = DataMethods.getResultSetLength(startingRS);
        startingRS.first();

        String insertQuery = "INSERT INTO .`test_result` (`vehicle_id`,`fuel_emission_id`,`test_station_id`,`tester_id`,`preparer_id`,`vehicle_class_id`,`test_type_id`,`testStatus`,`reasonForCancellation`,`numberOfSeats`,`odometerReading`,`odometerReadingUnits`,`countryOfRegistration`,`noOfAxles`,`regnDate`,`firstUseDate`,`createdAt`,`lastUpdatedAt`,`testCode`,`testNumber`,`certificateNumber`,`secondaryCertificateNumber`,`testExpiryDate`,`testAnniversaryDate`,`testTypeStartTimestamp`,`testTypeEndTimestamp`,`numberOfSeatbeltsFitted`,`lastSeatbeltInstallationCheckDate`,`seatbeltInstallationCheckDate`,`testResult`,`reasonForAbandoning`,`additionalNotesRecorded`,`additionalCommentsForAbandon`,`particulateTrapFitted`,`particulateTrapSerialNumber`,`modificationTypeUsed`,`smokeTestKLimitApplied`,`createdBy_Id`,`lastUpdatedBy_Id`) " +
                "VALUES (1,1,1,1,1,1,1,'Submitted','null',3,0,'Test','UK',2,NULL,NULL,NULL,NULL,'abc','A12B34567','A12B34567','A12B34567',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1) " +
                "ON DUPLICATE KEY UPDATE id=LAST_INSERT_ID(id)";

        int update = db.dbUpdate(insertQuery);
        ResultSet endRS = db.dbQuery(query);
        int endLength = DataMethods.getResultSetLength(endRS);

        assertThat(startingLength+1, equalTo(endLength));
        assertThat(update, equalTo(1));

        //data Clean Up
        if (update == 1){
            db.deleteLastEntry("test_result");
        }

    }
}