
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