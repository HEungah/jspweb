

// 1. N개 제품을 최신순으로 출력하는 함수
findByTop(10);	// 메인페이지 최신등록된 제품 출력
function findByTop(count){
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : {type : "findByTop", count : count},         // 보내는 데이터
       method : "get",
        success : jsonArray =>{ console.log(jsonArray);
        	let cardContent = document.querySelector('.cardContent');
        	let html = ``;
        	
        	jsonArray.forEach((p)=>{		
				// 대표 이미지 출력하기
				let firstImg = Object.values(p.imgList)[0];
				console.log(p.imgList);
				console.log(Object.values(p.imgList)[0]);
				
				html += 
				`
					<div class="col">
					    <div class="card">
					      <a href="/jspweb/product/view.jsp?pno=${p.pno}">
					      	<img src="/jspweb/product/img/${firstImg}" class="card-img-top cardimg">
					      </a>
					      	<div class="card-body">
					        	<h5 class="card-title">${p.pname}</h5>
					        	<p class="card-text">
					        		<div>${p.pname}</div>
					        		<div>${p.pprice}</div>
					        	</p>
				      		</div>
					    </div>
					 </div>
				`
			})	
        
        	cardContent.innerHTML = html;
			
		},
        error : e =>{}
     });

	
}
/*
	자바스크립트 객체
		형태 : let 객체명 = {키 : 데이터, 키 : 데이터, 키 : 데이터}
			객체명.새로운필드명 = 데이터
			delete 객체명.삭제할속성명	* 사용자정의 함수() 중에 delete 라는 이름으로 선언 불가능
			객체명.속성명		/		객체명[속성명]			---> 호출방법
				- Object.keys(객체명) : 객체내 모든 키를 배열로 반환
				
	자바스크립트 배열/리스트
		형태 : let 변수명 = [데이터, 데이터, 데이터]
		배열명.push(데이터)
		배열명.splice(인덱스, 개수)
		배열명[인덱스]
			
	
*/



// 2. 현재 카카오지도내 보고있는 동서남북 기준내 제품들을 출력하는 함수
function findByLatLng(east, west, south, north){
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : {type : 'findByLatLng', east : east, west : west,
       south : south, north: north},         // 보내는 데이터
       method : "get",
        success : jsonArray =>{console.log(jsonArray);
        
		},
        error : e =>{}
     });

	
}

function findByPno(pno){
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : {type: 'findByPno', pno: pno},         // 보내는 데이터
       method : "get",
        success : jsonObject =>{console.log(jsonObject);
			
		},
        error : e =>{}
     });

	
}

function findByAll(){
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : {type : 'findByAll'},         // 보내는 데이터
       method : "get",
        success : jsonArray =>{console.log(jsonArray);
			
		},
        error : e =>{}
     });

	
}






























