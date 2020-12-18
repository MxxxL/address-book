// pages/register/register.js
Page({
  data: {
    username: '',
    password: '',
    rpassword:''
  },
  usernameInput: function (e) {
    this.setData({
      username: e.detail.value
    })
  },
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },
  rpasswordInput: function (e) {
    this.setData({
      rpassword: e.detail.value
    })
  },
  register: function () {
    if (this.data.username.length == 0 || this.data.password.length == 0) {
      wx.showToast({
        title: '账号或密码不能为空',
        icon: 'none',
        duration: 2000
      })
    }else if(this.data.password!=this.data.rpassword){
        wx.showToast({
          title: '密码与确认密码不一致',
          icon:'none',
          duration:2000
        })
    } else {
      console.log("注册获取的参数：" + this.data.username + "," + this.data.password)
      wx.request({
        url: 'http://localhost:8080/user/register',
        method: 'post',
        data: {
          username: this.data.username,
          password: this.data.password
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success(res) {
          console.log("回调函数:" + res.data)
          var resData = res.data;
          if (resData == true) {
            wx.showToast({ 
              title: '注册成功',
              icon: 'success',
              duration: 2000,
              success: function () {
                wx.navigateTo({
                  url: '../login/login',
                })
              }
            })
          } else {
            wx.showToast({
              title: '注册失败',
              icon: 'none',
              duration: 2000,
            })
          }
        }
      })
    }
  }

})