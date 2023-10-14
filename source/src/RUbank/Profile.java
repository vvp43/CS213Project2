package RUbank;

/**
 *
 * @author
 */

public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;

    /**
     *
     * @author
     */
    public Profile(String fname, String lname, Date dob){
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public Date getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object input){
        Profile cast = (Profile) input;
        return fname.equals(cast.fname) && lname.equals(cast.lname) && dob.equals(cast.dob);
    }
    @Override
    public int compareTo(Profile o) {
        return 0;
    }
}
