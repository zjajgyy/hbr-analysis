package com.bigdata.hbr.listener;

/**
 * Created by percy on 2017/1/6.
 */
public class UploadStatus {

    private long bytesRead;

    private long contentLength;

    private int items;

    private long startTime = System.currentTimeMillis();

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "UploadStatus{" +
                "bytesRead=" + bytesRead +
                ", contentLength=" + contentLength +
                ", items=" + items +
                ", startTime=" + startTime +
                '}';
    }
}
