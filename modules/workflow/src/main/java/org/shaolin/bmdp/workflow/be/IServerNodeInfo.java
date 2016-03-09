/*
 *
 * This file is automatically generated on Wed Mar 09 23:50:02 CST 2016
 */

    
package org.shaolin.bmdp.workflow.be;
        
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.shaolin.bmdp.datamodel.bediagram.*;
import org.shaolin.bmdp.datamodel.common.*;
import org.shaolin.bmdp.runtime.be.IBusinessEntity;
import org.shaolin.bmdp.runtime.be.IExtensibleEntity;
import org.shaolin.bmdp.runtime.be.IPersistentEntity;
import org.shaolin.bmdp.runtime.be.IHistoryEntity;
import org.shaolin.bmdp.runtime.be.ITaskEntity;
import org.shaolin.bmdp.runtime.be.BEExtensionInfo;

import org.shaolin.bmdp.runtime.spi.IConstantService;

import org.shaolin.bmdp.runtime.AppContext;

import org.shaolin.bmdp.runtime.ce.CEUtil;



/**
 * null
 * 
 * This code is generated automatically, any change will be replaced after rebuild.
 * 
 *
 */

public interface IServerNodeInfo 
    extends IPersistentEntity, IExtensibleEntity
{
    public final static String ENTITY_NAME = "org.shaolin.bmdp.workflow.be.ServerNodeInfo";
    
 
    /**
     *  get id
     *
     *  @return id
     */
    public long getId();

    /**
     *  get ipAddress
     *
     *  @return ipAddress
     */
    public java.lang.String getIpAddress();

    /**
     *  get port
     *
     *  @return port
     */
    public long getPort();

    /**
     *  get protocol
     *
     *  @return protocol
     */
    public java.lang.String getProtocol();

    /**
     *  get domain
     *
     *  @return domain
     */
    public java.lang.String getDomain();

    /**
     *  set id
     */
    public void setId(long id);

    /**
     *  set ipAddress
     */
    public void setIpAddress(java.lang.String ipAddress);

    /**
     *  set port
     */
    public void setPort(long port);

    /**
     *  set protocol
     */
    public void setProtocol(java.lang.String protocol);

    /**
     *  set domain
     */
    public void setDomain(java.lang.String domain);


}

        