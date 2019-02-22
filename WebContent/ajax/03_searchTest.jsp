<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>03_searchTest.jsp</title>
</head>
<body>
	<h3>[ Suggest 기능 구현 ]</h3>
	<form name="search" id="search">
		<input type="text" name="keyWord" id="keyWord" /> <input type="button" value="검색" />
	</form>

	<!-- 제시어 단어 출력부분 -->
	<div id="suggest" style="display: none"></div>

	<script src="js/jquery.js"></script>
	<script>
		$.ajaxSetup({dataType : "text"});
		$("#keyWord").keyup(function (){
			//alert("test");
			//1) id=keyWord값 가져오기
			//var params = $("#keyWord").val();
			//alert(params);
			
			//2) 폼양식의 모든 컨트롤 요소값들 가져오기
			// -> <form id=search></form>
			//var params = $("#search").serialize();
			//alert(params); // keyWord=iquery
			
			if($("#keyWord").val()==""){
				//검색어가 존재하지 않는다면 출력결과 숨기기
				$("#suggest").hide();
			}//if end
			
			var params = $("#search").serialize();
			$.post("/frontend/search.do"
				   , params
				   , responseProc
				   , "text");
		});//keyup end
		
		 function responseProc(result){
			  // alert(result);
			  // 2|"웹프로그래밍","웹마스터"
			  if(result.length>0){//응답내용이 있는지
				var data = result.split("|");
			  	//alert(data[0]);//2
			  	//alert(data[1]);//"웹프로그래밍","웹마스터"
				var wordList = data[1].split(",");
			  	var str = "";
			  	$.each(wordList, function(index, key){
			  		str += "<ul>";
			  		str += "<li>" + key + "</li>";
			  		str += "</ul>";
			  	});//each() end
			  	$("#suggest").html(str);
			  	$("#suggest").show();	  	
			  }else{
				$("#suggest").hide();  
			  }//if end	  
		  }//responseProc() end

	</script>
</body>
</html>



