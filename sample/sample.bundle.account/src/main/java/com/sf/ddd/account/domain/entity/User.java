package com.sf.ddd.account.domain.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 类User.java的实现描述：TODO 类实现描述
 * 
 * @author lizhuo 2020年7月22日 下午10:29:45
 */
@Data
@TableName("ti_fx_admin_board")
@ApiModel(value = "公告栏表", description = "公告栏表")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long          id;

    @ApiModelProperty(value = "'公告栏标题'")
    private String        boardTitle;

    @ApiModelProperty(value = "'公告栏详细'")
    private String        boardContent;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;

    @ApiModelProperty(value = "创建人")
    private String        creator;

    @ApiModelProperty(value = "'开始时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;
    @ApiModelProperty(value = "'结束时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
