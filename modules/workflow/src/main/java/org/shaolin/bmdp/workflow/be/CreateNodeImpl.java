/*
 *
 * This file is automatically generated on Mon Feb 22 22:39:37 CST 2016
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

import org.shaolin.bmdp.workflow.ce.*;


/**
 * null
 * 
 * This code is generated automatically, any change will be replaced after rebuild.
 * 
 *
 */

public class CreateNodeImpl  implements org.shaolin.bmdp.workflow.be.ICreateNode
{
    private static final long serialVersionUID = 0x90B1123CE87B50FFL;

    private final transient IConstantService ceService = AppContext.get().getConstantService();

    protected String getBusinessEntityName()
    {
        return "org.shaolin.bmdp.workflow.be.CreateNode";
    }

    public CreateNodeImpl()
    {
        
        _extField = new BEExtensionInfo();
        
    }
    
    
        /**
     * Create Date
     */
    private java.util.Date createDate = null;


    /**
     *  BEExtension _extType
     */
    protected String _extType;

    /**
     *  BEExtension _extField
     */
    protected BEExtensionInfo _extField;
        
   /**
     *  help is not available
     */    
    protected java.lang.String name;
    
   /**
     *  help is not available
     */    
    protected java.lang.String description;
    
   /**
     *  help is not available
     */    
    protected java.lang.String expression;
    
   /**
     *  help is not available
     */    
    protected int expiredDays;
    
   /**
     *  help is not available
     */    
    protected int expiredHours;
    
   /**
     *  help is not available
     */    
    protected java.lang.String partyType;
    
   /**
     *  help is not available
     */    
    protected java.lang.String actionPage;
    
   /**
     *  help is not available
     */    
    protected java.lang.String actionPosition;
    
   /**
     *  help is not available
     */    
    protected NodeType type = NodeType.NOT_SPECIFIED;
    
    protected int typeInt = NodeType.NOT_SPECIFIED.getIntValue();
    
        /**
     *  Get createDate
     *
     *  @return java.util.Date
     */
    public java.util.Date getCreateDate() {
        return createDate;
    }
        
    /**
     *  get _extType
     *
     *  @return _extType
     */
    public String get_extType() {
        return _extType;
    }

    /**
     *  get _extField
     *
     *  @return _extField
     */
    public BEExtensionInfo get_extField() {
        return _extField;
    }
        
    /**
     *  get name
     *
     *  @return name
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     *  get description
     *
     *  @return description
     */
    public java.lang.String getDescription() {
        return description;
    }

    /**
     *  get expression
     *
     *  @return expression
     */
    public java.lang.String getExpression() {
        return expression;
    }

    /**
     *  get expiredDays
     *
     *  @return expiredDays
     */
    public int getExpiredDays() {
        return expiredDays;
    }

    /**
     *  get expiredHours
     *
     *  @return expiredHours
     */
    public int getExpiredHours() {
        return expiredHours;
    }

    /**
     *  get partyType
     *
     *  @return partyType
     */
    public java.lang.String getPartyType() {
        return partyType;
    }

    /**
     *  get actionPage
     *
     *  @return actionPage
     */
    public java.lang.String getActionPage() {
        return actionPage;
    }

    /**
     *  get actionPosition
     *
     *  @return actionPosition
     */
    public java.lang.String getActionPosition() {
        return actionPosition;
    }

    /**
     *  get type
     *
     *  @return type
     */
    public NodeType getType() {
        return type;
    }

    /**
     *  get typeInt
     *
     *  @return typeInt
     */
    private int getTypeInt() {
        return typeInt;
    }

        /**
     *  set createDate
     *  @parameter true or false.
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     *  set _extType
     *  @param _extType which is the extension type of be object.
     */
    public void set_extType(java.lang.String _extType) {
        this._extType = _extType;
    }
        
    /**
     *  set name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     *  set description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    /**
     *  set expression
     */
    public void setExpression(java.lang.String expression) {
        this.expression = expression;
    }

    /**
     *  set expiredDays
     */
    public void setExpiredDays(int expiredDays) {
        this.expiredDays = expiredDays;
    }

    /**
     *  set expiredHours
     */
    public void setExpiredHours(int expiredHours) {
        this.expiredHours = expiredHours;
    }

    /**
     *  set partyType
     */
    public void setPartyType(java.lang.String partyType) {
        this.partyType = partyType;
    }

    /**
     *  set actionPage
     */
    public void setActionPage(java.lang.String actionPage) {
        this.actionPage = actionPage;
    }

    /**
     *  set actionPosition
     */
    public void setActionPosition(java.lang.String actionPosition) {
        this.actionPosition = actionPosition;
    }

    /**
     *  set type
     */
    public void setType(NodeType type) {
        this.type = type;
    if (typeInt != type.getIntValue()) {
            typeInt = type.getIntValue();
        }
    }

