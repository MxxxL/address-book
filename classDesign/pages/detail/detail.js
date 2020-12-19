// pages/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

    contacts:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    wx.request({
      url: 'http://localhost:8080/contacts/select?id='+options.id,
      method:"GET",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        that.setData({
          msg: res.data.msg,
          code:res.data.code,
          //将接口返回的数据contacts赋值给contacts
          contacts: res.data.contacts
        })
      },
      fail: function (res) {
        wx.showToast({
          title: '查看失败',
          icon: 'none',
          duration: 2000
        })
      }
    })
  }
})