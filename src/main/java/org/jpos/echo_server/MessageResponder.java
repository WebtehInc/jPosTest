package org.jpos.echo_server;

import java.io.IOException;

import org.jpos.iso.*;

public class MessageResponder implements ISORequestListener {

    @Override
    public boolean process(ISOSource source, ISOMsg m) {
        try {
            m.setResponseMTI();
            m.set(39, "00");
            source.send(m);
        } catch (ISOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
}