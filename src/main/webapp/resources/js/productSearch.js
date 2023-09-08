function submitForm(){
    
    var p_name = $("#word").val();

    $.ajax({
        type: "POST",
        url: "/sm/shop/p_search",
        data: JSON.stringify(p_name),
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