package cn.lexiang.singleservice.controller;

import cn.lexiang.singleservice.bean.LxException;
import cn.lexiang.singleservice.bean.Result;
import cn.lexiang.singleservice.bean.service.ServiceOrder;
import cn.lexiang.singleservice.bean.service.ServiceOrderQueryVo;
import cn.lexiang.singleservice.service.a.service.ServiceOrderService;
import cn.lexiang.singleservice.service.a.sso.SsoService;
import cn.lexiang.singleservice.uitl.MyUtils;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @Author kay三石
 *
 */
@RestController
@RequestMapping("/api/service/order")
public class ServiceOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceOrderController.class);

    @Autowired
    private ServiceOrderService serviceOrderService;

    /**
     * 获取订单列表
     * @return
     */
    @PostMapping("/list")
    public Result listOrder(ServiceOrderQueryVo serviceOrderQueryVo){
        try {
            return Result.success(serviceOrderService.list(serviceOrderQueryVo))
                    .setCount(serviceOrderService.listSum(serviceOrderQueryVo));
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }
    }
    /**
     * 获取订单详情
     * @param serviceOrder
     * @return
     */
    @PostMapping("/detail")
    public Result orderDetail(ServiceOrder serviceOrder) {
        try {
            logger.debug("serviceOrder: " + serviceOrder);
            if (serviceOrder.getId() == null)
                throw new Exception(LxException.PARA_ERR);
            return Result.success(serviceOrderService.detailOrder(serviceOrder));
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }

    }

    /**
     * 完成订单
     * 服务者订单反馈
     * @param serviceOrder
     * @return
     */
    @PostMapping("/fulfillorder")
    public Result orderReport(ServiceOrder serviceOrder){
        try {
            if (serviceOrder.getId() == null) {
                throw new Exception(LxException.PARA_ERR);
            }
            if (serviceOrderService.orderReport(serviceOrder))
                return Result.success();
            return Result.fail();
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }
    }
    /**
     *确认接单
     * @param serviceOrder
     * @param token
     * @return
     */
    @PostMapping("/reactorder")
    public Result orderReact(ServiceOrder serviceOrder,String token) {
        try {
            if (serviceOrder.getId() == null) {
                throw new Exception(LxException.PARA_ERR);
            }
            serviceOrder.setStartTime(new Date());
            if (serviceOrderService.reactOrder(serviceOrder))
                return Result.success();
            return Result.fail();
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }
    }
    /**
     * 历史订单
     * @param serviceOrder
     * @return
     */
    @PostMapping("/historyorder")
    public Result historyOrder(ServiceOrder serviceOrder){
        try {
            logger.debug(serviceOrder.getServiceid().toString());
            if (serviceOrder.getServiceid() != null){
                return Result.success(serviceOrderService.listHistoryOrder(serviceOrder));
            }else{
                return Result.createResult(Result.CODE_FAIL,"未获取到","null");
            }
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }

    }

    /**
     * 历史订单详情
     * @param serviceOrder
     * @return
     */
    @PostMapping("/historyorderdetail")
    public Result historyOrderDetail(ServiceOrder serviceOrder,String token){
        try {
            logger.debug(serviceOrder.getServiceid().toString());
            try {
                if (serviceOrder.getId() == null)
                    throw new Exception(LxException.PARA_ERR);
                return Result.success(serviceOrderService.historyOrderDetail(serviceOrder));
            } catch (Exception e) {
                return MyUtils.handlerException(e);
            }
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }
    }

    /**
     *获取服务项目
     * @param categoryid
     * @return
     */
    @PostMapping("/getcategory")
    public Result getCategory( @RequestParam( value = "categoryid" )String categoryid) {
        try {
            logger.debug("cagoryid: " + categoryid);
            if (categoryid != null) {
                String[] strarr = categoryid.split(",");
                List <Integer> list = Lists.newArrayList();
                for (String s : strarr) {
                    System.out.print(s);
                    list.add(Integer.parseInt(s));
                }
                return Result.success(serviceOrderService.getCatoryName(list));
            }else{
                return null;
            }
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }

    }



}
