/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Andrew;

/**
 *
 * @author Andrew
 */
public class StockInfo implements Comparable<StockInfo> {
    //This data is about 1 week of hourly traffic estimate in Ontario
    //2 string elements and 6 integer data to represent the traffic volume of each type of car and road type
    private String region;
    private String roadType;
    private int dayOfWeek;
    private int hour;
    private int numSingleTruck;
    private int numMultiTruck;
    private int truckTotal;
    private int carsTotal;
    
    /**
     * Constructor for setting the value of the variables by each item in the array
     * @param data The row of data
     */
    public StockInfo(String[] data) {
        //Each row of data will have 8 parts to it
        region = data[0];
        roadType = data[1];
        dayOfWeek = Integer.parseInt(data[2]);
        hour = Integer.parseInt(data[3]);
        numSingleTruck = Integer.parseInt(data[4]);
        numMultiTruck = Integer.parseInt(data[5]);
        truckTotal = Integer.parseInt(data[6]);
        carsTotal = Integer.parseInt(data[7]);
    }

    /**
     * Compares the total number of cars on the road in one week
     *
     * @param other The other row of data
     * @return 0 if both number of total cars are equal; returns -1 is the
     * current car total is smaller returns 1 if the current car total is
     * greater
     */
    @Override
    public int compareTo(StockInfo other) {
        if (this.getCarsTotal() == other.getCarsTotal()) {
            return 0;
        } else if (this.getCarsTotal() < other.getCarsTotal()) {
            return -1;
        } else {
            return 1;
        }
    }
    /**
     * Separates the data by using a comma as a delimiter
     * @return the data in a delimited format
     */
    @Override
    public String toString(){
        String delim = ",";
        return getRegion() + delim + getRoadType() + delim + getDayOfWeek() + delim + getHour() + delim + getNumSingleTruck() + delim + getNumMultiTruck() + delim + getTruckTotal() 
                +delim + getCarsTotal();
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the roadType
     */
    public String getRoadType() {
        return roadType;
    }

    /**
     * @param roadType the roadType to set
     */
    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    /**
     * @return the dayOfWeek
     */
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * @param dayOfWeek the dayOfWeek to set
     */
    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * @return the numSingleTruck
     */
    public int getNumSingleTruck() {
        return numSingleTruck;
    }

    /**
     * @param numSingleTruck the numSingleTruck to set
     */
    public void setNumSingleTruck(int numSingleTruck) {
        this.numSingleTruck = numSingleTruck;
    }

    /**
     * @return the numMultiTruck
     */
    public int getNumMultiTruck() {
        return numMultiTruck;
    }

    /**
     * @param numMultiTruck the numMultiTruck to set
     */
    public void setNumMultiTruck(int numMultiTruck) {
        this.numMultiTruck = numMultiTruck;
    }

    /**
     * @return the truckTotal
     */
    public int getTruckTotal() {
        return truckTotal;
    }

    /**
     * @param truckTotal the truckTotal to set
     */
    public void setTruckTotal(int truckTotal) {
        this.truckTotal = truckTotal;
    }

    /**
     * @return the carsTotal
     */
    public int getCarsTotal() {
        return carsTotal;
    }

    /**
     * @param carsTotal the carsTotal to set
     */
    public void setCarsTotal(int carsTotal) {
        this.carsTotal = carsTotal;
    }
}
