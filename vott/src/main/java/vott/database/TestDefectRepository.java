package vott.database;

import vott.databaseModels.Location;
import vott.databaseModels.TestDefect;
import vott.sqlgeneration.TableDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDefectRepository extends AbstractRepository<TestDefect>{
    public TestDefectRepository(ConnectionFactory connectionFactory) { super(connectionFactory); }

    @Override
    protected TableDetails getTableDetails() {

        TableDetails tableDetails = new TableDetails();

        tableDetails.setTableName("test_defect");
        tableDetails.setColumnNames(new String[] {
                "test_result_id",
                "defect_id",
                "location_id",
                "notes",
                "prs",
                "prohibitionIssued",
        });

        return tableDetails;
    }

    @Override
    protected void setParameters(PreparedStatement preparedStatement, TestDefect entity) throws SQLException {
        // 1-indexed
        preparedStatement.setString(1, entity.getTestResultID());
        preparedStatement.setString(2, entity.getDefectID());
        preparedStatement.setString(3, entity.getLocationID());
        preparedStatement.setString(4, entity.getNotes());
        preparedStatement.setString(5, entity.getPrs());
        preparedStatement.setString(6, entity.getProhibitionIssued());

    }

    @Override
    protected TestDefect mapToEntity(ResultSet rs) throws SQLException {
        TestDefect td = new TestDefect();

        td.setTestResultID(rs.getString("test_result_id"));
        td.setDefectID(rs.getString("defect_id"));
        td.setLocationID(rs.getString("location_id"));
        td.setNotes(rs.getString("notes"));
        td.setPrs(rs.getString("prs"));
        td.setProhibitionIssued(rs.getString("prohibitionIssued"));

        return td;
    }
}
