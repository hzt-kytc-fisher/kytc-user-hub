/*
 * Copyright 2020 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.kytc.user.hub.server.remote;

import com.kytc.user.api.UserInfoApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: 何志同
 * @Date: 2020/10/2 11:36
 * @Description:
 **/
@FeignClient("kytc-user")
public interface UserInfoFeign extends UserInfoApi {
}