console.log('제품등록스크립트 실행')
/*
function register(){
	
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formData = new FormData(registerForm);
	
	// 첨부파일없는 폼데이터 전송
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : formData,         // 보내는 데이터
       method : "post",
       contentType : false,
       processData : false,
       success : r => {console.log(r)
       		
			
			
		}
        // error : function f(result){}
     });
	
	
}*/

// 1. 제품 등록
function onRegister(){
	
	// 1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	// 2. formData 객체 생성
	let formData = new FormData(registerForm);
	console.log(formData)
	
		// *** 드래그앤드랍을 사용했을때
			// 현재 드랍된 파일들을 form에 같이 추가해서 전송해야함(드래그된 파일들은 input태그가 아니기때문)
			
		if(fileList.length >= 1){	// 드랍된 파일이 존재하면
			fileList.forEach(f =>{
				//formData.set('fileList', f);
					// 폼데이터객체.set -> 기존에 동일한 키가 있으면 해당 키에 데이터 덮어쓰기
				// 폼데이터객체.set('키', 값);	-> 폼데이터객체에 데이터 추가
				formData.append('fileList', f)
					// 폼데이터객체.append -> 기존에 동일한 키가 있으면 해당 키에 데이터 추가
			})
		}
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : formData,         // 보내는 데이터
       method : "post",
       contentType : false,
       processData : false,
       success : r => {console.log(r)
       		
			
			
		},
        error : function f(result){}
     });
	
}	// f end

// 2. 드래그 앤 드랍
	// 1. 드래그 앤 드랍 할 구역 dom 객체 호출
let fileDropBox = document.querySelector('.fileDropBox');

	// 2. 해당 dom 객체 구역내 드래그가 들어왔을때
fileDropBox.addEventListener("dragenter", (e)=>{
	e.preventDefault();	// 상위 이벤트 무시하고 현 이벤트 우선 할당
	console.log('드래그 들어옴');
});	
	// 3. 해당 dom 객체 구역내 드래그가 올라왔을때
fileDropBox.addEventListener("dragover",(e)=>{
	e.preventDefault();	// 상위 이벤트 무시하고 현 이벤트 우선 할당
	console.log('구역에 드래그 위치중');
	fileDropBox.style.backgroundColor="#e8e8e8";
})
	// 4. 해당 dom 객체 구역내 드래그가 나갔을때
fileDropBox.addEventListener("dragleave",(e)=>{
	e.preventDefault();	// 상위 이벤트 무시하고 현 이벤트 우선 할당
	console.log('드래그 나감');
	fileDropBox.style.backgroundColor="#ffffff"
})
	// 5. 해당 dom 객체에 구역내 드래그 드랍(마우스를 놓았을때)
fileDropBox.addEventListener("drop",(e)=>{
	console.log(e);
	// * 브라우저 자체적으로 'drop'이벤트가 실행되므로 dragdrop 실행안됨
	// - 해결방안 : 기존 상위(브라우저) 이벤트 무시
	e.preventDefault();	// 상위 이벤트 무시하고 현 이벤트 우선 할당
	
	// 드랍된 파일의 정보
		// 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기
		console.log(e.dataTransfer);
		console.log(e.dataTransfer.files);
		console.log(e.dataTransfer.files[0]);
		
		// 드랍된 파일들을 특정 리스트에 저장
		let files = e.dataTransfer.files;
		
		for(let i = 0; i<files.length; i++){
			if(files[i] != null && files[i] != undefined){
				// 드랍된 파일의 정보가 존재하면[null도 아니고 undefined도 아닌상태이면]
				fileList.push(files[i]);
			}
		}
		// 배경색 초기화
		fileDropBox.style.backgroundColor="#ffffff";
		// 현재 드랍된 파일의 정보를 드래그앤드랍 구역에 표시
		fileListPrint()
		
})	;	// f end

let fileList = [];	// 현재 드래그 앤 드랍으로 등록된 파일들

// 3. 현재 드랍된 파일들의 정보를 구역에 표시하는 함수
function fileListPrint(){
	// 1. fileDropBox에
	
	// 2. html정보를 
	let html = ``;
		fileList.forEach((f,i) =>{
			let fname = f.name;		// 파일의 이름
			let fsize = (f.size/1024).toFixed(1);		// 파일의 용량[바이트 단위] -> kb로 변환
									// toFixed() : 소수점 자르기
			html += 
			`
				<div>
					<span>${fname}</span>
					<span>${fsize}kb</span>
					<span><button onclick="fileDelete(${i})" type="button">삭제</button></span>
				</div>
			`						
									
		} )
	// 3. 대입
	fileDropBox.innerHTML = html;
}

// 4. 현재 드랍된 파일들 중에 삭제버튼 클릭시 해당 파일 제거
function fileDelete(i){
	fileList.splice(i, 1);
	fileListPrint();
}



/*
	dom 객체 이벤트 추가하는 방법 2가지
		1. html에서 속성 이벤트 추가 (<button onclick="">)
		2. js에서 dom객체를 호출하여 이벤트 추가(button.addEventListener)
		
	이벤트
		종류 : click, keyup, kydown 등등
		정의 : 특정 조건(자동)을 충족하면 발생하고 발생한 이벤트의 결과물을 반환
		

	드래그 앤 드랍 관련 이벤트
		1. dragenter
		2. dragover
		3. dragleave
		4. drop
*/	











