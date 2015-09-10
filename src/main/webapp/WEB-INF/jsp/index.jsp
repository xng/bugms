<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>bugms | cail.cc</title>
		<link rel="stylesheet" href="css/newmain.css" />
		<link rel="stylesheet" href="js/easyui/themes/default/easyui.css" />
		<script src="js/easyui/jquery.min.js" type="text/javascript"></script>
		<script src="js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/newmain.js" ></script>
	</head>
	<body class="easyui-layout">
		<div data-options="region:'north',border:false" class="yk-head">
			<span class="yk-logo"><img src="images/cail.png"/></span>
			<span class="yk-usermark">当前用户：${user.userName}</span>
		</div>
		<div data-options="region:'west',split:true,title:'导航菜单'" class="yk-nav">
			<div id="nav" class="easyui-accordion" fit="true" border="false">
				
					<ul  class="easyui-tree">
					<c:forEach items="${menus}" var="menu" varStatus="status">
						<li>
							<a href="#" onclick="addTab('${menu.menuName}','${menu.menuUrl}')">${menu.menuName}</a>
						</li>
					</c:forEach>
					</ul>
			</div>
		</div>
		<div data-options="region:'center'">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
			</div>
		</div>
		
	</div>
	</body>

</html>
