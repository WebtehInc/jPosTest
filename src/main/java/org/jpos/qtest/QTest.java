package org.jpos.qtest;

import org.jpos.iso.ISOUtil;
import org.jpos.q2.*;

public class QTest extends QBeanSupport implements Runnable, QTestMBean {
    long tickInterval;
    
    public long getTickInterval() {
        return tickInterval;
    }

    public void setTickInterval(long tickInterval) {
        this.tickInterval = tickInterval;
    }

    @Override
    protected void startService() {
        new Thread(this).start();
    }

    public void run() {
        for (int tickCount = 0; running(); tickCount++) {
            log.info("tick " + tickCount);
            ISOUtil.sleep(tickInterval);
        }
    }
}