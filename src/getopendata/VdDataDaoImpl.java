/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getopendata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kizax
 */
public class VdDataDaoImpl implements VdDataDao {

    @Override
    public void add(ArrayList<VdData> vdDataList) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        StringBuffer sql = new StringBuffer("INSERT INTO vddata (deviceid,exchangetime,laneno,volume,avgspeed,avgoccupancy,svolume,mvolume,lvolume) VALUES (?,?,?,?,?,?,?,?,?)");
        try {
            conn = DbUtils.getConnection();

            for (int i = 0; i < vdDataList.size() - 1; i++) {
                sql.append(", (?,?,?,?,?,?,?,?,?)");
            }

            preparedStatement = conn.prepareStatement(sql.toString());

            for (int i = 0; i < vdDataList.size(); i++) {

                VdData vdData = vdDataList.get(i);

                preparedStatement.setString(i * 9 + 1, vdData.getDeviceId());
                preparedStatement.setString(i * 9 + 2, vdData.getTimeStr());
                preparedStatement.setInt(i * 9 + 3, vdData.getLaneNo());
                preparedStatement.setDouble(i * 9 + 4, vdData.getVolume());
                preparedStatement.setDouble(i * 9 + 5, vdData.getAvgSpeed());

                preparedStatement.setDouble(i * 9 + 6, vdData.getAvgOccupancy());
                preparedStatement.setDouble(i * 9 + 7, vdData.getSVolume());
                preparedStatement.setDouble(i * 9 + 8, vdData.getMVolume());
                preparedStatement.setDouble(i * 9 + 9, vdData.getLVolume());

            }

            if (vdDataList.size() > 0) {
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Insertion fail");
        } finally {
            DbUtils.close(null, preparedStatement, conn);
        }
    }

}
