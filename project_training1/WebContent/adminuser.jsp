<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.entity.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ustora Demo</title>
    
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="/project_training1/css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/project_training1/css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="/project_training1/css/owl.carousel.css">
    <link rel="stylesheet" href="/project_training1/style.css">
    <link rel="stylesheet" href="/project_training1/css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="/project_training1/admin.jsp"><i class="fa fa-user"></i> admin</a></li>
                            <li><a href="#"><i class="fa fa-heart"></i> 收藏</a></li>
                            <li><a href="/project_training1/cart.jsp"><i class="fa fa-user"></i> 购物车</a></li>
                            <li><a href=""><i class="fa fa-user"></i> 查看</a></li>
                            <li><a href="/project_training1/register.jsp"><i class="fa fa-user"></i> 注册</a></li>
                            <li><a href="/project_training1/login.jsp"><i class="fa fa-user"></i> 登录</a></li>
                            <li><a href=""><i class="fa fa-user"></i> 当前用户：${user.name}</a></li>
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">货币 :</span><span class="value">美元 </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">美元</a></li>
                                    <li><a href="#">INR</a></li>
                                    <li><a href="#">英镑</a></li>
                                </ul>
                            </li>

                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">语言 :</span><span class="value">汉语 </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">汉语</a></li>
                                    <li><a href="#">法语</a></li>
                                    <li><a href="#">英语</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->
    
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href=""><img src="/project_training1/img/logo.png"></a></h1>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End site branding area -->
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Admin User</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
	<div class="container">
	<br>
		<table border="1">
			<th width="200px" height="60px">姓名</th>
			<th width="200px">密码</th>
			<th width="300px">email地址</th>
			<th width="200px">删除</th>
			<c:forEach items="${userlist}" var="u">
				<tr>
					<td>${u.name }</td>
					<td>${u.password }</td>
					<td>${u.address }</td>
					<td><a href="${ctx}/admin/deleteuser?address=${u.address}"><span>删除</span></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
    <br><br><br><br><br><br><br><br><br><br>
        <div class="footer-top-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="footer-about-us">
                        <h2>u<span>Stora</span></h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis sunt id doloribus vero quam laborum quas alias dolores blanditiis iusto consequatur, modi aliquid eveniet eligendi iure eaque ipsam iste, pariatur omnis sint! Suscipit, debitis, quisquam. Laborum commodi veritatis magni at?</p>
                        <div class="footer-social">
                            <a href="#" target="_blank"><i class="fa fa-facebook"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-twitter"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-youtube"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
                        </div>
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">用户导航</h2>
                        <ul>
                            <li><a href="#">我的账单</a></li>
                            <li><a href="#">订单历史</a></li>
                            <li><a href="#">收藏</a></li>
                            <li><a href="#">供应商联系</a></li>
                            <li><a href="#">首页</a></li>
                        </ul>                        
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">分类</h2>
                        <ul>
                            <li><a href="#">移动电话</a></li>
                            <li><a href="#">家庭accesseries</a></li>
                            <li><a href="#">LED TV</a></li>
                            <li><a href="#">电脑</a></li>
                            <li><a href="#">Gadets</a></li>
                        </ul>                        
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-newsletter">
                        <h2 class="footer-wid-title">通讯</h2>
                        <p>注册我们的通讯，并获得独家优惠，你不会找到其他地方直接到您的收件箱！</p>
                        <div class="newsletter-form">
                            <form action="#">
                                <input type="email" placeholder="Type your email">
                                <input type="submit" value="订阅">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
    
    <!-- End footer top area -->
    <div class="footer-bottom-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="copyright">
                        <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="footer-card-icon">
                        <i class="fa fa-cc-discover"></i>
                        <i class="fa fa-cc-mastercard"></i>
                        <i class="fa fa-cc-paypal"></i>
                        <i class="fa fa-cc-visa"></i>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End footer bottom area -->
   
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="/project_training1/js/owl.carousel.min.js"></script>
    <script src="/project_training1/js/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="/project_training1/js/jquery.easing.1.3.min.js"></script>
    
    <!-- Main Script -->
    <script src="/project_training1/js/main.js"></script>
    
    <!-- Slider -->
    <script type="text/javascript" src="/project_training1/js/bxslider.min.js"></script>
	<script type="text/javascript" src="/project_training1/js/script.slider.js"></script>
  </body>
</html>
</body>
</html>