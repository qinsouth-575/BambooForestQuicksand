//图片前后摆动
$(function() {
	var page = 1;
	var i = 6; //每版放6个图片
	//向后 按钮
	$("span.next").click(function() { //绑定click事件
		var $parent = $(this).parents("div.sListPic"); //根据当前点击元素获取到父元素
		var $sListPic = $parent.find("div.v_content_list"); //寻找到“视频内容展示区域”
		var $v_content = $parent.find("div.v_content"); //寻找到“视频内容展示区域”外围的DIV元素
		var v_width = $v_content.width() - 8;
		var len = $sListPic.find("li").length;
		var page_count = Math.ceil(len / i); //只要不是整数，就往大的方向取最小的整数
		if(!$sListPic.is(":animated")) { //判断“视频内容展示区域”是否正在处于动画
			if(page == page_count) { //已经到最后一个版面了,如果再向后，必须跳转到第一个版面。
				$sListPic.animate({
					left: '4px'
				}, "slow"); //通过改变left值，跳转到第一个版面
				page = 1;
			} else {
				$sListPic.animate({
					left: '-=' + v_width
				}, "slow"); //通过改变left值，达到每次换一个版面
				page++;
			}
		}
		$parent.find("span").eq((page - 1)).addClass("current").siblings().removeClass("current");
	});
	//往前 按钮
	$("span.prev").click(function() {
		var $parent = $(this).parents("div.sListPic"); //根据当前点击元素获取到父元素
		var $sListPic = $parent.find("div.v_content_list"); //寻找到“视频内容展示区域”
		var $v_content = $parent.find("div.v_content"); //寻找到“视频内容展示区域”外围的DIV元素
		var v_width = $v_content.width() - 8;
		var len = $sListPic.find("li").length;
		var page_count = Math.ceil(len / i); //只要不是整数，就往大的方向取最小的整数
		if(!$sListPic.is(":animated")) { //判断“视频内容展示区域”是否正在处于动画
			if(page == 1) { //已经到第一个版面了,如果再向前，必须跳转到最后一个版面。
				$sListPic.animate({
					left: '-=' + v_width * (page_count - 1)
				}, "slow");
				page = page_count;
			} else {
				$sListPic.animate({
					left: '+=' + v_width
				}, "slow");
				page--;
			}
		}
		$parent.find("span").eq((page - 1)).addClass("current").siblings().removeClass("current");
	});
	//点击图片置大图
	$(".jqzoom").imagezoom();
	$(".productPicShow .tb-thumb li").live("mouseover", function() {
		//切换样式
		$(this).addClass("current").siblings().removeClass("current");
		//切换放大镜图片
		$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
		$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
	});
	//$("#thumblist li:eq(0)").trigger("click");
	//左右移动功能
	$('.productPicShow .controlDiv .leftBtn').die().live('click', function() {
		$(this).parents("li").prev("li").insertAfter($(this).parents("li"));
	});
	$('.productPicShow .controlDiv .rightBtn').die().live('click', function() {
		if($(this).parents("li").next("li").attr("class").indexOf("addBtn") != -1) {

		} else {
			$(this).parents("li").next("li").insertBefore($(this).parents("li"));
		}
	});
	//删除功能
	$('.productPicShow .controlDiv .delBtn').die().live('click', function() {
		/*var imgId = $(this).attr("value");
		//console.log(imgId);	获取图片id正常
		for (var i = 0; i < imgListX.length; i++) {
        	if (imgListX[i].imgId == imgId) {
            	imgListX.splice(i, 1);	//从图片列表中删除
           	}
      	}			这里的代码不能用了 
		console.log("图片列表" + JSON.stringify(imgListX));*/	//删除后打印图片列表的信息 - 正常
		$(this).parents("li").remove();		//删除父级》父级 li标签
		
		if($(".productPicShow .tb-thumb li").size() == 1) {
			$(".jqzoom").attr('src', "/picture/uploadimg150_150.jpg");
			$(".jqzoom").attr('rel', "/picture/uploadimg150_150.jpg");
		}
	});
	//点击上传图片
	$("#addProductPicBtn").live('click', function() {
		if($("#thumblist li").size() > 12)
			alert("error: 最多只能上传12张图片");
	});
	
	var uploadProductId = 0;
	//点击事件，打开文件选择框的同时判断一次已上传照片是否大于十二张
	$("#uploadImgFile").on("click", function(){
		console.log("#uploadImgFile - click - Start - #thumblist li.size：" + $("#thumblist li").size());
		
		if($("#thumblist li").size() >= 12) {
			alert("error: 最多只能上传12张图片");
		}
	});
	
	var imgListX = [];
	//值变更事件，上传图片
	$("#uploadImgFile").on("change", function(){
		console.log("#uploadImgFile - change - Start");
		var cur = $("#uploadImgFile");		//file文件域
		var v = cur.val();	//上传文件的名字
		var ext = v.substring(v.lastIndexOf("."));
		var fileName = v.substring(v.lastIndexOf("\\")+1); 
		
		for (var i = 0; i < imgListX.length; i++) {
        	if (imgListX[i].imgPath.indexOf(fileName, 0) != -1) {
            	alert("此文件已上传，不可重复操作！");
 				return false;
           	}
      	}
		
		if(ext != ".jpg" && ext != ".png" && ext != ".gif" && ext != ".jpeg" && ext != ".JPG" && ext != ".PNG" && ext != ".GIF" && ext != ".JPEG") { //检查文件格式
			alert("请选择图片，支持的图片格式有：JPG, PNG, GIF, JPEG !");
			cur.val("");
		} else {
			var fileSize = 0;	//文件大小
			var target = document.getElementById("uploadImgFile");
			if(isIE && !target.files) {
				var filePath = target.value;				//FileSystemObject 简称 FSO，文件系统组件。
				var fileSystem = new ActiveXObject("Scripting.FileSystemObject");	//功能太强，在客户端无权限
				var file = fileSystem.GetFile(filePath);
				fileSize = file.Size;
			} else {
				fileSize = target.files[0].size;
			}
			
			var size = fileSize / 1024;
			if(size > 2000) {
				alert("上传的图片大小不能超出2M");
				target.value = "";
				return false;
			}
			
			var newBannerId = "product" + WC.version_time + uploadProductId;
			if($(".productPicShow .tb-thumb li.current").attr("class").indexOf("addBtn") != -1) {
				var HTML = '<li class="" value="">';
						HTML += '<a href="javascript:void(0);" class="imgD">';
							HTML += '<img id="' + newBannerId + '" src="/picture/loading.gif" mid="/picture/loading.gif" big="/picture/loading.gif" pic222_222="/picture/loading.gif">';
						HTML += '</a>';
						HTML += '<div class="controlDiv">';
							HTML += '<a class="leftBtn" href="javascript:void(0);">向左</a>';
							HTML += '<a class="rightBtn" href="javascript:void(0);">向右</a>';
							HTML += '<a class="delBtn" href="javascript:void(0);">删除</a>';
						HTML += '</div>';
					HTML += '</li>';
				$('#productPicShow .tb-thumb li.addBtn').before(HTML);
			} else {
				$("#productPicShow .tb-thumb li.current img").attr("id", newBannerId);
				$("#productPicShow .tb-thumb li.current img").attr("src", "/picture/loading.gif");
				$("#productPicShow .tb-thumb li.current img").attr("mid", "/picture/loading.gif");
				$("#productPicShow .tb-thumb li.current img").attr("big", "/picture/loading.gif");
			}
			// alert(newBannerId);	id正常		alert(uploadProductId);	自增序号标号正常
			uploadProductId++;	//序号自增
			
			var formData = new FormData($("[name=form1]")[0]);
			$.ajax({
				url:"uploadingCommodityImg",
				type:"post",
				data:formData,
				mimeType:"multipart/form-data",
				processData:false,
				contentType:false,
				dataType:"json",
				success:function(res){
					//console.log(res);		返回数据正常
					
					if (res.imgPath != "break") {
						$("#" + newBannerId).attr("src", "/commodity/" + res.imgPath);	//pic
						$("#" + newBannerId).attr("mid", "/commodity/" + res.imgPath);
						$("#" + newBannerId).attr("big", "/commodity/" + res.imgPath);
						$("#" + newBannerId).attr("pic222_222", "/commodity/" + res.imgPath);
						$("#" + newBannerId).parents("li").attr("value", res.imgId);
						
						imgListX.push(res);
					} else {
						alert("新增失败，请重试！");
					}
				}
			});
			//Ajax代码结束
		}
	});
	//文件域change事件结束
});
//uploading.js - 工厂函数结束

