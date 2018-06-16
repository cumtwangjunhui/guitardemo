<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>guitar</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-reboot.css" />
<link rel="stylesheet" href="css/bootstrap-reboot.min.css" />
<link rel="stylesheet" href="css/bootstrap-grid.css" />
<link rel="stylesheet" href="css/bootstrap-grid.min.css" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.js"></script>
</head>
<body>
<div>
	<div class="text-center">
		<label style="text-align: center;font-size: 30px;font-family: 微软雅黑">GUITAR</label>
	</div>
</div>
<form method="post" action="guitarserach">
	<div class="row" style="margin-top: 30px">
		<div class="col-md-2 text-center">
			<label >输入查询:</label>
		</div>
		<div class="input-group col-md-4">
			<select class="form-control" name="StringNumber">
				<option value="0">请选择查询条件</option>
				<option value="1">Builder</option>
				<option value="2">Model</option>
				<option value="3">Type</option>
				<option value="4">BackWood</option>
				<option value="5">TopWood</option>
			</select>
		</div>
	
		<div class="input-group col-md-4">
		  <input type="text" class="form-control" placeholder="请输入" aria-describedby="basic-addon1" name="guitarSpec">
		</div>
		<div class=" col-md-2">
		  <input type="submit"   class="btn btn-success" value="查询" />
		</div>
	</div>
</form>

<div class="row" style="margin-top: 50px;">
	<div class="col-md-12 row" >
		<div class="col-md-2 text-center">查询结果:</div>
	</div>
		<div class="col-md-12 text-center">
			<div class="row ">
				<div class="col-md-2"> </div>
				<div class="col-md-1">Model</div>
				<div class="col-md-1">Builder</div>
				<div class="col-md-1">Type</div>
				<div class="col-md-1">BackWood</div>
				<div class="col-md-1">TopWood</div>
				<div class="col-md-1">Number</div>
				<div class="col-md-1">Price</div>
				<div class="col-md-3"> </div>
			</div>
			<div class="row">
				<c:forEach items="${requestScope.guitarSerach }" var="guitarSerach">
					<div class="col-md-2"> </div>
		            <div class="col-md-1">${guitarSerach.model}</div>
					<div class="col-md-1">${guitarSerach.builder}</div>
					<div class="col-md-1">${guitarSerach.type}</div>
					<div class="col-md-1">${guitarSerach.backWood}</div>
					<div class="col-md-1">${guitarSerach.topWood}</div>
					<div class="col-md-1">${guitarSerach.seriaNumber}</div>
					<div class="col-md-1">${guitarSerach.price}</div>
					<div class="col-md-3"> </div>
		        </c:forEach> 
			</div>
		</div>
	
</div>
</body>
</html>