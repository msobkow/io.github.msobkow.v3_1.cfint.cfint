// Description: Java 25 buffer implementation of a CFInt factory service.

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

package server.markhome.mcf.v3_1.cfint.cfint.buff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.buff.*;

@Service("cfint31BuffFactoryService")
public class CFIntBuffFactoryService
	implements ICFIntFactory
{

	@Autowired
	@Qualifier("cfint31BuffLicenseFactoryService")
	protected ICFIntLicenseFactory factoryLicense;

	@Autowired
	@Qualifier("cfint31BuffMajorVersionFactoryService")
	protected ICFIntMajorVersionFactory factoryMajorVersion;

	@Autowired
	@Qualifier("cfint31BuffMimeTypeFactoryService")
	protected ICFIntMimeTypeFactory factoryMimeType;

	@Autowired
	@Qualifier("cfint31BuffMinorVersionFactoryService")
	protected ICFIntMinorVersionFactory factoryMinorVersion;

	@Autowired
	@Qualifier("cfint31BuffSubProjectFactoryService")
	protected ICFIntSubProjectFactory factorySubProject;

	@Autowired
	@Qualifier("cfint31BuffTldFactoryService")
	protected ICFIntTldFactory factoryTld;

	@Autowired
	@Qualifier("cfint31BuffTopDomainFactoryService")
	protected ICFIntTopDomainFactory factoryTopDomain;

	@Autowired
	@Qualifier("cfint31BuffTopProjectFactoryService")
	protected ICFIntTopProjectFactory factoryTopProject;

	@Autowired
	@Qualifier("cfint31BuffURLProtocolFactoryService")
	protected ICFIntURLProtocolFactory factoryURLProtocol;


	public CFIntBuffFactoryService() { }

	@Override
	public ICFIntLicenseFactory getFactoryLicense() {
		return( factoryLicense );
	}

	@Override
	public ICFIntMajorVersionFactory getFactoryMajorVersion() {
		return( factoryMajorVersion );
	}

	@Override
	public ICFIntMimeTypeFactory getFactoryMimeType() {
		return( factoryMimeType );
	}

	@Override
	public ICFIntMinorVersionFactory getFactoryMinorVersion() {
		return( factoryMinorVersion );
	}

	@Override
	public ICFIntSubProjectFactory getFactorySubProject() {
		return( factorySubProject );
	}

	@Override
	public ICFIntTldFactory getFactoryTld() {
		return( factoryTld );
	}

	@Override
	public ICFIntTopDomainFactory getFactoryTopDomain() {
		return( factoryTopDomain );
	}

	@Override
	public ICFIntTopProjectFactory getFactoryTopProject() {
		return( factoryTopProject );
	}

	@Override
	public ICFIntURLProtocolFactory getFactoryURLProtocol() {
		return( factoryURLProtocol );
	}

}
