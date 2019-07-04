package com.yxy.springboot.exception;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: UserNotExistException
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @date: 2019年07月04日 15:01
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
