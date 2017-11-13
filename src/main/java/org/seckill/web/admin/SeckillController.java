package org.seckill.web.admin;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.dto.WebResult;
import org.seckill.entity.SecKill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillService secKillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<SecKill> list = secKillService.getSeckilList();
        model.addAttribute("list", list);
        // list.jsp+model = ModelAndView
        return "admin/list";//WEB-INF/JSP/list.jsp

    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        SecKill secKill = secKillService.getById(seckillId);
        if (secKill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", secKill);
        return "admin/detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public WebResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        WebResult<Exposer> result;
        try {
            Exposer exposer = secKillService.exportSeckillUrl(seckillId);
            result = new WebResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new WebResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public WebResult<SeckillExcution> excute(@PathVariable("seckillId") Long seckillId, @PathVariable("md5") String md5, @CookieValue(value = "userPhone", required = false) Long phone) {
        if (phone == null) {
            return new WebResult<SeckillExcution>(false, "未注册");
        }
        WebResult<SeckillExcution> result;
        try {
            SeckillExcution excution = secKillService.executeSeckill(seckillId, phone, md5);
            return new WebResult<SeckillExcution>(true, excution);
        } catch (RepeatKillException e1) {

            SeckillExcution execution = new SeckillExcution(seckillId, SeckillStatEnum.REPEAT_KILL);

            return new WebResult<SeckillExcution>(true, execution);

        } catch (SeckillCloseException e2) {

            SeckillExcution execution = new SeckillExcution(seckillId, SeckillStatEnum.END);

            return new WebResult<SeckillExcution>(true, execution);

        } catch (Exception e) {

            SeckillExcution execution = new SeckillExcution(seckillId, SeckillStatEnum.INNER_ERROR);

            return new WebResult<SeckillExcution>(true, execution);

        }
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public WebResult<Long> time() {
        Date now = new Date();
        return new WebResult<Long>(true, now.getTime());
    }
}
