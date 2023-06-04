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
package us.mn.state.health.lims.common.valueholder;

import java.io.Serializable;

import us.mn.state.health.lims.common.log.LogEvent;

/**
 * <p>
 * <b>Purpose</b>: Act as a place holder for a variable that required a value holder interface.
 * This class should be used to initialze an objects attributes that are using indirection is their mappings.
 */
public class ValueHolder implements ValueHolderInterface, Cloneable, Serializable {

    /**
     * Stores the wrapped object.
     */
    protected Object value;

    /**
     * PUBLIC:
     * Initialize the holder.
     */
    public ValueHolder() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueHolder that = (ValueHolder) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    /**
     * PUBLIC:
     * Initialize the holder with an object.
     */
    public ValueHolder(Object value) {

        this.value = value;
    }

    /**
     * INTERNAL:
     */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException exception) {
            //bugzilla 2154
			LogEvent.logError("ValueHolder","clone()",exception.toString());
        }

        return null;
    }

    /**
     * PUBLIC:
     * Return the wrapped object.
     */
    public synchronized Object getValue() {
        return value;
    }

    /**
     * PUBLIC:
     * Return a boolean indicating whether the
     * wrapped object has been set or not.
     */
    public boolean isInstantiated() {
        // Always return true since we consider 
        // null to be a valid wrapped object.
        return true;
    }

    /**
     * PUBLIC:
     * Set the wrapped object.
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * INTERNAL:
     */
    public String toString() {
        if (getValue() == null) {
            return "{" + null + "}";
        }
        return "{" + getValue().toString() + "}";
    }
}
