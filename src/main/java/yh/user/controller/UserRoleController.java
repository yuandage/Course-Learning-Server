package yh.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.user.entity.UserRole;
import yh.user.service.UserRoleService;

@RestController
@CrossOrigin
@RequestMapping("/userRole")
public class UserRoleController {
	@Autowired
	UserRoleService userRoleService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userRoleService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userRoleService.findById(id));
	}

	@RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
	public Result findUserRoles(@PathVariable String userId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userRoleService.getUserRoles(userId));
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result save(@RequestBody UserRole userRole) {
		userRoleService.save(userRole);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result update(@PathVariable String id, @RequestBody UserRole userRole) {
		userRoleService.update(userRole);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result deleteById(@PathVariable String id) {
		userRoleService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

	@RequestMapping(value = "/{userId}/{roleId}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result deleteByUserIdAndRoleId(@PathVariable String userId, @PathVariable String roleId) {
		userRoleService.deleteByUserIdAndRoleId(userId, roleId);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}
}
