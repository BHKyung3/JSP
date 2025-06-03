function check() { // 체크사항
	if(document.frm.id.value == ""){
		alert("아이디를 입력해주세요.");
//		document -> 문서전체, frm.id -> 이름이 id, == "" -> 칸에 입력된 값이 0이면 alert -> ()안에 문구를 노출한다

		document.frm.id.focus();
//		id에 값이 입력되지 않았다면 문구 노출 후 등록할 곳에 커서를 가져다 놓는다는 의미

		return false;
//		true일 경우는 정상으로 오류 값이 뜨지 않음 / 페이지를 반환하지 않음

	} else if(document.frm.age.value == ""){
		alert("나이를 입력해주세요.");
		document.frm.age.focus();
		return false; 
	} else if(isNaN(document.frm.age.value)){
//		isNaN => 숫자가 아니면
		alert("숫자로 입력해주세요.");
		document.frm.age.focus();
		return false;
	} else {
		return true;
	}
		
}