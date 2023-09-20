console.log('header.js 실행');

// 1. 현재 로그인된 회원정보 요청
let loginState = false;		// 로그인 스위치
let loginMId = ' ';	// 로그인 성공된 아이디를 가지고 있는 변수
let loginMno = ' ';	// 로그인 성공된 회원번호를 가지고 있는 변수

getMembertInfo();

function getMembertInfo(){
	
	// 1. ajax 이용한 서블릿세션 정보 가져오기
	$.ajax( { 
       url : "/jspweb/MemberInfoController",
       data : {type : "info"},         // 보내는 데이터
       method : "get",
       async :	false,		/*동기화, 비동기화(기본값[ true ]) 설정하는 속성*/
        success : r =>{
        
        	let submenu = document.querySelector('.submenu')
        	let html = ``;
        
        	if(r == null){	// 비로그인 상태
        		loginState = false;	loginMId = ' ';
				html += 
				`
					<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
					<li><a href="/jspweb/member/login.jsp">로그인</a></li>
				`
			}else{	// 로그인상태
				loginState = true;	loginMId = r.mid; loginMno = r.mno;
				console.log(loginState)
				sessionStorage.setItem("loginMno", r.mno);
				if(r.mid == "admin"){/*관리자로그인상태*/}
				
				html +=
				`
					<li><img class="hmimg" src="/jspweb/member/img/${r.mimg}"/></li>
					<li> ${r.mid}님</li>
					<li><a href="/jspweb/member/info.jsp">마이페이지</a></li>
					<li><a href="/jspweb/product/wishlist.jsp">찜목록</a></li>
					<li><a onclick="logout()" href="#">로그아웃</a></li>
				`
			}
			submenu.innerHTML = html;	
		},
        error : e =>{console.log(e)}
    });
	
	
}// f end

// 로그아웃 함수[ 서블렛의 세션을 삭제, 로그아웃 성공시 메인페이지로 이동]
function logout(){
	
	$.ajax( { 
       url : "/jspweb/MemberInfoController",
       data : {type : "logout"},         // 보내는 데이터
       method : "get",
        success : r =>{
			sessionStorage.setItem("loginMno", 0);
			location.href = "/jspweb/index.jsp"
        },
        error : e =>{console.log(e)}
     });
	
}	// f end

function returnList(){
	location.href = "/jspweb/board/list.jsp";
}






























