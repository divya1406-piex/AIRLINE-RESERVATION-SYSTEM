package Modules;

public class Aircraft
{
    protected String aircraftName;
    protected String sources;
    protected String destination;
    
    Aircraft(String aircraftName,String source,String destination)
    {
        this.aircraftName=aircraftName;
        this.sources=source;
        this.destination=destination;
    }
    public void displayDetails()
    {
        System.out.println("Aircraft Name                                   : "+this.aircraftName);
        System.out.println("Sources                                         : "+this.sources);
        System.out.println("Destination                                     : "+this.destination);
    }
}
