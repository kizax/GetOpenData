/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getopendata;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kizax
 */
public interface VdDataDao {
     public void add(ArrayList<VdData> vdDataList) throws SQLException;
}
