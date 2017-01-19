package com.bigdata.hbr.plugin;

/**
 * Created by percy on 2017/1/10.
 */
public class HistoryDataMultiProcess implements Runnable {

    private String username;

    public HistoryDataMultiProcess(String username) {
        this.username = username;
    }
    @Override
    public void run() {
        synchronized (HistoryDataMultiProcess.class) {
            //String username = "";//从前端获取用户名
            String[] arg1 = new String[]{username};
            TestCommonScala.main(arg1);
        }

    }
}