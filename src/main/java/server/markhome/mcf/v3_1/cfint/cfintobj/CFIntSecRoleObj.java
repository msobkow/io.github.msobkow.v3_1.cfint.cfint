// Description: Java 25 base object instance implementation for SecRole

/*
 *	server.markhome.mcf.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfint.cfintobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfsec.cfsecobj.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public class CFIntSecRoleObj
	implements ICFIntSecRoleObj
{
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecSecRoleEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFLibDbKeyHash256 pKey;
	protected ICFSecSecRole rec;
	protected List<ICFSecSecRoleEnablesObj> optionalChildrenEnabledByRole;
	protected List<ICFSecSecRoleMembObj> optionalChildrenMembByRole;

	public CFIntSecRoleObj() {
		isNew = true;
	}

	public CFIntSecRoleObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getSecRoleTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecRole" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredName();
		return( objName );
	}

	@Override
	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	@Override
	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
	}

	@Override
	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	@Override
	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	@Override
	public String getObjFullName() {
		String fullName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	@Override
	public ICFSecSecRoleObj realise() {
		ICFSecSecRoleObj retobj = ((ICFIntSchemaObj)getSchema()).getSecRoleTableObj().realiseSecRole(
			(ICFSecSecRoleObj)this );
		return( (ICFSecSecRoleObj)retobj );
	}

	@Override
	public void forget() {
		((ICFIntSchemaObj)getSchema()).getSecRoleTableObj().reallyDeepDisposeSecRole( (ICFSecSecRoleObj)this );
	}

	@Override
	public ICFSecSecRoleObj read() {
		ICFSecSecRoleObj retobj = ((ICFIntSchemaObj)getSchema()).getSecRoleTableObj().readSecRoleByIdIdx( getPKey(), false );
		return( (ICFSecSecRoleObj)retobj );
	}

	@Override
	public ICFSecSecRoleObj read( boolean forceRead ) {
		ICFSecSecRoleObj retobj = ((ICFIntSchemaObj)getSchema()).getSecRoleTableObj().readSecRoleByIdIdx( getPKey(), forceRead );
		return( (ICFSecSecRoleObj)retobj );
	}

	@Override
	public ICFSecSecRoleTableObj getSecRoleTable() {
		return( ((ICFIntSchemaObj)getSchema()).getSecRoleTableObj() );
	}

	@Override
	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	@Override
	public ICFSecSecRole getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactorySecRole().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableSecRole().readDerivedByIdIdx( ((ICFIntSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecRole value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecSecRole ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecSecRoleRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ICFSecSecRole getSecRoleRec() {
		return( (ICFSecSecRole)getRec() );
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return( pKey );
	}

	@Override
	public void setPKey( CFLibDbKeyHash256 value ) {
		if( pKey != value ) {
       		pKey = value;
			copyPKeyToRec();
		}
	}

	@Override
	public boolean getIsNew() {
		return( isNew );
	}

	@Override
	public void setIsNew( boolean value ) {
		isNew = value;
	}

	@Override
	public ICFSecSecRoleEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecSecRoleObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecRoleObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)getSchema()).getSecRoleTableObj().lockSecRole( getPKey() );
		}
		edit = ((ICFIntSchemaObj)getSchema()).getSecRoleTableObj().newEditInstance( lockobj );
		return( (ICFSecSecRoleEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecSecRoleEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecSecRoleEditObj getEditAsSecRole() {
		return( (ICFSecSecRoleEditObj)edit );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecSecRole rec = getRec();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
		}
		return( createdBy );
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( getRec().getCreatedAt() );
	}

	@Override
	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			ICFSecSecRole rec = getRec();
			updatedBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecRoleId() {
		return( getPKey() );
	}

	@Override
	public List<ICFSecSecRoleEnablesObj> getOptionalChildrenEnabledByRole() {
		List<ICFSecSecRoleEnablesObj> retval;
		retval = ((ICFIntSchemaObj)getSchema()).getSecRoleEnablesTableObj().readSecRoleEnablesByRoleIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecSecRoleEnablesObj> getOptionalChildrenEnabledByRole( boolean forceRead ) {
		List<ICFSecSecRoleEnablesObj> retval;
		retval = ((ICFIntSchemaObj)getSchema()).getSecRoleEnablesTableObj().readSecRoleEnablesByRoleIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ICFSecSecRoleMembObj> getOptionalChildrenMembByRole() {
		List<ICFSecSecRoleMembObj> retval;
		retval = ((ICFIntSchemaObj)getSchema()).getSecRoleMembTableObj().readSecRoleMembByRoleIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecSecRoleMembObj> getOptionalChildrenMembByRole( boolean forceRead ) {
		List<ICFSecSecRoleMembObj> retval;
		retval = ((ICFIntSchemaObj)getSchema()).getSecRoleMembTableObj().readSecRoleMembByRoleIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredName() {
		return( getSecRoleRec().getRequiredName() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				setPKey(rec.getPKey());
			}
		}
	}
}
