package hms.ussd.manager.sample.menu;

import com.hms.Session;
import com.hms.menu.Menu;
import hms.tap.api.ussd.OperationType;
import hms.tap.api.ussd.messages.MoUssdReq;

/**
 * Created by rajive on 4/21/15.
 */
public class FirstMenu implements Menu {

    public static final String MenuName = FirstMenu.class.getName();

    @Override
    public String getMenuName() {
        return MenuName;
    }

    @Override
    public String getMessage(Session session,MoUssdReq moUssdReq) {
        return "Sample Tips\n1.GYM Tips\n2.Love Tips\n\n000.Exit";
    }

    @Override
    public String getNextMenu(Session session,MoUssdReq moUssdReq) {
       String nextMenuName = null;
        String message = moUssdReq.getMessage();
        if ("1".equals(message)) {
            nextMenuName = GymTipMenu.MenuName;

        } else if ("2".equals(message)) {
            nextMenuName = LoveTipMenu.MenuName;

        } else if ("3".equals(message)) {
            nextMenuName = "";

        }
        return nextMenuName;
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.MT_CONT;
    }
}
