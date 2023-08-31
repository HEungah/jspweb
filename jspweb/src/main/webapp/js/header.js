console.log('header.js 실행');

// 1. 현재 로그인된 회원정보 요청
getMembertInfo();

function getMembertInfo(){
	
	// 1. ajax 이용한 서블릿세션 정보 가져오기
	$.ajax( { 
       url : "/jspweb/MemberInfoController",
       data : {type : "info"},         // 보내는 데이터
       method : "get",
        success : r =>{console.log(r)
        
        	let submenu = document.querySelector('.submenu')
        	let html = ``;
        
        	if(r == null){	// 비로그인 상태
				html += 
				`
					<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
					<li><a href="/jspweb/member/login.jsp">로그인</a></li>
				`
			}else{	// 로그인상태
				if(r.mid == "admin"){/*관리자로그인상태*/}
				
				html +=
				`
					<li><img class="hmimg" src="/jspweb/member/img/${r.mimg}"/></li>
					<li> ${r.mid}님</li>
					<li><a href="/jspweb/member/info.jsp">마이페이지</a></li>
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
			location.href = "/jspweb/index.jsp"
        },
        error : e =>{console.log(e)}
     });
	
}	// f end






























