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
* Copyright (C) The Minnesota Department of Health.  All Rights Reserved.
*
* Contributor(s): CIRG, University of Washington, Seattle WA.
*/
package us.mn.state.health.lims.inventory.valueholder;

import us.mn.state.health.lims.common.valueholder.BaseObject;

/*
 * N.B.  This class does not map completely to the table.  If more of the table needs to be supported feel free to add
 * it.  
 * N.B. For Haiti the description is being used to identify the type of inventory.  This may or may not follow for
 * other implementations.
 */
public class InventoryItem extends BaseObject{
	
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	private String isActive;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

}

