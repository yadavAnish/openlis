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
*/

package us.mn.state.health.lims.common.util;

import java.io.Serializable;

/*
 * Nothing special, just for when id's and values should be encapsulated. 
 * 
 * N.B. This is very light weight, if you want to stick it in a hash and want to use something
 * other than identity of equals then over-ride equals and hash.
 */
public class IdValuePair implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String value;
	
	public IdValuePair( String id, String value){
		this.setId(id);
		this.setValue(value);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdValuePair that = (IdValuePair) o;

        if (!id.equals(that.id)) return false;
        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}

