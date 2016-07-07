/**
 * 
 */
function getRootURL(){  
    var curWwwPath = window.document.location.href;
    var pathName = window.document.location.pathname;  
    var pos = curWwwPath.indexOf(pathName);
    var localhostPath = curWwwPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);  
    var rootPath = localhostPath + projectName;  
    return rootPath;  
      
}
function getSecondURL(){
    var pathName = window.document.location.pathname;
    pathName = pathName.substring(1,pathName.length);
    var s = pathName.indexOf('/');
    var e = pathName.substring(s+1,pathName.length).indexOf('/');
    if(e==-1)e=pathName.length;
    return pathName.substring(s+1,pathName.length);
}
