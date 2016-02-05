/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getopendata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kizax
 */
public class VdDataDaoImpl implements VdDataDao {

    @Override
    public void add(VdData vdData) throws SQLException {
      Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO vddata (deviceid,exchangetime,laneno,volume,avgspeed,avgoccupancy,svolume,mvolume,lvolume) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            conn = DbUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, vdData.getDeviceId());
            preparedStatement.setString(2, vdData.getTimeStr());
            preparedStatement.setInt(3, vdData.getLaneNo());
            preparedStatement.setDouble(4, vdData.getVolume());
            preparedStatement.setDouble(5, vdData.getAvgSpeed());

            preparedStatement.setDouble(6, vdData.getAvgOccupancy());
            preparedStatement.setDouble(7, vdData.getSVolume());
            preparedStatement.setDouble(8, vdData.getMVolume());
            preparedStatement.setDouble(9, vdData.getLVolume());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Insertion fail");
        } finally {
            DbUtils.close(null, preparedStatement, conn);
        }
    }
    
}
