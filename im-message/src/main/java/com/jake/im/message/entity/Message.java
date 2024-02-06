package com.jake.im.message.entity;

import com.jake.im.common.enums.MessageType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Table(value = "messages")
@Data
public class Message {
    @PrimaryKey
    private MessageKey key;

    @Column(value = "author_id")
    private Long authorId;
    @Column(value = "content")
    private String content;
    @Column(value = "message_type")
    private MessageType messageType;

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

    @Column(value = "is_edited")
    private Boolean isEdited;
    @Column(value = "is_pinned")
    private Boolean isPinned;
    @Column(value = "is_deleted")
    private Boolean isDeleted;

    // user id : emoji
    @Column(value = "emoji_map")
    private Map<Long, String> emojiMap;

    // user id
    @Column(value = "deleted_set")
    private Set<Long> deletedSet;
}
