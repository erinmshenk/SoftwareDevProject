public class Nurse extends EmergencyRoom{
    
    int vitals;
    String height;
    int weight;
    int nightsstayed;
    String bloodpressure;
    String admittance;
    String observation;
    String pretreatment;
    
    public Nurse(int vitals, String height, int weight, int nightsstayed, String bloodpressure,
    String admittance, String observation, String pretreatment){
        
        super(vitals, height, weight, nightsstayed, bloodpressure, admittance, observation, pretreatment);
        
    }
    
    public String toString()
    {
        return (super.toString()+"patient's vitals: "+ vitals +", the patient's height is: "+ height +
                ", the patient's weight is: "+ weight +"lbs., the patient has stayed "+ nightsstayed +
                "nights in the emergency room, the patient's blood pressure: "+ bloodpressure +
                "does the patient require admittance? "+ admittance +"my notes on the patient's condition: "+ observation +
                ", the pre-treatment performed to the patient before seeing the doctor: "+ pretreatment);
    }
}
}
