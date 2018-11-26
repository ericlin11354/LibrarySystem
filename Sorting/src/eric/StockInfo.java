/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eric;

/**
 *  StockInfo Class keeps track of information in each row of "unsortedData.csv"
 * @author Eric
 */
public class StockInfo implements Comparable<StockInfo>{
    //info in order
    //year is described as an estimate (ex. "2000/2002")
    private String year;
    //information includes Canada as a country
    private String province;
    private String sex;
    //age is described in data as a String
    private String age;
    private double lifeExpectancy;
    
    /**
     * Constructor sets values based on String array
     * @param arr 
     */
    public StockInfo(String arr[]){
        //loop avoided assuming that each row always contains 5 elements of info
        year = arr[0];
        province = arr[1];
        sex = arr[2];
        age = arr[3];
        lifeExpectancy = Double.parseDouble(arr[4]);
    }
    
    /**
     * Compares the life expectancy of two instances of StockInfo
     * @param other gets the other instance
     * @return returns 1 if the life expectancy of other is less. Returns 0 if both share the same life expectancy.
     * Returns -1 if the life expectancy of other is greater.
     */
    @Override
    public int compareTo(StockInfo other){
        if(this.getLifeExpectancy()<other.getLifeExpectancy())
            return -1;
        else if(this.getLifeExpectancy()==other.getLifeExpectancy())
            return 0;
        return 1;
    }
    
    /**
     * Gets information of instance in a comma delimited format
     * @return returns information
     */
    @Override
    public String toString(){
        String delim = ",";
        return getYear() + delim + getProvince() + delim + getSex() + delim + getAge() + delim + getLifeExpectancy();
    }

    
                                                    //BELOW CONSISTS OF GETTERS AND SETTERS
    
    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the lifeExpectancy
     */
    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * @param lifeExpectancy the lifeExpectancy to set
     */
    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
}