$(".directoryBox .comboxText").val("请选择类别");
$(".factoryBox .comboxText").val("请选择供应商");

//设置Cookie
var directoryX = WC.getCookie(userInfo.uid + "shop_add_directory");
if(directoryX) {
	$(".directoryBox .comboxText").attr("comboxval", directoryX.split(",")[0]).val(directoryX.split(",")[1]);
}
var factoryX = WC.getCookie("shop_add_factory");
if(factoryX.split(",")[0]) {
	$(".factoryBox .comboxText").attr("comboxval", factoryX.split(",")[0]).val(factoryX.split(",")[1]);
} else {
	$(".factoryBox .comboxText").attr("comboxval", "自主供应").val("自主供应");
}
//供应商列表 - dropDownBox事件
$(".dropDownBox").live("mouseover", function() {
	$(".dropDownBox_hover").removeClass("dropDownBox_hover");
	$(this).addClass("dropDownBox_hover");
})
$(".dropDownBox").live("mouseleave", function() {
	$(".dropDownBox_hover").removeClass("dropDownBox_hover");
})
//选择商品类别
$(".directoryBox .pannel a").live("click", function() {
	WC.setCookie(userInfo.uid + "shop_add_directory", $(this).attr("comboxval") + "," + $(this).attr("default"), !1);
})
//选择供应商
$(".factoryBox .pannel a").live("click", function() {
	WC.setCookie("shop_add_factory", $(this).attr("comboxval") + "," + $(this).attr("default"), !1);
})

/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////// - Start - color 增删改查  - ///////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////

//添加颜色
$(".productsColorObject .addColorBtn").live("click", function() {
	addColorHTML(0, "", "");
})
$("input[name='checkColor']").live('click', function() {
	if($(this).attr("checked")) {
		addColorHTML($(this).attr("idvalue"), $(this).val(), $(this).attr("imageurl"));
	} else {
		delColorHTML($(this).attr("idvalue"), $(this).val());
	}
});

//删除颜色
$(".uploadProductArea .productsColorList .Delete").live("click", function() {
	delColorHTML($(this).parents("tr").find(".colorInputText").attr("idvalue"), $(this).parents("tr").find(".colorInputText").val());
})

//添加颜色
function addColorHTML(colorid, colorName, url) {
	console.log(colorid + " - " + colorName + " - " + url);
	var n = $("#productsColorList tbody tr").size();
	if(n >= 20) {
		alert("error: 颜色数量不能超过20个!");
		return false;
	}
	$("#productsColorList").append('<tr pic66_66="" pic464_464="" pic="" pic222_222="">' +
										'<td>' +
											'<span class="Num">0</span>' +
											'<span class="NumPoint">.</span>' +
											'<span class="ColorImg ' + url + '"> </span>' +
											'<input type="text" placeholder="颜色名不能为空" viewimageurl="" imageurl="" idvalue="' + colorid + '" value="' + colorName + '" name="" maxlength="15" class="colorInputText">' +
											'<a rel="删除" href="javascript:void(0);" class="Delete">删除</a>' +
										'</td>' +
										'<td>' +
											'<div class="uploadTd">' +
												'<input type="text" class="imageInputText" value="" disabled="disabled" style="background-color:#FAFAFA;">' +
												'<label for="uploadImgFileX" class="btn">上传图片</label>' +
											'</div>' +
										'</td>' +
									'</tr>');
	$('#productsColorList .colorInputText:last').focus();	//将新添加的tr获得焦点
	if($(".productsColorList tbody tr").size() > 0) {
		$(".productsColorList").show();
	}
	//生成数量列表
	setProductNumList();
	
	//颜色文本框离开焦点事件
	$(".colorInputText").on("blur", function(){
		if($(this).val() == "" || $(this).val() == null || $(this).val() == undefined){
			$(this).focus();
		}
	});
}

