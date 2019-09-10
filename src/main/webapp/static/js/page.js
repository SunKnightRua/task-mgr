// 分页方法
// 跳转到指定页码
function jump() {
	pages = document.getElementById("pages").innerHTML;
	content = document.getElementById("searTabContent").value;
	desc = document.getElementById("searTabDesc").value;
	priority = document.getElementById("searTabPriority").value;
	isHabit = document.getElementById("searTabIsHabit").value;
	isComplete = document.getElementById("searTabIsComplete").value;
	var $targetPage = document.getElementById("index").value;
	if ($targetPage != null && $targetPage > 0 && $targetPage <= pages) {// 有输入值，并且输入值在1到总页数之间才跳转。
		window.location.href = $url + "?pageNo=" + $targetPage + "&pageSize="
				+ $pageSize + "&content=" + encodeURI(content) + "&desc="
				+ encodeURI(desc) + "&priority=" + priority + "&isHabit="
				+ isHabit + "&isComplete=" + isComplete;
	}
};