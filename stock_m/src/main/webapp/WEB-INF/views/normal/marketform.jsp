<%--      
   Date    : 2023.05.22
   name    : marketform
   type    : form
   ver     : 6.0
   conect  : MarketController
   content : 일반사용자용 구매 메인페이지
   writer  : 김기덕
   api     : x
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ogani | Template</title>




<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="../market/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="../market/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="../market/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="../market/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="../market/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="../market/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="../market/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="../market/css/style.css" type="text/css">

<style>
.switch {
	position: relative;
	display: inline-block;
	width: 60px;
	height: 34px;
}

.switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.slider:before {
	position: absolute;
	content: "";
	height: 26px;
	width: 26px;
	left: 4px;
	bottom: 4px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #2196F3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px);
	-ms-transform: translateX(26px);
	transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}

thead {
	background-color: #7fad39;
}
</style>


</head>

<body>

	<!-- Header Section Begin -->
	<header class="header">
		<input type="hidden" name="command" id="command" value="market">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="/normal/market"><img src="../market/img/logo.png"
							alt=""></a>
					</div>
				</div>
				<div class="col-lg-3"></div>
				<div class="col-lg-6">

					<div class="header__cart">
						<ul>
							<li>${userid}님 안녕하세요</li>
							<li>
								<div class="header__top__right__auth">
									<%-- logout기능 클릭시 MarketController에 logout메서드로 세션에 저장된 userid 정보를 삭제 --%>
									<a href="/logout"><i class="fa fa-user"></i> 로그아웃</a>									
								</div>
								<div class="header__top__right__auth">
								<a href="broadSelecMenu"><i class="fa fa-user"></i> 알람설정</a>
								</div>
							</li>
							<%-- 장바구니에 저장된 상품수 출력 및 클릭시 MarketController에 cform메서드로 해당유저의 장바구니로 이동 --%>
							<li><a href="cart/${userid}"><i
									class="fa fa-shopping-bag"></i> <span id="ccount">${ccount}</span></a></li>
						</ul>
						<%-- 장바구니에 저장된 상품들의 가격 총합 출력 --%>
						<div class="header__cart__price">
							총 액: <span id="cprice">${cprice}원</span>
						</div>						
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Header Section End -->

	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>전체 분류</span>
						</div>
						<%-- 상품을 분류코드로 분류하여 분류코드 별 상품정보를 MarketController에 pvform메서드로 shop-grid.jsp에 출력 --%>
						<ul>
							<li><a href="/normal/p_val?p_val=100">식량작물</a></li>
							<li><a href="/normal/p_val?p_val=200">채소류</a></li>
							<li><a href="/normal/p_val?p_val=300">특용작물</a></li>
							<li><a href="/normal/p_val?p_val=400">과일류</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<%-- 상품을 상품명으로 검색하여 상품정보를 MarketController에 sform메서드로 shop-grid.jsp에 출력 --%>
							<form action="/normal/search">
								<input type="text" placeholder="검색할 상품명" name="pname">
								<button type="submit" class="site-btn">검색</button>
							</form>

						</div>
					</div>
					<div class="hero__item set-bg"
						data-setbg="../market/img/hero/banner.jpg">
						<div class="hero__text">
							<span>FRUIT FRESH</span>
							<h2>
								Vegetable <br />100% Organic
							</h2>
							<p>Free Pickup and Delivery Available</p>
							<a href="#" class="primary-btn">SHOP NOW</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Categories Section Begin -->

	<!-- Categories Section End -->

	<!-- Featured Section Begin -->

	<!-- Featured Section End -->
	<!-- Banner Begin -->
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<!-- chart 부분 -->
						<div class="hero__categories__box">
								<!--hero__categories__all 이 부분 변경 필요 -->
								<h4 align="center">거래 동향</h4>
							</div>
						<div class="card-body">
							
							<div class="chart-area" >

								<canvas id="mymainChart"></canvas>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="hero__categories">
						<div class="hero__categories__box">
							<!--hero__categories__all 이 부분 변경 필요 -->
							<h4 align="center">관리 업체</h4>
						</div>
						<div class="shoping__cart__table">
							<table>
								<thead>
									<tr>
										<th style="color: white;">no.</th>
											<th style="color: white;">회사 이름</th>
											<th style="color: white;"> 관리 상태</th>
											<th style="color: white;">삭제</th>
											<th style="color: white;">상태 변경</th>
									</tr>
								</thead>
								<c:forEach items="${mainList}" var="management"
									varStatus="count">
									<tr>
										<th>${count.index+1}</th>
										<th class="m_content" data-c_userid="${management.c_userid}">${management.m_content}</th>
										<th><c:set var="type" value="${management.m_val}" /> <c:choose>

												<c:when test="${type}">
											관심 업체
											</c:when>
												<c:when test="${!type}">
											유의 업체
											</c:when>
											</c:choose></th>
											<th><button class="click">삭제</button></th>
											<th><button class="click2">변경</button></th>
										</tr>
									</c:forEach>
									</tbody>
								</table>
								<div class="header__cart"><div class="site-btn"><a href="interest" style="color: #fff;"> 전체 보기</a></div></div>
                        </div>
                    </div>
                </div>
                               <%--  <div class="col-lg-12 col-md-6 col-sm-6">
                <div class="hero__categories">
                        <div class="hero__categories__box">
                   
                            <h4 align="center">게시물</h4>
                        </div>
                        	<div class="shoping__cart__table">
                        	<table>
                        	<thread>
                        		<tr>
                                	<th>제목</th>
                					<th>작성자</th>
                					<th>작성일</th>
                					<th>조회수</th>
                        		</tr>
                            </thread>
                        

                        
                       
                         <c:if test="${bcount != 0 }">
                        	<c:forEach items="${bList}" var="board">
    	<tr>
        	<c:choose>
            	<c:when test="${board.secret}">
                	<c:if test="${user.role eq 'admin' or user.userid eq board.userid}">
                    	<td>
                        	<a href="content/${board.boardno}">
                            	<i class="icofont-lock"></i>
                            	<c:out value="${board.subject}"/>
                            	<span class="text-muted small"> </span>
                       	 </a>
                    	</td>
               	 	</c:if>
               	 	<c:if test="${user.role ne 'admin' and user.userid ne board.userid}">
                    	<td>
                        	<a href="#" onclick="showAlert();">
                            	<i class="icofont-lock"></i>
                            	비밀글입니다.
                            	<span class="text-muted small"> </span>
                        	</a>
                    	</td>
                	</c:if>
            	</c:when>
            	<c:otherwise>
                <td>
                    <a href="content/${board.boardno}">
                        <c:out value="${board.subject}"/>
                    </a>
                </td>
            </c:otherwise>
        </c:choose>
        <td>${board.userid}</td>
        <td><fmt:formatDate value="${board.regdate}" dateStyle="short"/></td>
        <td>${board.readcount}</td>
    </tr>
