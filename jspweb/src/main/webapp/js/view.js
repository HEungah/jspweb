console.log('view.js 실행');

printView();

// 선택한 게시물 출력
function printView(){
	
	let bno = sessionStorage.getItem("bno");
	
	$.ajax( { 
       url : "/jspweb/BoardInfoController",
       data : {type : "pBoard", bno: bno},         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       		
       		let viewBox = document.querySelector('.viewBox');
       		let html = ``;
       		
       		html = 
       		`
				<div class="viewTitle">
					${r.btitle}
				</div>
				<div class="viewContent">
					${r.bcontent}
				</div>
       		`
       		let mno = sessionStorage.getItem("loginMno");
       		console.log(mno);
       		if(r.mno == mno){
				   html += `
					<button onclick="updateBoard(${r.bno})" type="button">수정</button>
					<button onclick="deleteBoard(${r.bno})" type="button">삭제</button>
				`
			}
				
       		viewBox.innerHTML = html;
       		
		},
       	error : e=>{console.log(e)}
     });
	
}

// 게시물 삭제함수
function deleteBoard(bno){console.log('삭제기능 실행')

	let dconfirm = confirm('정말 삭제하시겠습니까?');
	
	if(dconfirm == true){
		
		$.ajax( { 
	       url : "/jspweb/BoardInfoController",
	       data : {bno: bno},         // 보내는 데이터
	       method : "delete",
	       success : r =>{console.log('통신성공')
	       		
	       		if(r){
					   alert('삭제성공');
					   location.href = "/jspweb/board/list.jsp";
				}else{
					alert('삭제실패')
				}
	       		
			},
	       	error : e=>{console.log(e)}
	     });
     }
}

// 게시물 수정함수
function updateBoard(bno){ console.log('수정함수 실행');
	
	sessionStorage.setItem("bno", bno);
	
	location.href = "/jspweb/board/update.jsp";
	
}



























