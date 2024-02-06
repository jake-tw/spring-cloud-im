package com.jake.im.message.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "user_contact")
@Data
public class UserContact {
    @PrimaryKey
    private UserContactKey key;
}
