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
  });

    var dataArray1=[[

        {
            "status":"0"
        },
        {
            "status":"0"
        },
        {
            "status":"0"
        },
        {
            "status":"0"
        }],[

        {
            "prevStatus":"0",
            "status":"1"
        },
        {
            "prevStatus":"0",
            "status":"0"
        },
        {
            "prevStatus":"0",
            "status":"0"
        },
        {
            "prevStatus":"0",
            "status":"0"
        }],[

        {
            "prevStatus":"1",
            "status":"1"
        },
        {
            "prevStatus":"0",
            "status":"0"
        },
        {
            "prevStatus":"0",
            "status":"0"
        },
        {
            "prevStatus":"0",
            "status":"0"
        }],[

        {
            "prevStatus":"1",
            "status":"2"
        },
        {
            "prevStatus":"0",
            "status":"1"
        },
        {
            "prevStatus":"0",
            "status":"0"
        },
        {
            "prevStatus":"0",
            "status":"0"
        }],[

        {
            "prevStatus":"2",
            "status":"2"
        },
        {
            "prevStatus":"1",
            "status":"1"
        },
        {
            "prevStatus":"0",
            "status":"0"
        },
        {
            "prevStatus":"0",
            "status":"0"
        }],[

        {
            "prevStatus":"2",
            "status":"2"
        },
        {
            "prevStatus":"1",
            "status":"2"
        },
        {
            "prevStatus":"0",
            "status":"1"
        },
        {
            "prevStatus":"0",
            "status":"0"
        }]
        ,[

            {
                "prevStatus":"2",
                "status":"2"
            },
            {
                "prevStatus":"2",
                "status":"2"
            },
            {
                "prevStatus":"1",
                "status":"2"
            },
            {
                "prevStatus":"0",
                "status":"1"
            }]
        ,[

            {
                "prevStatus":"2",
                "status":"2"
            },
            {
                "prevStatus":"2",
                "status":"2"
            },
            {
                "prevStatus":"2",
                "status":"2"
            },
            {
                "prevStatus":"0",
                "status":"2"
            }]
    ];
    var timeArray=[];
    var time = 0;
  var deploy = function (){
     var dataArray2 = [
         [
             {
                 "status":"0"
             },
             {
                 "status":"0"
             },
             {
                 "status":"0"
             },
             {
                 "status":"0"
             }
         ],[{
             "prevStatus":"0",
             "status":"2"
         },
         {
             "prevStatus":"0",
             "status":"2"
         },
         {
             "prevStatus":"0",
             "status":"2"
         },
         {
             "prevStatus":"0",
             "status":"0"
         }],[{
             "prevStatus":"2",
             "status":"2"
         },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"0",
                 "status":"0"
             }],[{
             "prevStatus":"2",
             "status":"2"
         },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"0",
                 "status":"0"
             }],[{
             "prevStatus":"2",
             "status":"2"
         },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"0",
                 "status":"1"
             }],[{
             "prevStatus":"2",
             "status":"2"
         },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"2",
                 "status":"2"
             },
             {
                 "prevStatus":"1",
                 "status":"2"
             }]
     ]

      for(var k=0;k<dataArray2.length;k++){
          var dataArray = dataArray2[k];
          // 用于判断首次进入
          var prevStatus = null;
          // 状态为2的索引
          var twoCurrentIndex = null;
          // 状态为3的索引
          var threeCurrentIndex = null;
          // 上一次状态2的索引
          var twoPrevIndex = null;


          for(var i=0;i<dataArray.length;i++){
              prevStatus = dataArray[i].prevStatus;
              if(dataArray[i].status === "3"){
                  threeCurrentIndex = i;
              }
              if(dataArray[i].status === "2"){
                  twoCurrentIndex = i;
              }
              if(dataArray[i].prevStatus === "2"){
                  twoPrevIndex = i;
              }

          }
          if(prevStatus== null || prevStatus == undefined){
              // 第一次进入，开启定时器
              time +=1;
              continue;
          }

          if (threeCurrentIndex != null || (twoCurrentIndex != null && twoCurrentIndex == (dataArray.length - 1))) {
              /**
               * 结束：
               *    1.停止定时器
               *    2.计算时间
               */
              var stopIndex = threeCurrentIndex != null ? threeCurrentIndex : twoCurrentIndex;
              timeArray[timeArray.length] = time;
              for (var i = timeArray.length; i <=stopIndex; i++) {
                  timeArray[i] = 1;
              }
              console.log(timeArray);
              continue;
          }

          if (twoCurrentIndex != null) {
              if (twoPrevIndex != null && twoPrevIndex == twoCurrentIndex) {

                  // ，啥也不干
                  time += 1;
                  continue;
              }
              // 1.清除定时器

              // 2.记录时间
              if (timeArray[twoCurrentIndex] ==undefined) {
                  timeArray[timeArray.length] = time;
              }
              for (var i = timeArray.length; i <= twoCurrentIndex; i++) {
                  timeArray[i] = 1;
              }
              // 3.开启定时器
              time = 1;

          }
          console.log(timeArray);




      }

    }

    deploy();
})
