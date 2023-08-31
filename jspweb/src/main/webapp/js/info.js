console.log('info.js 실행');

// 1. 로그인된 회원의 정보 호출
getInfo();
function getInfo(){
	
	$.ajax( { 
       url : "/jspweb/MemberInfoController",
       data : {type : "info"},         // 보내는 데이터
       method : "get",
        success : r =>{
			
			if(r == null){	// 비로그인
				alert('로그인후 사용가능한 페이지입니다.');
				location.href = "/jspweb/member/login.jsp";
			}else{	// 로그인 상태 -> 마이페이지 구역에 정보 넣어주기
				document.querySelector('.preprofile').src= `img/${r.mimg}`
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.memail').innerHTML = r.memail;
			}
		},
        error : r =>{console.log(r)}
     });
	
} // f end


// 2. 수정
function mupdate(){
	
	let signupForm = document.querySelectorAll(".signupForm")[0];
	console.log(signupForm);
	let formdata = new FormData(signupForm);
	
	$.ajax( { 
       url : "/jspweb/MemberInfoController",
       data : formdata,
       method : "put",
       /*
       		폼 전송타입 : 문자(x), json(x), 첨부파일(o)
       		
       		HTTP 전송타입
       				1. text/html					: 문자타입 [기본값]
       				2. application/json		: json타입
       				3. multipart/form-data	: 대용량 form 전송 타입
       */
       
       contentType : false,		
       processData : false,
        success : r =>{console.log('통신성공')
        	if(r){
				alert('수정완료');
				logout();
			}else{alert('수정실패 비밀번호를 확인해주세요.')}
		},
		 error : e=>{console.log(e)}
     });
     		
	
} 


// 3. 탈퇴
function mdelete(){
	
	// 1. 탈퇴 여부 확인 
	let dconfirm =  confirm('정말 탈퇴하시겠습니까?');
	
	// 2. 확인 버튼을 눌렀을때
	if(dconfirm == true){
		let mpwd = prompt('비밀번호확인');
		// 3. 탈퇴기능 [ 패스워드 전송해서 로그인 회원번호와 입력받은 패스워드가 일치하면 탈퇴]
		$.ajax( { 
       		url : "/jspweb/MemberInfoController",
       		data : {mpwd : mpwd},         // 보내는 데이터
       		method : "delete",
        	success : r =>{
				if(r){
					alert('회원탈퇴가 완료되었습니다.');
					logout();
				}else{
					alert('회원탈퇴에 실패하였습니다 비밀번호를 확인해주세요.')
				}
			},
         	error : r =>{}
     	});	// delete ajax end
	}
} // f end


















