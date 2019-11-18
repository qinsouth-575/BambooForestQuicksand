/* *
 * 图片前后摆动
 */
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
	/* *
	 * 点击图片置大图
	 */
	$(".jqzoom").imagezoom();
	$(".productPicShow .tb-thumb li").live("mouseover", function() {
		//切换样式
		$(this).addClass("current").siblings().removeClass("current");
		//切换放大镜图片
		$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
		$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
	});

	//$("#thumblist li:eq(0)").trigger("click");

	/* *
	 * 左右移动功能
	 */
	$('.productPicShow .controlDiv .leftBtn').die().live('click', function() {
		$(this).parents("li").prev("li").insertAfter($(this).parents("li"));
	});
	$('.productPicShow .controlDiv .rightBtn').die().live('click', function() {
		if($(this).parents("li").next("li").attr("class").indexOf("addBtn") != -1) {

		} else {
			$(this).parents("li").next("li").insertBefore($(this).parents("li"));
		}
	});
	$('.productPicShow .controlDiv .delBtn').die().live('click', function() {
		$(this).parents("li").remove();
		if($(".productPicShow .tb-thumb li").size() == 1) {
			$(".jqzoom").attr('src', "http://www.poso2o.com/ECSHOP/style/img/uploadImg150_150.jpg");
			$(".jqzoom").attr('rel', "http://www.poso2o.com/ECSHOP/style/img/uploadImg150_150.jpg");
		}
	});

	/*
	 * 上传图片
	 */
	$("#addProductPicBtn").live('click',function(){

		if($("#thumblist li").size()>12){
			("最多只能上传12张图片",'error');
			return false;
		}
		$("#uploadImgFile").trigger("click"); //处理事件

	})

	$(function() {
		//上传封面图
		$("#uploadImgFile").toUploadImgFile();
	})

	var uploadProductId = 0;
	$.fn.toUploadImgFile = function() {

		if($("#thumblist li").size() > 12) {
			("最多只能上传12张图片", 'error');
			return false;
		}

		var cur = this;
		this.change(function() {
			var v = cur.val();
			var ext = v.substring(v.lastIndexOf("."));
			if(ext != ".jpg" && ext != ".png" && ext != ".gif" && ext != ".jpeg" && ext != ".JPG" && ext != ".PNG" && ext != ".GIF" && ext != ".JPEG") { //检查文件格式
				alert("请选择图片，支持的图片格式有：JPEG, PNG, GIF !");
				cur.val("");
				return false;
			} else {
				var fileSize = 0;
				var target = document.getElementById("uploadImgFile");
				if(isIE && !target.files) {
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
				var newBannerId = "product" + WC.version_time + uploadProductId;
				if($(".productPicShow .tb-thumb li.current").attr("class").indexOf("addBtn") != -1) {
					var HTML = '<li class="">';
					HTML += '<a href="javascript:void(0);" class="imgD">';
					HTML += '<img id="' + newBannerId + '" src="picture/loading.gif" mid="http://www.poso2o.com/WeChat/style/img/loading.gif" big="http://www.poso2o.com/WeChat/style/img/loading.gif" pic222_222="">';
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
					$("#productPicShow .tb-thumb li.current img").attr("src", "http://www.poso2o.com/WeChat/style/img/loading.gif");
					$("#productPicShow .tb-thumb li.current img").attr("mid", "http://www.poso2o.com/WeChat/style/img/loading.gif");
					$("#productPicShow .tb-thumb li.current img").attr("big", "http://www.poso2o.com/WeChat/style/img/loading.gif");
				}
				uploadProductId++;
				cur.wrap('<form enctype="multipart/form-data"/>');
				var options = {
					url: "/productImageService.htm?Act=upload" + "&sessionUid=" + userInfo.uid + "&sessionKey=" + userInfo.password, // 路径写全
					type: "post",
					success: function(r) {
						// 取消form包裹
						cur.unwrap();
						// 此处data可以返回文件ID，然后根据ID查询并返回文件即可
						//cur.after(data);
						var datas = eval("(" + r + ")");
						if(datas.code.indexOf("success") != -1) {
							$("#" + newBannerId).attr("src", datas.data.pic); //pic
							$("#" + newBannerId).attr("mid", datas.data.pic);
							$("#" + newBannerId).attr("big", datas.data.pic);
							$("#" + newBannerId).attr("pic222_222", datas.data.pic);
							$(".jqzoom").attr('src', datas.data.pic);
							$(".jqzoom").attr('rel', datas.data.pic);
							$("#" + newBannerId).parents("li").find(".imgsData").html($.toJSON(datas));
						} else {
							//fntopmessagebox(datas.data,'error');
							alert(datas.data);
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown) {
						alert(textStatus + "," + errorThrown);
						//$(".loading_div").show();
						//$(".loading_div .img_div").removeClass("loading_img");
					}
				};
				cur.parent("form").ajaxSubmit(options); // 异步提交
			}
		})
	}

})

