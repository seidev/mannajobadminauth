<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="includes/header.jsp" %>

<script type="text/javascript">
window.name = 'showempl';



  //Configure below to change URL path to the snow image
  var snowsrc="/resources/img/like.png"

  // Configure below to change number of snow to render
  var no = 10;

  // Configure whether snow should disappear after x seconds (0=never):
  var hidesnowtime = 0;

  // Configure how much snow should drop down before fading ("windowheight" or "pageheight")
  var snowdistance = "pageheight";




  var ie4up = (document.all) ? 1 : 0;
  var ns6up = (document.getElementById&&!document.all) ? 1 : 0;




function iecompattest(){
return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body

}




  var dx, xp, yp;    // coordinate and position variables
  var am, stx, sty;  // amplitude and step variables
  var i, doc_width = 800, doc_height = 600; 

  

  if (ns6up) {
    doc_width = self.innerWidth;
    doc_height = self.innerHeight;
  } else if (ie4up) {

    doc_width = iecompattest().clientWidth;
    doc_height = iecompattest().clientHeight;

  }




  dx = new Array();
  xp = new Array();
  yp = new Array();
  am = new Array();
  stx = new Array();
  sty = new Array();
  snowsrc=(snowsrc.indexOf("dynamicdrive.com")!=-1)? "snow.gif" : snowsrc

  for (i = 0; i < no; ++ i) {  

    dx[i] = 0;                        // set coordinate variables
    xp[i] = Math.random()*(doc_width-50);  // set position variables
    yp[i] = Math.random()*doc_height;
    am[i] = Math.random()*20;         // set amplitude variables
    stx[i] = 0.02 + Math.random()/10; // set step variables
    sty[i] = 0.7 + Math.random();     // set step variables

if (ie4up||ns6up) {
      if (i == 0) {
        document.write("<div id=\"dot"+ i +"\" style=\"POSITION: absolute; Z-INDEX: "+ i +"; VISIBILITY: visible; TOP: 15px; LEFT: 15px;\"><a href=\"http://dynamicdrive.com\"><img src='"+snowsrc+"' border=\"0\"><\/a><\/div>");

      } else {

        document.write("<div id=\"dot"+ i +"\" style=\"POSITION: absolute; Z-INDEX: "+ i +"; VISIBILITY: visible; TOP: 15px; LEFT: 15px;\"><img src='"+snowsrc+"' border=\"0\"><\/div>");

      }

    }

  }




  function snowIE_NS6() {  // IE and NS6 main animation function
    doc_width = ns6up?window.innerWidth-10 : iecompattest().clientWidth-10;

doc_height=(window.innerHeight && snowdistance=="windowheight")? window.innerHeight : (ie4up && snowdistance=="windowheight")?  iecompattest().clientHeight : (ie4up && !window.opera && snowdistance=="pageheight")? iecompattest().scrollHeight : iecompattest().offsetHeight;

    for (i = 0; i < no; ++ i) {  // iterate for every dot

      yp[i] += sty[i];

      if (yp[i] > doc_height-50) {

        xp[i] = Math.random()*(doc_width-am[i]-30);
        yp[i] = 0;
        stx[i] = 0.02 + Math.random()/10;
        sty[i] = 0.7 + Math.random();
      }

      dx[i] += stx[i];
      document.getElementById("dot"+i).style.top=yp[i]+"px";
      document.getElementById("dot"+i).style.left=xp[i] + am[i]*Math.sin(dx[i])+"px";  
    }
    snowtimer=setTimeout("snowIE_NS6()", 10);
  }


function hidesnow(){
if (window.snowtimer) clearTimeout(snowtimer)
for (i=0; i<no; i++) document.getElementById("dot"+i).style.visibility="hidden"

}


if (ie4up||ns6up){
    snowIE_NS6();
if (hidesnowtime>0)
setTimeout("hidesnow()", hidesnowtime*1000)
}


</script>

