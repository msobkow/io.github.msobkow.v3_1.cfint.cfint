// Description: Java 25 Instance Edit Object interface for CFInt License.

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
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfint.cfintprot.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintprotobj.*;

public interface ICFIntLicenseEditObj
	extends ICFIntLicenseObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFIntLicenseObj.
	 */
	ICFIntLicenseObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFIntLicenseObj.
	 */
	ICFIntLicenseObj getOrigAsLicense();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFIntLicenseObj create();

	/*
	 *	Update the instance.
	 */
	CFIntLicenseEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFIntLicenseEditObj deleteInstance();

	/**
	 *	Get the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Set the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ICFSecTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ICFSecTenantObj value );

	/**
	 *	Get the ICFIntTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@return	The ICFIntTopDomainObj instance referenced by the TopDomain key.
	 */
	ICFIntTopDomainObj getRequiredContainerTopDomain();

	/**
	 *	Get the required ICFIntTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@return	The required ICFIntTopDomainObj instance referenced by the TopDomain key.
	 */
	ICFIntTopDomainObj getRequiredContainerTopDomain( boolean forceRead );

	/**
	 *	Set the ICFIntTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@param	value	the ICFIntTopDomainObj instance to be referenced by the TopDomain key.
	 */
	void setRequiredContainerTopDomain( ICFIntTopDomainObj value );

	/**
	 *	Get the required $implIJavaAtomType$ attribute Id.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute Id.
	 */
	$implIJavaAtomType$ getRequiredId();

	/**
	 *	Set the required $implIJavaAtomType$ attribute Id.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute Id value to be applied.
	 */
	void setRequiredId($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute TenantId.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute TenantId.
	 */
	$implIJavaAtomType$ getRequiredTenantId();

	/**
	 *	Get the required $implIJavaAtomType$ attribute TopDomainId.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute TopDomainId.
	 */
	$implIJavaAtomType$ getRequiredTopDomainId();

	/**
	 *	Get the required $implIJavaAtomType$ attribute Name.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute Name.
	 */
	$implIJavaAtomType$ getRequiredName();

	/**
	 *	Set the required $implIJavaAtomType$ attribute Name.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute Name value to be applied.
	 */
	void setRequiredName($implIJavaAtomType$ value);

	/**
	 *	Get the optional $implIJavaAtomType$ attribute Description.
	 *
	 *	@return	The optional $implIJavaAtomType$ attribute Description.
	 */
	$implIJavaAtomType$ getOptionalDescription();

	/**
	 *	Set the optional $implIJavaAtomType$ attribute Description.
	 *
	 *	@param value The optional $implIJavaAtomType$ attribute Description value to be applied.
	 */
	void setOptionalDescription($implIJavaAtomType$ value);

	/**
	 *	Get the optional $implIJavaAtomType$ attribute EmbeddedText.
	 *
	 *	@return	The optional $implIJavaAtomType$ attribute EmbeddedText.
	 */
	$implIJavaAtomType$ getOptionalEmbeddedText();

	/**
	 *	Set the optional $implIJavaAtomType$ attribute EmbeddedText.
	 *
	 *	@param value The optional $implIJavaAtomType$ attribute EmbeddedText value to be applied.
	 */
	void setOptionalEmbeddedText($implIJavaAtomType$ value);

	/**
	 *	Get the optional $implIJavaAtomType$ attribute FullText.
	 *
	 *	@return	The optional $implIJavaAtomType$ attribute FullText.
	 */
	$implIJavaAtomType$ getOptionalFullText();

	/**
	 *	Set the optional $implIJavaAtomType$ attribute FullText.
	 *
	 *	@param value The optional $implIJavaAtomType$ attribute FullText value to be applied.
	 */
	void setOptionalFullText($implIJavaAtomType$ value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
