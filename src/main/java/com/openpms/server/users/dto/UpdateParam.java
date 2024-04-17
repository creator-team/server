package com.openpms.server.users.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Data;

@Data
@JSONType(schema = """
        {
            "minProperties": 1
        }""")
public class UpdateParam {
    @JSONField(schema = "{'format':'email'}")
    private String email;
    private String name;
    private String avatar;
    private Boolean status;
}