package com.jake.im.common.util;

/**
 * id: 0 _ 0 00000000 00000000 00000000 00000000 _ 0 0000 _ 0 0000 _ 0000 00000000 = 64 bits
 * 1 bits: +- sign
 * 41 bits: timestamp
 * 5 bits: service id
 * 5 bits: node id (use IP to get the node ID)
 * 12 bits: sequence
 */
public class SnowflakeIdGenerator {


    // 2020 01 01
    private static final long SERVICE_EPOCH = 1577836800000L;

    private static final long TIMESTAMP_BITS = 41L;
    private static final long SERVICE_ID_BITS = 5L;
    private static final long NODE_ID_BITS = 5L;
    private static final long SEQ_ID_BITS = 12L;


    private static final long NODE_ID_SHIFT = SEQ_ID_BITS;
    private static final long SERVICE_ID_SHIFT = SEQ_ID_BITS + NODE_ID_BITS;
    private static final long TIMESTAMP_SHIFT = SEQ_ID_BITS + NODE_ID_BITS + SERVICE_ID_BITS;


    private static final long MAX_TIMESTAMP = -1L ^ (-1L << TIMESTAMP_BITS);
    private static final long MAX_SERVICE_ID = -1L ^ (-1L << SERVICE_ID_BITS);
    private static final long MAX_NODE_ID = -1L ^ (-1L << NODE_ID_BITS);
    private static final long SEQ_MASK = -1L ^ (-1L << SEQ_ID_BITS);

    private static final long SERVICE_ID;

    static {
        SERVICE_ID = 0b10001L;
    }

    private static final long NODE_ID;

    static {
        NODE_ID = 0b11011L;
    }

    private static long lastTimestamp = -1L;
    private static long seq = 0;

    public static long getId() {
        return nextId();
    }

    private synchronized static long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            System.out.println("err timestamp");
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            seq = (seq + 1) & SEQ_MASK;
            if (seq == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            seq = 0;
        }

        lastTimestamp = timestamp;
        return (timestamp - SERVICE_EPOCH) << TIMESTAMP_SHIFT |
                SERVICE_ID << SERVICE_ID_SHIFT |
                NODE_ID << NODE_ID_SHIFT |
                seq;
    }

    public static long timeGen() {
        return System.currentTimeMillis();
    }

    public static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }
}
