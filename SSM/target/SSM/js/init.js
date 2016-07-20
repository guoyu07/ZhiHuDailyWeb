
/** ********************************** */
function selectButton(obj,className){
	var objs = $("."+className);
	objs.removeClass("active");
	$(obj).addClass("active");
}
