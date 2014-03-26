function getPrenomInCookie(valcookie){
	
	var tabele = valcookie.split('#');
	return tabele[1];
}


function getRoleInCookie(valcookie){
	
	var tabele = valcookie.split('#');
	return tabele[2];
}


function getTokenInCookie(valcookie){
	
	var tabele = valcookie.split('#');
	return tabele[0];
}