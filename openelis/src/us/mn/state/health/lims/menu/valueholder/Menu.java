/*
* The contents of this file are subject to the Mozilla Public License
* Version 1.1 (the "License"); you may not use this file except in
* compliance with the License. You may obtain a copy of the License at
* http://www.mozilla.org/MPL/ 
* 
* Software distributed under the License is distributed on an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
* License for the specific language governing rights and limitations under
* the License.
* 
* The Original Code is OpenELIS code.
* 
* Copyright (C) CIRG, University of Washington, Seattle WA.  All Rights Reserved.
*
*/
package us.mn.state.health.lims.menu.valueholder;

import org.apache.commons.validator.GenericValidator;

import us.mn.state.health.lims.common.util.StringUtil;
import us.mn.state.health.lims.common.valueholder.BaseObject;
import us.mn.state.health.lims.common.valueholder.ValueHolder;
import us.mn.state.health.lims.common.valueholder.ValueHolderInterface;

public class Menu extends BaseObject {

	private static final long serialVersionUID = 1L;

	private String id;

	private ValueHolderInterface parent = new ValueHolder();

	private int presentationOrder;
	
	private String elementId;
	
	private String actionURL;
	
	private String clickAction;
	
	private String displayKey;
	
	private String toolTipKey;

	private boolean openInNewWindow;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public int getPresentationOrder() {
		return presentationOrder;
	}

	public void setPresentationOrder(int presentationOrder) {
		this.presentationOrder = presentationOrder;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getActionURL() {
		return actionURL;
	}

	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}

	public String getClickAction() {
		return clickAction;
	}

	public void setClickAction(String clickAction) {
		this.clickAction = clickAction;
	}

	public String getDisplayKey() {
		return displayKey;
	}

	public void setDisplayKey(String displayKey) {
		this.displayKey = displayKey;
	}

	public String getToolTipKey() {
		return toolTipKey;
	}

	public void setToolTipKey(String toolTipKey) {
		this.toolTipKey = toolTipKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setParent( Menu parent){
		this.parent.setValue(parent);
	}
	
	public Menu getParent(){
		return (Menu)this.parent.getValue();
	}
	
	public String getLocalizedTitle(){
		if( GenericValidator.isBlankOrNull(getDisplayKey())){
			return null;
		}else{
			return StringUtil.getContextualMessageForKey(getDisplayKey());
		}
	}
	
	public String getLocalizedTooltip(){
		if( GenericValidator.isBlankOrNull(getToolTipKey())){
			return null;
		}else{
			return StringUtil.getContextualMessageForKey(getToolTipKey());
		}
	}

	public void setOpenInNewWindow(boolean openInNewWindow) {
		this.openInNewWindow = openInNewWindow;
	}

	public boolean isOpenInNewWindow() {
		return openInNewWindow;
	}

}