/* *
 * 上传商品 - 同步至微商城
 */
$('.synchroListDiv .frm_checkbox_label').live('click', function() {
	if($(this).attr("class").indexOf("selected") != -1) {
		$(this).removeClass("selected");
	} else {
		$(this).addClass("selected");
	}
});
/* *
 * 上传商品 -  运费设置 按件数
 */
$('.templetXDiv .frm_checkbox_label').live('click', function() {
	$('.templetXDiv .frm_checkbox_label').removeClass("selected");
	if($(this).attr("class").indexOf("selected") != -1) {
		$(this).removeClass("selected");
	} else {
		$(this).addClass("selected");
	}
	if($(this).index() == 2) {
		window.location.href = "http://www.poso2o.com/EntityStore/goods/add.jsp";
	} else {
		window.location.href = "http://www.poso2o.com/EntityStore/goods/setMeal.jsp";
	}
});
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
/* *
 * 供应商列表 - dropDownBox事件
 */
$(".dropDownBox").live("mouseover", function() {
	$(".dropDownBox_hover").removeClass("dropDownBox_hover");
	$(this).addClass("dropDownBox_hover");
})
$(".dropDownBox").live("mouseleave", function() {
	$(".dropDownBox_hover").removeClass("dropDownBox_hover");
})
/* *
 * 选择商品类别
 */
$(".directoryBox .pannel a").live("click", function() {
	WC.setCookie(userInfo.uid + "shop_add_directory", $(this).attr("comboxval") + "," + $(this).attr("default"), !1);
})
/* *
 * 选择供应商 
 */
$(".factoryBox .pannel a").live("click", function() {
	WC.setCookie("shop_add_factory", $(this).attr("comboxval") + "," + $(this).attr("default"), !1);
})
/* *
 *  商品信息 - 类别列表
 */
$(".directoryBox").live('click', function() {
	if($(".directoryList li").size() == 2) {
		getTypeList();
	}
})
//获取类别列表信息
function getTypeList() {
	var paramObject = new Object();
	paramObject.sessionUid = userInfo.uid;
	paramObject.sessionKey = userInfo.password;
	var paramJson = jQuery.param(paramObject);
	$.ajax({
		type: "POST",
		dataType: "json",
		cache: false,
		url: "/directory.htm?Act=list",
		data: paramJson,
		timeout: 20000,
		success: function(datas) {
			if(datas.code.indexOf("success") != -1) {
				var datas = datas.data;
				var HTML = '<li><a comboxval="" default="请选择类别" href="javascript:void(0);">请选择类别</a></li>';
				for(var i = 0; i < datas.length; i++) {
					if(datas[i].fid != "TC") HTML += '<li><a href="javascript:void(0);" default="' + datas[i].directory + '" comboxval="' + datas[i].fid + '">' + datas[i].directory + '</a></li>';
				}
				$(".directoryList").html(HTML);
			} else {
				fntopmessagebox(datas.data, 'error');
			}
		},
		error: function() {
			fntopmessagebox("服务器繁忙，稍后再试试.", 'error');
		}
	}).always(function() {})
}
//getTypeList();

//添加颜色
$(".productsColorObject .addColorBtn").live("click", function() {
	addColorHTML("", "");
})
$("input[name='checkColor']").live('click', function() {
	if($(this).attr("checked")) {
		addColorHTML($(this).val(), $(this).attr("imageurl"));
	} else {
		delColorHTML($(this).val());
	}
});

