/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getopendata;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kizax
 */
public class VdData {

    private final String deviceID;
    private final Date exchangeTime;
    private final int laneNO;
    private final double volume;
    private final double avgSpeed;
    private final double avgOccupancy;
    private final double sVolume;
    private final double mVolume;
    private final double lVolume;

    public VdData(String deviceID, Date exchangeTime, int laneNO, double volume, double avgSpeed, double avgOccupancy, double sVolume, double mVolume, double lVolume) {

        this.deviceID = deviceID;
        this.exchangeTime = exchangeTime;
        this.laneNO = laneNO;
        this.volume = volume;
        this.avgSpeed = avgSpeed;
        this.avgOccupancy = avgOccupancy;
        this.sVolume = sVolume;
        this.mVolume = mVolume;
        this.lVolume = lVolume;

    }

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

    /**
     * @return the dateTime
     */
    public Date getDateTime() {
        return exchangeTime;
    }

    private String getTimeStr() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2016-01-15 00:00:00
        String timeStr = timeFormat.format(exchangeTime);
        return timeStr;
    }

}
