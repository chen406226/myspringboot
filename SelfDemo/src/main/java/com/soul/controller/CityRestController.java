package com.soul.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soul.domain.City;
import com.soul.enums.EnumResponse;
import com.soul.server.CityService;
import com.soul.service.impl.CityServiceImpl;
import com.soul.service.impl.MailServiceImpl;

@RestController
public class CityRestController {
	@Autowired
	private CityService cityService;
	
	@Autowired 
	private MailServiceImpl mailservicelmpl;
	
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public BaseResponse findOneCity(@PathVariable("id") Long id) {
    	Map obj = new HashMap<>();
    	obj.put("city", cityService.findCityById(id));
        BaseResponse baseResponse = new BaseResponse<>(true,EnumResponse.SUCCESS.getMsg(),obj);
    	return baseResponse;
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public BaseResponse findAllCity() {
    	Map<String,List<City>> object = new HashMap<>();
    	object.put("list", cityService.findAllCity());
    	BaseResponse baseResponse = new BaseResponse(true,EnumResponse.SUCCESS.getMsg(),object);
        return baseResponse;
    }
    //此借口可以测试过滤器
    @RequestMapping("/api/cite")
    public List<City> findAllCity1() {
        return cityService.findAllCity();
    }
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public Long modifyCity(@RequestBody City city) {
        return cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
    @RequestMapping("/sendemail")
    public void sendemail() {
    	mailservicelmpl.sendSimpleMail("1319785768@qq.com","测试标题","测试内容");
    }
    @RequestMapping("/sendemailhtml")
    public void sendHtmlMail() {
    	mailservicelmpl.sendHtmlMail("1319785768@qq.com","测试标题","测试内容");
    }
    @RequestMapping("/sendemailfile")
    public void sendAttachmentsMail() {
    	mailservicelmpl.sendAttachmentsMail("1319785768@qq.com","测试标题","测试内容","/home/chenkun/studus/javastudus/vhr/README.md");
    }
}
