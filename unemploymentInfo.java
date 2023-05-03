import javax.swing.plaf.nimbus.State;

public class unemploymentInfo
{
    private String mStateName;
    private String mAbbreviation;
    private float mURate;


    public String getmStateName() {
        return mStateName;
    }

    public void setmStateName(String mStateName) {
        this.mStateName = mStateName;
    }

    public String getmAbbreviation() {
        return mAbbreviation.toUpperCase();
    }

    public void setmAbbreviation(String mAbbreviation) {
        this.mAbbreviation = mAbbreviation;
    }

    public float getmURate() {
        return mURate;
    }

    public void setmURate(float mURate) {
        this.mURate = mURate;
    }


    public unemploymentInfo(String Abbreviation,String mStateName,float mURate)
    {
        this.mAbbreviation = Abbreviation;
        this.mStateName = mStateName;
        this.mURate = mURate;

    }
    @Override
    public String toString() {
        return "unemploymentInfo{" +
                "mStateName='" + mStateName + '\'' +
                ", mAbbreviation='" + mAbbreviation + '\'' +
                ", mURate=" + mURate +
                '}';
    }

//    public String getStateName()
//    {
//        return mStateName;
//    }
//
//    public String getAbbreviation()
//    {
//        return mAbbreviation;
//    }
//
//    public float getURate()
//    {
//        return mURate;
//    }

//    public String toString()
//    {
//        return "Abbreviation: " + getAbbreviation() + "State: " + getStateName() + "Unemployment Rate: " + getURate();
//    }
}