//删除颜色
function delColorHTML(colorid, colorName) {
	console.log("要删除的颜色id为：" + colorid + "，要删除的颜色名称为：" + colorName);
	$.ajax({
		url:"deleteColor",
		type:"POST",
		data : {
			colorId : colorid
		},
		dataType : "json",
		success:function(res){
			if(res.colorId != "500"){
				/*for (var i = 0; i < colorListX.length; i++) {
		        	if (colorListX[i].colorId == colorid) {
		            	colorListX.splice(i, 1);	//从颜色列表中删除，后会push新的
		           	}
		      	}
				console.log("选中颜色列表：" + JSON.stringify(colorList));*/	//删除后打印颜色列表的信息 - 正常
				
				//取消已选颜色
				$(".chosenColorArea input[name='checkColor']").each(function() {
					if($(this).val() === colorName) {
						$(this).removeAttr("checked");
					}
				})
				//颜色输入框
				$("#productsColorList tbody .colorInputText").each(function() {
					if($(this).val() == colorName) {
						$(this).parents("tr").remove();
					}
				})
				//数量输入框
				$("#productNumList tbody .colorText").each(function() {
					if($(this).attr("colorid") == colorName) {
						$(this).parents("tr").remove();
					}
				})
				//生成数量列表
				setProductNumList();
				//
				if($(".productsColorList tbody tr").size() == 0) {
					$(".productsColorList").hide();
				}
			} else {
				alert(res.colorName);
			}
		}
	});
	//Ajax代码结束
}

//修改颜色
$("#productsColorList .colorInputText").live('keyup', function() {
	var this_ = this;
	var color = {
		colorId : $(this).attr("idvalue"),
		colorName : $(this).val()
	};
	//alert(JSON.stringify(color));		正常
	
	$.ajax({
		url:"insertOrUpdateColorName",
		type:"POST",
		data : JSON.stringify(color),
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success:function(res){
			//alert(JSON.stringify(res));	正常
			if(res.colorId != "500"){
				$(this_).attr("idvalue", res.colorId);
				
				/*for (var i = 0; i < colorListX.length; i++) {
		        	if (colorListX[i].colorId == res.colorId) {
		            	colorListX.splice(i, 1);	//从颜色列表中删除，后会push新的
		           	}
		      	}*/
			} else {
				console.log(res.colorName);
			}
			//alert(JSON.stringify(sizeList));	//数据正常
		}
	});
	//Ajax代码结束
	
	//生成数量列表	
	setProductNumList();
});
//上传颜色图片 
$(".uploadProductArea .productsColorList .uploadTd").live("click", function() {
	$(".colorTableTr").removeClass("colorTableTr");	//删除所有此class
	$(this).parents("tr").addClass("colorTableTr");	//给当前点击上传图片的tr添加colorTableTr类名
});
/*$(".uploadProductArea .colorTable tbody tr").live("mouseover",function(){ 
	$(".colorTableTr").removeClass("colorTableTr");
	$(this).addClass("colorTableTr");
})
$(".uploadProductArea .colorTable tbody tr").live("mouseleave",function(){
	$(".colorTableTr").removeClass("colorTableTr");
})*/