    /**
     *  set int type
     */
    private void setTypeInt(int intValue) {
        this.typeInt = intValue;
        if (typeInt != type.getIntValue()) {
            type = (NodeType)ceService.getConstantEntity(NodeType.ENTITY_NAME).getByIntValue(typeInt);
        }
    }

    
    /**
     * Check different according to primary key.
     */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof org.shaolin.bmdp.workflow.be.CreateNodeImpl))
            return false;
        org.shaolin.bmdp.workflow.be.CreateNodeImpl o = (org.shaolin.bmdp.workflow.be.CreateNodeImpl)obj;
        
        boolean result = super.equals(obj);

        boolean eq = true;
        
        return result;
    }

    /**
     * Generate hashCode according to primary key.
     */
    public int hashCode() {
        
        int result = super.hashCode();

        return result;
    }
        
    
     /**
     * Gets the String format of the business entity.
     *
     * @return String the business entity in String format.
     */
    public  String  toString() {
        StringBuffer aBuf = new StringBuffer();
        aBuf.append("org.shaolin.bmdp.workflow.be.CreateNode");
    
        aBuf.append(" : ");
        
        aBuf.append("createDate=").append(createDate).append(", ");
        
        aBuf.append("name");
        aBuf.append("=");
        aBuf.append(name);
        aBuf.append(", ");
        
        aBuf.append("description");
        aBuf.append("=");
        aBuf.append(description);
        aBuf.append(", ");
        
        aBuf.append("expression");
        aBuf.append("=");
        aBuf.append(expression);
        aBuf.append(", ");
        
        aBuf.append("expiredDays");
        aBuf.append("=");
        aBuf.append(expiredDays);
        aBuf.append(", ");
        
        aBuf.append("expiredHours");
        aBuf.append("=");
        aBuf.append(expiredHours);
        aBuf.append(", ");
        
        aBuf.append("partyType");
        aBuf.append("=");
        aBuf.append(partyType);
        aBuf.append(", ");
        
        aBuf.append("actionPage");
        aBuf.append("=");
        aBuf.append(actionPage);
        aBuf.append(", ");
        
        aBuf.append("actionPosition");
        aBuf.append("=");
        aBuf.append(actionPosition);
        aBuf.append(", ");
        
        aBuf.append("type");
        aBuf.append("=");
        aBuf.append(type);
        aBuf.append(", ");
        
        return aBuf.toString();
    }
    
    
     /**
     * Gets list of MemberType.
     *
     * @return List     the list of MemberType.
     */
    public List<MemberType> getMemberList() {
        List<MemberType> memberTypeList = new ArrayList<MemberType>();
        
        MemberType member = null;
        
        org.shaolin.bmdp.datamodel.bediagram.StringType nameBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for name
        member = new MemberType();
        member.setName("name");
        member.setDescription("null");
        member.setType(nameBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.StringType descriptionBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for description
        member = new MemberType();
        member.setName("description");
        member.setDescription("null");
        member.setType(descriptionBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.StringType expressionBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for expression
        member = new MemberType();
        member.setName("expression");
        member.setDescription("null");
        member.setType(expressionBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.IntType expiredDaysBEType = new org.shaolin.bmdp.datamodel.bediagram.IntType();
    
        //MemberType Define for expiredDays
        member = new MemberType();
        member.setName("expiredDays");
        member.setDescription("null");
        member.setType(expiredDaysBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.IntType expiredHoursBEType = new org.shaolin.bmdp.datamodel.bediagram.IntType();
    
        //MemberType Define for expiredHours
        member = new MemberType();
        member.setName("expiredHours");
        member.setDescription("null");
        member.setType(expiredHoursBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.StringType partyTypeBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for partyType
        member = new MemberType();
        member.setName("partyType");
        member.setDescription("null");
        member.setType(partyTypeBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.StringType actionPageBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for actionPage
        member = new MemberType();
        member.setName("actionPage");
        member.setDescription("null");
        member.setType(actionPageBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.StringType actionPositionBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for actionPosition
        member = new MemberType();
        member.setName("actionPosition");
        member.setDescription("null");
        member.setType(actionPositionBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.CEObjRefType typeBEType = new org.shaolin.bmdp.datamodel.bediagram.CEObjRefType();
    
        TargetEntityType typeTargetEntity = new TargetEntityType();
        typeBEType.setTargetEntity(typeTargetEntity);
        typeTargetEntity.setEntityName("org.shaolin.bmdp.workflow.ce.NodeType");
            
        //MemberType Define for type
        member = new MemberType();
        member.setName("type");
        member.setDescription("null");
        member.setType(typeBEType);
        memberTypeList.add(member);
            
        return memberTypeList;
    }
    
    public ICreateNode createEntity ()
    {
        return new CreateNodeImpl();
    }
    
}

        
