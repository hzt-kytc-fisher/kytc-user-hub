package com.kytc.user.hub.server.controller;

import com.alibaba.fastjson.JSON;
import com.kytc.user.api.UserInfoApi;
import com.kytc.user.request.UserInfoRequest;
import com.kytc.user.request.UserInfoSearchRequest;
import com.kytc.user.response.UserInfoResponse;

import com.kytc.framework.web.common.BasePageResponse;
import com.kytc.framework.web.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@RestController
@Slf4j
@Api(tags = "用户基本信息hub 操作")
@RequestMapping("/hub/user")
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class UserInfoController {
	private final UserInfoApi userInfoApi;

	@ApiOperation("查询用户基本信息列表")
	@PostMapping("/list")
	public BaseResponse<BasePageResponse<UserInfoResponse>> listByCondition(
		@RequestBody @Valid UserInfoSearchRequest request){
		log.info("查询用户信息request:{}", JSON.toJSONString(request));
		return BaseResponse.success(this.userInfoApi.listByCondition(request));
	}

	@ApiOperation("添加用户基本信息数据")
	@PostMapping("/info")
	public BaseResponse<Long> add(@RequestBody @Valid UserInfoRequest request){
		return BaseResponse.success(this.userInfoApi.add(request));
	}

	@ApiOperation("修改用户基本信息数据")
	@PutMapping("/info")
	public BaseResponse<Boolean> update(@RequestBody @Valid UserInfoRequest request){
		return BaseResponse.success(this.userInfoApi.update(request));
	}

	@ApiOperation("登录")
	@GetMapping("/login")
	public BaseResponse<UserInfoResponse> login(@RequestParam("userName")String userName,
									   			@RequestParam("userPwd")String userPwd){
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		userInfoResponse.setUsername(userName);
		userInfoResponse.setNickName("测试");
		return BaseResponse.success(userInfoResponse);
	}

	@ApiOperation("删除用户基本信息数据")
	@DeleteMapping("/{id}")
	public BaseResponse<Boolean> delete(@PathVariable("id")Long id){
		return BaseResponse.success(this.userInfoApi.delete(id));
	}

	@ApiOperation("查询用户基本信息详情")
	@GetMapping("/{id}")
	public BaseResponse<UserInfoResponse> detail(@PathVariable("id")Long id){
		return BaseResponse.success(this.userInfoApi.detail(id));
	}
}
