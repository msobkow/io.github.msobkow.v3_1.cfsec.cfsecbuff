// Description: Java 25 implementation of a Service by UTypeIdx index key buffer

/*
 *	io.github.msobkow.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	This file is part of Mark's Code Fractal CFSec.
 *	
 *	Mark's Code Fractal CFSec is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFSec is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFSec is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFSec.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 *	
 */

package io.github.msobkow.v3_1.cfsec.cfsec.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cflib.xml.CFLibXmlUtil;
import io.github.msobkow.v3_1.cfsec.cfsec.*;

public class CFSecBuffServiceByUTypeIdxKey
	implements ICFSecServiceByUTypeIdxKey, Comparable<Object>, Serializable
{
	protected long requiredClusterId;
	protected CFLibDbKeyHash256 requiredHostNodeId;
	protected CFLibDbKeyHash256 requiredServiceTypeId;
	public CFSecBuffServiceByUTypeIdxKey() {
		requiredClusterId = ICFSecService.CLUSTERID_INIT_VALUE;
		requiredHostNodeId = CFLibDbKeyHash256.fromHex( ICFSecService.HOSTNODEID_INIT_VALUE.toString() );
		requiredServiceTypeId = CFLibDbKeyHash256.fromHex( ICFSecService.SERVICETYPEID_INIT_VALUE.toString() );
	}

	@Override
	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	@Override
	public void setRequiredClusterId( long value ) {
		requiredClusterId = value;
	}

	@Override
	public CFLibDbKeyHash256 getRequiredHostNodeId() {
		return( requiredHostNodeId );
	}

	@Override
	public void setRequiredHostNodeId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredHostNodeId",
				1,
				"value" );
		}
		requiredHostNodeId = value;
	}

	@Override
	public CFLibDbKeyHash256 getRequiredServiceTypeId() {
		return( requiredServiceTypeId );
	}

	@Override
	public void setRequiredServiceTypeId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredServiceTypeId",
				1,
				"value" );
		}
		requiredServiceTypeId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecServiceByUTypeIdxKey ) {
			ICFSecServiceByUTypeIdxKey rhs = (ICFSecServiceByUTypeIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredHostNodeId() != null && !getRequiredHostNodeId().isNull() ) {
				if( rhs.getRequiredHostNodeId() != null && !rhs.getRequiredHostNodeId().isNull() ) {
					if( ! getRequiredHostNodeId().equals( rhs.getRequiredHostNodeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredHostNodeId() != null && !getRequiredHostNodeId().isNull()) {
					return( false );
				}
			}
			if( getRequiredServiceTypeId() != null && !getRequiredServiceTypeId().isNull() ) {
				if( rhs.getRequiredServiceTypeId() != null && !rhs.getRequiredServiceTypeId().isNull() ) {
					if( ! getRequiredServiceTypeId().equals( rhs.getRequiredServiceTypeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServiceTypeId() != null && !getRequiredServiceTypeId().isNull()) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecService) {
			ICFSecService rhs = (ICFSecService)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredHostNodeId() != null && !getRequiredHostNodeId().isNull() ) {
				if( rhs.getRequiredHostNodeId() != null && !rhs.getRequiredHostNodeId().isNull() ) {
					if( ! getRequiredHostNodeId().equals( rhs.getRequiredHostNodeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredHostNodeId() != null && !getRequiredHostNodeId().isNull()) {
					return( false );
				}
			}
			if( getRequiredServiceTypeId() != null && !getRequiredServiceTypeId().isNull() ) {
				if( rhs.getRequiredServiceTypeId() != null && !rhs.getRequiredServiceTypeId().isNull() ) {
					if( ! getRequiredServiceTypeId().equals( rhs.getRequiredServiceTypeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServiceTypeId() != null && !getRequiredServiceTypeId().isNull()) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + (int)( getRequiredClusterId() );
		hashCode = hashCode + getRequiredHostNodeId().hashCode();
		hashCode = hashCode + getRequiredServiceTypeId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof ICFSecServiceByUTypeIdxKey ) {
			ICFSecServiceByUTypeIdxKey rhs = (ICFSecServiceByUTypeIdxKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if (getRequiredHostNodeId() != null) {
				if (rhs.getRequiredHostNodeId() != null) {
					cmp = getRequiredHostNodeId().compareTo( rhs.getRequiredHostNodeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredHostNodeId() != null) {
				return( -1 );
			}
			if (getRequiredServiceTypeId() != null) {
				if (rhs.getRequiredServiceTypeId() != null) {
					cmp = getRequiredServiceTypeId().compareTo( rhs.getRequiredServiceTypeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServiceTypeId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecService ) {
			ICFSecService rhs = (ICFSecService)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if (getRequiredHostNodeId() != null) {
				if (rhs.getRequiredHostNodeId() != null) {
					cmp = getRequiredHostNodeId().compareTo( rhs.getRequiredHostNodeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredHostNodeId() != null) {
				return( -1 );
			}
			if (getRequiredServiceTypeId() != null) {
				if (rhs.getRequiredServiceTypeId() != null) {
					cmp = getRequiredServiceTypeId().compareTo( rhs.getRequiredServiceTypeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServiceTypeId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredHostNodeId=" + "\"" + getRequiredHostNodeId().toString() + "\""
			+ " RequiredServiceTypeId=" + "\"" + getRequiredServiceTypeId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffServiceByUTypeIdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
