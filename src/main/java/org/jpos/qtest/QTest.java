package org.jpos.qtest;

import org.jpos.iso.ISOUtil;
import org.jpos.q2.*;

public class QTest extends QBeanSupport implements Runnable, QTestMBean {
    long tickInterval = 1000;

    @Override
    public void run() {
        for (int tickCount = 0; running(); tickCount++) {
            log.info("tick " + tickCount);
            ISOUtil.sleep(tickInterval);
        }
    }

    @Override
    public void startService() {
        new Thread(this).start();
    }

    public void setTickInterval(long tickInterval) {
        this.tickInterval = tickInterval;
    }

    public long getTickInterval() {
        return tickInterval;
    }
}