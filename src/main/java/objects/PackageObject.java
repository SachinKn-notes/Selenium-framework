package objects;

public class PackageObject {

    int siid;
    String totalAmount;
    EnumContainer.CreditCardType creditCardType;

    public int getSiid() {
        return siid;
    }

    public void setSiid(int siid) {
        this.siid = siid;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public EnumContainer.CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(EnumContainer.CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }
}
