
// 회원가입/로그인 화면에서 유효성 검사와 아이디 중복체크를 담당하는 스크립트

function loginCheck() { // 로그인 유효성 검사
	if(document.frm.userid.value.length == 0) {
		alert("아이디를 입력해주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value == "") {
			alert("암호를 입력해주세요");
			frm.pwd.focus();
			return false;
		}
	return true;
}

// 아이디 중복 체크(아이디 중복 체크 버튼 클릭 시 실행)
function idCheck() { 
	
	if(document.frm.userid.value == ""){
		alert("아이디를 입력하여 주세요.");
		document.frm.userid.focus();
		return false;
	}
	
	let url = "idCheck.do?userid=" + document.frm.userid.value;
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}
//  중복 체크 팝업창에서 "사용" 버튼 누를 때 실행
function idok() {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

// 회원가입 유효성 검사
function joinCheck() {
	if(document.frm.name.value.length=0){
		alert("이름을 써주세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length=0){
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.reid.value.length=0){
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	
	return true;
}