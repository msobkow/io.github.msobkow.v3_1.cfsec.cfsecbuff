// Description: Java 25 buffer implementation of a CFSec schema.

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
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cfsec.cfsec.*;

public class CFSecBuffSchema
	implements ICFSecSchema
{
	protected static ICFSecTablePerms tablePerms;

	protected ICFSecClusterTable tableCluster;
	protected ICFSecHostNodeTable tableHostNode;
	protected ICFSecISOCcyTable tableISOCcy;
	protected ICFSecISOCtryTable tableISOCtry;
	protected ICFSecISOCtryCcyTable tableISOCtryCcy;
	protected ICFSecISOCtryLangTable tableISOCtryLang;
	protected ICFSecISOLangTable tableISOLang;
	protected ICFSecISOTZoneTable tableISOTZone;
	protected ICFSecSecDeviceTable tableSecDevice;
	protected ICFSecSecGroupTable tableSecGroup;
	protected ICFSecSecGrpIncTable tableSecGrpInc;
	protected ICFSecSecGrpMembTable tableSecGrpMemb;
	protected ICFSecSecSessionTable tableSecSession;
	protected ICFSecSecUserTable tableSecUser;
	protected ICFSecServiceTable tableService;
	protected ICFSecServiceTypeTable tableServiceType;
	protected ICFSecSysClusterTable tableSysCluster;
	protected ICFSecTSecGroupTable tableTSecGroup;
	protected ICFSecTSecGrpIncTable tableTSecGrpInc;
	protected ICFSecTSecGrpMembTable tableTSecGrpMemb;
	protected ICFSecTenantTable tableTenant;

	protected ICFSecClusterFactory factoryCluster;
	protected ICFSecHostNodeFactory factoryHostNode;
	protected ICFSecISOCcyFactory factoryISOCcy;
	protected ICFSecISOCtryFactory factoryISOCtry;
	protected ICFSecISOCtryCcyFactory factoryISOCtryCcy;
	protected ICFSecISOCtryLangFactory factoryISOCtryLang;
	protected ICFSecISOLangFactory factoryISOLang;
	protected ICFSecISOTZoneFactory factoryISOTZone;
	protected ICFSecSecDeviceFactory factorySecDevice;
	protected ICFSecSecGroupFactory factorySecGroup;
	protected ICFSecSecGrpIncFactory factorySecGrpInc;
	protected ICFSecSecGrpMembFactory factorySecGrpMemb;
	protected ICFSecSecSessionFactory factorySecSession;
	protected ICFSecSecUserFactory factorySecUser;
	protected ICFSecServiceFactory factoryService;
	protected ICFSecServiceTypeFactory factoryServiceType;
	protected ICFSecSysClusterFactory factorySysCluster;
	protected ICFSecTSecGroupFactory factoryTSecGroup;
	protected ICFSecTSecGrpIncFactory factoryTSecGrpInc;
	protected ICFSecTSecGrpMembFactory factoryTSecGrpMemb;
	protected ICFSecTenantFactory factoryTenant;

	@Override
	public int initClassMapEntries(int value) {
		return( ICFSecSchema.doInitClassMapEntries(value) );
	}

	@Override
	public void wireRecConstructors() {
		ICFSecSchema.ClassMapEntry entry;
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecCluster.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecCluster ret = new CFSecBuffCluster();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecCluster.CLASS_CODE)[" + ICFSecCluster.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecHostNode.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecHostNode ret = new CFSecBuffHostNode();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecHostNode.CLASS_CODE)[" + ICFSecHostNode.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCcy ret = new CFSecBuffISOCcy();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCcy.CLASS_CODE)[" + ICFSecISOCcy.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtry.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCtry ret = new CFSecBuffISOCtry();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtry.CLASS_CODE)[" + ICFSecISOCtry.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCtryCcy ret = new CFSecBuffISOCtryCcy();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryCcy.CLASS_CODE)[" + ICFSecISOCtryCcy.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCtryLang ret = new CFSecBuffISOCtryLang();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryLang.CLASS_CODE)[" + ICFSecISOCtryLang.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOLang ret = new CFSecBuffISOLang();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOLang.CLASS_CODE)[" + ICFSecISOLang.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOTZone.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOTZone ret = new CFSecBuffISOTZone();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOTZone.CLASS_CODE)[" + ICFSecISOTZone.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecDevice.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecDevice ret = new CFSecBuffSecDevice();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecDevice.CLASS_CODE)[" + ICFSecSecDevice.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecGroup.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecGroup ret = new CFSecBuffSecGroup();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecGroup.CLASS_CODE)[" + ICFSecSecGroup.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecGrpInc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecGrpInc ret = new CFSecBuffSecGrpInc();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecGrpInc.CLASS_CODE)[" + ICFSecSecGrpInc.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecGrpMemb ret = new CFSecBuffSecGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecGrpMemb.CLASS_CODE)[" + ICFSecSecGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSession.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecSession ret = new CFSecBuffSecSession();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSession.CLASS_CODE)[" + ICFSecSecSession.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUser.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecUser ret = new CFSecBuffSecUser();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUser.CLASS_CODE)[" + ICFSecSecUser.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecService.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecService ret = new CFSecBuffService();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecService.CLASS_CODE)[" + ICFSecService.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecServiceType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecServiceType ret = new CFSecBuffServiceType();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecServiceType.CLASS_CODE)[" + ICFSecServiceType.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSysCluster.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSysCluster ret = new CFSecBuffSysCluster();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSysCluster.CLASS_CODE)[" + ICFSecSysCluster.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecTenant.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecTenant ret = new CFSecBuffTenant();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecTenant.CLASS_CODE)[" + ICFSecTenant.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecTSecGroup.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecTSecGroup ret = new CFSecBuffTSecGroup();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecTSecGroup.CLASS_CODE)[" + ICFSecTSecGroup.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecTSecGrpInc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecTSecGrpInc ret = new CFSecBuffTSecGrpInc();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecTSecGrpInc.CLASS_CODE)[" + ICFSecTSecGrpInc.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecTSecGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecTSecGrpMemb ret = new CFSecBuffTSecGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecTSecGrpMemb.CLASS_CODE)[" + ICFSecTSecGrpMemb.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		throw new CFLibMustOverrideException(getClass(), "wireTableTableInstances");
	}

	@Override		
	public ICFSecSchema getCFSecSchema() {
		return( ICFSecSchema.getBackingCFSec() );
	}

	@Override
	public void setCFSecSchema(ICFSecSchema schema) {
		ICFSecSchema.setBackingCFSec(schema);
		schema.wireRecConstructors();
	}

	public CFSecBuffSchema() {

	tableCluster = null; // new CFSecBuffClusterTable();
	tableHostNode = null; // new CFSecBuffHostNodeTable();
	tableISOCcy = null; // new CFSecBuffISOCcyTable();
	tableISOCtry = null; // new CFSecBuffISOCtryTable();
	tableISOCtryCcy = null; // new CFSecBuffISOCtryCcyTable();
	tableISOCtryLang = null; // new CFSecBuffISOCtryLangTable();
	tableISOLang = null; // new CFSecBuffISOLangTable();
	tableISOTZone = null; // new CFSecBuffISOTZoneTable();
	tableSecDevice = null; // new CFSecBuffSecDeviceTable();
	tableSecGroup = null; // new CFSecBuffSecGroupTable();
	tableSecGrpInc = null; // new CFSecBuffSecGrpIncTable();
	tableSecGrpMemb = null; // new CFSecBuffSecGrpMembTable();
	tableSecSession = null; // new CFSecBuffSecSessionTable();
	tableSecUser = null; // new CFSecBuffSecUserTable();
	tableService = null; // new CFSecBuffServiceTable();
	tableServiceType = null; // new CFSecBuffServiceTypeTable();
	tableSysCluster = null; // new CFSecBuffSysClusterTable();
	tableTSecGroup = null; // new CFSecBuffTSecGroupTable();
	tableTSecGrpInc = null; // new CFSecBuffTSecGrpIncTable();
	tableTSecGrpMemb = null; // new CFSecBuffTSecGrpMembTable();
	tableTenant = null; // new CFSecBuffTenantTable();

	factoryCluster = new CFSecBuffClusterDefaultFactory();
	factoryHostNode = new CFSecBuffHostNodeDefaultFactory();
	factoryISOCcy = new CFSecBuffISOCcyDefaultFactory();
	factoryISOCtry = new CFSecBuffISOCtryDefaultFactory();
	factoryISOCtryCcy = new CFSecBuffISOCtryCcyDefaultFactory();
	factoryISOCtryLang = new CFSecBuffISOCtryLangDefaultFactory();
	factoryISOLang = new CFSecBuffISOLangDefaultFactory();
	factoryISOTZone = new CFSecBuffISOTZoneDefaultFactory();
	factorySecDevice = new CFSecBuffSecDeviceDefaultFactory();
	factorySecGroup = new CFSecBuffSecGroupDefaultFactory();
	factorySecGrpInc = new CFSecBuffSecGrpIncDefaultFactory();
	factorySecGrpMemb = new CFSecBuffSecGrpMembDefaultFactory();
	factorySecSession = new CFSecBuffSecSessionDefaultFactory();
	factorySecUser = new CFSecBuffSecUserDefaultFactory();
	factoryService = new CFSecBuffServiceDefaultFactory();
	factoryServiceType = new CFSecBuffServiceTypeDefaultFactory();
	factorySysCluster = new CFSecBuffSysClusterDefaultFactory();
	factoryTSecGroup = new CFSecBuffTSecGroupDefaultFactory();
	factoryTSecGrpInc = new CFSecBuffTSecGrpIncDefaultFactory();
	factoryTSecGrpMemb = new CFSecBuffTSecGrpMembDefaultFactory();
	factoryTenant = new CFSecBuffTenantDefaultFactory();	}

	public ICFSecSchema newSchema() {
		throw new CFLibMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOCcyIdGen");
	}

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOCtryIdGen");
	}

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOLangIdGen");
	}

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOTZoneIdGen");
	}

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextClusterIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSessionIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecUserIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next ServiceTypeIdGen identifier.
	 *
	 *	@return	The next ServiceTypeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextServiceTypeIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTenantIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next HostNodeIdGen identifier.
	 *
	 *	@return	The next HostNodeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextHostNodeIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecGroupIdGen identifier.
	 *
	 *	@return	The next SecGroupIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecGroupIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecGrpIncIdGen identifier.
	 *
	 *	@return	The next SecGrpIncIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecGrpIncIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecGrpMembIdGen identifier.
	 *
	 *	@return	The next SecGrpMembIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecGrpMembIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next ServiceIdGen identifier.
	 *
	 *	@return	The next ServiceIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextServiceIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TSecGroupIdGen identifier.
	 *
	 *	@return	The next TSecGroupIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTSecGroupIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TSecGrpIncIdGen identifier.
	 *
	 *	@return	The next TSecGrpIncIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTSecGrpIncIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TSecGrpMembIdGen identifier.
	 *
	 *	@return	The next TSecGrpMembIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTSecGrpMembIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	public ICFSecClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ICFSecClusterTable value ) {
		tableCluster = value;
	}

	public ICFSecClusterFactory getFactoryCluster() {
		return( factoryCluster );
	}

	public void setFactoryCluster( ICFSecClusterFactory value ) {
		factoryCluster = value;
	}

	public ICFSecHostNodeTable getTableHostNode() {
		return( tableHostNode );
	}

	public void setTableHostNode( ICFSecHostNodeTable value ) {
		tableHostNode = value;
	}

	public ICFSecHostNodeFactory getFactoryHostNode() {
		return( factoryHostNode );
	}

	public void setFactoryHostNode( ICFSecHostNodeFactory value ) {
		factoryHostNode = value;
	}

	public ICFSecISOCcyTable getTableISOCcy() {
		return( tableISOCcy );
	}

	public void setTableISOCcy( ICFSecISOCcyTable value ) {
		tableISOCcy = value;
	}

	public ICFSecISOCcyFactory getFactoryISOCcy() {
		return( factoryISOCcy );
	}

	public void setFactoryISOCcy( ICFSecISOCcyFactory value ) {
		factoryISOCcy = value;
	}

	public ICFSecISOCtryTable getTableISOCtry() {
		return( tableISOCtry );
	}

	public void setTableISOCtry( ICFSecISOCtryTable value ) {
		tableISOCtry = value;
	}

	public ICFSecISOCtryFactory getFactoryISOCtry() {
		return( factoryISOCtry );
	}

	public void setFactoryISOCtry( ICFSecISOCtryFactory value ) {
		factoryISOCtry = value;
	}

	public ICFSecISOCtryCcyTable getTableISOCtryCcy() {
		return( tableISOCtryCcy );
	}

	public void setTableISOCtryCcy( ICFSecISOCtryCcyTable value ) {
		tableISOCtryCcy = value;
	}

	public ICFSecISOCtryCcyFactory getFactoryISOCtryCcy() {
		return( factoryISOCtryCcy );
	}

	public void setFactoryISOCtryCcy( ICFSecISOCtryCcyFactory value ) {
		factoryISOCtryCcy = value;
	}

	public ICFSecISOCtryLangTable getTableISOCtryLang() {
		return( tableISOCtryLang );
	}

	public void setTableISOCtryLang( ICFSecISOCtryLangTable value ) {
		tableISOCtryLang = value;
	}

	public ICFSecISOCtryLangFactory getFactoryISOCtryLang() {
		return( factoryISOCtryLang );
	}

	public void setFactoryISOCtryLang( ICFSecISOCtryLangFactory value ) {
		factoryISOCtryLang = value;
	}

	public ICFSecISOLangTable getTableISOLang() {
		return( tableISOLang );
	}

	public void setTableISOLang( ICFSecISOLangTable value ) {
		tableISOLang = value;
	}

	public ICFSecISOLangFactory getFactoryISOLang() {
		return( factoryISOLang );
	}

	public void setFactoryISOLang( ICFSecISOLangFactory value ) {
		factoryISOLang = value;
	}

	public ICFSecISOTZoneTable getTableISOTZone() {
		return( tableISOTZone );
	}

	public void setTableISOTZone( ICFSecISOTZoneTable value ) {
		tableISOTZone = value;
	}

	public ICFSecISOTZoneFactory getFactoryISOTZone() {
		return( factoryISOTZone );
	}

	public void setFactoryISOTZone( ICFSecISOTZoneFactory value ) {
		factoryISOTZone = value;
	}

	public ICFSecSecDeviceTable getTableSecDevice() {
		return( tableSecDevice );
	}

	public void setTableSecDevice( ICFSecSecDeviceTable value ) {
		tableSecDevice = value;
	}

	public ICFSecSecDeviceFactory getFactorySecDevice() {
		return( factorySecDevice );
	}

	public void setFactorySecDevice( ICFSecSecDeviceFactory value ) {
		factorySecDevice = value;
	}

	public ICFSecSecGroupTable getTableSecGroup() {
		return( tableSecGroup );
	}

	public void setTableSecGroup( ICFSecSecGroupTable value ) {
		tableSecGroup = value;
	}

	public ICFSecSecGroupFactory getFactorySecGroup() {
		return( factorySecGroup );
	}

	public void setFactorySecGroup( ICFSecSecGroupFactory value ) {
		factorySecGroup = value;
	}

	public ICFSecSecGrpIncTable getTableSecGrpInc() {
		return( tableSecGrpInc );
	}

	public void setTableSecGrpInc( ICFSecSecGrpIncTable value ) {
		tableSecGrpInc = value;
	}

	public ICFSecSecGrpIncFactory getFactorySecGrpInc() {
		return( factorySecGrpInc );
	}

	public void setFactorySecGrpInc( ICFSecSecGrpIncFactory value ) {
		factorySecGrpInc = value;
	}

	public ICFSecSecGrpMembTable getTableSecGrpMemb() {
		return( tableSecGrpMemb );
	}

	public void setTableSecGrpMemb( ICFSecSecGrpMembTable value ) {
		tableSecGrpMemb = value;
	}

	public ICFSecSecGrpMembFactory getFactorySecGrpMemb() {
		return( factorySecGrpMemb );
	}

	public void setFactorySecGrpMemb( ICFSecSecGrpMembFactory value ) {
		factorySecGrpMemb = value;
	}

	public ICFSecSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ICFSecSecSessionTable value ) {
		tableSecSession = value;
	}

	public ICFSecSecSessionFactory getFactorySecSession() {
		return( factorySecSession );
	}

	public void setFactorySecSession( ICFSecSecSessionFactory value ) {
		factorySecSession = value;
	}

	public ICFSecSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ICFSecSecUserTable value ) {
		tableSecUser = value;
	}

	public ICFSecSecUserFactory getFactorySecUser() {
		return( factorySecUser );
	}

	public void setFactorySecUser( ICFSecSecUserFactory value ) {
		factorySecUser = value;
	}

	public ICFSecServiceTable getTableService() {
		return( tableService );
	}

	public void setTableService( ICFSecServiceTable value ) {
		tableService = value;
	}

	public ICFSecServiceFactory getFactoryService() {
		return( factoryService );
	}

	public void setFactoryService( ICFSecServiceFactory value ) {
		factoryService = value;
	}

	public ICFSecServiceTypeTable getTableServiceType() {
		return( tableServiceType );
	}

	public void setTableServiceType( ICFSecServiceTypeTable value ) {
		tableServiceType = value;
	}

	public ICFSecServiceTypeFactory getFactoryServiceType() {
		return( factoryServiceType );
	}

	public void setFactoryServiceType( ICFSecServiceTypeFactory value ) {
		factoryServiceType = value;
	}

	public ICFSecSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ICFSecSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ICFSecSysClusterFactory getFactorySysCluster() {
		return( factorySysCluster );
	}

	public void setFactorySysCluster( ICFSecSysClusterFactory value ) {
		factorySysCluster = value;
	}

	public ICFSecTSecGroupTable getTableTSecGroup() {
		return( tableTSecGroup );
	}

	public void setTableTSecGroup( ICFSecTSecGroupTable value ) {
		tableTSecGroup = value;
	}

	public ICFSecTSecGroupFactory getFactoryTSecGroup() {
		return( factoryTSecGroup );
	}

	public void setFactoryTSecGroup( ICFSecTSecGroupFactory value ) {
		factoryTSecGroup = value;
	}

	public ICFSecTSecGrpIncTable getTableTSecGrpInc() {
		return( tableTSecGrpInc );
	}

	public void setTableTSecGrpInc( ICFSecTSecGrpIncTable value ) {
		tableTSecGrpInc = value;
	}

	public ICFSecTSecGrpIncFactory getFactoryTSecGrpInc() {
		return( factoryTSecGrpInc );
	}

	public void setFactoryTSecGrpInc( ICFSecTSecGrpIncFactory value ) {
		factoryTSecGrpInc = value;
	}

	public ICFSecTSecGrpMembTable getTableTSecGrpMemb() {
		return( tableTSecGrpMemb );
	}

	public void setTableTSecGrpMemb( ICFSecTSecGrpMembTable value ) {
		tableTSecGrpMemb = value;
	}

	public ICFSecTSecGrpMembFactory getFactoryTSecGrpMemb() {
		return( factoryTSecGrpMemb );
	}

	public void setFactoryTSecGrpMemb( ICFSecTSecGrpMembFactory value ) {
		factoryTSecGrpMemb = value;
	}

	public ICFSecTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ICFSecTenantTable value ) {
		tableTenant = value;
	}

	public ICFSecTenantFactory getFactoryTenant() {
		return( factoryTenant );
	}

	public void setFactoryTenant( ICFSecTenantFactory value ) {
		factoryTenant = value;
	}

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public static ICFSecTablePerms getTablePerms() {
		return(tablePerms);
	}

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	public static ICFSecTablePerms getCFSecTablePerms() {
		return (ICFSecTablePerms)getTablePerms();
	}

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ICFSecTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public static void setTablePerms( ICFSecTablePerms value ) {
		if(value == null) {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "setTablePerms", 1, "value");
		}
		tablePerms = value;
	}

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}
}
