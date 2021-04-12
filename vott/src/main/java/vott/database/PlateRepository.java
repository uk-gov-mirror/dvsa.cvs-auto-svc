package vott.database;

import vott.databaseModels.Microfilm;
import vott.databaseModels.Plate;
import vott.sqlgeneration.TableDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlateRepository extends AbstractRepository<Plate> {
    public PlateRepository(ConnectionFactory connectionFactory) { super(connectionFactory); }

    @Override
    protected TableDetails getTableDetails() {

        TableDetails tableDetails = new TableDetails();

        tableDetails.setTableName("plate");
        tableDetails.setColumnNames(new String[] {
                "technical_record_id",
                "plateSerialNumber",
                "plateIssueDate",
                "plateReasonForIssue",
                "plateIssuer",
        });

        return tableDetails;
    }

    @Override
    protected void setParameters(PreparedStatement preparedStatement, Plate entity) throws SQLException {

        // 1-indexed
        preparedStatement.setString(1, entity.getTechnicalRecordID());
        preparedStatement.setString(2, entity.getPlateSerialNumber());
        preparedStatement.setString(3, entity.getPlateIssueDate());
        preparedStatement.setString(4, entity.getPlateReasonForIssue());
        preparedStatement.setString(5, entity.getPlateIssuer());
    }

    @Override
    protected Plate mapToEntity(ResultSet rs) throws SQLException {
        Plate plate = new Plate();

        plate.setTechnicalRecordID(rs.getString("technical_record_id"));
        plate.setPlateSerialNumber(rs.getString("plateSerialNumber"));
        plate.setPlateIssueDate(rs.getString("plateIssueDate"));
        plate.setPlateReasonForIssue(rs.getString("plateReasonForIssue"));
        plate.setPlateIssuer(rs.getString("plateIssuer"));

        return plate;
    }
}
