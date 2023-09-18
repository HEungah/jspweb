console.log('지도 출력페이지');


var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 14 // 지도의 확대 레벨
    });


var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});


$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : {type : 'findByAll'},         // 보내는 데이터
       method : "get",
        success : jsonArray =>{console.log(jsonArray);	
			
			var markers = jsonArray.map((p)=> {
				console.log(p.plat + ' ' + p.plng)
		        return new kakao.maps.Marker({
		            position : new kakao.maps.LatLng(p.plat, p.plng)
		        });
		    });
		    // 클러스터러에 마커들을 추가합니다
		    clusterer.addMarkers(markers);
		},
        error : e =>{}
     });

kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

    // 현재 지도 레벨에서 1레벨 확대한 레벨
    var level = map.getLevel()-1;

    // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
    map.setLevel(level, {anchor: cluster.getCenter()});
});


// 1. 현재 보고 있는 지도의 동서남북 좌표 얻기
getInfo();
function getInfo() {


    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();	// 남, 서, 북, 동 순으로 필드가 저장
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
    let 동	 = neLatLng.getLng();
    let 서 = swLatLng.getLng();
    let 남 = swLatLng.getLat();
    let 북 = neLatLng.getLat();
    
    console.log('동' + 동);
    console.log('서' + 서);
    console.log('남' + 남);
    console.log('북' + 북);
    
    findByLatLng(동, 서, 남, 북);
}

// 2. 해당 동서남북 좌표에 범위내 제품만 출력하기
function findByLatLng(east, west, south, north){
	clusterer.clear();
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       async : false,		/* ajax 통신은 기본적으로 비동기 통신이므로 동기화로 변경*/
       data : {type : 'findByLatLng', east : east, west : west,
       	south: south, north : north},         // 보내는 데이터
       method : "get",
        success : jsonArray =>{console.log(jsonArray);	
			
			var markers = jsonArray.map((p)=> {
		        return new kakao.maps.Marker({
		            position : new kakao.maps.LatLng(p.plat, p.plng)
		        });
		    });
		    // 클러스터러에 마커들을 추가합니다
		    clusterer.addMarkers(markers);
		},
        error : e =>{}
     });

	
}	// f end


// 3. 카카오 지도에서 드래그를 하고 끝났을때 1번 함수 재실행
kakao.maps.event.addListener(map, 'dragend', function() {
    getInfo();
});




























