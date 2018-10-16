<%--
  Created by IntelliJ IDEA.
  User: oditha
  Date: 7/6/18
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
﻿<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Sign In | Unique Creations</title>
    <!-- Favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Sweetalert Css -->
    <link href="${pageContext.request.contextPath}/plugins/sweetalert/sweetalert.css" rel="stylesheet" />
    <!-- Sweet Alert Plugin Js -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <!-- Waves Effect Css -->
    <link href="${pageContext.request.contextPath}/plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="${pageContext.request.contextPath}/plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>

<body class="login-page" style="background-color: #1c81da; ">
<div class="login-box">
    <div class="logo">
        <img src="/images/logo.svg" alt="">
        <%--<a href="javascript:void(0);">Admin<b>BSB</b></a>--%>
        <%--<small>Unique ERP Solutions</small>--%>
    </div>
    <div class="card">
        <div class="body">
            <form id="sign_in">
                <div class="msg">Sign in to start your session</div>
                <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                    <div class="form-line">
                        <input type="text" class="form-control required" name="username" placeholder="Username" required autofocus id="username">
                    </div>
                </div>
                <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                    <div class="form-line">
                        <input type="password" class="form-control required" name="password" placeholder="Password" required id="password">
                    </div>
                </div>
                <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                    <div class="form-line">
                        <input type="password" class="form-control required" name="password2" placeholder="Confirm" required id="password2">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-block bg-pink waves-effect" type="button" id="signin">SIGN UP</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>




<!-- Jquery Core Js -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>

<!-- Bootstrap Core Js -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.js"></script>

<!-- Waves Effect Plugin Js -->
<script src="${pageContext.request.contextPath}/plugins/node-waves/waves.js"></script>

<!-- Validation Plugin Js -->
<script src="${pageContext.request.contextPath}/plugins/jquery-validation/jquery.validate.js"></script>

<!-- Custom Js -->
<script src="${pageContext.request.contextPath}/js/admin.js"></script>
<script src="${pageContext.request.contextPath}/js/pages/examples/sign-in.js"></script>

<!-- JQuery Steps Plugin Js -->
<script src="${pageContext.request.contextPath}/plugins/jquery-steps/jquery.steps.js"></script>

<!-- Sweet Alert Plugin Js -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<%----CustomJS Start----%>

<script src="${pageContext.request.contextPath}/js/customescripts/SignUp.js"></script>

<%----CustomJS End ----%>

<jsp:include page="/includes/modals/StartUpModel.jsp" />


</body>

</html>
