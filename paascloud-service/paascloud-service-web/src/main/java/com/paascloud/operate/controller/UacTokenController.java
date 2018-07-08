/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacTokenMainController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.paascloud.operate.controller;

import com.paascloud.core.support.BaseController;
import com.paascloud.provider.model.dto.token.TokenMainQueryDto;
import com.paascloud.provider.model.service.UacTokenFeignApi;
import com.paascloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * token主页面.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@RequestMapping(value = "/web/token", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacTokenMainController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacTokenController extends BaseController{


	@Resource
	private UacTokenFeignApi uacTokenFeignApi;


	@PostMapping(value = "/updateTokenOffLine")
	@ApiOperation(httpMethod = "POST", value = "更新在线用户")
	public Wrapper updateTokenOffLine() {
		return uacTokenFeignApi.updateTokenOffLine();
	}


	/**
	 * 分页查询角色信息.
	 *
	 * @param token the token
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/queryListWithPage")
	@ApiOperation(httpMethod = "POST", value = "查询在线用户列表")
	public Wrapper queryUacActionListWithPage(@ApiParam(name = "token") @RequestBody TokenMainQueryDto token) {
		logger.info("查询在线用户列表. token={}", token);
		return uacTokenFeignApi.queryUacActionListWithPage(token);
	}

}