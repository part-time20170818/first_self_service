   $(function(){
      $("#regist_button").click(function(){
         $("#regist_username_msg1").html("");
         $("#nickname_msg1").html("");
         $("#regist_password_msg").html("");
      
      
       var name=$("#regist_username").val().trim();
       var pwd=$("#regist_password").val().trim();
       var password=$("#final_password").val().trim();
       var desc=$("#nickname").val().trim();  
       var tag=true;
       if(name==""){
         tag=false;
         $("#regist_username_msg1").html("用户名为空"); 
       }
       if(desc==""){
         tag=false;
         $("#nickname_msg1").html("昵称为空");
       }
       if(pwd==""){
         tag=false;
         $("#regist_password_msg").html("密码为空");
       }
       if(pwd.length<6){
          tag=false;
       }
       if(pwd!=password){
         tag=false;               
       } 
       
       
       
    if(tag){   
      $.ajax({
       url:"http://localhost:8088/note/user/register.do",
       type:"post",
       data:{"name":name,"password":password,"desc":desc},
       dataType:"json",
       success:function(result){
       
       
         if(result.status==0){
         alert("注册成功!");
         window.location.href="log_in.html";
         }else{
           $("#regist_username_msg2").html(result.msg);
         }
       
       
       }
      });
      }
      
     });
   });