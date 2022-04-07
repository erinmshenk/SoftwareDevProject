public class Physician extends EmergencyRoom{
    
    String tests;
    String observation;
    String symptoms;
    String discharge;
    String medications;
    String diagnoses;
    
    public Physician(String tests, String observation, String symptoms, String discharge,
    String medications, String diagnoses){
        
        super(tests, observation, symptoms, discharge, medications, diagnoses);
        
    }
    
    public String toString()
    {
        return (super.toString()+"The tests required by the physician: "+ tests +", doctors observation notes: "
                + observation +", symptoms noticed: "+ symptoms +", discharge instructions: "+ discharge +
                ", prescribed medications: "+ medications +", final diagnoses: "+ diagnoses);
    }
}
}
