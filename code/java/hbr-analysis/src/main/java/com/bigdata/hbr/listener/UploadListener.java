package com.bigdata.hbr.listener;

import org.apache.commons.fileupload.ProgressListener;

/**
 * Created by percy on 2017/1/6.
 */
public class UploadListener implements ProgressListener {

    private UploadStatus status;

    public UploadListener(UploadStatus status) {
        this.status = status;
    }

    public void update(long bytesRead, long contentLength, int items) {
        status.setBytesRead(bytesRead);
        status.setContentLength(contentLength);
        status.setItems(items);
        //System.out.println("execute listener, status: " + status);
    }
}
