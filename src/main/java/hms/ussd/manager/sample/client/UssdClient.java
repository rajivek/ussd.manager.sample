/*
 *   (C) Copyright 1996-2012 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 */
package hms.ussd.manager.sample.client;

import com.hms.UssdMessageProcessor;
import com.hms.conf.AppConfig;
import com.hms.menu.Menu;
import com.hms.repo.GuavaCacheSessionRepoImpl;
import hms.tap.api.ussd.MoUssdListener;
import hms.tap.api.ussd.MoUssdReceiver;
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.ussd.manager.sample.menu.FirstMenu;
import hms.ussd.manager.sample.menu.GymTipMenu;
import hms.ussd.manager.sample.menu.LoveTipMenu;

import java.util.logging.Logger;

public class UssdClient implements MoUssdListener {

    private final static Logger LOGGER = Logger.getLogger(UssdClient.class.getName());

    UssdMessageProcessor ussdMessageProcessor;


    @Override
    public void init() {
        /*// create and initialize service
        try {
            ussdMtSender = new UssdRequestSender(new URL(Messages.getMessage("sdp.server.url")));
        } catch (MalformedURLException e) {
            LOGGER.log(Level.INFO, "Unexpected error occurred", e);
        }*/

        Menu firstMenu = new FirstMenu();

        if (ussdMessageProcessor == null){
            ussdMessageProcessor = new UssdMessageProcessor(firstMenu, new GuavaCacheSessionRepoImpl(), new AppConfig());
        }
        ussdMessageProcessor.registerMenu(firstMenu);
        ussdMessageProcessor.registerMenu(new GymTipMenu());
        ussdMessageProcessor.registerMenu(new LoveTipMenu());

    }

    /**
     * Receive requests
     *
     * @param moUssdReq
     */
    @Override
    public void onReceivedUssd(final MoUssdReq moUssdReq) {


        ussdMessageProcessor.processMessage(moUssdReq);
        /*try {
        menuState = cache.get(moUssdReq.getSessionId());
        // start processing request
        processRequest(moUssdReq);
    } catch (SdpException e) {
        LOGGER.log(Level.INFO, "Unexpected error occurred", e);
    } catch (ExecutionException e) {
        LOGGER.log(Level.INFO, "Unexpected error occurred", e);
    }*/
}

}
