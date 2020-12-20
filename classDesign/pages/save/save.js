// pages/save/save.js
Page({

  save: function (event) {
    wx.request({
      url: 'http://localhost:8080/contacts/save',
      method: "POST",
      data: event.detail.value,
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        if (res.data.msg == "ok") {
          wx.showToast({
            title: '新增成功',
            icon: 'none',
            duration: 2000
          })
          wx.navigateBack({
            url: '../index/index',
          })
        }
      },
      fail: function (res) {
        if (res.data.msg != "ok") {
          wx.showToast({
            title: '新增失败',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  }
})