package com.jake.im.message.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "file_info")
@Data
public class FileInfo {
    @PrimaryKey
    private FileInfoKey key;

    // file
    @Column(value = "file_path")
    private String filePath;
    @Column(value = "file_size")
    private String fileSize;
    @Column(value = "file_info")
    private String fileInfo;
    @Column(value = "file_seconds")
    private String fileSeconds;
    @Column(value = "file_preview")
    private String filePreview;
}
