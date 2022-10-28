<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>iLand Multipurpose Landing Page Template</title>
    <link rel="icon" href="../images/favicon.png" type="image/png" sizes="16x16">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="iLand Multipurpose Landing Page Template">
    <meta name="keywords" content="iLand HTML Template, iLand Landing Page, Landing Page Template">
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="https://fonts.googleapis.com/css?family=Open%20Sans:300,400,500,600,700" rel="stylesheet"
          type="text/css">
    <link rel="stylesheet" href="../css/animate.css">
    <!-- Resource style -->
    <link rel="stylesheet" href="../css/owl.carousel.css">
    <link rel="stylesheet" href="../css/owl.theme.css">
    <link rel="stylesheet" href="../css/ionicons.min.css">

    <!-- Resource style -->
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <style>
        fieldset {
            border: 0;
        }

        label {
            display: block;
            margin: 30px 0 0 0;
        }

        .overflow {
            height: 200px;
        }
    </style>

    <!-- Jquery and Js Plugins -->
    <script type="text/javascript" src="../js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>

    <script type="text/javascript" src="../js/plugins.js"></script>
    <script type="text/javascript" src="../js/menu.js"></script>
    <script type="text/javascript" src="../js/custom.js"></script>
    <script src="../js/jquery.subscribe.js"></script>
    <script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
    <style type="text/css">
        #admin{
            height: 300px;
            margin: 250px 100px 100px 100px;
        }
    </style>
    <style type="text/css">
        /* Google Web Font */
        @import url('https://fonts.googleapis.com/css?family=Montserrat:300,400,500&display=swap');
        * {
            box-sizing: border-box;
        }

        /* Table */
        .member {
            width: 600px;
            background-color: #fff;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
            border-radius: 5px;
            overflow: hidden;
        }
        .member caption {
            font-size: 20px;
            margin-bottom: 30px;
        }
        .member tr {
            border-bottom: 1px solid #eee;
        }
        .member tr:last-child {
            border: none;
        }
        .member tr:nth-child(odd) {
            background-color: #ddd;
        }
        .member th,
        .member td {
            padding: 12px;

        }
        .member tr th {
            background-color: royalblue;
            color: #fff;
        }
        .member tr th:first-child {
            border-radius: 5px 0 0 0;
        }
        .member tr th:last-child {
            border-radius: 0 5px 0 0;
        }
        .member tr td:last-child {

            font-weight: 500;
        }




        input, select , textarea {
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;

            background: var(--button-bg-color);
            color: var(--button-color);

            margin: 0;
            padding: 0.5rem 1rem;

            font-family: 'Noto Sans KR', sans-serif;
            font-size: 1rem;
            font-weight: 400;

            text-decoration: none;

            border: none;
            border-radius: 4px;

            display: inline-block;
            width: auto;

            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);

            cursor: pointer;

            transition: 0.5s;
        }

       </style>
    <script type="text/javascript">
            $(function(){

            //전체검색
            function readQuestion(){
                $.ajax({
                    url :"../ajax" , //서버요청주소
                    type:"post", //요청방식(method방식 : get | post | put | delete )
                    dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
                    data: {key:"q" , methodName : "readQuestion"}, //서버에게 보낼 데이터정보(parameter정보)
                    success :function(arr){
                        let str="";
                        $.each(arr, function(index, item){
                            str+=`<tr>`;
                            str+=`<td><a href='#'>${"${item.qSubject}"}</a></td>`;
                            str+=`<td>${"${item.eMail}"}</td>`;
                            str+=`<td>${"${item.qDate}"}</td>`;
                            str+=`<td>${"${item.qHits}"}</td>`;
                            str+=`</tr>`;
                        });

                        $("#listTable tr:gt(0)").remove();
                        $("#listTable tr:eq(0)").after(str);

                    } , //성공했을때 실행할 함수
                    error : function(err){
                        alert(err+"에러 발생했어요.");
                    }  //실패했을때 실행할 함수
                });//ajax끝
            }

                readQuestion();
        });

    </script>
    </script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<!-- /.navbar-collapse -->
</div>
<!-- /.container-fluid -->

<div class="main app form" id="main"><!-- Main Section-->
    <div class="hero-section">
        <div class="container nopadding">
            <div class="col-md-5"><img class="img-responsive wow fadeInUp" data-wow-delay="0.1s"
                                       src="${path}/images/logo1.png" alt="App" id="admin"/></div>
            <div class="col-md-7">
                <div class="hero-content">
                    <h1 class="wow fadeInUp" data-wow-delay="0.1s">궁금한 내용을 물어보세요.</h1>
                    <p class="wow fadeInUp" data-wow-delay="0.2s"> 궁금한 내용을 물어보세요. </p>
                    <div  data-wow-delay="0.3s" id="add">


                        <form name="writeForm" method="post" action="${path}/front?key=elec&methodName=insert"
                              onSubmit='return checkValid()' enctype="multipart/form-data" class="subscribe-form wow zoomIn">

                            <table align="center"  width="600px" border="1" class="member">

                                <tr>
                                    <td width="150" height="20" >
                                        <p align="right"><b><span style=" font-size:9pt;">Category</span></b></p>
                                    </td>

                                    <td><select name="category" class="mail" id="category">
                                        <option disabled selected>Category</option>
                                        <option>iPhone</option>
                                        <option>Watch</option>
                                        <option>AirPods</option>
                                    </select>
                                    </td>
                                </tr>

                                <tr>
                                    <td width="150" height="20">
                                        <p align="right"><b><span style="font-size:9pt;">제목</span></b></p>
                                    </td>
                                    <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="subject" size="50"></span></b></td>
                                </tr>
                                <tr>
                                    <td width="150" height="20">
                                        <p align="right"><b><span style="font-size:9pt;">질문 내용</span></b></p>
                                    </td>
                                    <td width="450" height="20"><b><span style="font-size:9pt;">
		<textarea name="content" cols="50" rows="10" style="width: 400px; height: 250px"></textarea></span></b></td>
                                </tr>

                                <tr align="center">
                                    <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
            <input type="submit" value="글쓰기" id="submit">
        <input type="reset" value="다시쓰기" id="reset"></span></b></td>
                                </tr>
                            </table>

                        </form>


                    </div>
                    <!-- subscribe message -->
                    <div id="mesaj"></div>
                    <!-- subscribe message -->
                </div>
            </div>
        </div>
    </div>
</div>



<!-- Client Section -->


<div class="feature-sub">
    <div class="container">
        <div class="sub-inner">
            <h1 class="wow fadeInUp">Creative Landing App For Your Easy Life! Simple Reliable & Understandable for
                your customers </h1>
            <a href="#" class="btn btn-action wow fadeInUp">Buy now</a></div>
    </div>
</div>

<!-- Footer Section -->
<jsp:include page="../common/footer.jsp"/>
</div>

<!-- Scroll To Top -->

<a id="back-top" class="back-to-top page-scroll" href="#main"> <i class="ion-ios-arrow-thin-up"></i> </a>

<!-- Scroll To Top Ends-->

</div>
<!-- Main Section -->
</div>
<!-- Wrapper-->


</body>
</html>
