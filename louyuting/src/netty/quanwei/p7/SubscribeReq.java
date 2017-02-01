package netty.quanwei.p7;

import java.io.Serializable;

/**
 * Created by louyuting on 17/2/1.
 *
 */
public class SubscribeReq implements Serializable{
    private static final long serialVersionUID = 1L;

    private String messageID;

    private String userName;

    private String productName;

    private String phone;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "SubscribeReq: [messageID]:"+ messageID + " [userName]:" +userName
                + " [productName]:" +productName+ " [phone]:" +phone+ " [address]:" +address;
    }
}
