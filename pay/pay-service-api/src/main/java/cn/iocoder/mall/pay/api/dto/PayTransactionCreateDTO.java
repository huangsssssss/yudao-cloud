package cn.iocoder.mall.pay.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 支付交易创建 DTO
 */
@Data
@Accessors(chain = true)
public class PayTransactionCreateDTO implements Serializable {

    /**
     * 应用编号
     */
    @NotEmpty(message = "应用编号不能为空")
    private String appId;
    /**
     * 发起交易的 IP
     */
    @NotEmpty(message = "IP 不能为空")
    private String createIp;
    /**
     * 业务线的订单编号
     */
    @NotEmpty(message = "订单号不能为空")
    private String orderId;
    /**
     * 订单商品名
     */
    @NotEmpty(message = "商品名不能为空")
    @Size(max = 32, message = "商品名不能超过32")
    private String orderSubject;
    /**
     * 订单商品描述
     */
    @NotEmpty(message = "商品描述不能为空")
    @Size(max = 128, message = "商品描述长度不能超过128")
    private String orderDescription;
    /**
     * 订单备注
     */
    @Size(max = 256, message = "商品描述长度不能超过256")
    private String orderMemo;
    /**
     * 支付金额，单位：分。
     */
    @NotNull(message = "金额不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "金额必须大于零")
    private Integer price;
    /**
     * 交易过期时间
     */
    @NotNull(message = "交易过期时间不能为空")
    private Date expireTime;

}
