function login(){
    $("#username_msg").html("");
    $("#password_msg").html("");
    $("#checknumber_msg").html("");
    var username = $("#username").val();
    var password = $("#password").val();
    var checknumber = $("#checknumber").val();
    var flag=true;
    if(username==""){
        flag=false;
        $("#username_msg").html("用户名为空");
    }
    if(password==""){
        flag=false;
        $("#password_msg").html("密码为空");
    }
    if(!flag){
        $("#checknumber_get").click();
    }
    if(flag){
        $.ajax({
            url:"../user/login",
            type:"post",
            data:{"userName":username,"passWord":password,"checkNumber":checknumber},
            dataType:"json",
            success:function(result){
                $("#checknumber_get").click();
                if (result.code==0003) {
                    $("#password_msg").html(result.msg);
                }else if (result.code==0005) {
                    $("#checknumber_msg").html(result.msg);
                }else if (result.code==0000) {
                    addCookie("userId",result.object,30);
                    window.location.href="index.html";
                }

            },
            error:function() {
                $("#checknumber_get").click();
            }
        });
    }

}