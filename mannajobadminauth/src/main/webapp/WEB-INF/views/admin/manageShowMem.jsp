<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../includes/header.jsp" %>

<script>
		window.name = 'showempl';
</script>

<section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span12">
            <ul class="breadcrumb">
              <li><a href="#"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="#">매칭</a><i class="icon-angle-right"></i></li>
              <li class="active">취업준비생 매칭 리스트</li>
            </ul>
          </div>
        </div>
      </div>
    </section>


    <section id="" style="min-height:680px">
      <div class="container">
        <div class="row">
          <div class="span3">
            <aside class="left-sidebar">
              <div class="widget">
              </div>
              <div class="widget">
                <h5 class="widgetheading height_40">매&nbsp&nbsp&nbsp&nbsp칭</h5>

                <ul class="cat">
                  <li><i class="icon-angle-right"></i><a href="/bmatch/list?b_category=A">현직자 매칭 리스트</a></li>
                  <li><i class="icon-angle-right"></i><a href="/bmatch/list?b_category=B">쥐업준비생 매칭 리스트</a></li>
                </ul>
              </div>
            </aside>
          </div>
          <div class="span8">
            <article>
              <form id="commentform" action="#" method="post" name="comment-form">

                <div class="row">
                  <div class="post-heading">
                    <p class="line_9"></p>
                    <p class="line_9"></p>
                    <h3 style="color: #f84002;">&nbsp&nbsp&nbsp 취업준비생 <strong>프로필</strong>상세정보</h3>
                    <p class="line_9"></p>
                  </div>

                  <div class="span10">
                    <h5>▶ 기본정보</h5>
                    <%--
                    <div class="span2" >
                        <div class="post-image">
                          <p class="line_9"></p>
                          <!--현직자 이미지 사진 -->
                          <img src="/resources/certifi/${image}"  style="width:180px; height:180px;"/>
                        </div>
                    </div>
                    --%>

                    <div class="span9">
                      <table class="table table-bordered">  
                        <colgroup>
                          <col style="width: 20%" />
                          <col style="width: 30%" />
                          <col style="width: 20%" />
                          <col style="width: 10%" />
                        </colgroup>                    
                        <tr>
                          <td>
                            <p class="center">아 &nbsp&nbsp 이 &nbsp&nbsp 디</p>
                          </td>
                          <td colspan="3">
                            <!-- 아이디 -->
                            ${m_id}
                          </td>
                        </tr>
                      </table>
                    </div>
                
                	<%--
                    <div class="span9">
                      <table class="table table-bordered">
                        <colgroup>
                          <col sytle width="10%"/>
                          <col sytle width="90%"/>
                        </colgroup>     
                        <tr>
                          <td>
                            <p class="center">소&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp개</p>
                          </td>
                          <td>
                            <!-- 소개 -->
                            <% pageContext.setAttribute("line", "\n");%>
							${empl.e_intro}
                          </td>
                        </tr>                        
                      </table>
                    </div>
                  --%>
                  </div> 

                  <div class="span10">                   
                    <h5>▶ 리뷰</h5>
                    <div class="span9">
                      <table class="table table-bordered">
                        <colgroup>
                          <col style="width: 8%" />
                          <col style="width: auto" />
                          <col style="width: 12%" />
                          <col style="width: 12%" />
                          <col style="width: 8%" />
                          <col style="width: 8%" />
                        </colgroup>
                        <tr>
                          <td>
                            <p class="center" >구분</p>    
                          </td>
                          <td>
                            <p class="center" >내 용</p>    
                          </td>
                          <td>
                            <p class="center">작성자</p>    
                          </td>
                          <td>
                            <p class="center">작성일</p>    
                          </td>
                          <td>
                            <p class="center">수정</p>    
                          </td>
                          <td>
                            <p class="center">삭제</p>    
                          </td>
                        </tr> 
               			<c:forEach var="r" items="${MReview}">
                        <tr>
                          <td>
                            <!-- 추천여부 r_good 코드로 구분(g,b) -->
                            <p class="center"><c:if test="${r.r_good eq 'B'}">비</c:if>추천</p>
                          </td>
                          <td style="width: 400px;">
                            <!-- 리뷰내용  r_contents -->
                            
							<% pageContext.setAttribute("line", "\n");%>
							${fn: replace(r.r_contents, line,"<br/>")}
                            
                          </td>
                          <td>
                            <!-- 작성자 -->
                            <p class="center">${r.r_w_m_id}</p>
                          </td>
                          <td>
                            <!-- 작성일 r_wdate-->
                            <p class="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${r.r_wdate}"/></p>
                          </td>
                          <td>
                            <!-- 수정버튼 (세션 아이디와 동일할 경우 활성화) -->
                            <p class="center">
                            <%--
                            <c:if test="${r.r_w_m_id eq userId}">
                    		<a class="btn btn-mini btn-theme" href="/review/updatem?r_num=${r.r_num}&r_contents=${r.r_contents}" onClick="window.open(this.href, '리뷰 수정', 'width=400, height=300'); return false">수정</a>
               				</c:if>
               				--%>
                            </p>
                          </td>
                          <td>
                           <!-- 삭제버튼 (세션 아이디와 동일할 경우 활성화)-->
                           <p class="center">
                           	<a class="btn btn-mini btn-theme" href="/review/deletem?r_num=${r.r_num}">삭제</a>
                           <%--
                           <c:if test="${r.r_w_m_id eq userId}">
                    		<a class="btn btn-mini btn-inverse" href="/review/deletem?r_num=${r.r_num}">삭제</a>
                    		</c:if>
                    		--%>
                           </p>
                          </td>
                        </tr>
               			</c:forEach>
                      </table>
                      
                    </div>
                  </div>
                </div>               
              </form>             
            </article>
            <div class="span9">
				<div class="box aligncenter">
					<p class="center">
                  		<a href="javascript:history.back();" class="btn btn-inverse margintop10 a_btn4" type="button">리스트</a>
                  	</p>
                </div>
			</div>
          </div>
        </div>
      </div>
    </section>


<%@ include file="../includes/footer.jsp" %>