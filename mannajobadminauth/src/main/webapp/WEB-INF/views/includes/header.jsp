<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <title>manajob administrator</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&family=Sunflower:wght@500&display=swap"
    rel="stylesheet">
  <link href="/resources/css/bootstrap.css" rel="stylesheet" />
  <link href="/resources/css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="/resources/css/fancybox/jquery.fancybox.css" rel="stylesheet">
  <link href="/resources/css/jcarousel.css" rel="stylesheet" />
  <link href="/resources/css/flexslider.css" rel="stylesheet" />
  <link href="/resources/css/style.css" rel="stylesheet" />
  <!-- Theme skin -->
  <link href="/resources/skins/default.css" rel="stylesheet" />
  <!-- Chart -->
  <link href="/resources/css/chart.css" rel="stylesheet">
  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/resources/ico/apple-touch-icon-144-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/resources/ico/apple-touch-icon-114-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/resources/ico/apple-touch-icon-72-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" href="/resources/ico/apple-touch-icon-57-precomposed.png" />
  <link rel="shortcut icon" href="/resources/ico/MJfavi.png" />
  
</head>
  <style>
    body,
    h1,
    h5 {
      font-family: 'Sunflower', sans-serif;
    }

    .height_40 {
      padding-top: 30px;
    }

  </style>

<body>
  <div id="wrapper">
      <!-- start header -->
    <header>
      <div class="container "> 
       
        <div class="row nomargin">
          <div class="span12">
            <div class="headnav">
              <ul>

                <!-- ????????? ?????? ??????  <sytle.css : headnav>
                ??????????????????
                <li>????????????</li>
                <li><a href="#" data-toggle="modal"> ????????????</a></li> 
              
                 ?????????????????????-->
                 <c:if test="${sessionScope.userId != null}">
                 	<li>${userId}???</li>
	                <li><a href="/logout">????????????</a></li>
                 	<%--
               		<li>
	                	<c:choose>
							<c:when test="${userId eq null}">
								<a href="/login">?????????</a>
							</c:when>
							<c:otherwise>
								<a href="/profile/main">${userId}???</a>
							</c:otherwise>
						</c:choose>
					</li>
	                <li>
	               		<c:choose>
							<c:when test="${userId eq null}">
								<a href="/join/member_agree">????????????</a>
							</c:when>
						<c:otherwise>
								<a href="/logout">????????????</a>
							</c:otherwise>
						</c:choose>
						--%>
                 </c:if>
                <!-- ????????? ?????? ???-->
              </ul>
            </div>
          </div>
        </div>
        <div class="row nomargin">
           <!-- ?????? ??????????????? ??????-->
          <div class="span4">
            <div class="logo">
              <%-- <a href="/main"><img src="/resources/img/MANNAJOB.png" alt="" class="logo" /></a> --%>
              <img src="/resources/img/MANNAJOB.png" alt="" class="logo" />
              <h1>??????????????? - ?????????</h1>
              <h1>???????????? ?????? ?????? ?????????</h1>
            </div>
          </div>
          <div class="">
            <!-- ????????? ??????-->
            <%--
             <div class="">
               <form class="form-search" method="get" action="/bmatch/search">
                 <input placeholder="???????????? ??????????????????" type="text" class="input-medium search-query" name="b_corp">
                 <input type="submit" class="btn btn-square btn-theme" value="Search">
               </form>
             </div>
             --%>
            <!-- ????????? ???-->            
           </div>
           <!-- ?????? ??????????????? ???-->
           <c:if test="${sessionScope.userId != null}">
	          <div class="">
		          <div class="navbar navbar-static-top">
		
		              <!-- ?????? ???????????? navigation  style.css   menu> -->
		              <div class="navigation">
		                <nav>
		                  <ul class="nav topnav">
		                  <!-- <ul class="recent"> -->
		                    <li>
		                      <a href="/bmatch/list?b_category=A">???&nbsp&nbsp???</a>
		                    </li>
		                    <li>
		                      <a href="/qna/list">?????????</a>
		                    </li>
		                    <li>
		                      <a href="/chart/chart_cnt">???&nbsp&nbsp???</a>
		                    </li>
		                    <!-- 
		                    <li>
		                      <a href="/match/matlist">???????????????</a>
		                    </li>
		                     -->
		                    <li>
		                      <a href="/admin/manage">?????????</a> 
		                    </li> 
		                  </ul>
		                </nav>
		              </div>
		              <!-- ?????? ???????????? ???-->
		
		            </div>
	          </div>
          </c:if>
        </div>
      </div>
    </header>
    <!-- end header -->
