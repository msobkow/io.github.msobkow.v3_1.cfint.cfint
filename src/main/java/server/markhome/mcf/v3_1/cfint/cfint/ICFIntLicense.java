// Description: Java 25 interface for a License record declementation

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

package server.markhome.mcf.v3_1.cfint.cfint;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;

import server.markhome.mcf.v3_1.cfint.cfintprotobj.*;

/**
 *	ICFIntLicense persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFIntLicense
{
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final CFLibDbKeyHash256 ID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_TENANTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final CFLibDbKeyHash256 TENANTID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_TENANTID_INIT_VALUE );
	public static final String S_TOPDOMAINID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final CFLibDbKeyHash256 TOPDOMAINID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_TOPDOMAINID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public static final String EMBEDDEDTEXT_INIT_VALUE = new String( "" );
	public static final String FULLTEXT_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa110;
	public final static String S_CLASS_CODE = "a110";

	public int getClassCode();

	public $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ getPKey();
	public void setPKey($iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ requiredId);
	public $implIJavaAtomType$ getRequiredId();
	public void setRequiredId( $implIJavaAtomType$ value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ICFSecTenant getRequiredOwnerTenant();

	public void setRequiredOwnerTenant($implIJavaAtomType$ argTenantId);

	public void setRequiredOwnerTenant(ICFSecPubTenant argObj);

	public ICFIntTopDomain getRequiredContainerTopDomain();

	public void setRequiredContainerTopDomain($implIJavaAtomType$ argTopDomainId);

	public void setRequiredContainerTopDomain(ICFIntTopDomain argObj);

	public void setRequiredContainerTopDomain(ICFIntProtTopDomain argObj);

	public void setRequiredContainerTopDomain(ICFIntPubTopDomain argObj);

	public $implIJavaAtomType$ getRequiredTenantId();
	public void setRequiredTenantId( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredTopDomainId();
	public void setRequiredTopDomainId( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredName();
	public void setRequiredName( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getOptionalDescription();
	public void setOptionalDescription( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getOptionalEmbeddedText();
	public void setOptionalEmbeddedText( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getOptionalFullText();
	public void setOptionalFullText( $implIJavaAtomType$ value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ICFIntLicense src );

	public void setLicense( ICFIntLicense src );

	public void set( ICFIntLicenseH src );

	public void setLicense( ICFIntLicenseH src );

	public void set( ICFIntProtLicense src );

	public void setLicense( ICFIntProtLicense src );

	public void set( ICFIntProtLicenseH src );

	public void setLicense( ICFIntProtLicenseH src );

	public void set( ICFIntPubLicense src );

	public void setLicense( ICFIntPubLicense src );

	public void set( ICFIntPubLicenseH src );

	public void setLicense( ICFIntPubLicenseH src );

	public String getXmlAttrFragment();

	public String toString();
}
