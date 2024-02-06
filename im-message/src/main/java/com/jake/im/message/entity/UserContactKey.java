package com.jake.im.message.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
@Data
public class UserContactKey {
    @PrimaryKeyColumn(value = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long userId;
    @PrimaryKeyColumn(value = "contact_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Long contactId;
}
