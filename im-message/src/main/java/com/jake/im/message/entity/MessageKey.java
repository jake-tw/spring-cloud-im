package com.jake.im.message.entity;


import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;


@PrimaryKeyClass
@Data
public class MessageKey {
    @PrimaryKeyColumn(value = "channel_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long channelId;
    @PrimaryKeyColumn(value = "bucket", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private Long bucket;
    @PrimaryKeyColumn(value = "message_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Long messageId;
}
