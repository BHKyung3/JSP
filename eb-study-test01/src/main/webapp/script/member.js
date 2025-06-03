/**
 	유효성 체크를 위한 자바 스크립트 파일
	자바스크립트에서는 함스를 여러 jsp에서 공통적으로 사용되는 내용을 포함하기 때문에 하나의
	스크립트 파일로 분리해 놓고 이를 필요로 하는 jsp 파일에서 포함하여 사용한다
 */
function loginCheck() { // 로그인 유효성 검사
	if(document.frm.id.value.length == 0) {
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	if(document.frm.pass.value == "") {
		alert("암호를 입력해주세요");
		frm.pass.focus();
		return false;
	}
	if(document.frm.lev.value.length == ""){
		alert("권한 여부를 확인해주세요");
		frm.lev.focus();
		return false;
	}
	return true;
}