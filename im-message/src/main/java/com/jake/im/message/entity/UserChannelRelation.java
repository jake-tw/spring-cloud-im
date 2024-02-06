package com.jake.im.message.entity;

import com.jake.im.common.enums.ChannelType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "user_channel_relations")
@Data
public class UserChannelRelation {
    @PrimaryKey
    private UserChannelRelationKey key;

    @Column(value = "channel_type")
    @CassandraType(type = CassandraType.Name.INT)
    private ChannelType channelType;

    // either group id or user id by channel type
    @Column(value = "target_id")
    private Long targetId;

    @Column(value = "message_starting_point")
    private Long messageStartingPoint;

    @Column(value = "is_muted")
    private Boolean isMuted;

    @Column(value = "is_blocked")
    private Boolean isBlocked;

    @Column(value = "is_pinned")
    private Boolean isPinned;
    @Column(value = "pin_timestamp")
    private Long pinTimestamp;
}
