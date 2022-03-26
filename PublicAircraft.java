package Modules;

public class PublicAircraft extends Aircraft
{
    private int noOfKgsallowed;
    private float additionalFeeperKg;
    private boolean checkinbeforetwohours;
    
    PublicAircraft(String aircraftName,String sources,String destination,int noOfKgsallowed,float additionalFeeperKg,boolean b1)
    {
        super(aircraftName,sources,destination);
        this.checkinbeforetwohours=checkinbeforetwohours;
        this.noOfKgsallowed=noOfKgsallowed;
        this.additionalFeeperKg=additionalFeeperKg;
    }
    public void displayDetails()
    {
        super.displayDetails();
        if(checkinbeforetwohours==false)
        {
            System.out.println("Flight check in before two hours                : Yes");
        }
        else
        {
            System.out.println("Flight check in before two hours                : No");
        }
        System.out.println("Number of kgs allowed per person                : "+this.noOfKgsallowed);
        System.out.println("Additional fee charged for extra baggage per Kg : "+this.additionalFeeperKg);
        //System.out.println("Registration is completed and registered successfully");
    }

}

