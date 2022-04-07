public class Nurse extends EmergencyRoom{
    
    int vitals;
    int bloodpressure;
    int height;
    int weight;
    int nightsstayed;
    String admittance;
    String observation;
    String pretreatment;
    
    public Nurse(int vitals, int bloodpressure, int height, int weight, int nightsstayed,
    String admittance, String observation, String pretreatment){
        
        super(vitals, bloodpressure, height, weight, nightsstayed, admittance, observation, pretreatment);
        
    }
}
