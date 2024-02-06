package com.jake.im.message.entity;

import com.jake.im.common.enums.GroupRoleType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "group_users")
@Data
public class GroupUser {
    @PrimaryKey
    private GroupUserKey key;

    @Column(value = "role_type")
    @CassandraType(type = CassandraType.Name.INT)
    private GroupRoleType isOwner;
}
