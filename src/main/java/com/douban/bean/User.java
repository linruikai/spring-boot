package com.douban.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户信息")
public class User extends BaseBean{
  @ApiModelProperty("用户ID")
  private Integer id;
  @ApiModelProperty("用户姓名")
  private String name;
  @ApiModelProperty("用户密码")
  private String password;
  @ApiModelProperty("性别 1 男  2 女")
  private Integer gender;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

}
