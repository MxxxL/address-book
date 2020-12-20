// pages/index/index.js
Page({

  data: {
    contacts: []
  },

  select: function (event) {
    let value = event.currentTarget.dataset.value
    wx.navigateTo({
      url: '../detail/detail?id=' + value
    })
  },
  save: function () {
    wx.navigateTo({
      url: '../save/save'
    })
  },
  edit: function (event) {
    let value = event.currentTarget.dataset.value
    wx.navigateTo({
      url: '../edit/edit?id=' + value
    })
  },
  delete: function (event) {
    let value = event.currentTarget.dataset.value
    wx.request({
      url: 'http://localhost:8080/contacts/delete?id=' + value,
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'get',
      success: function (res) {
        if (res.data.msg == "ok") {
          wx.showToast({
            title: '删除信息成功！',
            icon: 'none',
            duration: 2000,
          })
          this.onLoad()
        }
      },
      fail: function (res) {
        if (res.data.msg != "ok") {
          wx.showToast({
            title: '删除取信息失败！',
            icon: 'none',
            duration: 2000,
          })
        }
      }
    })
  },

  logout:function(){
    wx.removeStorage({
      key: 'loginUser',
      success (res) {
        wx.navigateBack({
          delta: 10,
        })
      }
    })
  },
  //-------------------------------------------------//
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    try {
      var value = wx.getStorageSync('loginUser')
      if (!value) {
        wx.navigateBack({
          delta: 10,
        })
      }
    } catch (e) {
      // Do something when catch error
    }
    var that = this
    wx.request({
      //请求数据接口
      url: 'http://localhost:8080/contacts/list',
      data: {},
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'get',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        if (res.data.code == 200) {
          that.setData({
            msg: res.data.msg,
            code: res.data.code,
            //将接口返回的数据contacts赋值给contacts
            contacts: res.data.contacts
          })
        }
      },
      fail: function (res) {
        if (res.data.code != 200) {
          wx.showToast({
            title: '获取信息失败！',
            icon: 'none',
            duration: 2000,
          })
        }

      }
    })
  }

})