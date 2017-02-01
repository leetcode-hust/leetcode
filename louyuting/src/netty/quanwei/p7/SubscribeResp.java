package netty.quanwei.p7;

import java.io.Serializable;

/**
 * Created by louyuting on 17/2/1.
 */
public class SubscribeResp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String messageID;

    private String respCode;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    @Override
    public String toString() {
        return "SubscribeReq: [messageID]:"+ messageID + " [respCode]:" +respCode
                + " [description]:" +description;
    }
}