//删除颜色
$(".uploadProductArea .productsColorList .Delete").live("click", function() {
	delColorHTML($(this).parents("tr").find(".colorInputText").val());
})

//添加颜色
function addColorHTML(colorid, url) {
	var n = $("#productsColorList tbody tr").size();
	if(n >= 20) {
		fntopmessagebox('尺码数量不能超过20个。', 'error');
		return false;
	}
	$("#productsColorList").append('<tr pic66_66="" pic464_464="" pic="" pic222_222=""><td><span class="Num">0</span><span class="NumPoint">.</span><span class="ColorImg ' + url + '"> </span><input type="text" placeholder="请输入颜色" viewimageurl="" imageurl="" value="' + colorid + '" name="" maxlength="15" class="colorInputText"><a rel="删除" href="javascript:void(0);" class="Delete">删除</a></td><td><div class="uploadTd"><input type="text" class="imageInputText" value="" disabled="disabled" style="background-color:#FAFAFA;"><label for="uploadImgFileX" class="btn">上传图片</label></div></td></tr>');
	$('#productsColorList .colorInputText:last').focus();
	if($(".productsColorList tbody tr").size() > 0) {
		$(".productsColorList").show();
	}
	//生成数量列表
	setProductNumList();
}

//删除颜色
function delColorHTML(colorid) {

	//取消已选颜色
	$(".chosenColorArea input[name='checkColor']").each(function() {
		if($(this).val() === colorid) {
			$(this).removeAttr("checked");
		}
	})

	//颜色输入框
	$("#productsColorList tbody .colorInputText").each(function() {
		if($(this).val() == colorid) {
			$(this).parents("tr").remove();
		}
	})

	//数量输入框
	$("#productNumList tbody .colorText").each(function() {
		if($(this).attr("colorid") == colorid) {
			$(this).parents("tr").remove();
		}
	})

	//生成数量列表
	setProductNumList();

	//
	if($(".productsColorList tbody tr").size() == 0) {
		$(".productsColorList").hide();
	}
}

//设置列表数量
function productsColorListNum() {
	$(".uploadProductArea .productsColorList .Num").each(function(i) {
		$(this).html(Number(i) + 1);
	})
}

/* *
 * 修改颜色
 */
$("#productsColorList .colorInputText").live('keyup', function() {
	//生成数量列表
	setProductNumList();
})

/* *
 * 选择尺码
 */
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
/* *
 * 发布商品 - 编辑尺码事件
 */
