package GasStationApplication;

public class Card extends Payment {
    private String ReferenceNo;

    public Card(double amount, String vehicleId, String NICOfOwner,String ReferenceNo,DateTime Dateandtime) {
        super(amount, vehicleId, NICOfOwner,Dateandtime);
        this.ReferenceNo=ReferenceNo;
    }

    public String getReferenceNo() {
        return ReferenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.ReferenceNo = referenceNo;
    }
}
