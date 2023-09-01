console.log('list.js 실행');

// 작성버튼 누르면 실행되는 함수
function onWrite(){
	
	if(loginState == true){
		// - 로그인상태
		location.href = "write.jsp";
		
	}else{
		// - 비로그인상태
		alert('로그인이 필요합니다.');
		
	}
	
}

// 페이지 로드시 게시판출력함수 실행
printBoard();

// 게시판 출력 함수
function printBoard(){
	
	$.ajax( { 
       url : "/jspweb/BoardInfoController",
       data : "",         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       
      		let boardContent = document.querySelector('.boardContent');
			let html = ``;
      		
      		for(let i =0; i < r.length; i++){
				  html += 
				  `
				  	<tr>
				      <th scope="row" class="bno">${r[i].bno}</th>
				      <td class="bcname">${r[i].bcname}</td>
				      <td class="btitle">${r[i].btitle}</td>
				      <td class="mid">${r[i].mid}</td>
				      <td class="bdate">${r[i].bdate}</td>
				      <td class="bview">${r[i].bview}</td>
				    </tr>
				  `
			  }
			  boardContent.innerHTML = html;	
		},
       	error : e=>{console.log(e)}
     });
	
	
}























