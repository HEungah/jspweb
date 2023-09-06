console.log('view.js 실행');

printView();

// 선택한 게시물 출력
function printView(){console.log('printVeiw 함수 실행')
	//	URL에 있는 매개변수(쿼리스트링) 가져오기
		// 1. 현재 주소(url)상 매개변수 가져오기
	let urlParams = new URL(location.href).searchParams
		console.log(urlParams)
	
	let bno = urlParams.get("bno");	// url상의 bno 데이터 가져오기
	
	// 2. AJAX 이용한 bno 전달해서 게시물의 상세 정보 모두 가져오기
	$.ajax( { 
       url : "/jspweb/BoardInfoController",
       data : {type : "2", bno: bno},         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       		
       		let viewBox = document.querySelector('.viewBox');
       		let html = ``;
       		
       		if(r.bfile == null){
				  
			   }
       		html += 
       		`	<table class="table">
					<thead>
						<tr class="table-active">
							<th scope="col" style="width: 60%"><h3>${r.btitle}</h3><br>
								<img class="mimg img-fluid" alt="" src="/jspweb/member/img/${r.mimg}">${r.mid}</th>
							<th scope="col" style="width: 40%" class="text-right tdate">${r.bdate}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><h6>${r.bcname}</h6></td><td></td>
						</tr>
						<tr>
							<td><pre>${r.bcontent}</pre></td><td></td>
						</tr>
						<tr>`
						if(r.bfile == null){
				  			html += `<td>첨부파일없음</td>`
			   			}else{
							html +=
							`
							<td>첨부파일 <a href="/jspweb/FileDownLoad?filename=${r.bfile}">${r.bfile}</a></td>
							`
			html +=				
							`
						</tr>
					</tbody>
				</table>

       		`
       		}
       		
       		let mno = sessionStorage.getItem("loginMno");
       		console.log(mno);
       		if(r.ishost){
				   html += `
					<button class="btn btn-outline-info" onclick="updateBoard(${r.bno})" type="button">수정</button>
					<button class="btn btn-outline-info" onclick="deleteBoard(${r.bno})" type="button">삭제</button>
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
	
	location.href = `/jspweb/board/update.jsp?bno=${bno}`;
	
}



























