package com.jake.im.message.entity;

import com.jake.im.common.enums.MessageType;
import com.jake.im.common.enums.OperationType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "message_feeds")
@Data
public class MessageFeed {
    @PrimaryKey
    private MessageFeedKey key;

    @Column(value = "author_id")
    private Long authorId;
    @Column(value = "content")
    private String content;
    @Column(value = "message_type")
    private MessageType messageType;
    @Column(value = "operation_type")
    private OperationType operationType;

    // reply
    @Column(value = "reply_message_id")
    private Long replyMessageId;

    // forwarding
    @Column(value = "forwarding_channel_id")
    private Long forwardingChannelId;
    @Column(value = "forwarding_message_id")
    private Long forwardingMessageId;
    @Column(value = "forwarding_author_id")
    private Long forwardingAuthorId;
    @Column(value = "forwarding_content")
    private String forwardingContent;
}
