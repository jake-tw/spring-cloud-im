package com.jake.im.message.repository;

import com.jake.im.message.entity.Message;
import com.jake.im.message.entity.MessageKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface MessageRepository extends CassandraRepository<Message, MessageKey> {

    List<Message> findByKeyChannelIdAndKeyBucketAndKeyMessageIdIn(long channelId, long bucket, List<Long> messageId);

    List<Message> findByKeyChannelIdAndKeyBucketAndKeyMessageIdIn(long channelId, long bucket, Set<Long> messageId);

    @Query("UPDATE messages SET test_map = test_map + ?0 WHERE channel_id = ?1 and bucket = ?2 and message_id = ?3")
    void update(Map<String, Boolean> test, long channelId, long bucket, long messageId);

    @Query("UPDATE messages SET test_set = test_set + ?0 WHERE channel_id = :a and bucket = :b and message_id = ?3")
    void update(Set<Long> test, @Param("a") long channelId, @Param("b") long bucket, @Param("c") long messageId);
}
