// pages/login/login.js
Page({
  data: {
    username: '',
    password: ''
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
  login: function () {
    const that = this
    if (this.data.username.length == 0 || this.data.password.length == 0) {
      wx.showToast({
        title: '账号或密码不能为空',
        icon: 'none',
        duration: 2000
      })
    } else {
      console.log("登录获取的参数：" + this.data.username + "," + this.data.password)
      wx.request({
        url: 'http://localhost:8080/user/login',
        method: 'post',
        data: {
          username: that.data.username,
          password: that.data.password
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success(res) {
          if (res.data.code == 200) {
            wx.setStorage({
              key:"loginUser",
              data:{
                username: that.data.username,
                password: that.data.password
              },
            })
            wx.showToast({
              title: '登录成功',
              icon: 'success',
              duration: 2000,
              success: function () {
                wx.navigateTo({
                  url: '../index/index',
                })
              }
            })
          }
        },
        fail(res) {
          if (res.data.code != 200) {
            wx.removeStorage({
              key: 'loginUser',
            })
            wx.showToast({
              title: '登录失败',
              icon: 'none',
              duration: 2000,
            })
          }
        }
      })
    }
  },
  register: function () {
    wx.navigateTo({
      url: '../register/register'
    })
  },

  //-------------------------------------------------//
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    try {
      var value = wx.getStorageSync('loginUser')
      if (value) {
        // Do something with return value
        wx.request({
          url: 'http://localhost:8080/user/login',
          method: 'post',
          data: value,
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          success(res) {
            if (res.data.code == 200) {
              wx.navigateTo({
                url: '../index/index',
              })
            }
          },
          fail(res) {
            if (res.data.code != 200) {
              wx.removeStorage({
                key: 'loginUser',
              })
            }
          }
        })
      }
    } catch (e) {
      // Do something when catch error
    }
  }
})