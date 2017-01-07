package test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by louyuting on 16/12/20.
 */
public class Obj implements Serializable {
    private  static final long serialVersionUID = -5836283489677344417L;

    public transient int classValue = 10;
    public transient Date date = new Date();
    public transient static int staticValue = 10;
    private int te;

    public int getClassValue() {
        return classValue;
    }

    public void setClassValue(int classValue) {
        this.classValue = classValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static int getStaticValue() {
        return staticValue;
    }

    public static void setStaticValue(int staticValue) {
        Obj.staticValue = staticValue;
    }

    public int getTe() {
        return te;
    }

    public void setTe(int te) {
        this.te = te;
    }
}