<section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span12">
            <ul class="breadcrumb">
              <li><a href="#"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="#">Search</a><i class="icon-angle-right"></i></li>
              <li><a href="#"> ????????? ????????? ?????????</a><i class="icon-angle-right"></i></li>
              <li class="active">????????? ????????????</li>
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
                <h5 class="widgetheading height_40">???&nbsp&nbsp&nbsp&nbsp???</h5>

                <ul class="cat">
                  <li><i class="icon-angle-right"></i><a href="/bmatch/list?b_category=A">????????? ?????? ?????????</a></li>
                  <li><i class="icon-angle-right"></i><a href="/bmatch/list?b_category=B">??????????????? ?????? ?????????</a></li>
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
                    <h3 style="color: #f84002;">&nbsp&nbsp&nbsp ????????? <strong>?????????</strong>????????????</h3>
                    <p class="line_9"></p>
                  </div>

                  <div class="span10">
                    <h5>??? ????????????</h5>
                    <div class="span2" >
                        <div class="post-image">
                          <p class="line_9"></p>
                          <!--????????? ????????? ?????? -->
                          <img src="/resources/certifi/${image}"  style="width:180px; height:180px;"/>
                        </div>
                    </div>

                    <div class="span7 right">
                      <table class="table table-bordered">  
                        <colgroup>
                          <col sytle width="20%"/>
                          <col sytle width="30%"/>
                          <col sytle width="20%"/>
                          <col sytle width="30%"/>
                        </colgroup>                    
                        <tr>
                          <td>
                            <p class="center">??? &nbsp&nbsp ??? &nbsp&nbsp ???</p>
                          </td>
                          <td colspan="3">
                            <!-- ????????? -->
                            ${m_id}
                          </td>
                        </tr>
                        <tr> 
                          <td>
                            <p class="center">??? &nbsp&nbsp ??? &nbsp&nbsp ???</p>
                          </td>
                          <td>
                            <!-- ????????? -->
                            ${empl.e_corp}
                          </td>
                          <td>
                            <p class="center">??? &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ???</p>
                          </td>
                          <td>
                            <!-- ?????? -->
                            ${empl.e_dept}
                          </td>
                        </tr>
                        <tr> 
                          <td>
                            <p class="center">??? &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ???</p>
                              
                          <td>
                            <!-- ?????? -->
                            ${empl.e_task}
                          </td>
                          <td>
                            <p class="center">??? &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ???</p>
                          </td>
                          <td>
                            <!-- ?????? -->
                            ${empl.e_rank}
                          </td>
                        </tr>
                        <tr> 
                          <td>
                            <p class="center">???????????????</p>                            
                          <td>
                            <!-- ??????????????? -->
                            <span style="color:orangered"><strong>${count}</strong></span>
                            <span style="color:orangered">&nbsp ???</span>
                          </td>
                          <td>
                            <p class="center">??? &nbsp&nbsp ??? &nbsp&nbsp ???</p>
                          </td>
                          <td>
                            <!-- ????????? -->
                            <span style="color:orangered"><strong>${good}</strong></span>
                            <span style="color:orangered">&nbsp ???</span>
                          </td>
                        </tr>

                      </table>
                    </div>
                
                    <div class="span9">
                      <table class="table table-bordered">
                        <colgroup>
                          <col sytle width="10%"/>
                          <col sytle width="90%"/>
                        </colgroup>     
                        <tr>
                          <td>
                            <p class="center">???&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp???</p>
                          </td>
                          <td>
                            <!-- ?????? -->
                            <% pageContext.setAttribute("line", "\n");%>
							${empl.e_intro}
                          </td>
                        </tr>                        
                      </table>
                    </div>
                  </div> 

                  <div class="span10">                   
                    <h5>??? ??????</h5>
                    <div class="span9">
                      <table class="table table-bordered">
                        <colgroup>
                          <col sytle width="8%"/>
                          <col sytle width="auto%"/>
                          <col sytle width="12%"/>
                          <col sytle width="12%"/>
                          <col sytle width="8%"/>
                          <col sytle width="8%"/>
                        </colgroup>
                        <tr>
                          <td>
                            <p class="center" >??????</p>    
                          </td>
                          <td>
                            <p class="center" >??? ???</p>    
                          </td>
                          <td>
                            <p class="center">?????????</p>    
                          </td>
                          <td>
                            <p class="center">?????????</p>    
                          </td>
                          <td>
                            <p class="center">??????</p>    
                          </td>
                          <td>
                            <p class="center">??????</p>    
                          </td>
                        </tr> 
                        <c:forEach var="re" items="${review}">
                        <tr>
                          <td>
                            <!-- ???????????? r_good ????????? ??????(g,b) -->
                            <p class="center">
	                            <c:choose>
									<c:when test="${re.r_good eq 'G'}">??????</c:when>
									<c:otherwise>?????????</c:otherwise>
								</c:choose>
                            </p>
                          </td>
                          <td style="width: 400px;">
                            <!-- ????????????  r_contents -->
                            <% pageContext.setAttribute("line", "\n");%>
							<c:out value='${fn:replace(paramVO.content, line ,"<br/>")}'/>
                            <p>${re.r_contents}</p>
                          </td>
                          <td>
                            <!-- ????????? -->
                            <p class="center">${re.r_w_m_id}</p>
                          </td>
                          <td>
                            <!-- ????????? r_wdate-->
                            <p class="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${re.r_wdate}" /></p>
                          </td>
                          <td>
                            <!-- ???????????? (?????? ???????????? ????????? ?????? ?????????) -->
	                        <c:if test="${userId eq re.r_w_m_id }">
                            <p class="center"><a href="/review/updatee?r_num=${re.r_num}&r_contents=${re.r_contents}" class="btn btn-mini btn-theme" onClick="window.open(this.href, '?????? ??????', 'width=500, height=400'); return false">??????</a></p>
	                        </c:if>
                          </td>
                          <td>
                            <!-- ???????????? (?????? ???????????? ????????? ?????? ?????????)-->
                            <c:if test="${userId eq re.r_w_m_id }">
                            <p class="center"><a href="/review/deletee?r_num=${re.r_num}" class="btn btn-mini btn-inverse">??????</a></p>
                            </c:if>
                          </td>
                        </tr>  
                        </c:forEach>
                        
                      </table>
                    </div>
                  </div>
                </div>               
              </form>             
            </article>
            
          </div>
        </div>
      </div>
    </section>


<%@ include file="includes/footer.jsp" %>