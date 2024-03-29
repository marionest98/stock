<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>판매</title>

<!-- Custom fonts for this template-->
<link href="../../vendor/fontawesome-free/css/all.min.css"
   rel="stylesheet" type="text/css">
<link
   href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
   rel="stylesheet">



<!-- Custom styles for this template-->
<link href="../../css/sb-admin-2.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="../../js/webSocket.js"></script>
<script src="../../js/sell.js"></script>

<script src="../../vendor/jquery/jquery.min.js"></script>
   <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

   <!-- Core plugin JavaScript-->
   <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

   <!-- Custom scripts for all pages-->
   <script src="../../js/sb-admin-2.min2.js"></script>

</head>

<body id="page-top">

   <!-- Page Wrapper -->
   <div id="wrapper">

      <!-- Sidebar -->
      <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

         <!-- Sidebar - Brand -->
         <!-- 홈화면 링크 부분-->
         <a href="/admin/price" class="sidebar-brand d-flex align-items-center justify-content-center" > 
            <div class="sidebar-brand-icon rotate-n-15">
               <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">
               관리해줘 <sup>admin</sup>
            </div>
         </a>
         
         <li class="nav-item"><a class="nav-link" href="/admin/change">
               <i class="fas fa-fw fa-chart-area"></i> <span>변경</span>
         </a></li>
         <!-- Sidebar Message -->

      </ul>
      <!-- End of Sidebar -->

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">

         <!-- Main Content -->
         <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

               <!-- Sidebar Toggle (Topbar) -->
               <button id="sidebarToggleTop"
                  class="btn btn-link d-md-none rounded-circle mr-3">
                  <i class="fa fa-bars"></i>
               </button>

               <!-- Topbar Search -->
               <form
                  class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">

               </form>

               <!-- Topbar Navbar -->
               <ul class="navbar-nav ml-auto">

                  <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                  <li class="nav-item dropdown no-arrow"><a
                     class="nav-link dropdown-toggle" href="#" id="userDropdown"
                     role="button" data-toggle="dropdown" aria-haspopup="true"
                     aria-expanded="false"> <span
                        class="mr-2 d-none d-lg-inline text-gray-600 small">${uid}</span>
                        <img class="img-profile rounded-circle"
                        src="../../img/undraw_profile.svg">
                  </a> <!-- Dropdown - User Information -->
                     <div
                        class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                        aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#"> <i
                           class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 프로필
                        </a>

                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal"
                           data-target="#logoutModal"> <i
                           class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                           로그아웃
                        </a>
                     </div></li>
               </ul>

            </nav>



                  <!-- Nav Item - User Information -->
                  <!-- 로그아웃 마이페이 부분-->
                  
                  
            
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

               <!-- Page Heading -->
               <div
                  class="d-sm-flex align-items-center justify-content-between mb-4">
                  <h1 class="h3 mb-0 text-gray-800">재고 등록</h1>
               </div>

               <!-- Content Row -->
               <div class="row">
               <div id="Message" class="col-lg-6 mb-4">
                     <div class="card shadow mb-4" style="width: 1600px;">
                        <div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">재고 추가</h6>
                        </div>
                        <table
                              class="table table-bordered dataTable copyright text-center my-auto"
                              id="dataTable" width="100%" cellspacing="0" role="grid"
                              aria-describedby="dataTable_info" style="width: 100%;">
      <tr>                        
    <td>
    작물 종류
    </td>
   <td>
    <select id ="a_content">
    <c:forEach var="priceData" items="${priceDataList}" varStatus="count">
    <option value = "${priceData.PUM_NM_A}" id = "${priceData.PAV_P_A}">${priceData.PUM_NM_A}</option>
    </c:forEach>
     </select>
    </td>
    </tr>
   <tr>
   <td>분류 번호</td>
   <td><input type="text" id ="a_val"></td>
   </tr>
    </table>
     <script type="text/javascript">
        console.log(document.getElementById("a_content").value)
     </script>
   
   </div>
   <button class="btn btn-primary btn-icon-split click" style="width:45px;height:41px;float: right;">제출</button>
   </div>
   </div>
   </div>
   </div>
                <div>
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
            aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
               <div class="modal-content">
                  <div class="modal-header">
                     <h5 class="modal-title" id="exampleModalLabel">로그아웃</h5>
                     <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                        <span aria-hidden="true">×</span>
                     </button>
                  </div>
                  <div class="modal-body">로그아웃 하시겠습니까?</div>
                  <div class="modal-footer">
                     <button class="btn btn-secondary" type="button"
                        data-dismiss="modal">취소</button>
                     <a class="btn btn-primary" href="/logout">로그아웃</a>
                  </div>

               </div>
            </div>
         </div>
      </div>
   </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    
    $(document).ready(function(){
       $('.click').click(
            function() {
               var a_content = $('#a_content').val();
                  var a_val = $('#a_val').val();
               var a_volum= parseInt($('#a_content option:selected').attr('id')/10);

               $.ajax({
                     type: 'POST',
                     url: '/company/inserta',
                     data: {'a_content':a_content, "a_val":a_val, "a_volum":a_volum},
                     success:function(result){
                        $('#a_content').val("");
                        $('#a_val').val("");
                        if(result == 0){
                           alert("재고 등록에 실패하였습니다");
                        }else{
                           alert("재고 등록에 성공하셨습니다.");
                        }
                     }
                  });
               });
      });
    </script>
</body>
</html>