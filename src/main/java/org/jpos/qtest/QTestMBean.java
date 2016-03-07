package org.jpos.qtest;

public interface QTestMBean extends org.jpos.q2.QBeanSupportMBean {
    public void setTickInterval(long tickInterval);

    public long getTickInterval();
    
}