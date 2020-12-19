// pages/index/index.js
Page({

  data: {
    contacts: []
  },


  //-------------------------------------------------//
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
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
        that.setData({
          msg: res.data.msg,
          code:res.data.code,
          //将接口返回的数据contacts赋值给contacts
          contacts: res.data.contacts
        })
      },
      fail: function (res) {
        console.log("fail=================")
      }
    })
  }

})