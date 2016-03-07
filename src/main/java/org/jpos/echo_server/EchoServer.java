package org.jpos.echo_server;

import java.io.IOException;

import org.jpos.iso.*;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.packager.XMLPackager;
import org.jpos.q2.*;
import org.jpos.util.LogSource;

public class EchoServer extends QBeanSupport implements Runnable, EchoServerMBean, ISORequestListener {

    @Override
    protected void startService() throws IOException, ISOException {
        new Thread(this).start();
    }

    public void run() {
        while (running()) {
            try {
                runServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            if(running())
                ISOUtil.sleep(1000);
        }
    }

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
    
    private void runServer() throws IOException, ISOException {
        // configure channel and assign logger
        ServerChannel channel = new XMLChannel(new XMLPackager());
        ((LogSource) channel).setLogger(log.getLogger(), "channel");
        
        // configure server
        ISOServer server = new ISOServer(8000, channel, null);
        server.setLogger(log.getLogger(), "server");
        server.addISORequestListener(new EchoServer());

        server.run();
    }

}