package hms.ussd.manager.sample.menu;

import com.hms.Session;
import com.hms.menu.Menu;
import hms.tap.api.ussd.OperationType;
import hms.tap.api.ussd.messages.MoUssdReq;

/**
 * Created by rajive on 4/21/15.
 */
public class LoveTipMenu implements Menu {

    public static final String MenuName = LoveTipMenu.class.getName();

    @Override
    public String getMenuName() {
        return MenuName;
    }

    @Override
    public String getMessage(Session session,MoUssdReq moUssdReq) {
        return "Love Tips\n1.Friendship Love\n2.Romantic Love \n000.Exit";
    }

    @Override
    public String getNextMenu(Session session,MoUssdReq moUssdReq) {
        String nextMenuName = null;
        String message = moUssdReq.getMessage();
        if ("1".equals(message)) {
            nextMenuName = "";

        } else if ("2".equals(message)) {
            nextMenuName = "";

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
