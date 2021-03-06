package yh;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import yh.common.Result;
import yh.common.StatusCode;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
		e.printStackTrace();//追踪错误信息
		if ("用户名不存在!".equals(e.getMessage()))
			return new Result(false, StatusCode.LOGIN_ERROR, "用户名不存在!", e.getMessage());
		return new Result(false, StatusCode.ERROR, "发生了错误!", e.getMessage());
	}

	@ExceptionHandler(AccessDeniedException.class)
	public Result handleAccessException(AccessDeniedException e) {
		return new Result(false, StatusCode.ACCESS_ERROR, "权限不足!", e.getMessage());
	}

	@ExceptionHandler(BadCredentialsException.class)
	public Result handleBadCredentialsException(BadCredentialsException e) {
		return new Result(false, StatusCode.LOGIN_ERROR, "密码错误!", e.getMessage());
	}

}
