console.log('update.js 실행');

// 수정할 게시물 정보 보여주기
getBoard();
function getBoard(){
	
	// 쿼리스트링 가져오기
	let bno = new URL(location.href).searchParams.get("bno");
	
	// ajax에게 bno 전달해서 게시물정보 가져오기
	$.ajax( { 
       url : "/jspweb/BoardInfoController",
       data : {type : "pBoard", bno: bno},         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       		document.querySelector('.newbcno').value = `${r.bcno}`
       		document.querySelector('.newbtitle').value = `${r.btitle}`
       		document.querySelector('.newbcontent').value = `${r.bcontent}`
       		document.querySelector('.newbfile').value = `${r.bfile}`
       },
       error : e => {}
     });
	
	
}


// 수정버튼 눌렀을때 실행되는 함수(게시물 수정)
function bupdate(){console.log('수정함수 실행');

	let updateForm = document.querySelectorAll('.updateForm')[0]
	
	let formData = new FormData(updateForm);
	
	let urlParams = new URL(location.href).searchParams
		console.log(urlParams)
	
	let bno = urlParams.get("bno");	// url상의 bno 데이터 가져오기
	
	formData.append('bno', bno);
	console.log(formData)
	
	$.ajax( { 
		       url : "/jspweb/BoardInfoController",
		       data : formData,         // FormData 객체를 전송
		       contentType : false,
		       processData : false,
		       method : "put",		// 첨부파일 form 전송은 post 방식
		       success : r =>{console.log('통신성공')
					if(r){
						alert('수정성공');
						location.href = `/jspweb/board/list.jsp`
					}else{
						alert('수정실패')
					}
				},
       			 error : e=>{console.log(e)}
     });

	
	
}






