</c:forEach>
        </table>

    </c:if>
    <c:if test="${bcount eq 0 && bList eq null }">
        아직 입력한 글이 없습니다.
    </c:if>
    </table>
                        
                        </div>
     <div class="header__cart"><div class="site-btn"><a href="list" style="color: black; ">
        				<h6>더보기</h6>
    					</a></div></div>
                </div>
                </div> --%>

            </div>
        </div>
    </div>
    <!-- Banner End -->


	<!-- Latest Product Section Begin -->
	<!-- Blog Section End -->

	<!-- Footer Section Begin -->

	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="../market/js/jquery-3.3.1.min.js"></script>
	<script src="../market/js/bootstrap.min.js"></script>
	<script src="../market/js/jquery.nice-select.min.js"></script>
	<script src="../market/js/jquery-ui.min.js"></script>
	<script src="../market/js/jquery.slicknav.js"></script>
	<script src="../market/js/mixitup.min.js"></script>
	<script src="../market/js/owl.carousel.min.js"></script>
	<script src="../market/js/main.js"></script>

	<!--chart  -->
	<script src="../../../vendor/chart.js/Chart.min.js"></script>
	<script src="../../../js/demo/chart-area-demo2.js"></script>

	<!--js list made by kim -->
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../../js/webSocket.js"></script>
	<!-- <script>
        $('document').ready(function () {
        	console.log("aaa");
            $.ajax({
                type: "get",	
                url: "/cartcount"   
                
            }).done(function(response){    
            	
            	document.getElementById("ccount").textContent = reponse.ccount;
            	document.getElementById("cprice").textContent = reponse.cprice;
            });
            console.log(document.getElementById("ccount").textContent);
        });
    </script> -->


	<script>
		$(document).ready(
				function() {
					$('.click').click(
							function() {
								var m_content = $(this).closest('tr').find(
										'.m_content').text();
								var m_content = $(this).closest('tr').find(
										'.m_content').text();
								location.href = "/normal/madelete?m_content="
										+ m_content;

							});
				});

		$(document).ready(
				function() {
					$('.click2').click(
							function() {
								var m_content = $(this).closest('tr').find('.m_content').text();
								console.log(m_content);
									$.ajax({										
										type : 'POST',
										url : '/normal/check2',
										data : {
											'm_content' : m_content											
											},
										success :										
											function(result) {
												if (result == true) {
													location.href = "/normal/update?m_content="+ m_content;													
												} else {
													location.href = "/normal/update2?m_content="+ m_content;
												}												
											}

									});
							});
				});
		/* $(document).ready(
				function() {
					$('.switch input').change(
							function() {
								var Checked = $(this).is(":checked");
								var userid = $(this).closest('tr')
										.find('.userid').val();
								console.log("슬라이드 바 상태: " + Checked);
								console.log(userid);
								$.ajax({
									type : 'POST',
									url : '/normal/switch',
									data : {
										Checked : Checked,
										'userid' : userid
									},
									success : function(result) {
										if (result == true) {

										} else {

										}
									}

								});
							});
				}); */
	</script>

</body>

</html>