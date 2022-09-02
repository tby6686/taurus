package cn.com.taurus.common.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 实体父类
 * @author tby
 * @date 2018-11-08
 */
@Data
public abstract class BaseEntity implements Serializable{
	private static final long serialVersionUID = -7176390653391227433L;

	/** 创建者 */
	@ApiModelProperty(value = "创建者",position = 500)
	private String createBy;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建时间",position = 501)
	private Date createTime;

	/** 更新者 */
	@ApiModelProperty(value="更新者",position = 502)
	private String updateBy;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="更新时间",position = 503)
	private Date updateTime;

	/** 备注 */
	@ApiModelProperty(value = "备注",position = 504)
	private String remark;
}
