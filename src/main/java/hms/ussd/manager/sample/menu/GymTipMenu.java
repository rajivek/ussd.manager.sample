package hms.ussd.manager.sample.menu;

import com.hms.Session;
import com.hms.menu.Menu;
import hms.tap.api.ussd.OperationType;
import hms.tap.api.ussd.messages.MoUssdReq;

/**
 * Created by rajive on 4/21/15.
 */
public class GymTipMenu implements Menu {

    public static final String MenuName = GymTipMenu.class.getName();


    @Override
    public String getMenuName() {
        return MenuName;
    }

    @Override
    public String getMessage(Session session,MoUssdReq moUssdReq) {
        return "GYM Tips\n1.abs tip for men\n2.abs tip for women 000.Exit";
    }

    @Override
    public String getNextMenu(Session session,MoUssdReq moUssdReq) {

       String nextMenuName = null;
        if ("1".equals(moUssdReq.getMessage())) {
            nextMenuName = "";

        } else if ("2".equals(moUssdReq.getMessage())) {
            nextMenuName = "";

        } else if ("3".equals(moUssdReq.getMessage())) {
            nextMenuName = "";

        }

        return nextMenuName;
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.MT_CONT;
    }
}
