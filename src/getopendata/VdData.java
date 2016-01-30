/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getopendata;

/**
 *
 * @author kizax
 */
public class VdData {

    private String deviceID;
    private String time;
    private int laneNO;
    private double volume;
    private double avgSpeed;
    private double avgOccupancy;
    private double sVolume;
    private double mVolume;
    private double lVolume;

    
    
    public String getMovementListStr() {
        String movementListStr = null;
//
//        int movementListCount = 0;
//        for (String m : movementList) {
//            movementListCount++;
//            movementListStr += m;
//            if (movementListCount != movementList.size()) {
//                movementListStr += ", ";
//            }
//        }

        return movementListStr;
    }

    /**
     * @return the deviceID
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * @return the laneNO
     */
    public int getLaneNO() {
        return laneNO;
    }

    /**
     * @return the volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * @return the avgSpeed
     */
    public double getAvgSpeed() {
        return avgSpeed;
    }

    /**
     * @return the avgOccupancy
     */
    public double getAvgOccupancy() {
        return avgOccupancy;
    }

    /**
     * @return the sVolume
     */
    public double getsVolume() {
        return sVolume;
    }

    /**
     * @return the mVolume
     */
    public double getmVolume() {
        return mVolume;
    }

    /**
     * @return the lVolume
     */
    public double getlVolume() {
        return lVolume;
    }

}
