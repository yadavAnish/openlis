<%@ page language="java"
	contentType="text/html; charset=utf-8"
	import="us.mn.state.health.lims.common.action.IActionConstants"
%>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/labdev-view" prefix="app" %>

<script type="text/javascript">

function /*void*/ showSuccessMessage( show ){
	$("successMsg").style.display = show ? 'block' : 'none';
}

</script>



<div id="successMsg" style="text-align:center; color:#FF9999;  width : 100%;font-size:170%; display:none">
				<bean:message key="save.success"/>
</div>



