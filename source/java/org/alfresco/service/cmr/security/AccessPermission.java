/*
 * Copyright (C) 2005-2007 Alfresco Software Limited.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.

 * As a special exception to the terms and conditions of version 2.0 of 
 * the GPL, you may redistribute this Program in connection with Free/Libre 
 * and Open Source Software ("FLOSS") applications as described in Alfresco's 
 * FLOSS exception.  You should have recieved a copy of the text describing 
 * the FLOSS exception, and it is also available here: 
 * http://www.alfresco.com/legal/licensing"
 */
package org.alfresco.service.cmr.security;


/**
 * The interface used to support reporting back if permissions are allowed or
 * denied.
 * 
 * @author Andy Hind
 */
public interface AccessPermission
{   
    /**
     * The permission.
     * 
     * @return
     */
    public String getPermission();
    
    /**
     * Get the Access enumeration value
     * 
     * @return
     */
    public AccessStatus getAccessStatus();
    
    
    /**
     * Get the authority to which this permission applies.
     * 
     * @return
     */
    public String getAuthority();
    
 
    /**
     * Get the type of authority to which this permission applies.
     * 
     * @return
     */
    public AuthorityType getAuthorityType();
    
   
    /**
     * At what position in the inheritance chain for permissions is this permission set?
     * = 0 -> Set direct on the object.
     * > 0 -> Inherited
     * < 0 -> We don't know and are using this object for reporting (e.g. the actual permissions that apply to a node for the current user)
     * @return
     */
    public int getPosition();
    
   /**
    * Is this an inherited permission entry?
    * @return
    */ 
    public boolean isInherited();
    
    /**
     * Is this permission set on the object?
     * @return
     */ 
     public boolean isSetDirectly();
}
