package Modules;

public class PrivateAircraft extends Aircraft
{
    private String pilotPreference;
    private String purpose;
    private boolean checkinbeforetwohours;
    
    PrivateAircraft(String aircraftName,String sources,String destination,boolean checkinbeforetwohours,String pilotPreference,String purpose)
    {
        super(aircraftName,sources,destination);
        this.checkinbeforetwohours=checkinbeforetwohours;
        this.pilotPreference= pilotPreference;
        this.purpose=purpose;
    }
    public void displayDetails()
    {
        super.displayDetails();
        if(checkinbeforetwohours==true)
        {
            System.out.println("Flight check in before two hours : Yes");
        }
        else
        {
            System.out.println("Flight check in before two hours : No");
        }
        System.out.println("Pilot chose           : "+this.pilotPreference);
        System.out.println("Purpose of the flight : "+this.purpose);
       // System.out.println("Registration is completed and registered successfully");
    }

}