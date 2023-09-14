function submitComment(){
 	
 	var b_category = $("#b_category").val();
    var b_id = $("#u_id").val();
    var b_reply_ori = $("#b_ori_id").val();
    var b_text = $("#comment").val();
	var url = "/sm/board/read?category=" + b_category + "&no=" + b_reply_ori;
	if(b_id === ""){
		alert("로그인 후 이용해주십시오.");
		return;
	}
	
	if(b_text === ""){
		alert("내용을 입력해주십시오.");
		return;
	}

    var formData = {
    	b_category: b_category,
        b_id: b_id,
        b_reply_ori: b_reply_ori,
        b_text: b_text
    };
    
    console.log("category : " + formData.b_category);
    console.log("writer : " + formData.b_id);
    console.log("reply_ori : " + formData.b_reply_ori);
    console.log("b_text : " + formData.b_text);
    $.ajax({
        type: "POST",
        url: "/sm/board/commentProc",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function(data){
            if(data.success){
            	console.log(data.success);
                alert("댓글 작성이 완료되었습니다.");
                window.location.href= url;
            }else{
            	console.log(data.success);
                alert("댓글 작성이 실패하였습니다.")
            }
        },
        error: function(xhr, status, error){
            console.error("Error", error);
        }
    });
}