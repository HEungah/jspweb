
// 게시판 상세페이지, 제품상세페이지 등등에서는 클릭된  제품번호[식별자]
// URL(인터넷주소)에서 매개변수(쿼리스트링) 가져오기
let pno = new URL(location.href).searchParams.get("pno");


// 1. pno에 해당하는 제품 1개 호출
findByPno(pno);
function findByPno(pno){
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : {type: 'findByPno', pno: pno},         // 보내는 데이터
       method : "get",
        success : jsonObject =>{console.log(jsonObject);
			
			// 캐러셀에 이미지 여러개 대입
			let imgbox = document.querySelector('.imgbox');
			let html = ``;
			
			Object.values( jsonObject.imgList ).forEach((img,i)=>{
				// 첫번째 이미지에만 active 클래스 삽입
				html += 
				`
				    <div class="carousel-item ${i == 0 ? 'active' : ''}">
				    	<img src="/jspweb/product/img/${img}" class="d-block w-100">
				    </div>
				`
				
			})
			
			imgbox.innerHTML = html;
			
			
			// ------------ 각 위치에 데이터 넣어주기
			document.querySelector('.mid').innerHTML = `판매자 : ${jsonObject.mid}`;
			document.querySelector('.pcname').innerHTML = `카테고리 : ${jsonObject.pcname}`;
			document.querySelector('.pdate').innerHTML = `등록일 : ${jsonObject.pdate}`;
			document.querySelector('.pname').innerHTML = `${jsonObject.pname}`;
			document.querySelector('.pprice').innerHTML = `${jsonObject.pprice} 원`;
			document.querySelector('.pcontent').innerHTML = `${jsonObject.pcontent}`;
			
			
		},
        error : e =>{}
     });

	
}



