var hadChoiceSize = "";
$("#productsSizeList .editSizeBtn").live("click", function() {
	var HTML = '';
	$(".fdColor li a").each(function() {
		HTML += '<li><input type="text" name="product_size" value="' + $(this).html() + '" maxlength="8"><a href="javascript:void(0);" class="delBtn"></a></li>';
	})
	HTML += '<li class="add_li"><a href="javascript:void(0);" class="addBtn">添加尺码</a></li>';
	$("#editProductsSizeList ul").html(HTML);
	$("#productsSizeList").hide();
	$("#editProductsSizeList").show();
	$("#productsSizeList .selected").each(function() {
		if(hadChoiceSize == "") {
			hadChoiceSize += $(this).attr("title");
		} else {
			hadChoiceSize += "," + $(this).attr("title");
		}
	})
})
//取消编辑尺码
$("#editProductsSizeList .cancelBtn").live("click", function() {
	$("#productsSizeList").show();
	$("#editProductsSizeList").hide();
})
//选中输入尺码
$("input[name='product_size']").live("focus", function() {
	$(this).select();
})
//删除尺码
$(".editColor .delBtn").live("click", function() {
	if($("input[name='product_size']").size() == 1) {
		fntopmessagebox('至少保留一个尺码。', 'error');
		return false;
	}
	$(this).parents("li").remove();
})
//增加尺码
$(".editColor .addBtn").live("click", function() {
	var n = $("input[name='product_size']").size();
	if(n >= 20) {
		fntopmessagebox('尺码数量不能超过20个。', 'error');
		return false;
	}
	//判断是否存在空
	var $thisVal = $("input[name='product_size']:last").val().replace(/\s/g, "");
	if($thisVal == "") {
		$("input[name='product_size']:last").val("").focus();
		fntopmessagebox('请输入尺码名称。', 'error');
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
		fntopmessagebox('尺码名称已存在', 'error');
		return false;
	}
	$(".editColor .add_li").before('<li><input type="text" maxlength="8" value="" name="product_size"><a class="delBtn" href="javascript:void(0);"></a></li>');
	$("input[name='product_size']:last").focus();
})
//生成选择尺码列表
function choiceSizeHTML(datas) {
	var data = datas.split(",");
	var HTML = '';
	if(data.length > 0) {
		for(var i = 0; i < data.length; i++) { //创建列表
			if(hadChoiceSize.split(",")[i] == data[i]) {
				HTML += '<li class="selected" title="' + clearClassName(data[i]) + '"><a href="javascript:void(0);">' + data[i] + '</a><i></i></li>';
			} else {
				HTML += '<li class="" title="' + clearClassName(data[i]) + '"><a href="javascript:void(0);">' + data[i] + '</a><i></i></li>';
			}
		}
	} else {
		HTML += '<li class="" title="均码"><a href="javascript:void(0);">均码</a><i></i></li>';
	}
	$("#productsSizeList ul").html(HTML);
}
//提交尺码
$("#toBatchUpdateSize").live("click", function() {
	if($("input[name='product_size']").size() == 0) {
		fntopmessagebox('至少保存一个尺码。', 'error');
		return false;
	}
	var paramObject = new Object();
	paramObject.sessionUid = userInfo.uid;
	paramObject.sessionKey = userInfo.password;
	var datas = "";
	var null_flag = 0;
	$("input[name='product_size']").each(function() {
		if($(this).val().replace(/\s/g, "") == "") {
			null_flag++;
			$(this).focus();
			fntopmessagebox('请输入尺码名称。', 'error');
			return false;
		}
		if(datas == "") {
			datas = $(this).val();
		} else {
			datas += "," + $(this).val();
		}
	});
	if(null_flag > 0) return false;
	paramObject.datas = datas.replace(/\s/g, "");
	$(".toBatchUpdateSize").attr("id", "").html("正在保存");
	var paramJson = jQuery.param(paramObject);
	WC.setLoadingBar();
	$.ajax({
		type: "POST",
		dataType: "json",
		cache: false,
		url: "/sizeTemplate.htm?Act=batchUpdate",
		data: paramJson,
		timeout: 20000,
		success: function(datas) {
			if(datas == null || datas == "") {
				fntopmessagebox("服务器出错啦。", 'error');
				return false;
			}
			if(datas.code.indexOf("success") != -1) {
				fntopmessagebox(datas.data, 'success');
				choiceSizeHTML(paramObject.datas);
				$("#productsSizeList").show();
				$("#editProductsSizeList").hide();
			} else {
				fntopmessagebox(datas.data, 'error');
			}
		},
		error: function() {
			fntopmessagebox('获取信息失效.', 'error');
		}
	}).always(function() {
		$(".toBatchUpdateSize").attr("id", "toBatchUpdateSize").html("保存");
		$("#loading-bar .bar").animate({
			width: '100%'
		});
		setTimeout(function() {
			$(".loadingBar").remove();
		}, 600);
	})
})
//获取尺码信息
function getSizeInfo() {
	var paramObject = new Object();
	paramObject.sessionUid = userInfo.uid;
	paramObject.sessionKey = userInfo.password;
	paramObject.wx = "1";
	var paramJson = jQuery.param(paramObject);
	$.ajax({
		type: "POST",
		dataType: "json",
		cache: false,
		url: "/sizeTemplate.htm?Act=list",
		data: paramJson,
		timeout: 20000,
		success: function(datas) {
			if(datas == null || datas == "") {
				fntopmessagebox("服务器出错啦。", 'error');
				return false;
			}
			if(datas.code.indexOf("success") != -1) {
				//{"data":"[\"S\",\"M\",\"L\"]","code":"success"}
				var data = datas.data;
				if(data.charAt(0) == "[") {
					data = data.replace("[", "");
					data = data.replace("]", "");
					data = data.replace(/\"/g, "");
				}
				choiceSizeHTML(data);
			} else {
				fntopmessagebox(datas.data, 'error');
			}
		},
		error: function() {
			fntopmessagebox('获取信息失效.', 'error');
		}
	}).always(function() {})
}

//生成数量列表
function setProductNumList() {

	//存在尺码
	var sizeIsEmpty = true;
	$("#productsSizeList .selected").each(function() {
		if($(this).attr("title") != "") sizeIsEmpty = false;
	})

	//存在颜色
	var colorIsEmpty = true;
	$("#productsColorList .colorInputText:visible").each(function() {
		if($(this).val() != "") colorIsEmpty = false;
	})

	//存在尺码\颜色
	if(!sizeIsEmpty && !colorIsEmpty) {

		var HTML = '';
		$("#productsSizeList .selected").each(function() {
			var sizeid = $(this).attr("title");
			sizeid = clearClassName(sizeid);
			if(sizeid) {
				$("#productsColorList .colorInputText:visible").each(function() {
					var colorid = $(this).val();
					colorid = clearClassName(colorid);
					if(colorid) {
						if($("#productNumList tbody ." + sizeid + colorid).size() == 0) {
							$("#productNumList tbody ." + sizeid + colorid).remove();
							HTML += '<tr class="' + sizeid + colorid + '"><td>' + itselfClassName(sizeid) + '/' + itselfClassName(colorid) + '</td><td><input type="text" name="productnum" sizeid="' + sizeid + '" colorid="' + colorid + '" class="colorText" value="0"></td><td><input type="text" name="barcode" class="barcodeText" value="" maxlength="20"></td></tr>';
						}
					}
				})
			}
		})
		$("#productNumList tbody").append(HTML);
		$("#productNumList thead th:eq(0)").html("尺码/颜色");

	} else if(!sizeIsEmpty) { //仅存在尺码

		var HTML = '';
		$("#productsSizeList .selected").each(function() {
			var sizeid = $(this).attr("title");
			if(sizeid) {
				sizeid = clearClassName(sizeid);
				if($("#productNumList tbody ." + sizeid).size() == 0) {
					HTML += '<tr class="' + sizeid + '"><td>' + itselfClassName(sizeid) + '</td><td><input type="text" value="0" class="colorText" colorid="" sizeid="' + sizeid + '" name="productnum"></td><td><input type="text" name="barcode" class="barcodeText" value="" maxlength="20"></td></tr>';
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
					HTML += '<tr class="' + itselfClassName(colorid) + '"><td>' + $(this).val() + '</td><td><input type="text" value="0" class="colorText" colorid="' + colorid + '" sizeid="" name="productnum"></td><td><input type="text" name="barcode" class="barcodeText" value="" maxlength="20"></td></tr>';
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
	//自动生成条码
	createBarcode();
	//设置列表数量
	productsColorListNum();
	//设置原来数量、条形码
	setNumBarcode();
	//设置库存总数
	setProductsTotalNum();
}

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

//设置库存总数
function setProductsTotalNum() {
	var num = 0;
	$("input[name='productnum']").each(function() {
		if($(this).val() > 0 || isNaN($(this).val())) {
			num += Number($(this).val());
		}
	})
	$("input[name='num_total']").val(num);
}
//设置原来数量、条形码
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

//数量输入框
$("input[name='productnum']").live("focus", function() {
	if($(this).val() == 0) {
		$(this).val("");
	}
	//设置库存总数
	//setProductsTotalNum();
})
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
})

/* *
 * 数量
 */
$("input[name='num']").live("click", function() {
	$(this).select();
})
$("input[name='num']").live("focus", function() {

})
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
})
/* *
 * 吊牌价格、成本价格
 */
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
}).bind("paste", function() { //CTR+V事件处理
	var myreg = /^[+]?(([0-9]\d*[.]?)|(0.))(\d{0,2})?$/;
	if(!myreg.test(this.value)) {
		this.value = '';
	};
}).css("ime-mode", "disabled"); //CSS设置输入法不可用

