<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>bug列表 | www.cail.cc</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/newmain.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
		<script src="<%=request.getContextPath()%>/js/easyui/jquery.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js" ></script>
	</head>
	<body>
		<table id="dg" title="bug列表" class="easyui-datagrid"></table>
		<div id="dlg2" class="easyui-dialog" title="查看bug" 
	 style="width:500px;height:500px;padding:10px"  data-options="resizable:true,closed:true,modal:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>bug标题:</td>
	    			<td><span id="bugTitle"></span></td>
	    		</tr>
	    		<tr>
	    			<td>bug描述:</td>
	    			<td>
	    			<span id="bugDesc"></span>
					</td>
	    		</tr>
	    		<tr>
	    			<td>严重程度:</td>
	    			<td><span id="bugLevel"></span></td>
	    		</tr>
	    		<tr>
	    			<td>指派给:</td>
	    			<td>
	    			<span id="assignName"></span></td>
	    		</tr>
	    		<tr>
	    			<td>处理过程:</td>
	    			<td>
	    				<ul class="bugLogs">
	    					
	    				</ul>
	    			</td>
	    		</tr>
				<!-- <tr>
					<td colspan="2"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a></td>
				</tr> -->
	    	</table>
	</div>
	<div id="dlg" class="easyui-dialog" title="处理bug" 
	 style="width:500px;height:500px;padding:10px"  data-options="resizable:true,closed:true,modal:true">
	 	<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>bug标题:</td>
	    			<td>
	    			<input class="easyui-textbox  cl-width-300" type="text" name="bugTitle" data-options="disabled:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>bug描述:</td>
	    			<td>
					<textarea rows=5 name="bugDesc" class=" cl-width-300" disabled></textarea>
					</td>
	    		</tr>
	    		<tr>
	    			<td>严重程度:</td>
	    			<td><select class="easyui-combobox" data-options="editable:false,disabled:true" id="creater" name="bugLevel">
						<option value="1">一般</option>
						<option value="2">紧急</option>
						<option value="3">火急</option>
					</select></td>
	    		</tr>
	    		<tr>
	    			<td>指派给:</td>
	    			<td><input class="easyui-textbox" data-options="disabled:true"  name="assignName" /></td>
	    		</tr>
	    		<tr>
	    			<td>处理过程:</td>
	    			<td>
	    				<ul class="bugLogs">
	    					
	    				</ul>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>备注：</td>
	    			<td>
	    			<input type="hidden" name="bugId" id="bugId"/>
	    			<input type="hidden" name="updateId" value="${userId }"/>
	    			<textarea rows=3 name="opRemark" class="cl-width-300"></textarea><br>
	    			<shiro:hasRole name="tester">
	    			<select class="easyui-combobox" data-options="editable:false" name="operation">
	    				<option value="未解决">未解决</option>
	    				<option value="关闭">关闭</option>
	    			</select>
    					 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
    				</shiro:hasRole>
    				<shiro:hasRole name="dev">
	    			<select class="easyui-combobox" data-options="editable:false"  name="operation">
	    				<option value="不予处理">不予处理</option>
	    				<option value="已修正">已修正</option>
	    			</select>
    					 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
    				</shiro:hasRole>
	    			</td>
	    		</tr>
				<!-- <tr>
					<td colspan="2"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a></td>
				</tr> -->
	    	</table>
	    </form>
	</div>
	<script type="text/javascript">
	Date.prototype.format = function (format) {  
	    var o = {  
	        "M+": this.getMonth() + 1, // month  
	        "d+": this.getDate(), // day  
	        "h+": this.getHours(), // hour  
	        "m+": this.getMinutes(), // minute  
	        "s+": this.getSeconds(), // second  
	        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter  
	        "S": this.getMilliseconds()  
	        // millisecond  
	    }  
	    if (/(y+)/.test(format))  
	        format = format.replace(RegExp.$1, (this.getFullYear() + "")  
	            .substr(4 - RegExp.$1.length));  
	    for (var k in o)  
	        if (new RegExp("(" + k + ")").test(format))  
	            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
	    return format;  
	}
	
	
	function formatOper(value,row,index){ 
    	if (value == null || value == '') {  
            return '';  
        }  
        var dt;  
        if (value instanceof Date) {  
            dt = value;  
        } else {  
            dt = new Date(value);  
        }  
        return dt.format("yyyy-MM-dd hh:mm:ss");
    	}
    
		$('#dg').datagrid({
		    url: '<%=request.getContextPath()%>/bug/bug_list.do',
		    method: 'get',
		    idField: 'id',
		    fitColumns:true,
		    singleSelect:true,
		    striped:true,
		    pagination: true,
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
		        { field: 'bugLevel', title: '紧急程度',formatter:function formatOper(val,row,index){  
		        	if(val==1){
			        	   return '一般';
			           }else if(val==2){
			        	   return '紧急';
			           }else if(val==3){
			        	   return '火急';
			           }else{
			        	   return '未知';
			           } 
		        },sortable:true },
		        { field: 'createName', title: '创建人' ,sortable:true },
		        { field: 'createTime', title: '创建时间',formatter:formatOper,sortable:true },
		        { field: 'assignName', title: '当前分配人',sortable:true  },
		        { field: 'assignTime', title: '当前分配时间',formatter:formatOper,sortable:true  },
		        { field: 'bugStatus', title: '当前状态',formatter:function formatOper(val,row,index){  
		           if(val==0){
		        	   return '待开发处理';
		           }else if(val==1){
		        	   return '待测试处理';
		           }else if(val==2){
		        	   return '已关闭';
		           }else{
		        	   return '未知';
		           }
		        },sortable:true  },
		        { field: 'action', title: '操作',formatter:function formatOper(val,row,index){  
		        	
		        	var result = ' <a href="#" onclick="seeBug('+index+')">查看</a> ';
		        	if((row.bugStatus==0&&row.assignId=='${userId}')
		        			||row.bugStatus==1&&row.assignId!='${userId}'){
		        		result +=' | <a href="#" onclick="editBug('+index+')">处理</a> ';
		        	}
		            return result;
		        }  }
		    ]]
		});
		
		function editBug(index){
		    $('#dg').datagrid('selectRow',index);
		    var row = $('#dg').datagrid('getSelected');  
		    if (row){
		    	 $('#dlg').dialog({
			        	iconCls:'icon-edit',
			        	title:'查看Bug'
			        }).dialog('open');
		        $('#ff').form('load',row); 
		        $("#bugId").val(row.id);
		        seeBugLog(row.id);
		    }  
		}
		
		function seeBugLog(id){
			 $.ajax({ 
		        	url: "bug_log_list.do?id="+id,
		        	dataType: "json",
		        	type:"get",
		        	success: function(data){
		        		var logList = data.data.logList;
		        		var lihtmls = '';
		        		for(var i = 0; i<logList.length;i++){
		        			lihtmls+=('<li>'+formatOper(logList[i].updateTime,null,null)+'---'+logList[i].opRemark+'</li>');
		        		}
		        		$(".bugLogs").html(lihtmls);
		          	}
		        });
		}
		
		function seeBug(index){
		    $('#dg').datagrid('selectRow',index);
		    var row = $('#dg').datagrid('getSelected');  
		    if (row){
		    	 $('#dlg2').dialog({
			        	iconCls:'icon-edit'
			        }).dialog('open');
		        $("#bugTitle").text(row.bugTitle);
		        $("#bugDesc").text(row.bugDesc);
		        if(row.bugLevel==1){
			        $("#bugLevel").text('一般');
		        }else if(row.bugLevel==2){
			        $("#bugLevel").text('紧急');
		        }else if(row.bugLevel==3){
			        $("#bugLevel").text('火急');
		        }
		        $("#assignName").text(row.assignName);
		        seeBugLog(row.id);
		    }  
		}
		
		function submitForm(){
			$("#ff").ajaxSubmit({
				url:'op_bug.do',
				type:'post',
				dataType:'json',
				beforeSubmit:function(){
					return $("#ff").form('enableValidation').form('validate');
				},
				success:function(data){
					if(data.errorCode==200){
						$('#dlg').dialog('close');
						alert("成功");
						 $('#dg').datagrid('reload');
					}else{
						alert(data.errorMsg);
					}
				}
		});
		}
	</script>
	</body>

</html>