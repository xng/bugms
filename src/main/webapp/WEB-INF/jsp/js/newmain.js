function addTab(subtitle, url) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title: subtitle,
			content: createFrame(url),
			closable: true
		});
	} else {
		$('#tabs').tabs('select', subtitle);
	}
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	return s;
}
