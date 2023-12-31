function submitForm(){
    
    var u_id = $("#u_id").val();
    var u_pw = $("#u_pw").val();
    var re_pw = $("#re_pw").val();
    var u_name = $("#u_name").val();
    var age = $("#u_age").val();
    var u_gender = $("input[name='u_gender']:checked").val();

    if(u_id === "" || u_pw === ""){
        alert("아이디와 비밀번호를 모두 입력해주십시오.");
        return;
    }
    if(u_pw !== re_pw){
        alert("비밀번호가 일치하지 않습니다. 다시 입력해주십시오.");
        return;
    }
    var birthDate = new Date(age);
    var currentDate = new Date();
    var u_age = currentDate.getFullYear() - birthDate.getFullYear();

    if (currentDate.getMonth() < birthDate.getMonth() ||  (currentDate.getMonth() === birthDate.getMonth() && currentDate.getDate() < birthDate.getDate())) {
    u_age--;
    }

    var formData = {
        u_id: u_id,
        u_pw: u_pw,
        u_name: u_name,
        u_age: u_age,
        u_gender: u_gender
    };
    console.log("id : " + formData.u_id);
    console.log("pw : " + formData.u_pw);
    console.log("name : " + formData.u_name);
    console.log("age : " + formData.u_age);
    console.log("gender : " + formData.u_gender);
    $.ajax({
        type: "POST",
        url: "/sm/member/regProc",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function(data){
            if(data.success){
            	console.log(data.success);
                alert("회원가입이 완료되었습니다.");
                window.location.href="/sm/";
            }else{
            	console.log(data.success);
                alert("회원가입에 실패하였습니다.")
            }
        },
        error: function(xhr, status, error){
            console.error("Error", error);
        }
    });
}