<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>新建bug | cail.cc</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/newmain.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
		<script src="<%=request.getContextPath()%>/js/easyui/jquery.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js" ></script>
	</head>
	<body>
		<table id="dg" title="bug列表" class="easyui-datagrid"></table>
	<div id="dlg" class="easyui-dialog" title="处理bug" 
	 style="width:300px;height:300px;padding:10px"  data-options="resizable:true,closed:true,modal:true">
	</div>
	<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({
			width:500,
		    url: '<%=request.getContextPath()%>/user/bugList.do',
		    method: 'get',
		    idField: 'id',
		    fitColumns:true,
		    singleSelect:true,
		    striped:true,
		    pagination: true,
		    toolbar:toolbar,
		    pageSize: 10,
		    pageList: [10, 20, 50, 100, 150, 200],
		    loadFilter:function(data){
		    	if(data.errorCode==200){
		    		return data.data;
		    	}
		    },
		    columns: [[
				{ field: 'id', title: 'ID' },
		        { field: 'bugTitle', title: '标题' },
		        { field: 'bugLevel', title: '紧急程度',sortable:true },
		        { field: 'bugCreate', title: '创建人' },
		        { field: 'bugAssign', title: '当前人' },
		        { field: 'action', title: '操作',formatter:function formatOper(val,row,index){  
		            return '<a href="#" onclick="opreate('+index+')">处理</a>';  
		        } }
		    ]]
		});
	});
	</script>
	</body>

</html>