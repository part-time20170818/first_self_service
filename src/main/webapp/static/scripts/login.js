$(function(){
  $("#login").click(function(){
     $("#count_msg").html("");
     $("#password_msg").html("");
     var check=$("#check1").val().trim();
     var name = $("#count").val().trim();
  	 var password = $("#password").val().trim();
  	 var ok=true;
  	 if(name==""){
  	   ok=false;
  	   $("#count_msg").html("用户名为空");
  	 }
  	 if(password==""){
  	   ok=false;
  	   $("#password_msg").html("密码为空");
  	 }
  	 if(!ok){
  	   $("#check2_msg").click();
  	 }
  	 
  	 if(ok){
  	 $.ajax({
  	   url:"http://localhost:8088/note/user/login.do",
  	   type:"post",
  	   data:{"name":name,"password":password,"check":check},
  	   dataType:"json",
  	   success:function(result){
  	      if(result.status==3){
  	        $("#check1_msg").html(result.msg);
  	      }
  	      if(result.status==0){
  	        var userId=result.data;
  	        addCookie("userId",userId,2);
  	        window.location.href="edit.html";
  	      }else if(result.status==1){
  	        $("#count_msg").html(result.msg);
  	      }else if(result.status==2){
   	      	$("#password_msg").html(result.msg);
  	      }
  	   }
  	 });
  	 }
  });
});