$(function(){
  var formData = new FormData();
  formData.append("name","1");
  formData.append("age","2");
  $.ajax({
      type: "post",
      url:"./submitForm",
      data:formData,
      processData: false,
      contentType: false,
      success: function (data){
          console.log(data);
      }
  })
})