var isIE = /msie/i.test(navigator.userAgent) && !window.opera;	//是否IE浏览器
var uploadImgIdX = 1;
$(function() {
	//点击事件，打开文件选择框的同时判断一次已上传照片是否大于十二张
	$("#uploadImgFileX").on("click", function(){
		console.log("#uploadImgFileX - click - Start");
	});
	
	//值变更事件，上传图片
	$("#uploadImgFileX").on("change", function(){
		console.log("#uploadImgFileX - change - Start");
		var cur = $("#uploadImgFileX");		//file文件域
		var v = cur.val();	//上传文件的名字
		var ext = v.substring(v.lastIndexOf("."));
		//var fileName = v.substring(v.lastIndexOf("\\")+1); 
		
		if(ext != ".jpg" && ext != ".png" && ext != ".gif" && ext != ".jpeg" && ext != ".JPG" && ext != ".PNG" && ext != ".GIF" && ext != ".JPEG") { //检查文件格式
			alert("请选择图片，支持的图片格式有：JPEG, PNG, GIF !");
			cur.val("");
			return false;
		} else {
			var fileSize = 0;
			var target = document.getElementById("uploadImgFileX");
			if(isIE && !target.files) {	//IE浏览器且~~ 则进入
				var filePath = target.value;
				var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
				var file = fileSystem.GetFile(filePath);
				fileSize = file.Size;
			} else {
				fileSize = target.files[0].size;
			}
			var size = fileSize / 1024;
			if(size > 2000) {
				alert("上传的图片大小不能超出2M");
				target.value = "";
				return
			}
			var newBannerId = "colorTableTr" + WC.version_time + uploadImgIdX;
			$(".colorTableTr .uploadTd").append('<img class="loadingImg" src="/picture/loadingdian.gif">').parents("tr").addClass(newBannerId);
			uploadImgIdX++;
			
			var formData = new FormData($("[name=form2]")[0]);
			var colorId = $(".colorTableTr .colorInputText").attr("idvalue");
			formData.append("colorId", colorId);
			
			$(".colorTableTr").removeClass("colorTableTr");
			$.ajax({
				url:"uploadingColorImg",
				type:"post",
				data:formData,
				mimeType:"multipart/form-data",
				processData:false,
				contentType:false,
				dataType:"json",
				success:function(res){
					console.log(res);		//返回数据正常
					
					if (res.colorId != "500") {
						/*for (var i = 0; i < colorListX.length; i++) {
				        	if (colorListX[i].colorId == res.colorId) {
				            	colorListX.splice(i, 1);	//从颜色列表中删除，后会push新的
				           	}
				      	}*/
						
						$("." + newBannerId).find(".imageInputText").val("localhost:8080/color/" + res.colorPrcture);
						$("." + newBannerId).find(".loadingImg").remove();
					} else {
						alert(res.colorName);
					}
				}
			});
			//Ajax代码结束
		}
	});
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////// - End - color 增删改查  - ///////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////// - Start - size 增删改查  - ///////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////

//选择尺码
$(".fdColor li").live('click', function() {
	var CN = $(this).attr("class");
	if($(this).attr("class") == "selected") {
		$(this).removeClass("selected");
	} else {
		$(this).addClass("selected");
	}
	//生成数量列表
	setProductNumList();
})
//发布商品 - 编辑尺码事件
var hadChoiceSize = "";
$("#productsSizeList .editSizeBtn").live("click", function() {
	var HTML = '';
	$(".fdColor li a").each(function() {
		HTML += '<li>' + 
					'<input type="text" name="product_size" idvalue="' + $(this).attr("value") + '" value="' + $(this).html() + '" maxlength="8">' + 
					'<a href="javascript:void(0);" class="delBtn"></a>' + 
				'</li>';
	});
	HTML += '<li class="add_li">' + 
				'<a href="javascript:void(0);" class="addBtn">添加尺码</a>' + 
			'</li>';
	$("#editProductsSizeList ul").html(HTML);
	
	$("#productsSizeList").hide();
	$("#editProductsSizeList").show();
	
	$("#productsSizeList .selected").each(function() {
		if(hadChoiceSize == "") {
			hadChoiceSize += $(this).attr("title");
		} else {
			hadChoiceSize += "," + $(this).attr("title");
		}
	});
});
//取消编辑尺码
$("#editProductsSizeList .cancelBtn").live("click", function() {
	$("#productsSizeList").show();
	$("#editProductsSizeList").hide();
});
//选中输入尺码
$("input[name='product_size']").live("focus", function() {
	$(this).select();
});
//删除尺码
$(".editColor .delBtn").live("click", function() {
	if($("input[name='product_size']").size() == 1) {
		alert("error: 至少保留一个尺码!");
		return false;
	}
	
	var this_ = this;
	var sizeId = $(this).prev().attr("idvalue");
	//alert(sizeId);
	$.ajax({
		url:"deleteSize",
		type:"DELETE",
		data : {
			sizeId : sizeId
		},
		dataType : "json",
		success:function(res){
			//alert(JSON.stringify(res));	//正常
			if(res.sizeId != "500"){
				$(this_).parents("li").remove();	//删除 #editProductsSizeList中的尺码
				
				//重新查询并绑定
				$.ajax({
					url:"querySizeList",
					type:"get",
					dataType : "json",
					success:function(res){
						sizeListC = res;	//JSON.parse(res);
						
						var $li = $("#productsSizeList>ul>li");
						for(var i = 0; i < $li.length; i++){
							//alert($($li[i]).text() + " - " + $($li[i]).find("a").attr("value"));
							if($($li[i]).find("a").attr("value") == sizeId){
								$($li[i]).remove();
							}
						}
						/*$("#productsSizeList>ul").html('');
						for(var i = 0; i < sizeListC.length; i++){
							var $li = $("<li class='' title='" + sizeListC[i].sizeName + "'>" +
											"<a href='javascript:void(0);' value='" + sizeListC[i].sizeId + "'>" + sizeListC[i].sizeName + "</a><i></i>" +
										"</li>");
							$("#productsSizeList>ul").append($li);
						}
						
						productSizeBlur();	//绑定失去焦点事件*/

						//生成数量列表
						setProductNumList();
					}
				});
				//Ajax代码结束
			} else  {
				alert(res.sizeName);
			}
		}
	});
	//Ajax代码结束
})
//增加尺码 - 按钮事件
$(".editColor .addBtn").live("click", function() {
	var n = $("input[name='product_size']").size();
	if(n >= 20) {
		alert("error: 尺码数量不能超过20个!");
		return false;
	}
	//判断是否存在空
	var $thisVal = $("input[name='product_size']:last").val().replace(/\s/g, "");
	if($thisVal == "") {
		$("input[name='product_size']:last").val("").focus();
		alert("error: 请输入尺码名称!");
		return false;
	}
	//是否存在尺码
	var flag_size = 0;
	$("input[name='product_size']").each(function() {
		if($(this).val() == $thisVal) {
			flag_size++;
		}
	})
	if(flag_size > 1) {
		$("input[name='product_size']:last").select();
		alert("error: 尺码名称已存在!");
		return false;
	}
	
	$(".editColor .add_li").before('<li>' +
			'<input type="text" idvalue="" value="" name="product_size">' +
			'<a class="delBtn" href="javascript:void(0);"></a>' +
		'</li>');
	$("input[name='product_size']:last").focus();
	
	productSizeBlur();
})

//编辑框失去焦点事件
function productSizeBlur(){
	$("input[name='product_size']").on("blur", function(){
		var size = {
				sizeId : $(this).attr("idvalue"),
				sizeName : $(this).val()
		};
		if(size.sizeId == null || size.sizeId == ""){
			size.sizeId = 0;
		}
		
		var this_ = this;
		//console.log(JSON.stringify(size));
		$.ajax({
			url:"insertOrUpdateSize",
			type:"POST",
			data : JSON.stringify(size),
			contentType : "application/json;charset=utf-8",
			dataType : "json",
			success:function(res){
				//alert(JSON.stringify(res));	正常
				if(res.sizerId != "500"){
					if(res.sizeId == "501"){
						alert(res.sizeName);
						//状态码等于501，则
						$(this_).parents("li").remove();
						return false;
					}
					
					var $li = $("<li class='' title='" + res.sizeName + "'>" +
									"<a href='javascript:void(0);' value='" + res.sizeId + "'>" + res.sizeName + "</a><i></i>" +
								"</li>");
					$("#productsSizeList>ul").append($li);
				} else {
					alert(res.sizeName);
				}
				//alert(JSON.stringify(sizeList));	//数据正常
			}
		});
		//Ajax代码结束
	});
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////// - End - size 增删改查  - ///////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////

//生成数量列表
function setProductNumList() {
	
	//colorListX = [];
	//sizeListX = [];
	//commodityMain.commodityDetails = [];

	//存在尺码
	var sizeIsEmpty = true;
	$("#productsSizeList .selected").each(function() {
		if($(this).attr("title") != "") sizeIsEmpty = false;
		
		//sizeListX.push($(this).find("a").attr("value"));	第1种办法
	})

	//存在颜色
	var colorIsEmpty = true;
	$("#productsColorList .colorInputText:visible").each(function() {
		if($(this).val() != "") colorIsEmpty = false;

		//colorListX.push($(this).attr("idvalue"));			第1种办法
	})
	
	//存在尺码\颜色
	if(!sizeIsEmpty && !colorIsEmpty) {

		var HTML = '';
		$("#productsSizeList .selected").each(function() {
			var this_ = this;
			var sizeid = $(this).attr("title");
			sizeid = clearClassName(sizeid);
			if(sizeid) {
				$("#productsColorList .colorInputText:visible").each(function() {
					var colorid = $(this).val();
					colorid = clearClassName(colorid);
					if(colorid) {
						if($("#productNumList tbody ." + sizeid + colorid).size() == 0) {
							sizeIdX = $(this_).find("a").attr("value");
							colorIdX = $(this).attr("idvalue");
							
							$("#productNumList tbody ." + sizeid + colorid).remove();
							HTML += '<tr class="' + sizeid + colorid + '">' + 
										'<td>' + itselfClassName(sizeid) + '/' + itselfClassName(colorid) + '</td>' + 
										'<td>' + 
											'<input type="text" name="productnum" sizeid="' + sizeid + '" colorid="' + colorid + '" class="colorText" value="0" sizeIdX="' + sizeIdX + '" colorIdX = "' + colorIdX + '">' + 
										'</td>' + 
										'<td>' + 
											'<input type="text" name="barcode" class="barcodeText" value="" maxlength="20">' + 
										'</td>' + 
									'</tr>';
							
							/*var commodityDetail = {
									cdId : 0,
									cmId : 0,
									sizeId : $(this_).find("a").attr("value"),
									colorId : $(this).attr("idvalue"),
									quantity : 0,
									barCode : ""
							}
							alert(JSON.stringify(commodityDetail));
							commodityMain.commodityDetails.push(commodityDetail);*/
						}
					}
				})
				//内层循环
			}
		})
		//外层循环
		$("#productNumList tbody").append(HTML);
		$("#productNumList thead th:eq(0)").html("尺码/颜色");

	} else if(!sizeIsEmpty) { //仅存在尺码

		var HTML = '';
		$("#productsSizeList .selected").each(function() {
			var sizeid = $(this).attr("title");
			if(sizeid) {
				sizeid = clearClassName(sizeid);
				if($("#productNumList tbody ." + sizeid).size() == 0) {
					sizeIdX = $(this_).find("a").attr("value");
					colorIdX = "";
					
					HTML += '<tr class="' + sizeid + '">' + 
								'<td>' + itselfClassName(sizeid) + '</td>' + 
								'<td>' + 
									'<input type="text" value="0" class="colorText" colorid="" sizeid="' + sizeid + '" name="productnum" sizeIdX="' + sizeIdX + '" colorIdX = "' + colorIdX + '">' + 
								'</td>' + 
								'<td>' + 
									'<input type="text" name="barcode" class="barcodeText" value="" maxlength="20">' + 
								'</td>' + 
							'</tr>';
				}
			}
		})
		$("#productNumList tbody").append(HTML);
		$("#productNumList thead th:eq(0)").html("尺码");

	} else if(!colorIsEmpty) { //仅存在颜色

		var HTML = '';
		$("#productsColorList .colorInputText:visible").each(function() {
			var colorid = $(this).val();
			if(colorid) {
				colorid = clearClassName(colorid);
				if($("#productNumList tbody ." + colorid).size() == 0) {
					sizeIdX = "";
					colorIdX = $(this).attr("idvalue");
					
					HTML += '<tr class="' + itselfClassName(colorid) + '">' +
								'<td>' + $(this).val() + '</td>' + 
								'<td>' + 
									'<input type="text" value="0" class="colorText" colorid="' + colorid + '" sizeid="" name="productnum" sizeIdX="' + sizeIdX + '" colorIdX = "' + colorIdX + '">' + 
								'</td>' + 
								'<td>' + 
									'<input type="text" name="barcode" class="barcodeText" value="" maxlength="20">' + 
								'</td>' + 
							'</tr>';
				}
			}
		})
		$("#productNumList tbody").append(HTML);
		$("#productNumList thead th:eq(0)").html("颜色");

	}

	//清除没有选择的尺码
	var sizeFlag = 1;
	$(".productNumList tbody .colorText").each(function() {
		var sizeid = $(this).attr("sizeid");
		sizeFlag = 0;
		if($("#productsSizeList .selected").size() == 0) {
			if(sizeid != "") {
				$(this).parents("tr").remove();
			}
		} else {
			$("#productsSizeList .selected").each(function() {
				//if($(this).val()!=""){
				if($(this).attr("title") == sizeid) {
					sizeFlag = 1;
					return false;
				} else {
					sizeFlag = 0;
				}
				//}
			})
			//alert("sizeFlag:"+sizeFlag);
			if(sizeFlag == 0) $(this).parents("tr").remove();
		}

	})

	//清除没有选择的颜色
	var colorFlag = 1;
	$(".productNumList tbody .colorText").each(function(x) {
		var colorid = $(this).attr("colorid");
		colorFlag = 0;
		if($(".uploadProductArea .colorInputText").size() == 0) {
			if(colorid != "") {
				$(this).parents("tr").remove();
			}
		} else {
			$(".uploadProductArea .colorInputText").each(function() {
				//if($(this).val()!=""){alert(x+":"+colorid+"-"+$(this).val());
				if(colorid == $(this).val()) {
					colorFlag = 1;
					return false;
				} else {
					colorFlag = 0;
				}
				//}
			})
			//alert("colorFlag:"+colorFlag);
			if(colorFlag == 0) $(this).parents("tr").remove();
		}
	})
	//1.自动生成条码
	createBarcode();
	//2.设置列表数量
	productsColorListNum();
	//3.设置原来数量、条形码
	setNumBarcode();
	//4.设置库存总数
	setProductsTotalNum();
}

//1.自动生成条形码barcode
var timeText = 0;
function createBarcode() {
	var d = new Date;
	var releaseYear = d.getFullYear();
	var month = d.getMonth() + 1;
	month = (month < 10 ? "0" + month : month);
	var date = d.getDate();
	date = (date < 10 ? "0" + date : date);
	var hours = d.getHours();
	hours = (hours < 10 ? "0" + hours : hours);
	var minutes = d.getMinutes();
	minutes = (minutes < 10 ? "0" + minutes : minutes);
	var seconds = d.getSeconds();
	seconds = (seconds < 10 ? "0" + seconds : seconds);
	var milliseconds = d.getMilliseconds();
	var time = (releaseYear.toString()).substr(2, 4) + month.toString() + date.toString() + hours.toString() + minutes.toString() + seconds.toString();
	if(timeText > 9) timeText = 0;
	
	$(".productNumList .barcodeText").each(function() {
		if($(this).val() == "") {
			$(this).val(time + timeText);
			
			timeText++;
		}
	})
}

//2.设置列表数量
function productsColorListNum() {
	$(".uploadProductArea .productsColorList .Num").each(function(i) {
		$(this).html(Number(i) + 1);
	})
}

//3.设置原来数量、条形码
function setNumBarcode() {
	var r = $(".productsSizeObject .jsonDiv").html();
	if(r) {
		var data = eval("(" + r + ")");
		for(var i = 0; i < data.length; i++) { //创建列表
			$("#productNumList tbody tr").each(function() {
				if($(this).find("input[name='productnum']").attr("sizeid") == data[i].sizeid && $(this).find("input[name='productnum']").attr("colorid") == data[i].colorid) {
					$(this).find("input[name='productnum']").val(data[i].num);
					$(this).find("input[name='barcode']").val(data[i].barcode);
				}
			})
		}
	}
}

//4.设置库存总数
function setProductsTotalNum() {
	var num = 0;
	$("input[name='productnum']").each(function() {
		if($(this).val() > 0 || isNaN($(this).val())) {
			num += Number($(this).val());
		}
	})
	$("input[name='num_total']").val(num);
}

//数量输入框
$("input[name='productnum']").live("focus", function() {
	if($(this).val() == 0) {
		$(this).val("");
	}
	//设置库存总数
	//setProductsTotalNum();
});

//清除其他字条
function clearClassName(name) {
	name = name.replace(/\//g, 'poso2oA');
	name = name.replace(/\\/g, "poso2oB");
	return name;
}

//原来的
function itselfClassName(name) {
	name = name.replace(/poso2oA/g, '/');
	name = name.replace(/poso2oB/g, '\\');
	return name;
}

$("input[name='productnum']").live('keyup', function(e) {
	$(this).val($(this).val().replace(/[^0-9]/g, ''));
	if($(this).val() < 0 || isNaN($(this).val())) {
		$(this).val(1).select();
	}
	//设置库存总数
	setProductsTotalNum();
}).bind("paste", function() { //CTR+V事件处理    
	$(this).val($(this).val().replace(/[^0-9]/g, ''));
}).css("ime-mode", "disabled"); //CSS设置输入法不可用

$("input[name='productnum']").live("blur", function() {
	if($(this).val() == "" || $(this).val() < 0 || isNaN($(this).val())) {
		$(this).val("0");
	}
	//设置库存总数
	setProductsTotalNum();
});

//数量
$("input[name='num']").live("click", function() {
	$(this).select();
});
$("input[name='num']").live("focus", function() {

});
$("input[name='num']").live('keyup', function(e) {
	var myreg = /^[+]?(([0-9]\d*[.]?)|(0.))(\d{0,2})?$/;
	if($(this).val() < 0 || isNaN($(this).val())) {
		$(this).val(1).select();
	}
}).bind("paste", function() { //CTR+V事件处理    
	var myreg = /^[+]?(([0-9]\d*[.]?)|(0.))(\d{0,2})?$/;
}).css("ime-mode", "disabled"); //CSS设置输入法不可用
$("input[name='num']").live("blur", function() {
	if($(this).val() == "" || $(this).val() < 0 || isNaN($(this).val())) {
		$(this).val("");
	}
});
//吊牌价格、成本价格
$("input[name='price'], input[name='fprice']").live("focus", function() {
	if($(this).val() == "" || $(this).val() == 0 || $(this).val() < 0 || isNaN($(this).val())) {
		$(this).val("");
	}
})
$("input[name='price'], input[name='fprice']").live("blur", function() {
	if($(this).val() == "" || $(this).val() < 0 || isNaN($(this).val())) {
		$(this).val(0);
	}
})
$("input[name='price'], input[name='fprice']").live('keyup', function(event) {
	var myreg = /^[+]?(([0-9]\d*[.]?)|(0.))(\d{0,2})?$/;
	if(!myreg.test(this.value)) {
		this.value = '';
	};
}).bind("paste", function() { //v CTR+V事件处理
	var myreg = /^[+]?(([0-9]\d*[.]?)|(0.))(\d{0,2})?$/;
	if(!myreg.test(this.value)) {
		this.value = '';
	};
}).css("ime-mode", "disabled"); //CSS设置输入法不可用

/*/条形码输入框	
$(".uploadProductArea .productNumList .barcodeText").live("focus",function(){
	if($(this).val()==0){
		$(this).val("");
	}
})
$(".uploadProductArea .productNumList .barcodeText").live("blur",function(){
	if($(this).val()==""){
		$(this).val("0");
	}
})*/

$(function(){
	//岂均：上传商品
	$("#toNewProductBtn").on("click", function() {
		
		//var paramObject = new Object();
		//var commodityMain ;
		
		//商品货号
		commodityMain.articleNo = $("input[name='bh']:visible").val();
		if(commodityMain.articleNo == ""){
			alert("error：请输入商品货号！");
			return false;
		}
		
		//商品品牌 - 不必验证非空
		commodityMain.brand = $("input[name='brand']:visible").val();
	
		//商品名称
		commodityMain.cmName = $("input[name='name']:visible").val();
		if(commodityMain.cmName == "") {
			alert("error：请输入商品名称！");
			return false;
		}
	
		//吊牌价格
		commodityMain.salePrice = $("input[name='price']:visible").val();
		if(commodityMain.salePrice == ""){
			alert("error：请输入吊牌价格！");
			return false;
		}
	
		//成本价格
		commodityMain.costPrice = $("input[name='fprice']:visible").val();
		if(commodityMain.costPrice == "") {
			alert("error：请输入成本价格！");
			return false;
		}
	
		//商品类别
		commodityMain.ctId = $(".directoryBox .comboxText:visible").attr("comboxval");
		if(commodityMain.ctId == "") {
			alert("error：请选择商品类别！");	
			return false;
		}
		
		//商品信息
		commodityMain.information = UM.getEditor('myEditor').getContentTxt();
		
		commodityMain.cdList = [];
		//商品详表数量
		$("#productNumList .colorText").each(function() {
			var commodityDetail = {
					cdId : 0,
					cmId : 0,
					sizeId : $(this).attr("sizeIdX"),
					colorId : $(this).attr("colorIdX"),
					quantity : Number($(this).val()),
					barCode : $(this).parent().next().find("input").val()
			}
			commodityMain.cdList.push(commodityDetail);
		})
		
		//处理商品图片集合
		$("#thumblist li").each(function() {
			if($(this).attr("class").indexOf("addBtn") != -1) {
				//不添加add按钮
			} else {
				var image = new Object();
				image.imgId = $(this).attr("value");
				image.imgPath = $(this).find("img").attr("src");
				commodityMain.imgList.push(image);
			}
		});
		
		//alert(JSON.stringify(commodityMain));
		
		$.ajax({
			url:"insertCommodityMainAndDetail",
			type:"POST",
			data : JSON.stringify(commodityMain),
			contentType : "application/json;charset=utf-8",
			dataType : "json",
			success:function(res){
				//alert(JSON.stringify(res));	正常
				if(res.cmId != "500"){
					window.parent.location.href = "/commodityManager/toPage";
				} else {
					alert(res.cmName);
				}
			}
		});
		//Ajax代码结束
	});

});

$(function() {
	$(".uploadProductArea .fdSize .skuItem .inputText").val("");
	$(".uploadProductArea .productsColorList .colorInputText").val("");
	$("#productsSizeList .J_Checkbox:eq(0)").attr("checked", 'true'); //全选
	$("input[name='checkColor']").removeAttr("checked");
	if(userInfo.shoptype == "1") { //餐饮店
		$(".templetXDiv").show();
	}
})

//反斜杠
$(".colorInputText, input[name='product_size']").live('blur', function(event) {
	if($(this).val().indexOf("\\") != -1) {
		$(this).val($(this).val().replace(/\\/g, ""));
	}
}).bind("paste", function() { //CTR+V事件处理
	if($(this).val().indexOf("\\") != -1) {
		$(this).val($(this).val().replace(/\\/g, ""));
	}
}).css("ime-mode", "disabled"); //CSS设置输入法不可用

//反斜杠
$(".colorInputText, input[name='product_size']").live('keyup', function(event) {
	if($(this).val().indexOf("\\") != -1) {
		$(this).val($(this).val().replace(/\\/g, ""));
	}
}).bind("paste", function() { //CTR+V事件处理
	if($(this).val().indexOf("\\") != -1) {
		$(this).val($(this).val().replace(/\\/g, ""));
	}
}).css("ime-mode", "disabled"); //CSS设置输入法不可用

/* *
 * - 编辑商品
 */	/*
var editProduct = {
	getInfo: function(guid) { //获取商品信息
		var paramObject = new Object();
		paramObject.sessionUid = userInfo.uid;
		paramObject.sessionKey = userInfo.password;
		paramObject.guid = guid;
		var paramJson = jQuery.param(paramObject);
		
		$.ajax({
		type: "POST",
		dataType: "json",
		cache: false,
		url: "/product.htm?Act=info",
		data: paramJson,
		timeout: 20000,
		success: function(datas) {
			if(datas.code.indexOf("success") != -1) {
				var data = datas.data;
				//上传模板
				if(data.ptype == "0") {
					$("input[name='J_radio']:eq(0)").attr("checked", "checked").trigger("click"); //处理事件
				} else {
					$("input[name='J_radio']:eq(1)").attr("checked", "checked").trigger("click"); //处理事件
				}
				//同步至微商城
				if(data.online == "1") {
					$(".synchroListDiv .frm_checkbox_label").addClass("selected");
				} else {
					$(".synchroListDiv .frm_checkbox_label").removeClass("selected");
				}
				//商品货号
				if(data.bh) $("input[name='bh']").val(data.bh);
				//商品名称
				if(data.name) $("input[name='name']").val(data.name);
				//吊牌价格
				if(data.price) $("input[name='price']").val(data.price);
				//成本价格
				if(data.fprice) $("input[name='fprice']").val(data.fprice);
				//商品类别
				if(data.fid) $(".directoryBox .comboxText").attr({
					"comboxval": data.fid
				}).val(data.directory);
				if(data.directory) $(".directoryBox .comboxText").attr({
					"default": data.directory
				}).val(data.directory);

				//default

				//供应商
				if(data.factory) $(".factoryBox .comboxText").attr("comboxval", data.factory).val(data.factoryname);

				if(userInfo.shoptype == "1") { //餐饮店
					//库存总数
					if(data.num) $("input[name='num']").val(data.num);
					//商品条码
					if(data.barcode) $("input[name='barcode']").val(data.barcode);
					//库存数量
					var nums = data.nums;
					var HTMLX = '';
					var CSHTML = '';
					for(var i = 0; i < nums.length; i++) {
						$("input[name='num']").val(nums[i].num);
						$("input[name='barcode']").val(nums[i].barcode);
					}
				} else { //服饰鞋包
					//商品品牌
					if(data.brand) $("input[name='brand']").val(data.brand);

					//尺码
					var sizes = data.sizes;
					//var sizes = eval("("+data.sizes+")");
					var sizeHTML = '';
					var isHad = 0;
					for(var i = 0; i < sizes.length; i++) { //创建列表
						isHad = 0;
						$("#productsSizeList li").each(function() {
							if(sizes[i].sizeid == itselfClassName($(this).attr("title"))) {
								$(this).addClass("selected");
								isHad = 1;
							}
						})
						if(isHad == 0) {
							sizeHTML += '<li class="selected" title="' + clearClassName(sizes[i].sizeid) + '"><a href="javascript:void(0);">' + sizes[i].sizeid + '</a><i></i></li>';
						}

					}
					//if(sizeHTML==''){
					//	sizeHTML+='<li class="" title="均码"><a href="javascript:void(0);">均码</a><i></i></li>';
					//}
					$("#productsSizeList ul").append(sizeHTML);
					//颜色
					var colors = data.colors;
					var colorsHTML = '';
					for(var i = 0; i < colors.length; i++) {
						colorsHTML += '<tr pic66_66="" pic464_464="" pic="" pic222_222=""><td><span class="Num">' + Number(i + 1) + '</span><span class="NumPoint">.</span><span class="ColorImg "> </span><input type="text" placeholder="请输入颜色" viewimageurl="" imageurl="" value="' + colors[i].colorid + '" name="" maxlength="15" class="colorInputText"><a rel="' + colors[i].colorid + '" href="javascript:void(0);" class="Delete">删除</a></td><td><div class="uploadTd"><input type="text" class="imageInputText" value="" disabled="disabled" style="background-color:#FAFAFA;"><label for="uploadImgFileX" class="btn">上传图片</label></div></td></tr>';
						//选中颜色
						$(".chosenColorArea input[name='checkColor']").each(function() {
							if($(this).val() === colors[i].colorid) {
								$(this).attr("checked", 'true'); //全选
							}	
						})
					}
					if(colorsHTML) {
						$("#productsColorList").show();
						$("#productsColorList tbody").html(colorsHTML);
					}
					//颜色图片
					if(data.colorimgs) {
						var colorimgs = eval("(" + data.colorimgs + ")");
						for(var i = 0; i < colorimgs.length; i++) {
							$(".uploadProductArea .colorInputText").each(function() {
								if($(this).val() == colorimgs[i].colorid && colorimgs[i].pic != "") {
									$(this).parents("tr").attr("pic", colorimgs[i].pic);
									$(this).parents("tr").attr("pic66_66", colorimgs[i].pic);
									$(this).parents("tr").attr("pic222_222", colorimgs[i].pic);
									$(this).parents("tr").attr("pic464_464", colorimgs[i].pic);
									$(this).parents("tr").find(".imageInputText").val(colorimgs[i].pic);
									$(this).parents("tr").find(".delBtn").show();
								}
							})
						}
					}
					//库存数量
					var nums = data.nums;
					$(".productsSizeObject .jsonDiv").html($.toJSON(nums));
					var HTMLX = '';
					var CSHTML = '';
					var totalNumInputText = 0;
					for(var i = 0; i < nums.length; i++) {
						if(nums[i].colorid && nums[i].sizeid) {
							CSHTML = nums[i].sizeid + "/" + nums[i].colorid;
						} else if(nums[i].colorid) {
							CSHTML = nums[i].colorid;
						} else {
							CSHTML = nums[i].sizeid;
						}
						HTMLX += '<tr class="' + nums[i].sizeid + nums[i].colorid + '"><td>' + CSHTML + '</td><td><input type="text" value="' + nums[i].num + '" class="colorText" colorid="' + nums[i].colorid + '" sizeid="' + nums[i].sizeid + '" name="productnum"></td><td><input type="text" name="barcode" class="barcodeText" value="' + nums[i].barcode + '" maxlength="20"></td></tr>';
						totalNumInputText += Number(nums[i].num);
					}
					if(HTMLX) {
						$("#productNumList tbody").html(HTMLX);
					}
					$(".totalNumInputText").val(totalNumInputText);
				}
				//imgs
				if(data.imgs) {
					var imgs = eval("(" + data.imgs + ")");
					var imgHTML = '';
					for(var i = 0; i < imgs.length; i++) {
						imgHTML += '<li class="">';
						imgHTML += '<a href="javascript:void(0);" class="imgD">';
						imgHTML += '<img id="' + i + '" src="' + imgs[i].pic + '" mid="' + imgs[i].pic + '" big="' + imgs[i].pic + '" pic222_222="' + imgs[i].pic + '">';
						imgHTML += '</a>';
						imgHTML += '<div class="controlDiv">';
						imgHTML += '<a class="leftBtn" href="javascript:void(0);">向左</a>';
						imgHTML += '<a class="rightBtn" href="javascript:void(0);">向右</a>';
						imgHTML += '<a class="delBtn" href="javascript:void(0);">删除</a>';
						imgHTML += '</div>';
						imgHTML += '<i style="display:none;" class="imgsData"></i>';
						imgHTML += '</li>';
					}
					if(imgs.length > 0) {
						$('#productPicShow .tb-thumb li.addBtn').before(imgHTML);
						//切换样式
						$("#productPicShow .tb-thumb li:eq(0)").addClass("current").siblings().removeClass("current");
						//切换放大镜图片
						$(".jqzoom").attr('src', imgs[0].pic);
						$(".jqzoom").attr('rel', imgs[0].pic);
					}
				}
				//商品信息
				UE.getEditor('JS_Editor').setContent(data.pdesc);
			} else if(datas.code.indexOf("error") != -1) {
				fntopmessagebox(datas.data, 'error');
			}
		},
		error: function() {
			fntopmessagebox("服务器繁忙，稍后再试试。", 'error');
		}
	}).always(function() {
		setTimeout(function() {
			$("#imloadingDialog").remove();
		}, 600);
	});
		
	}
}
*/