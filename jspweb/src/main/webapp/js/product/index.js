

// 1. N개 제품을 최신순으로 출력하는 함수
function findByTop(count){
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : {type : "findByTop", count : count},         // 보내는 데이터
       method : "get",
        success : jsonArray =>{ console.log(jsonArray);
			
		},
        error : e =>{}
     });

	
}

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






