//条形码输入框
/*$(".uploadProductArea .productNumList .barcodeText").live("focus",function(){
	if($(this).val()==0){
		$(this).val("");
	}
})
$(".uploadProductArea .productNumList .barcodeText").live("blur",function(){
	if($(this).val()==""){
		$(this).val("0");
	}
})*/

/* *
 * 自动生成条形码barcode
 */
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
/* *
 * 上传颜色图片
 */
$(".uploadProductArea .productsColorList .uploadTd").live("click", function() {
	$(".colorTableTr").removeClass("colorTableTr");
	$(this).parents("tr").addClass("colorTableTr");
})
/*$(".uploadProductArea .colorTable tbody tr").live("mouseover",function(){ 
	$(".colorTableTr").removeClass("colorTableTr");
	$(this).addClass("colorTableTr");
})
$(".uploadProductArea .colorTable tbody tr").live("mouseleave",function(){
	$(".colorTableTr").removeClass("colorTableTr");
})*/
$(function() {
	$("#uploadImgFileX").toUploadImgFileX();
})
var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
var uploadImgIdX = 1;
$.fn.toUploadImgFileX = function() {
	var cur = this;
	this.change(function() {
		var v = cur.val();
		var ext = v.substring(v.lastIndexOf("."));
		if(ext != ".jpg" && ext != ".png" && ext != ".gif" && ext != ".jpeg" && ext != ".JPG" && ext != ".PNG" && ext != ".GIF" && ext != ".JPEG") { //检查文件格式
			alert("请选择图片，支持的图片格式有：JPEG, PNG, GIF !");
			cur.val("");
			return false;
		} else {
			var fileSize = 0;
			var target = document.getElementById("uploadImgFileX");
			if(isIE && !target.files) {
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
			$(".colorTableTr .uploadTd").append('<img class="loadingImg" src="picture/loadingdian.gif">').parents("tr").addClass(newBannerId);
			uploadImgIdX++;
			$(".colorTableTr").removeClass("colorTableTr");
			cur.wrap('<form enctype="multipart/form-data"/>');
			var options = {
				url: "/productImageService.htm?Act=upload" + "&sessionUid=" + userInfo.uid + "&sessionKey=" + userInfo.password, // 路径写全
				type: "post",
				success: function(r) {
					// 取消form包裹
					cur.unwrap();
					// 此处data可以返回文件ID，然后根据ID查询并返回文件即可
					//cur.after(data);
					var datas = eval("(" + r + ")");
					if(datas.code.indexOf("success") != -1) {
						$("#" + newBannerId).attr("src", datas.data.pic); //pic66_66
						$("#" + newBannerId).attr("mid", datas.data.pic);
						$("#" + newBannerId).attr("big", datas.data.pic);
						$("#" + newBannerId).attr("pic222_222", datas.data.pic);
						$("." + newBannerId).find(".imageInputText").val(datas.data.pic);
						$("." + newBannerId).find(".loadingImg").remove();
					} else {
						//fntopmessagebox(datas.data,'error');
						alert(datas.data);
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert(textStatus + "," + errorThrown);
					//$(".loading_div").show();
					//$(".loading_div .img_div").removeClass("loading_img");
				}
			};
			cur.parent("form").ajaxSubmit(options); // 异步提交
		}
	})
}

//上传商品
$("#toNewProductBtn").live("click", function() {

	var paramObject = new Object();
	paramObject.sessionUid = userInfo.uid;
	paramObject.sessionKey = userInfo.password;

	//同步至微商城
	paramObject.online = "0"; //线下
	if($(".synchroListDiv .selected").size() > 0) {
		paramObject.online = "1"; //线上
	}

	//商品货号
	paramObject.bh = $("input[name='bh']:visible").val();
	if(paramObject.bh == "") {
		//fntopmessagebox("请输入商品货号.",'error');
		//setTimeout(function(){$("html,body").animate({scrollTop:$("input[name='bh']:visible").offset().top-10},300);$("input[name='bh']:visible").select();},1000);
		//return false;
	}

	//商品名称
	paramObject.name = $("input[name='name']:visible").val();
	if(paramObject.name == "") {
		fntopmessagebox("请输入商品名称.", 'error');
		setTimeout(function() {
			$("html,body").animate({
				scrollTop: $("input[name='name']:visible").offset().top
			}, 300);
			$("input[name='name']:visible").select();
		}, 1000);
		return false;
	}

	//吊牌价格
	paramObject.price = $("input[name='price']:visible").val();
	if(paramObject.price == "") {
		fntopmessagebox("请输入吊牌价格.", 'error');
		setTimeout(function() {
			$("html,body").animate({
				scrollTop: $("input[name='price']:visible").offset().top
			}, 300);
			$("input[name='price']:visible").select();
		}, 1000);
		return false;
	}

	//成本价格
	paramObject.fprice = $("input[name='fprice']:visible").val();
	if(paramObject.fprice == "") {
		//fntopmessagebox("请输入成本价格.",'error');
		//setTimeout(function(){$("html,body").animate({scrollTop:$("input[name='fprice']:visible").offset().top},300);$("input[name='fprice']:visible").select();},1000);
		//return false;
	}

	//商品类别
	paramObject.fid = $(".directoryBox .comboxText:visible").attr("comboxval");
	if(paramObject.fid == "") {
		fntopmessagebox("请选择商品类别.", 'error');
		setTimeout(function() {
			$("html,body").animate({
				scrollTop: $(".directoryBox:visible").offset().top - 10
			}, 300);
		}, 1000);
		$(".directoryBox:visible").addClass("dropDownBox_hover");
		return false;
	}
	paramObject.directory = $(".directoryBox .comboxText:visible").val();

	//处理商品图片JSON
	var jsonImageData = new Array();
	$("#thumblist li").each(function() {
		if($(this).attr("class").indexOf("addBtn") != -1) {

		} else {
			var strJSON = new Object();
			strJSON.pic = $(this).find("img").attr("big");
			strJSON.pic464_464 = $(this).find("img").attr("mid");
			strJSON.pic66_66 = $(this).find("img").attr("src");
			strJSON.pic222_222 = $(this).find("img").attr("pic222_222");
			jsonImageData.push(strJSON);
		}
	});
	paramObject.imgs = $.toJSON(jsonImageData);

	//商品主图片
	if($("#thumblist li:eq(0)").attr("class").indexOf("addBtn") != -1) {
		paramObject.img = "";
	} else {
		paramObject.img = $("#thumblist li:eq(0) img").attr('pic222_222');
	}

	//颜色图片
	var jsonColorsData = new Array();
	$("#productsColorList tbody tr").each(function() {
		if($(this).attr("pic")) {
			var strJSON = new Object();
			strJSON.colorid = $(this).find(".colorInputText").val();
			strJSON.pic = $(this).attr("pic");
			strJSON.pic66_66 = $(this).attr("pic66_66");
			strJSON.pic222_222 = $(this).attr("pic222_222");
			strJSON.pic464_464 = $(this).attr("pic464_464");
			jsonColorsData.push(strJSON);
		}
	});
	paramObject.colorimgs = $.toJSON(jsonColorsData);

	if(userInfo.shoptype == "1") { //餐饮店

		paramObject.ptype = "1";

		var num = Number($("input[name='num']").val());
		if(num == 0) {
			//fntopmessagebox("请输入库存总数.",'error');
			//setTimeout(function(){$("html,body").animate({scrollTop:$("input[name='num']:visible").offset().top},300);$("input[name='num']:visible").select();},1000);
			//return false;
		}

		//数量JSON
		var jsonNumData = new Array();
		var strJSON = new Object();
		strJSON.colorid = "-";
		strJSON.sizeid = "-";
		strJSON.num = num;
		strJSON.barcode = $("input[name='barcode']").val();
		jsonNumData.push(strJSON);
		paramObject.nums = $.toJSON(jsonNumData);

	} else { //服饰鞋包

		paramObject.ptype = "1";

		//商品品牌
		paramObject.brand = $("input[name='brand']").val();

		//商品信息
		paramObject.pdesc = UE.getEditor('JS_Editor').getContent();

		//数量JSON
		createBarcode();
		var jsonNumData = new Array();
		var jsonNumXX = 0;
		$("#productNumList .colorText").each(function() {
			var strJSON = new Object();
			strJSON.colorid = itselfClassName($(this).attr("colorid"));
			strJSON.sizeid = itselfClassName($(this).attr("sizeid"));
			if(strJSON.colorid == "") strJSON.colorid = "-";
			if(strJSON.sizeid == "") strJSON.sizeid = "-";
			strJSON.num = Number($(this).val());
			strJSON.barcode = $(this).parents("tr").find(".barcodeText").val(); //Number()
			jsonNumXX += Number($(this).val());
			jsonNumData.push(strJSON);
		})
		paramObject.nums = $.toJSON(jsonNumData);

		if(jsonNumData.length == 0) {
			fntopmessagebox("输入尺码.", 'error');
			setTimeout(function() {
				$("html,body").animate({
					scrollTop: $(".uploadProductArea .productsSizeObject").offset().top
				}, 300);
			}, 1000);
			return false;
		}
	}
	var url = "/product.htm?Act=add";
	if(userInfo.shoptype == "1") { //餐饮店
		//url="/foodproduct.htm?Act=add";
	}
	if(WC.getRequest().guid) {
		paramObject.guid = $(".uploadProductArea").attr("guid");
		url = "/product.htm?Act=edit";
		if(userInfo.shoptype == "1") { //餐饮店
			//url="/foodproduct.htm?Act=edit";
		}
	}
	var paramJson = jQuery.param(paramObject);
	$("#toNewProductBtn").attr("id", "").html("正在提交").addClass("loadingBnt");
	WC.imloadingDialog("正在提交...");
	WC.fnOverlay($("body"));
	$.ajax({
		type: "POST",
		dataType: "json",
		cache: false,
		url: url,
		data: paramJson,
		timeout: 20000,
		success: function(datas) {
			if(datas.code.indexOf("success") != -1) {
				fntopmessagebox("提交成功.", 'success');
				WC.setCookie(userInfo.uid + "shop_goods_directory", $(".directoryBox .comboxText:visible").attr("comboxval") + "," + $(".directoryBox .comboxText:visible").val(), !1);
				window.location.href = "http://www.poso2o.com/EntityStore/goods/goods.jsp?fid=" + $(".directoryBox .comboxText:visible").attr("comboxval");
			} else if(datas.code.indexOf("error") != -1) {
				fntopmessagebox('服务器繁忙，稍后再试试.', 'error');
			} else if(datas.code.indexOf("enabled") != -1) {
				showWarningDialog("POS收银系统", '<p style="text-align:center;font-size:16px;">该功能只有开通POS收银系统才可以使用，<a href="http://www.poso2o.com/UserAccount/service_fees.jsp" style="color:#44b549;">前往开通></a></p>', "http://www.poso2o.com/UserAccount/service_fees.jsp");
			} else {
				fntopmessagebox(datas.data, 'error');
			}
		},
		error: function() {
			fntopmessagebox('服务器繁忙，稍后再试试.', 'error');
		}
	}).always(function() {
		$('.toNewProductBtn').attr('id', 'toNewProductBtn').removeClass("loadingBnt").html("发布商品");
		$("#imloadingDialog, #itemOverlay").remove();
	})

})

$(function() {
	$(".navArea ul li:eq(1),.navList .nav_add").addClass("current");
	//取店类型： 0=服装店，1=餐饮店，-1=未类型
	if(userInfo.shoptype == "0") { //服装店
		$(".ptype1").hide();
		$(".ptype2, .editorArea").show();
	} else if(userInfo.shoptype == "1") { //=餐饮店
		$(".ptype1").show();
		$(".ptype2, .editorArea").hide();
	} else {
		showWarningDialog("店铺模块", "店铺模块未选择，无权限进行此操作", "http://www.poso2o.com/EntityStore/shop/index.jsp");
		$(".main_area .main_body").html('<p style="line-height:156px; text-align:center; font-size:16px;"><a href="http://www.poso2o.com/EntityStore/shop/index.jsp">店铺模块</a>未选择，无权限进行此操作</p>');
	}
	setWindowHeight();
	getSizeInfo(); //获取尺码
})
/* *
 * 上传商品 - 设置高度
 */
function setWindowHeight() {
	$(".containerArea").css("height", "auto");
	var body_H = $(".containerArea").height() + 182;
	var window_height = $(window).height();
	if(body_H > window_height) {
		$(".containerArea").css("height", "auto");
	} else {
		$(".containerArea").css("height", window_height - 206);
	}
}

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
 * 编辑商品
 */
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
						/*if(sizeHTML==''){
							sizeHTML+='<li class="" title="均码"><a href="javascript:void(0);">均码</a><i></i></li>';
						}*/
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
		})
	}
}